package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import org.json.JSONException;
import org.json.JSONObject;
import pub.devrel.easypermissions.EasyPermissions;

import java.util.StringTokenizer;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    public String qrResult;
    private String P_Name, P_Price, P_Image, P_Quantity, P_Type, Supplier_Name, W_Name, P_Code, bin_location;

    ZXingScannerView scannerview;
    Vibrator vibrator;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerview = new ZXingScannerView(this);
        setContentView(scannerview);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void handleResult(Result result) {
        qrResult = result.getText();

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            vibrator.vibrate(200);
        }

        StringTokenizer st = new StringTokenizer(qrResult, "\n");

        if(st.countTokens()==8)
        {
            P_Name = st.nextToken();
            P_Price = st.nextToken();
            P_Image = st.nextToken();
            P_Quantity = st.nextToken();
            Supplier_Name = st.nextToken();
            P_Type = st.nextToken();
            W_Name = st.nextToken();
            P_Code = st.nextToken();

            Response.Listener<String> respList1 = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonRes = new JSONObject(response);
                        boolean success = jsonRes.getBoolean("success");

                        //ScanItemsActivity.resultView.setText("Product Info: \nItem: " + P_Name + " Code: " + P_Code + " Price: " +
                         //       P_Price + " Quantity: " + P_Quantity + " Supplier: " + Supplier_Name +
                          //      " Type: " + P_Type + " Warehouse: " + W_Name + "\nBin Location: " + bin_location);
                        if (success && LoginActivity.usertype.equals("stock")) {
                           // ScanItemsActivity.resultView.setText("Item: " + P_Name + " Code: " + P_Code + " already exists in stock!!!");

                            P_Name = jsonRes.getString("P_Name");
                            P_Price = String.valueOf(jsonRes.getInt("P_Price"));
                            P_Image = jsonRes.getString("P_Image");
                            P_Quantity = String.valueOf(jsonRes.getInt("P_Quantity"));
                            Supplier_Name = jsonRes.getString("Supplier_Name");
                            P_Type = jsonRes.getString("P_Type");
                            W_Name = jsonRes.getString("W_Name");
                            P_Code = jsonRes.getString("P_Code");
                            bin_location = jsonRes.getString("bin_location");

                            Intent intent = new Intent(ScannerActivity.this, EditQuantActivity.class);
                            intent.putExtra("P_Name", P_Name);
                            intent.putExtra("P_Price", P_Price);
                            intent.putExtra("P_Image", P_Image);
                            intent.putExtra("P_Quantity", P_Quantity);
                            intent.putExtra("Supplier_Name", Supplier_Name);
                            intent.putExtra("P_Type", P_Type);
                            intent.putExtra("W_Name", W_Name);
                            intent.putExtra("P_Code", P_Code);
                            intent.putExtra("bin_location", bin_location);
                            ScannerActivity.this.startActivity(intent);

                        } else if (success && LoginActivity.usertype.equals("warehouse")) {
                            P_Name = jsonRes.getString("P_Name");
                            P_Price = String.valueOf(jsonRes.getInt("P_Price"));
                            P_Image = jsonRes.getString("P_Image");
                            P_Quantity = String.valueOf(jsonRes.getInt("P_Quantity"));
                            Supplier_Name = jsonRes.getString("Supplier_Name");
                            P_Type = jsonRes.getString("P_Type");
                            W_Name = jsonRes.getString("W_Name");
                            P_Code = jsonRes.getString("P_Code");
                            bin_location = jsonRes.getString("bin_location");
                            ScanItemsActivity.resultView.setText("Product Info: \nItem: " + P_Name + " Code: " + P_Code + " Price: " +
                                    P_Price + " Quantity: " + P_Quantity + " Supplier: " + Supplier_Name +
                                    " Type: " + P_Type + " Warehouse: " + W_Name + "\nBin Location: " + bin_location);

                            Intent intent = new Intent(ScannerActivity.this, DispatchActivity.class);
                            intent.putExtra("P_Name", P_Name);
                            intent.putExtra("P_Price", P_Price);
                            intent.putExtra("P_Image", P_Image);
                            intent.putExtra("P_Quantity", P_Quantity);
                            intent.putExtra("Supplier_Name", Supplier_Name);
                            intent.putExtra("P_Type", P_Type);
                            intent.putExtra("W_Name", W_Name);
                            intent.putExtra("P_Code", P_Code);
                            intent.putExtra("bin_location", bin_location);
                            ScannerActivity.this.startActivity(intent);

                        } else if (success == false && LoginActivity.usertype.equals("stock")) {
                            Intent intent = new Intent(ScannerActivity.this, SaveItemActivity.class);
                            intent.putExtra("P_Name", P_Name);
                            intent.putExtra("P_Price", P_Price);
                            intent.putExtra("P_Image", P_Image);
                            intent.putExtra("P_Quantity", P_Quantity);
                            intent.putExtra("Supplier_Name", Supplier_Name);
                            intent.putExtra("P_Type", P_Type);
                            intent.putExtra("W_Name", W_Name);
                            intent.putExtra("P_Code", P_Code);
                            intent.putExtra("bin_location", bin_location);
                            ScannerActivity.this.startActivity(intent);
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                }
            };

            ServerRequests loginReq1 = new ServerRequests(P_Code, respList1);
            RequestQueue queue1 = Volley.newRequestQueue(ScannerActivity.this);
            queue1.add(loginReq1);
            super.onBackPressed();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(ScannerActivity.this);
            builder.setMessage("Invalid Product Format!!").setNegativeButton("Retry", null).create().show();
            startActivity(new Intent(ScannerActivity.this, ScannerActivity.class));
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerview.setResultHandler(this);
        scannerview.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();

        scannerview.stopCamera();
    }

}
