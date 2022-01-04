package com.geekym.presin;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.geekym.presin.Fragments.account.account_Fragment;
import com.geekym.presin.Fragments.home.home_Fragment;
import com.geekym.presin.Fragments.attendace.scan_Fragment;
import com.geekym.presin.Fragments.tools.tools_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeScreen extends AppCompatActivity {

    BottomNavigationView bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        bottomBar = findViewById(R.id.bottomBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.main, new home_Fragment()).commit();

        bottomBar.setSelectedItemId(R.id.home);
        bottomBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new home_Fragment();
                        break;
                    case R.id.scan:
                        fragment = new scan_Fragment();
                        break;
                    case R.id.tools:
                        fragment = new tools_Fragment();
                        break;
                    case R.id.account:
                        fragment = new account_Fragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main, fragment).commit();
                return true;
            }
        });


    }
}