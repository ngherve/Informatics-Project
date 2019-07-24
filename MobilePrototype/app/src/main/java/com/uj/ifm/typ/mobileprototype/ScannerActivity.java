package com.uj.ifm.typ.mobileprototype;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

import java.util.StringTokenizer;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    public String qrResult;
    private String P_Name, P_Price, P_Image, P_Quantity, P_Type, Supplier_Name, W_Name, P_Code;

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
    public void handleResult(Result result) {
        qrResult = result.getText();
        ScanItemsActivity.resultView.setText(qrResult);

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            vibrator.vibrate(200);
        }

        StringTokenizer st = new StringTokenizer(qrResult, "\n");
        ScanItemsActivity.resultView.setText("Items Successfully saved!!! :" + qrResult);
        P_Name = st.nextToken();
        P_Price = st.nextToken();
        P_Image = st.nextToken();
        P_Quantity = st.nextToken();
        Supplier_Name = st.nextToken();
        P_Type = st.nextToken();
        W_Name = st.nextToken();
        P_Code = st.nextToken();

        Intent intent = new Intent(ScannerActivity.this, SaveItemActivity.class);
        intent.putExtra("P_Name", P_Name);
        intent.putExtra("P_Price", P_Price);
        intent.putExtra("P_Image", P_Image);
        intent.putExtra("P_Quantity", P_Quantity);
        intent.putExtra("Supplier_Name", Supplier_Name);
        intent.putExtra("P_Type", P_Type);
        intent.putExtra("W_Name", W_Name);
        intent.putExtra("P_Code", P_Code);
        ScannerActivity.this.startActivity(intent);

        super.onBackPressed();
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
