package com.uj.ifm.typ.mobileprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WarehouseHomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    public static int userIDw;

    private CardView c_profile, c_logoff, c_stock, c_notifications, c_reports, c_scanitems ;
    private String name, username, pass, email, gender, Address, user_type, DOB, Tel, photo;
    public static TextView txtNumItems2, txtNumNotif;
    int id;
    TextView prof, eml;
    private SessionManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_home);

        sm = new SessionManager(this);
        sm.checkLogin();

        refreshPage();
        userIDw = id;

        c_profile = (CardView) findViewById(R.id.profile1);
        c_profile.setOnClickListener(this);

        c_logoff = (CardView) findViewById(R.id.logoff1);
        c_logoff.setOnClickListener(this);

        c_notifications = (CardView) findViewById(R.id.notifications1);
        c_notifications.setOnClickListener(this);

        c_scanitems = (CardView) findViewById(R.id.scan_item1);
        c_scanitems.setOnClickListener(this);

        c_stock = (CardView) findViewById(R.id.stock1);
        c_stock.setOnClickListener(this);

        c_reports = (CardView) findViewById(R.id.viewreports1);
        c_reports.setOnClickListener(this);

        txtNumItems2 = findViewById(R.id.numitems2);
        txtNumNotif = findViewById(R.id.numNotif1);

        prof = (TextView) findViewById(R.id.nav_Profile_name);
        eml = (TextView) findViewById(R.id.nav_Profile_email);

        countProduct();
        countNotification();

        NavigationView navigationView = findViewById(R.id.nav_menu1);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_Profile_name);
        navUsername.setText(LoginActivity.name);
        TextView navEmail = (TextView) headerView.findViewById(R.id.nav_Profile_email);
        navEmail.setText(LoginActivity.email);
        ImageView navprofimage = (ImageView) headerView.findViewById(R.id.profilemenuimage);
        new HomeActivity.GetImageFromURL(navprofimage).execute(LoginActivity.photo);
    }

    public void refreshPage(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "QueryUserByID.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRes = new JSONObject(response);

                            id = jsonRes.getInt("UserID");
                            name = jsonRes.getString("Name");
                            username = jsonRes.getString("Username");
                            email = jsonRes.getString("Email");
                            pass = jsonRes.getString("Password");
                            Tel = jsonRes.getString("Tel_Number");
                            Address = jsonRes.getString("Address");
                            gender = jsonRes.getString("Gender");
                            DOB = jsonRes.getString("DOB");
                            user_type = jsonRes.getString("User_Type");
                            photo = jsonRes.getString("pphoto");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(WarehouseHomeActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(WarehouseHomeActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("UserID", String.valueOf(LoginActivity.userID));

                return params;
            }
        };


        RequestQueue reqQue = Volley.newRequestQueue(WarehouseHomeActivity.this);
        reqQue.add(strRequest);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.profile1:
                refreshPage();
                Intent intent = new Intent(WarehouseHomeActivity.this, ProfileActivity.class);
                intent.putExtra("UserID", id);
                intent.putExtra("Name", name);
                intent.putExtra("Username", username);
                intent.putExtra("Email", email);
                intent.putExtra("Password", pass);
                intent.putExtra("Tel_Number", Tel);
                intent.putExtra("Address", Address);
                intent.putExtra("Gender", gender);
                intent.putExtra("DOB", DOB);
                intent.putExtra("User_Type", user_type);
                intent.putExtra("pphoto", photo);
                startActivity(intent);

                break;
            case R.id.logoff1:
                Intent intent1 = new Intent(WarehouseHomeActivity.this, LoginActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
                break;
            case R.id.scan_item1:
                startActivity(new Intent(WarehouseHomeActivity.this, ScanItemsActivity.class));
                break;
            case R.id.stock1:
                startActivity(new Intent(WarehouseHomeActivity.this, StockActivity.class));
                break;

            case R.id.viewreports1:
                startActivity(new Intent(WarehouseHomeActivity.this, ViewInvoices.class));
                break;
            case R.id.notifications1:
                final String[] options = {"Notify User", "View Notifications", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(WarehouseHomeActivity.this);
                builder.setTitle("Please Choose an Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(options[which].equals("Notify User")){
                            startActivity(new Intent(WarehouseHomeActivity.this, NotifictionActivity.class));
                        }else if(options[which].equals("View Notifications")){
                            startActivity(new Intent(WarehouseHomeActivity.this, ViewNotifications.class));

                        } else if(options[which].equals("Cancel")){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
                break;
        }
    }

    public void countNotification(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "ViewNotifications.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            WarehouseHomeActivity.txtNumNotif.setText("Notifications: " + jsonarray.length());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(WarehouseHomeActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(WarehouseHomeActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("UserID", String.valueOf(LoginActivity.userID));
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(WarehouseHomeActivity.this);
        reqQue.add(strRequest);
    }

    public void countProduct(){
        Response.Listener<String> respList = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{
                    ArrayList<Product> products = new ArrayList<Product>();
                    JSONArray jsonarray = new JSONArray(response);
                    String numItemReport = "Items in Stock: " + String.valueOf(jsonarray.length());
                    if(LoginActivity.usertype.equals("stock"))
                        HomeActivity.txtNumItems.setText(numItemReport);
                    if(LoginActivity.usertype.equals("warehouse"))
                        WarehouseHomeActivity.txtNumItems2.setText(numItemReport);

                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        };

        ServerRequests loginReq = new ServerRequests(respList);
        RequestQueue queue = Volley.newRequestQueue(WarehouseHomeActivity.this);
        queue.add(loginReq);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //Menu menu = menuItem.get;
        //MenuItem logt = menu.findItem(R.id.logout_menu);
        if(menuItem.getItemId() == R.id.logout_menu){
            Intent intent2 = new Intent(WarehouseHomeActivity.this, LoginActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent2);
        } else if(menuItem.getItemId() == R.id.db){
            Intent intent2 = new Intent(WarehouseHomeActivity.this, WarehouseHomeActivity
                    .class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent2);
        } else if(menuItem.getItemId() == R.id.search){
            Intent intent2 = new Intent(WarehouseHomeActivity.this, ScannerSearchActivity.class);
            startActivity(intent2);
        } else if(menuItem.getItemId() == R.id.activities){
            Intent intent2 = new Intent(WarehouseHomeActivity.this, TaskActivity.class);
            startActivity(intent2);
        }
        else {
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }
}
