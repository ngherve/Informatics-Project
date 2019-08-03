package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText edUsername, edPassword;
    TextView registerLink;
    public static String usertype;
    public static String email;
    public static String name;
    public static int userID;

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
                                String photo = jsonRes.getString("pphoto");

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
