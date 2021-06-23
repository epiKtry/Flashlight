package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
private ToggleButton toggleFlashLightOnOff;
private CameraManager cameraManager;
private String getCameraID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleFlashLightOnOff = findViewById(R.id.toggleButton);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            getCameraID = cameraManager.getCameraIdList() [0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void setToggleFlashLightOnOff (View view){
        if(toggleFlashLightOnOff.isChecked()){
            try{
                cameraManager.setTorchMode(getCameraID, true);
            }
            catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
        if(!toggleFlashLightOnOff.isChecked()){
            try {
                cameraManager.setTorchMode(getCameraID, false);
            }
            catch (CameraAccessException e) {
                e.printStackTrace();
        }
        }
    }

}