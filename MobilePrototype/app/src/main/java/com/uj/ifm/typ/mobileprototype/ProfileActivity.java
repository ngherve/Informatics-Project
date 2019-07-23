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

public class ProfileActivity<getSim> extends AppCompatActivity implements View.OnClickListener {
    Button btnLogout;
    Button btnEdit;
    EditText eName, eDOB, eEmail, ePassword, eUsername, eAdress, ePhone, eGender;
    String name, username, pass, email, gender, Address, user_type, DOB, Tel, photo, message;
    int id;
    private Bitmap bitmap;
    CircleImageView profileimage;
    private String URL_Upload = "http://10.254.17.96:80/script/Upload.php";
    private static final String TAG = ProfileActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnLogout = (Button) findViewById(R.id.btnback);
        btnLogout.setOnClickListener(this);

        Intent intent = getIntent();
        id = intent.getIntExtra("UserID", -1);
        name = intent.getStringExtra("Name");
        username = intent.getStringExtra("Username");
        email = intent.getStringExtra("Email");
        pass = intent.getStringExtra("Password");
        Tel = intent.getStringExtra("Tel_Number");
        Address = intent.getStringExtra("Address");
        gender = intent.getStringExtra("Gender");
        DOB = intent.getStringExtra("DOB");
        user_type = intent.getStringExtra("User_Type");
        photo = intent.getStringExtra("pphoto");

        profileimage = findViewById(R.id.profile_image);


        btnEdit = (Button) findViewById(R.id.btnPhoto);
        btnEdit.setOnClickListener(this);

        eUsername = (EditText) findViewById(R.id.txtusername);
        ePassword = (EditText) findViewById(R.id.txtpassword);
        eName = (EditText) findViewById(R.id.txtname);
        eAdress = (EditText) findViewById(R.id.txtaddress);
        ePhone = (EditText) findViewById(R.id.txttelnumber);
        eEmail = (EditText) findViewById(R.id.txtemail);
        eDOB = (EditText) findViewById(R.id.txtDOB);
        eGender = (EditText) findViewById(R.id.txtgender);

        eUsername.setText(username);
        ePassword.setText(pass);
        eName.setText(name);
        eAdress.setText(Address);
        ePhone.setText(Tel);
        eEmail.setText(email);
        eDOB.setText(DOB);
        eGender.setText(gender);

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
                                Toast.makeText(ProfileActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDial.dismiss();
                            Toast.makeText(ProfileActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDial.dismiss();
                        Toast.makeText(ProfileActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("UserID", id);
                params.put("pphoto", photo);
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(ProfileActivity.this);
        reqQue.add(strRequest);
    }

    public void UpdatePicture(){
        //creating a file chooser
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);

    }

   @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnback:
                super.onBackPressed();
                break;
            case R.id.btnPhoto:
                UpdatePicture();
                break;
            case R.id.updatedetails:
                String name = eName.getText().toString();
                String username = eUsername.getText().toString();
                String email = eEmail.getText().toString();
                String Password = ePassword.getText().toString();
                String telNumber = ePhone.getText().toString();
                String address = eAdress.getText().toString();
                String gender = eGender.getText().toString();
                String dob = eDOB.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);
                            int success = jsonRes.getInt("success");

                            if(success==1) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                                builder.setMessage("Your Details have been successfully Updated !!!").setNegativeButton("OK", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                ServerRequests request = new ServerRequests(id, name, username, email, Password, telNumber, address, gender, dob, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ProfileActivity.this);
                queue.add(request);
                break;

        }
    }
}
