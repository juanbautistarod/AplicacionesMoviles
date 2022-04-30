package com.example.flashlight;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    private ImageView turnOn, turnOff;
    private static final int CAMERA_REQUEST = 50;
    private boolean flashLightStatus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        turnOn = findViewById(R.id.turnOn);
        turnOff = findViewById(R.id.turnOff);

        final boolean hasCameraFlash = getPackageManager().hasSystemFeature((PackageManager.FEATURE_CAMERA_FLASH));
        boolean isEnable = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;

        turnOn.setEnabled(isEnable);
        turnOff.setEnabled(isEnable);

        turnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasCameraFlash){
                    if (flashLightStatus){
                        flashLightOff();
                    } else {
                        flashLightOn();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Linterna no disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        turnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hasCameraFlash){
                    if (flashLightStatus){
                        flashLightOff();
                    } else {
                        flashLightOn();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Linterna no disponible", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void flashLightOff() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
            flashLightStatus = false;
            turnOff.setVisibility(View.GONE);
            turnOn.setVisibility(View.VISIBLE);
        } catch (CameraAccessException e) {
        }
    }

    private void flashLightOn() {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
            flashLightStatus = true;
            turnOn.setVisibility(View.GONE);
            turnOff.setVisibility(View.VISIBLE);
        } catch (CameraAccessException e) {
        }
    }

}
