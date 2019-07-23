package com.uj.ifm.typ.mobileprototype;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ServerRequests extends StringRequest {

    private static final String REQUEST_URL = "http://10.254.17.96:80/script/";
    private Map<String, String> params;

    //Register user Request
    public ServerRequests(String name, String username, String  email, String password,
                          String telNum, String address, String gender, String dob, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL+"Register.php", listener, null);

        //super(Method.POST, "http://10.254.17.96:8082/UserService.svc/RegisterUser", listener, null);

        params = new HashMap<>();
        params.put("Name", name);
        params.put("Username", username);
        params.put("Email", email);
        params.put("Password", password);
        params.put("Tel_Number", telNum);
        params.put("Address", address);
        params.put("Gender", gender);
        params.put("DOB", dob);

    }

    //Login user Request
    public ServerRequests(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL+"Login.php", listener, null);

        params = new HashMap<>();
        params.put("Username", username);
        params.put("Password", password);

    }

    //update user request
    public ServerRequests(int id, String name, String username, String  email, String password,
                          String telNum, String address, String gender, String dob,  Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL+"Update.php", listener, null);

        params = new HashMap<>();
        params.put("UserID", String.valueOf(id));
        params.put("Name", name);
        params.put("Username", username);
        params.put("Email", email);
        params.put("Password", password);
        params.put("Tel_Number", telNum);
        params.put("Address", address);
        params.put("Gender", gender);
        params.put("DOB", dob);
    }

    //test webservice
    public ServerRequests(Response.Listener<String> listener) {
        super(Method.POST, "http://10.254.17.96:8082/UserService.svc/GetUsers", listener, null);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}