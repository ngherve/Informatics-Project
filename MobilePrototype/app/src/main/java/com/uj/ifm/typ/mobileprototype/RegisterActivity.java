package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
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

    public void backAction(View view){
        super.onBackPressed();
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
            case R.id.btnback_regr:
                //super.onBackPressed();
                break;
        }

    }
}