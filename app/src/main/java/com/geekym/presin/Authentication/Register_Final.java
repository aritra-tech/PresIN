package com.geekym.presin.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.geekym.presin.HomeScreen;
import com.geekym.presin.R;

public class Register_Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_final);

        Button reg2 = findViewById(R.id.button);

        reg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Final.this, HomeScreen.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }
}