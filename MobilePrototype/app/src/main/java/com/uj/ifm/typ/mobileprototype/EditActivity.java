package com.uj.ifm.typ.mobileprototype;

import android.app.ProgressDialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EditActivity<getSim> extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    CircleImageView profileimage1;
    private String URL_Upload = "http://10.254.17.96:80/script/UploadProduct.php";
    String id;
    private static final String TAG = ProfileActivity.class.getSimpleName();
    Button btnSave, btnImage;
    EditText epName, eprice, ep_Image, eQuant, esuppname, ep_type, eW_name, ePCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        epName = (EditText) findViewById(R.id.editetpName);
        eprice = (EditText) findViewById(R.id.editetprice);
        //ep_Image = (EditText) findViewById(R.id.editetName);
        eQuant = (EditText) findViewById(R.id.editetstQuantity);
        esuppname = (EditText) findViewById(R.id.editetsupp_name);
        ep_type = (EditText) findViewById(R.id.editetp_type);
        eW_name = (EditText) findViewById(R.id.editetwarehouse);
        ePCode = (EditText) findViewById(R.id.editetpcode);

        btnSave = (Button) findViewById(R.id.editbtnSaveItem);
        btnSave.setOnClickListener(this);

        btnImage = findViewById(R.id.editbtnselectimage);
        btnImage.setOnClickListener(this);

        profileimage1 = findViewById(R.id.edititem_image);


        Intent intent = getIntent();
        epName.setText(intent.getStringExtra("P_Name"));
        eprice.setText(intent.getStringExtra("P_Price"));
        intent.getStringExtra("P_Image");
        eQuant.setText(intent.getStringExtra("P_Quantity"));
        esuppname.setText(intent.getStringExtra("Supplier_Name"));
        ep_type.setText(intent.getStringExtra("P_Type"));
        eW_name.setText(intent.getStringExtra("W_Name"));
        ePCode.setText(intent.getStringExtra("P_Code"));

    }

    public void backAction(View view) {
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode ==RESULT_OK && data !=null && data.getData() != null){
            Uri filepath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                profileimage1.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }

            UploadPicture(String.valueOf(id), getStringImage(bitmap));
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
                                Toast.makeText(EditActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDial.dismiss();
                            Toast.makeText(EditActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDial.dismiss();
                        Toast.makeText(EditActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
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

        RequestQueue reqQue = Volley.newRequestQueue(EditActivity.this);
        reqQue.add(strRequest);
    }

    public void UpdatePicture(){
        //creating a file chooser
        String pcode = ePCode.getText().toString();
        id = pcode;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);

    }

    public void saveItem(){
        String pname = epName.getText().toString();
        String price = eprice.getText().toString();
        String image = "My image";
        String quantity = eQuant.getText().toString();
        String suppname = esuppname.getText().toString();
        String type = ep_type.getText().toString();
        String warehouse = eW_name.getText().toString();
        String pcode = ePCode.getText().toString();
        id = pcode;

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonresp = new JSONObject(response);
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditActivity.this);
                    builder.setMessage("Your Item has been Saved successfully !!!").setNegativeButton("OK", null).create().show();

                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        };

        ServerRequests request = new ServerRequests(1,1, pname, price, image, quantity, suppname, type, warehouse, pcode, responseListener);
        RequestQueue queue = Volley.newRequestQueue(EditActivity.this);
        queue.add(request);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editbtnback_save:
                super.onBackPressed();
                break;
            case R.id.editbtnSaveItem:
                saveItem();
                break;

            case R.id.editbtnselectimage:
                UpdatePicture();
                break;
        }
    }
}
