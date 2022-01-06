package com.geekym.presin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geekym.presin.Authentication.Register;

public class Login extends AppCompatActivity {

    Button login;
    TextView makeAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        makeAcc = findViewById(R.id.noacc);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        makeAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Login.this, Register.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}