package com.uj.ifm.typ.mobileprototype;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    public static int userID;

    private CardView c_profile, c_logoff, c_stock, c_notifications, c_reports, c_scanitems, c_updateitems, c_delete_items ;
    private String name, username, pass, email, gender, Address, user_type, DOB, Tel, photo;
    public static TextView txtNumItems, txtNumNotif;
    private int id;
    TextView prof, eml;
    public static boolean isSearch = false;
    private SessionManager sm;


    //Class for download IMAGE
    public static class GetImageFromURL extends AsyncTask<String, Void, Bitmap> {
        ImageView imgV;
        Bitmap bitmap;

        public GetImageFromURL(ImageView imgV){
            this.imgV = imgV;
        }

        @Override
        protected Bitmap doInBackground(String... url) {
            String urldisplay = url[0];
            bitmap = null;
            try {
                InputStream srt = new java.net.URL(urldisplay).openStream();
                bitmap = BitmapFactory.decodeStream(srt);
            } catch (Exception e){
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgV.setImageBitmap(bitmap);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        if(item.getItemId() == R.id.logout_menu){
            sm.logout();
            Intent intent2 = new Intent(HomeActivity.this, LoginActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent2);
        } else if(item.getItemId() == R.id.db){
            Intent intent2 = new Intent(HomeActivity.this, HomeActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent2);
        } else if(item.getItemId() == R.id.search){
            HomeActivity.isSearch = true;
            //ScanItemsActivity.issearch2=true;
            Intent intent2 = new Intent(HomeActivity.this, ScanItemsActivity.class);
            startActivity(intent2);
        }
        else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sm = new SessionManager(this);
        sm.checkLogin();
        HashMap<String, String> user = sm.getUserDetail();
        String mName = user.get(SessionManager.NAME);
        String mEmail = user.get(SessionManager.EMAIL);

        refreshPage();
        countProduct();

        userID = id;

        c_profile = (CardView) findViewById(R.id.profile);
        c_profile.setOnClickListener(this);

        c_logoff = (CardView) findViewById(R.id.logoff);
        c_logoff.setOnClickListener(this);

        c_notifications = (CardView) findViewById(R.id.notifications);
        c_notifications.setOnClickListener(this);

        c_scanitems = (CardView) findViewById(R.id.scan_item);
        c_scanitems.setOnClickListener(this);

        c_stock = (CardView) findViewById(R.id.stock);
        c_stock.setOnClickListener(this);

        c_reports = (CardView) findViewById(R.id.viewreports);
        c_reports.setOnClickListener(this);

        c_updateitems = (CardView) findViewById(R.id.updateitems);
        c_updateitems.setOnClickListener(this);

        c_delete_items = (CardView) findViewById(R.id.saveitem);
        c_delete_items.setOnClickListener(this);

        txtNumItems = findViewById(R.id.numitems);

        txtNumNotif = findViewById(R.id.numNotif);

        prof = (TextView) findViewById(R.id.nav_Profile_name);
        eml = (TextView) findViewById(R.id.nav_Profile_email);

        countNotification();

        NavigationView navigationView = findViewById(R.id.nav_menu);
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
                            Toast.makeText(HomeActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("UserID", String.valueOf(LoginActivity.userID));

                return params;
            }
        };


        RequestQueue reqQue = Volley.newRequestQueue(HomeActivity.this);
        reqQue.add(strRequest);
    }

    public void countNotification(){
        StringRequest strRequest = new StringRequest(Request.Method.POST, ServerRequests.REQUEST_URL + "ViewNotifications.php",
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonarray = new JSONArray(response);
                            HomeActivity.txtNumNotif.setText("Notifications: " + jsonarray.length());
                            String message = "";
                            for (int i = 0; i < jsonarray.length(); i++) {
                                final JSONObject jsonRes = jsonarray.getJSONObject(i);
                                message += i+1+"- " + jsonRes.getString("Message") + "\n" +
                                        jsonRes.getString("N_Email") + "\n" +
                                        jsonRes.getString("N_Datetime") + "\n";
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(HomeActivity.this, "Try Again" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeActivity.this, "Try Again! " + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("UserID", String.valueOf(LoginActivity.userID));
                return params;
            }
        };

        RequestQueue reqQue = Volley.newRequestQueue(HomeActivity.this);
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
        RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
        queue.add(loginReq);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.profile:
                refreshPage();
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
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
            case R.id.logoff:
                sm.logout();
                Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
                break;
            case R.id.scan_item:
                startActivity(new Intent(HomeActivity.this, ScanItemsActivity.class));
                break;
            case R.id.stock:
                startActivity(new Intent(HomeActivity.this, StockActivity.class));
                break;
            case R.id.updateitems:
                startActivity(new Intent(HomeActivity.this, EditItemsActivity.class));
                break;
            case R.id.viewreports:
                startActivity(new Intent(HomeActivity.this, ViewInvoices.class));
                break;
            case R.id.notifications:
                final String[] options = {"Notify User", "View Notifications", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                builder.setTitle("Please Choose an Option");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(options[which].equals("Notify User")){
                            startActivity(new Intent(HomeActivity.this, NotifictionActivity.class));
                        }else if(options[which].equals("View Notifications")){
                            startActivity(new Intent(HomeActivity.this, ViewNotifications.class));

                        } else if(options[which].equals("Cancel")){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
                break;
            case R.id.saveitem:
                startActivity(new Intent(HomeActivity.this, SaveItemActivity.class));
                break;
        }
    }
}
