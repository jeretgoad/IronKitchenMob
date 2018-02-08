package com.ironkitchen.ironkitchenmob;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.InputStream;

import layout.ik_login;
import layout.ik_register;


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
