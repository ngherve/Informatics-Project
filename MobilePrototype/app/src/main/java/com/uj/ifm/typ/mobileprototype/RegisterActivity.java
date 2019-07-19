package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    EditText eName, eDOB, eEmail, ePassword, eUsername, eAdress, ePhone, eGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eUsername = (EditText) findViewById(R.id.etUsename);
        ePassword = (EditText) findViewById(R.id.etPassword);
        eName = (EditText) findViewById(R.id.etName);
        eAdress = (EditText) findViewById(R.id.etAddress);
        ePhone = (EditText) findViewById(R.id.etPhone);
        eEmail = (EditText) findViewById(R.id.etEmail);
        eDOB = (EditText) findViewById(R.id.etDOB);
        eGender = (EditText) findViewById(R.id.etGender);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegister:
                String name = eName.getText().toString();
                String username = eUsername.getText().toString();
                String email = eEmail.getText().toString();
                String Password = ePassword.getText().toString();
                String telNumber = ePhone.getText().toString();
                String address = eAdress.getText().toString();
                String gender = eGender.getText().toString();
                String dob = eDOB.getText().toString();

                //callWCFService(name, username, email, Password, telNumber, address, gender, dob);


                //User registeredUser = new User(name, username, email, Password, telNumber, address, gender, dob);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonresp = new JSONObject(response);
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            builder.setMessage("You have have been Registered successfully !!!").setNegativeButton("OK", null).create().show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        }catch(JSONException ex){
                            ex.printStackTrace();
                        }
                    }
                };

                ServerRequests request = new ServerRequests(name, username, email, Password, telNumber, address, gender, dob, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(request);
                break;
        }

    }

    private void callWCFService(String name, String username, String  email, String password,
                                String telNum, String address, String gender, String dob) {
        String url = "http://10.254.17.96:8082/UserService.svc/RegisterUser";
        //url += "RegisterUser"; // MyServiceMethod is a method name.
        User requestModel = new User();
        requestModel.Name = name;
        requestModel.Username = username;
        requestModel.Email = email;
        requestModel.Password = password;
        requestModel.Tel_Number = telNum;
        requestModel.Address = address;
        requestModel.Gender = gender;
        requestModel.DOB = dob;

        CustomWCFRequest<String> req = new CustomWCFRequest<String>(RegisterActivity.this);
        req.execute(Request.Method.POST, url, String.class, requestModel, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Here you got the response of webservice.
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setMessage(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // handle error
                AlertDialog.Builder builderErr = new AlertDialog.Builder(RegisterActivity.this);
                builderErr.setMessage(error.toString());
            }
        });
    }
}
