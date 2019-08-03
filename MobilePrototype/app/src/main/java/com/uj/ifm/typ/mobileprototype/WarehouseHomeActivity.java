package com.uj.ifm.typ.mobileprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
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
import java.util.List;
import java.util.Map;

public class WarehouseHomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    public static int userIDw;

    private CardView c_profile, c_logoff, c_stock, c_notifications, c_reports, c_scanitems, c_updateitems, c_delete_items ;
    String name, username, pass, email, gender, Address, user_type, DOB, Tel, photo, message;
    public static TextView txtNumItems2, txtNumNotif;
    int id;
    TextView prof, eml;
    DrawerLayout drw_layout;
    NavigationView nav_view;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse_home);

        countProduct();
        countNotification();

        drw_layout = findViewById(R.id.nav_drawer1);
        nav_view = findViewById(R.id.nav_menu1);
        nav_view.setNavigationItemSelectedListener(this);

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

        ImageView iv = (ImageView) findViewById(R.id.profilepic1);
        new HomeActivity.GetImageFromURL(iv).execute(photo);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.profile1:
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
                //startActivity(new Intent(HomeActivity.this, ReportsActivity.class));
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
        StringRequest strRequest = new StringRequest(Request.Method.POST, "http://10.254.17.96:80/script/ViewNotifications.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            String numNotifReport = "Notifications: " + String.valueOf(jsonarray.length());
                            if(LoginActivity.usertype.equals("stock"))
                                HomeActivity.txtNumNotif.setText(numNotifReport);
                            if(LoginActivity.usertype.equals("warehouse"))
                                WarehouseHomeActivity.txtNumNotif.setText(numNotifReport);

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
                if(LoginActivity.usertype.equals("warehouse"))
                    params.put("UserID", String.valueOf(WarehouseHomeActivity.userIDw));
                else if(LoginActivity.usertype.equals("stock"))
                    params.put("UserID", String.valueOf(HomeActivity.userID));
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

                    for(int i=0; i<jsonarray.length(); i++) {
                        JSONObject jsonRes = jsonarray.getJSONObject(i);
                        int P_ID = Integer.parseInt(jsonRes.getString("P_ID"));
                        String P_Name = jsonRes.getString("P_Name");
                        int P_Price = Integer.parseInt(jsonRes.getString("P_Price"));
                        String P_Image = jsonRes.getString("P_Image");
                        int P_Quantity = Integer.parseInt(jsonRes.getString("P_Quantity"));
                        String Supplier_Name = jsonRes.getString("Supplier_Name");
                        String P_Type = jsonRes.getString("P_Type");
                        String W_Name = jsonRes.getString("W_Name");
                        String P_Code = jsonRes.getString("P_Code");
                        Product product = new Product(P_ID, P_Name, P_Price, P_Image, P_Quantity, Supplier_Name, P_Type, W_Name, P_Code);

                        products.add(product);
                    }

                    List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

                    for (Product p : products) {
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("listview_title", p.getP_Name());
                        hm.put("listview_discription", p.toString());
                        //Bitmap bmp = getBitmapFromURL("https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_960_720.jpg");

                        hm.put("listview_image", Integer.toString(R.drawable.nav_image));

                        aList.add(hm);
                    }


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
            super.onBackPressed();
        }
        else {
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }
}
