package com.example.lab03;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getOnBackPressedDispatcher().addCallback(this, new BackHandler());
    }



    private class BackHandler extends OnBackPressedCallback {
        public BackHandler() {
            super(true);
        }

        @Override
        public void handleOnBackPressed() {
            var intn = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intn);
        }
    }
}