package com.epicodus.saladbowlcompanion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.playButton) Button mPlayButton;
    @Bind(R.id.rulesButton) Button mRulesButton;
    @Bind(R.id.aboutTextView) TextView mAboutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPlayButton.setOnClickListener(this);
        mRulesButton.setOnClickListener(this);
        mAboutTextView.setOnClickListener(this);
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
}
