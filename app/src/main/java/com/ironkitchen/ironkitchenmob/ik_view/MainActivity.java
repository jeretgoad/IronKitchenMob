package com.ironkitchen.ironkitchenmob.ik_view;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ironkitchen.ironkitchenmob.R;


public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent thisIntent = new Intent(this, HomeTabActivity.class);
        startActivity(thisIntent);
        //fm.beginTransaction().replace(R.id.content, new ik_login()).commit();

    }
}
