package com.uj.ifm.typ.mobileprototype;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import org.json.JSONException;
import org.json.JSONObject;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_CAMERA_AND_LOCATION = 3;
    private static final String TAG = "";
    Button btnLogin;
    EditText edUsername, edPassword;
    TextView registerLink;
    public static String usertype;
    public static String email;
    public static String name;
    public static int userID;
    public static String photo;
    private SessionManager sm;

    String[] perms = {Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = (EditText) findViewById(R.id.etUsername);
        edPassword = (EditText) findViewById(R.id.etPassword);
        registerLink = (TextView) findViewById(R.id.etregLink);
        registerLink.setOnClickListener(this);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        FirebaseMessaging.getInstance().subscribeToTopic("test");
        FirebaseInstanceId.getInstance().getToken();

        sm = new SessionManager(this);

        EasyPermissions.requestPermissions(
                new PermissionRequest.Builder(this, RC_CAMERA_AND_LOCATION, perms)
                        .setRationale(R.string.camera_and_location_rationale)
                        .setPositiveButtonText(R.string.rationale_ask_ok)
                        .setNegativeButtonText(R.string.rationale_ask_cancel)
                        .setTheme(R.style.my_fancy_style)
                        .build());
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(this, R.string.returned_from_app_settings_to_activity, Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }



    @Override
    public void onClick(View v) {
        String username = edUsername.getText().toString();
        String Password = edPassword.getText().toString();

        switch(v.getId()){
            case R.id.btnLogin:
                Response.Listener<String> respList = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonRes = new JSONObject(response);
                            boolean success = jsonRes.getBoolean("success");

                            if(success){
                                userID = jsonRes.getInt("UserID");
                                name = jsonRes.getString("Name");
                                String username = jsonRes.getString("Username");
                                email = jsonRes.getString("Email");
                                String pass = jsonRes.getString("Password");
                                String telNumber = jsonRes.getString("Tel_Number");
                                String address = jsonRes.getString("Address");
                                String gender = jsonRes.getString("Gender");
                                String dob = jsonRes.getString("DOB");
                                usertype = jsonRes.getString("User_Type");
                                photo = jsonRes.getString("pphoto");

                                sm.createSession(name, email, String.valueOf(userID));

                                if(usertype.equals("stock")) {
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    intent.putExtra("UserID", userID);
                                    intent.putExtra("Name", name);
                                    intent.putExtra("Username", username);
                                    intent.putExtra("Email", email);
                                    intent.putExtra("Password", pass);
                                    intent.putExtra("Tel_Number", telNumber);
                                    intent.putExtra("Address", address);
                                    intent.putExtra("Gender", gender);
                                    intent.putExtra("DOB", dob);
                                    intent.putExtra("User_Type", usertype);
                                    intent.putExtra("pphoto", photo);
                                    LoginActivity.this.startActivity(intent);
                                } else if(usertype.equals("warehouse")){
                                    Intent intent = new Intent(LoginActivity.this, WarehouseHomeActivity.class);
                                    intent.putExtra("UserID", userID);
                                    intent.putExtra("Name", name);
                                    intent.putExtra("Username", username);
                                    intent.putExtra("Email", email);
                                    intent.putExtra("Password", pass);
                                    intent.putExtra("Tel_Number", telNumber);
                                    intent.putExtra("Address", address);
                                    intent.putExtra("Gender", gender);
                                    intent.putExtra("DOB", dob);
                                    intent.putExtra("User_Type", usertype);
                                    intent.putExtra("pphoto", photo);
                                    LoginActivity.this.startActivity(intent);
                                } else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                    builder.setMessage("Login Failed: You have not been given permission by the Admin")
                                            .setNegativeButton("Retry", null).create().show();
                                }
                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed: Invalid Credentials").setNegativeButton("Retry", null).create().show();
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };

                ServerRequests loginReq = new ServerRequests(username, Password, respList);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginReq);
                break;
            case R.id.etregLink:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

                break;
        }
    }
}
