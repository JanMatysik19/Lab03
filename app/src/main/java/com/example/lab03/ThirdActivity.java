package com.example.lab03;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ThirdActivity extends AppCompatActivity {
    private Button startBtn, stopBtn;
    private TextView widthTv, lengthTv;
    private LocationManager locationManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);

        widthTv = findViewById(R.id.widthTv);
        lengthTv = findViewById(R.id.lengthTv);
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);

        stopBtn.setEnabled(false);
        startBtn.setEnabled(true);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationChangeHandler());
    }



    public void startBtn_click(View v) {
        startBtn.setEnabled(false);
        stopBtn.setEnabled(true);

        widthTv.setText("...");
        lengthTv.setText("...");
    }

    public void stopBtn_click(View v) {
        startBtn.setEnabled(true);
        stopBtn.setEnabled(false);

        widthTv.setText("-");
        lengthTv.setText("-");
    }

    private class LocationChangeHandler implements LocationListener {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            if(startBtn.isEnabled()) return;

            var width = String.valueOf(location.getLatitude());
            widthTv.setText(width);

            var length = String.valueOf(location.getLongitude());
            lengthTv.setText(length);
        }
    }
}
