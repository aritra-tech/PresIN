package com.geekym.presin;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Attendance_Scanner extends AppCompatActivity {

    CodeScanner codeScanner;
    CodeScannerView scannView;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMuuuu");
    LocalDate localDate = LocalDate.now();
    String date = dtf.format(localDate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_scanner);
        scannView = findViewById(R.id.scannerView);

        codeScanner = new CodeScanner(this,scannView);

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //resultData.setText(result.getText());
                        final String Rawresult = decrypt(result.getText());
                        String date = Rawresult.substring(0,8);
                        String SCode = Rawresult.substring(8);
                    }
                });

            }
        });



        scannView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestForCamera();

    }

    public void requestForCamera() {
        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                codeScanner.startPreview();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Toast.makeText(Attendance_Scanner.this, "Camera Permission is Required.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();

            }
        }).check();
    }

    public void onBackPressed() {
        Intent y = new Intent(Attendance_Scanner.this, HomeScreen.class);
        startActivity(y);
        finishAffinity();
    }

    public static String decrypt(String enc) {
        String dec = "";
        char[] ch = enc.toCharArray();
        for(char c : ch){
            c+=5;
            dec+=c;
        }
        return dec;
    }
}