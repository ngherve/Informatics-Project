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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import de.hdodenhof.circleimageview.CircleImageView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pub.devrel.easypermissions.EasyPermissions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class DamagesActivity extends AppCompatActivity implements View.OnClickListener {

    private String P_ID = "";
    private String URL_Upload = ServerRequests.REQUEST_URL + "UploadProduct.php";
    private Bitmap bitmap;
    private static final String TAG = EditActivity.class.getSimpleName();
    private String id = "";
    private CircleImageView profileimage1;
    private String code, loc;
    private String P_Price;
    private String P_Name;
    private String P_Code = "";
    private String P_Quantity;
    private String Supplier_Name;
    private String W_Name;
    private String P_Type;
    private TextView txtinfo;
    private EditText edDescript;
    private Button takpic, report;
    private String P_Photo = "";
    private EditText edQuan;
    private String datetime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damages);
        profileimage1 = findViewById(R.id.damageimg);
        txtinfo = findViewById(R.id.txtProdInfo);
        edQuan = findViewById(R.id.eQuant);
        edDescript = findViewById(R.id.damagedesc);
        takpic = findViewById(R.id.btntakepic);
        takpic.setOnClickListener(this);
        report = findViewById(R.id.btnReportDamage);
        report.setOnClickListener(this);

        Intent intent = getIntent();
        P_Name = (intent.getStringExtra("P_Name"));
        P_Price = (intent.getStringExtra("P_Price"));
        String image = intent.getStringExtra("P_Image");
        P_Quantity = (intent.getStringExtra("P_Quantity"));
        Supplier_Name = (intent.getStringExtra("Supplier_Name"));
        P_Type = (intent.getStringExtra("P_Type"));
        W_Name = (intent.getStringExtra("W_Name"));
        P_Code = (intent.getStringExtra("P_Code"));
        loc = intent.getStringExtra("bin_location");
        id = P_Code;
        txtinfo.setText("Product Info: \nItem: " + P_Name + " Code: " + P_Code + " Price: " +
                P_Price + " Quantity: " + P_Quantity + " Supplier: " + Supplier_Name +
                " Type: " + P_Type + " Warehouse: " + W_Name + "\nBin Location: " + loc);
        GetProdID();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    private void saveDamages(){

        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        datetime = dateformat.format(c.getTime());


        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "SaveDamages.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);
                            saveInvoice();
                            Toast.makeText(DamagesActivity.this, "Damage Successfully Reported", Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(DamagesActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DamagesActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("DateDamaged", datetime);
                params.put("P_ID", P_ID);
                params.put("Quantity", edQuan.getText().toString());
                params.put("Description", edDescript.getText().toString());
                params.put("P_Photo", ServerRequests.REQUEST_URL + "profile_image/prod"+ P_Code  +".jpeg");

                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(DamagesActivity.this);
        reqQue.add(strRequest);
    }

    public void saveInvoice(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "SaveInvoice.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(DamagesActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DamagesActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("P_Code", id);
                params.put("Quantity", P_Quantity);
                params.put("Total_Price", Integer.toString(Integer.parseInt(P_Quantity)*Integer.parseInt(P_Price)));
                params.put("C_ID", "1");
                params.put("INV_Date", datetime);
                params.put("UserID", Integer.toString(LoginActivity.userID));
                params.put("Inv_Type", "damage");

                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(DamagesActivity.this);
        reqQue.add(strRequest);
    }


    private void GetProdID(){
        Response.Listener<String> respList = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonarray = new JSONArray(response);
                    for(int i=0; i<jsonarray.length(); i++) {
                        JSONObject jsonRes = jsonarray.getJSONObject(i);
                        if(P_Code.equals(jsonRes.getString("P_Code"))){
                            P_ID = jsonRes.getString("P_ID");
                            P_Photo = jsonRes.getString("P_Image");
                        }
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };

        ServerRequests loginReq = new ServerRequests(respList);
        RequestQueue queue = Volley.newRequestQueue(DamagesActivity.this);
        queue.add(loginReq);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==RESULT_OK && data !=null && data.getData() != null){
            if(requestCode ==0) {
                Uri filepath = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                    profileimage1.setImageBitmap(bitmap);
                    UploadPicture(id, getStringImage(bitmap));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if(requestCode==1){
                Uri filepath = data.getData();
                try {
                    Bundle bundle = data.getExtras();
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                    profileimage1.setImageBitmap(bitmap);
                    UploadPicture(id, getStringImage(bitmap));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            GetProdID();
        }
    }

    private String getStringImage(Bitmap bitmap) {
        ByteArrayOutputStream byteAoutStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteAoutStream);

        byte[] imageByteArray = byteAoutStream.toByteArray();
        String encodedImage = android.util.Base64.encodeToString(imageByteArray, Base64.DEFAULT);
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
                                Toast.makeText(DamagesActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDial.dismiss();
                            Toast.makeText(DamagesActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDial.dismiss();
                        Toast.makeText(DamagesActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
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

        RequestQueue reqQue = Volley.newRequestQueue(DamagesActivity.this);
        reqQue.add(strRequest);
    }

    public void UpdatePicture(){
        //creating a file chooser

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReportDamage:
                saveDamages();
                Intent intent2 = new Intent(DamagesActivity.this, HomeActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent2);
                break;

            case R.id.btntakepic:
                final String[] options = {"Camera", "Gallery", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DamagesActivity.this);
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

    public void backAction(View view) {
        Intent intent2 = new Intent(DamagesActivity.this, HomeActivity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent2);
    }

}