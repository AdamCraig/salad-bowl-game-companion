package com.epicodus.saladbowlcompanion.ui;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.graphics.Typeface;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.util.ShakeDetector;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.playButton) Button mPlayButton;
    @Bind(R.id.rulesButton) Button mRulesButton;
    @Bind(R.id.aboutTextView) TextView mAboutTextView;
    @Bind(R.id. logoTextView) TextView mLogoTextView;

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf");
        mLogoTextView.setTypeface(font);

        mPlayButton.setOnClickListener(this);
        mRulesButton.setOnClickListener(this);
        mAboutTextView.setOnClickListener(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override //http://stackoverflow.com/questions/2317428/android-i-want-to-shake-it
            public void onShake() {
                Log.d("SHAKE", "SHAAAAAAAAKE");
                Toast toast = Toast.makeText(getApplicationContext(), "Device has shaken.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == mPlayButton) {
            Intent intent = new Intent (MainActivity.this, SetUpActivity.class);
            startActivity(intent);
        }

        if (view == mRulesButton) {
            Intent intent = new Intent (MainActivity.this, RulesActivity.class);
            startActivity(intent);
        }

        if (view == mAboutTextView) {
            Intent intent = new Intent (MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
}
