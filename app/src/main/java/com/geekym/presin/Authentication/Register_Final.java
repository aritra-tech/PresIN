package com.geekym.presin.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.geekym.presin.HomeScreen;
import com.geekym.presin.R;

import java.util.ArrayList;

public class Register_Final extends AppCompatActivity {

    Spinner branch, semester, subject_code;
    ArrayList<String> br = new ArrayList<>(), sm = new ArrayList<>(), sbc = new ArrayList<>();
    String branch_of_student, class_roll, univ_roll, sem, sub_code, email, phone, pass, name;
    EditText cr, ur;
   // Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_final);
       // Register = findViewById(R.id.button);
        branch = findViewById(R.id.branch);
        semester = findViewById(R.id.sem);
        subject_code = findViewById(R.id.sub_code);
        cr = findViewById(R.id.class_roll);
        ur = findViewById(R.id.univ_roll);
        SharedPreferences reg = getApplicationContext().getSharedPreferences("register", Context.MODE_PRIVATE);
        name=reg.getString("saved_name", "");
        phone=reg.getString("saved_phone", "");
        email=reg.getString("saved_email", "");
        pass=reg.getString("saved_pass", "");

        class_roll = cr.getText().toString();
        univ_roll = ur.getText().toString();

        br.add("CSE");
        br.add("BME");
        br.add("ECE");
        br.add("BCA");
        sm.add("1");
        sm.add("2");
        sm.add("3");
        sm.add("4");
        sm.add("5");
        sm.add("6");
        sm.add("7");
        sm.add("8");
        sbc.add("CS301");
        sbc.add("CS302");
        sbc.add("CS303");

//        Register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent x = new Intent(Register_Final.this, HomeScreen.class);
//                startActivity(x);
//                finish();
//            }
//        });

        branch.setAdapter(new ArrayAdapter<>(Register_Final.this, R.layout.support_simple_spinner_dropdown_item, br));
        branch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==-1) {
                    Toast.makeText(Register_Final.this, "Please select your branch", Toast.LENGTH_SHORT).show();
                } else {
                    branch_of_student = parent.getItemAtPosition(position).toString();;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        semester.setAdapter(new ArrayAdapter<>(Register_Final.this, R.layout.support_simple_spinner_dropdown_item, sm));
        semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==-1) {
                    Toast.makeText(Register_Final.this, "Please select your semester", Toast.LENGTH_SHORT).show();
                } else {
                    sem = parent.getItemAtPosition(position).toString();;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        subject_code.setAdapter(new ArrayAdapter<>(Register_Final.this, R.layout.support_simple_spinner_dropdown_item, sbc));
        subject_code.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==-1) {
                    Toast.makeText(Register_Final.this, "Please select your semester", Toast.LENGTH_SHORT).show();
                } else {
                    sub_code = parent.getItemAtPosition(position).toString();;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}