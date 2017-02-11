package com.ken.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initFragments();
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == 2) {
            View viewById = findViewById(R.id.fragment1);
            viewById.setVisibility(View.GONE);
        }
    }

    private void initFragments() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment1 fragment = new Fragment1();
        fragmentTransaction.replace(R.id.fragment1, fragment);
        fragmentTransaction.commit();


        android.support.v4.app.FragmentManager supportFragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction2 = supportFragmentManager.beginTransaction();

        Fragment2 fragment2 = new Fragment2();
        fragmentTransaction2.replace(R.id.fragment2, fragment2);
        fragmentTransaction2.commit();

    }
}
