package com.example.mobilprogramlamaodev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomnavi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomnavi=findViewById(R.id.menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new FragmentHome()).commit();
        bottomnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String a = item.toString();
                if(a.equals("Ana Sayfa")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new FragmentHome()).commit();
                }else if (a.equals("Arama")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new FragmentSearch()).commit();

                }else if(a.equals("Profil")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new FragmentProfile()).commit();
                }
                return false;
            }
        });

    }
}