package com.example.lab03;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText urlEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        urlEt = findViewById(R.id.urlEt);

        var act1Btn = findViewById(R.id.act1Btn);
        act1Btn.setOnClickListener(this::btnAct1_click);

        var act2Btn = findViewById(R.id.act2Btn);
        act2Btn.setOnClickListener(this::btnAct2_click);

        var act3Btn = findViewById(R.id.act3Btn);
        act3Btn.setOnClickListener(this::btnAct3_click);
    }



    public void btnAct1_click(View v) {
        Intent intn = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intn);
    }

    public void btnAct2_click(View v) {
        String url = urlEt.getText().toString();

        var intn = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intn);
    }

    public void btnAct3_click(View v) {
        var intn = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intn);
    }
}
