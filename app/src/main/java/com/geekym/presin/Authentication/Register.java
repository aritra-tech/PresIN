package com.geekym.presin.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.geekym.presin.R;

public class Register extends AppCompatActivity {

    Button reg1;
    SharedPreferences reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg = getSharedPreferences("register", Context.MODE_PRIVATE);

        EditText Name = findViewById(R.id.editTextTextPersonName);
        EditText Email = findViewById(R.id.editTextTextEmailAddress);
        EditText Phone = findViewById(R.id.editTextphone);
        EditText Pass = findViewById(R.id.editTextTextPassword);

        reg1 = findViewById(R.id.button);
        TextView exists = findViewById(R.id.haveacc);

        reg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = reg.edit();
                editor.putString("saved_name", Name.getText().toString());
                editor.putString("saved_email", Email.getText().toString());
                editor.putString("saved_phone", Phone.getText().toString());
                editor.putString("saved_pass", Pass.getText().toString());
                editor.commit();
                Intent intent = new Intent(Register.this, Register_Final.class);
                startActivity(intent);
            }
        });

        exists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}