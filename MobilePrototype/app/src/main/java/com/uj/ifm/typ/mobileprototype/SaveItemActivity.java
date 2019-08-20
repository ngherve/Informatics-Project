package com.uj.ifm.typ.mobileprototype;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SaveItemActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    CircleImageView profileimage2;
    private String URL_Upload = ServerRequests.REQUEST_URL + "UploadProduct.php";
    String id, image;
    private static final String TAG = ProfileActivity.class.getSimpleName();
    Button btnSave, btnUpoadImage;
    EditText epName, eprice, ep_Image, eQuant, esuppname, ep_type, eW_name, ePCode, ebinLoc;
    private String datetime;
    Spinner binlocation;
    ArrayList<String> bins = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveitems);

        epName = (EditText) findViewById(R.id.etpName);
        eprice = (EditText) findViewById(R.id.etprice);
        ep_Image = (EditText) findViewById(R.id.etName);
        eQuant = (EditText) findViewById(R.id.etstQuantity);
        esuppname = (EditText) findViewById(R.id.etsupp_name);
        ep_type = (EditText) findViewById(R.id.etp_type);
        eW_name = (EditText) findViewById(R.id.etwarehouse);
        ePCode = (EditText) findViewById(R.id.etpcode);

        binlocation = (Spinner) findViewById(R.id.etbinloc);
        for(int i=1;i<10;i++) {
            bins.add("bin0"+i);
        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SaveItemActivity.this,
                android.R.layout.simple_list_item_1, bins);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binlocation.setAdapter(myAdapter);
        binlocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btnSave = (Button) findViewById(R.id.btnSaveItem);
        btnSave.setOnClickListener(this);

        btnUpoadImage = findViewById(R.id.btnselectimage);
        btnUpoadImage.setOnClickListener(this);

        profileimage2 = findViewById(R.id.item_image);


        if((ScanItemsActivity.resultView !=null)) {
            Intent intent = getIntent();
            epName.setText(intent.getStringExtra("P_Name"));
            eprice.setText(intent.getStringExtra("P_Price"));
            image = intent.getStringExtra("P_Image");
            eQuant.setText(intent.getStringExtra("P_Quantity"));
            esuppname.setText(intent.getStringExtra("Supplier_Name"));
            ep_type.setText(intent.getStringExtra("P_Type"));
            eW_name.setText(intent.getStringExtra("W_Name"));
            ePCode.setText(intent.getStringExtra("P_Code"));
            ebinLoc.setText(intent.getStringExtra("bin_location"));
            StringTokenizer st = new StringTokenizer(ScanItemsActivity.resultView.getText().toString(), "\n");
            ScanItemsActivity.resultView.setText(ScanItemsActivity.resultView.getText().toString());
        }


        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        datetime = dateformat.format(c.getTime());
    }

    public void backAction(View view) {
        super.onBackPressed();
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode ==RESULT_OK && data !=null && data.getData() != null){
            if(requestCode ==0) {
                Uri filepath = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                    profileimage2.setImageBitmap(bitmap);
                    UploadPicture(String.valueOf(id), getStringImage(bitmap));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if(requestCode==1){
                Uri filepath = data.getData();
                Bundle bundle = data.getExtras();
                bitmap = (Bitmap) bundle.get("data");
                profileimage2.setImageBitmap(bitmap);
                UploadPicture(String.valueOf(id), getStringImage(bitmap));
            }
        }
    }

    private String getStringImage(Bitmap bitmap) {
        ByteArrayOutputStream byteAoutStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteAoutStream);

        byte[] imageByteArray = byteAoutStream.toByteArray();
        String encodedImage = Base64.encodeToString(imageByteArray, Base64.DEFAULT);
        return encodedImage;
    }

    private void UploadPicture(final String id, final String photo) {
        final ProgressDialog progressDial = new ProgressDialog(this);
        progressDial.setMessage("Uploading...");
        progressDial.show();

        StringRequest strRequest = new StringRequest(Request.Method.POST, URL_Upload,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDial.dismiss();
                        Log.i(TAG, response.toString());
                        try {
                            JSONObject jsobj = new JSONObject(response);
                            int success = jsobj.getInt("success");

                            if(success ==1);{
                                Toast.makeText(SaveItemActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDial.dismiss();
                            Toast.makeText(SaveItemActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDial.dismiss();
                        Toast.makeText(SaveItemActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("P_Code", id);
                params.put("P_Image", photo);
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(SaveItemActivity.this);
        reqQue.add(strRequest);
    }

    public void UpdatePicture(){
        //creating a file chooser
        String pcode = ePCode.getText().toString();
        id = pcode;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);

    }

    public void saveInvoice(){
        String pname = epName.getText().toString();
        final String price = eprice.getText().toString();
        final String quantity = eQuant.getText().toString();
        String suppname = esuppname.getText().toString();
        String type = ep_type.getText().toString();
        String warehouse = eW_name.getText().toString();
        String pcode = ePCode.getText().toString();
        String binloc = ebinLoc.getText().toString();
        id = pcode;

        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "SaveInvoice.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(SaveItemActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SaveItemActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("P_Code", id);
                params.put("Quantity", quantity);
                params.put("Total_Price", Integer.toString(Integer.parseInt(quantity)*Integer.parseInt(price)));
                params.put("C_ID", "1");
                params.put("INV_Date", datetime);
                params.put("UserID", Integer.toString(LoginActivity.userID));
                params.put("Inv_Type", "incoming");

                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(SaveItemActivity.this);
        reqQue.add(strRequest);
    }

    public void saveItem(){
        String pname = epName.getText().toString();
        String price = eprice.getText().toString();
        String quantity = eQuant.getText().toString();
        String suppname = esuppname.getText().toString();
        String type = ep_type.getText().toString();
        String warehouse = eW_name.getText().toString();
        String pcode = ePCode.getText().toString();
        String binloc = ebinLoc.getText().toString();
        id = pcode;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonresp = new JSONObject(response);
                    AlertDialog.Builder builder = new AlertDialog.Builder(SaveItemActivity.this);
                    builder.setMessage("Your Item has been Saved successfully !!!").setNegativeButton("OK", null).create().show();
                    saveInvoice();
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        };

        ServerRequests request = new ServerRequests("", pname, price, image, quantity, suppname, type, warehouse, pcode, binloc, responseListener);
        RequestQueue queue = Volley.newRequestQueue(SaveItemActivity.this);
        queue.add(request);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnback_save:
                super.onBackPressed();
                break;
            case R.id.btnSaveItem:
                saveItem();
                break;

            case R.id.btnselectimage:
                final String[] options = {"Camera", "Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(SaveItemActivity.this);
                builder.setTitle("Please Choose an Option to add Image");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(options[which].equals("Camera")){
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 1);
                        }else if(options[which].equals("Gallery")){
                            UpdatePicture();
                        } else if(options[which].equals("Cancel")){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
                break;
        }
    }
}
