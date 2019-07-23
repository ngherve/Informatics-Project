package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    /*private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mToggle;*/

    private CardView c_profile, c_logoff, c_stock, c_notifications, c_reports, c_scanitems, c_updateitems, c_delete_items ;
    String name, username, pass, email, gender, Address, user_type, DOB, Tel, photo, message;
    int id;
    TextView prof, eml;
    DrawerLayout drw_layout;
    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*mdrawer = (DrawerLayout) findViewById(R.id.nav_drawer);
        mToggle = new ActionBarDrawerToggle(this, mdrawer, R.string.open , R.string.close);
        mdrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        drw_layout = findViewById(R.id.nav_drawer);
        nav_view = findViewById(R.id.nav_menu);
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

        prof = (TextView) findViewById(R.id.nav_Profile_name);
        eml = (TextView) findViewById(R.id.nav_Profile_email);

        /*prof.setText(name);
        eml.setText(email);*/
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/



    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.profile:
                Intent intent = new Intent(NotificationActivity.this, ProfileActivity.class);
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
                Intent intent1 = new Intent(NotificationActivity.this, LoginActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
                break;
            case R.id.scan_item:

                break;
            case R.id.stock:
                startActivity(new Intent(NotificationActivity.this, StockActivity.class));
                break;
            case R.id.updateitems:
                break;
            case R.id.viewreports:
                break;
            case R.id.saveitem:
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //Menu menu = menuItem.get;
        //MenuItem logt = menu.findItem(R.id.logout_menu);
        if(menuItem.getItemId() == R.id.logout_menu){
            Intent intent2 = new Intent(NotificationActivity.this, LoginActivity.class);
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
