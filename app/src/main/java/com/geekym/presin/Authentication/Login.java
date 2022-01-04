package com.geekym.presin.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.geekym.presin.HomeScreen;
import com.geekym.presin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText email, pass;
    Button login;
    TextView makeAcc;
    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Auth = FirebaseAuth.getInstance();
        makeAcc = findViewById(R.id.noacc);
        login = findViewById(R.id.button);
        email = findViewById(R.id.loginemail);
        pass = findViewById(R.id.loginpass);
        CheckBox checkBox = findViewById(R.id.checkBox);

        //checkbox function
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = login.getText().toString();
                String passtext = pass.getText().toString();

                if (emailtext.isEmpty()){
                    email.setError("Field can't be empty");
                    email.requestFocus();
                    return;
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
                    email.setError("Please enter a valid Email id");
                    email.requestFocus();
                    return;
                }
                else if (passtext.isEmpty()){
                    pass.setError("Field can't be empty");
                    pass.requestFocus();
                    return;
                }
                else if (passtext.length()<6){
                    pass.setError("Password must be atleast 6 characters");
                    pass.requestFocus();
                    return;
                }
                else {
                    Auth.signInWithEmailAndPassword(emailtext,passtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                if (user.isEmailVerified()){
                                    Intent intent = new Intent(getApplicationContext(),HomeScreen.class);
                                    startActivity(intent);
                                    finishAffinity();
                                }
                                else{
                                    user.sendEmailVerification();
                                    Toast.makeText(getApplicationContext(), "Check your email to verify your account and Login again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });

                }
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