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

    //Query users Request
    public ServerRequests(String user, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL+"QueryUsers.php", listener, null);
        params = new HashMap<>();
    }

    //Query products Request
    public ServerRequests(Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL+"QueryProducts.php", listener, null);
        params = new HashMap<>();
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

    //Save Product request
    public ServerRequests(String pname, String price, String image, String quantity, String suppname, String type, String warehouse, Response.Listener<String> listener) {
        super(Method.POST, REQUEST_URL+"SaveProduct.php", listener, null);
        params = new HashMap<>();
        params.put("P_Name", pname);
        params.put("P_Price", price);
        params.put("P_Image", image);
        params.put("P_Quantity", quantity);
        params.put("Supplier_Name", suppname);
        params.put("P_Type", type);
        params.put("W_Name", warehouse);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}