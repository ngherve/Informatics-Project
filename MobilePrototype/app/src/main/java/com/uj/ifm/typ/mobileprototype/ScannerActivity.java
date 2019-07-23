package com.uj.ifm.typ.mobileprototype;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

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
        ScanItemsActivity.resultView.setText(result.getText());
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        }else {
            vibrator.vibrate(200);
        }
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
