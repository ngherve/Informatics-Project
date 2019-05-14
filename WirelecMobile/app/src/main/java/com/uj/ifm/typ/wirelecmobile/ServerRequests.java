package com.uj.ifm.typ.wirelecmobile;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ServerRequests extends StringRequest {

    private static final String REQUEST_URL = "http://10.254.17.96:8080/UserService.svc";
    private Map<String, String> params;

    public ServerRequests(String name, String username, String  email, String password,
                          String telNum, String address, String gender, String dob, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL, listener, null);

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

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}