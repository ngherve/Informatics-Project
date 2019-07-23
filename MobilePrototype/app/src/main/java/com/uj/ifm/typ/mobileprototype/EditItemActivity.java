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

public class EditItemActivity extends AppCompatActivity implements View.OnClickListener {

    private Bitmap bitmap;
    CircleImageView profileimage;
    private String URL_Upload = "http://10.254.17.96:80/script/UploadProduct.php";
    int id;
    private static final String TAG = ProfileActivity.class.getSimpleName();
    Button btnSave;
    EditText epName, eprice, ep_Image, eQuant, esuppname, ep_type, eW_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititems);

        epName = (EditText) findViewById(R.id.etpName);
        eprice = (EditText) findViewById(R.id.etprice);
        ep_Image = (EditText) findViewById(R.id.etName);
        eQuant = (EditText) findViewById(R.id.etstQuantity);
        esuppname = (EditText) findViewById(R.id.etsupp_name);
        ep_type = (EditText) findViewById(R.id.etp_type);
        eW_name = (EditText) findViewById(R.id.etwarehouse);

        btnSave = (Button) findViewById(R.id.btnSaveItem);
        btnSave.setOnClickListener(this);
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
                profileimage.setImageBitmap(bitmap);

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
                                Toast.makeText(EditItemActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDial.dismiss();
                            Toast.makeText(EditItemActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDial.dismiss();
                        Toast.makeText(EditItemActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("P_ID", id);
                params.put("P_Image", photo);
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(EditItemActivity.this);
        reqQue.add(strRequest);
    }

    public void UpdatePicture(){
        //creating a file chooser
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

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonresp = new JSONObject(response);
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditItemActivity.this);
                    builder.setMessage("Your Item has been Saved successfully !!!").setNegativeButton("OK", null).create().show();

                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        };

        ServerRequests request = new ServerRequests(pname, price, image, quantity, suppname, type, warehouse, responseListener);
        RequestQueue queue = Volley.newRequestQueue(EditItemActivity.this);
        queue.add(request);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnback_save:
                super.onBackPressed();
                break;
            case R.id.btnSaveItem:


            case R.id.btnselectimage:
                UpdatePicture();
                break;
        }
    }
}
