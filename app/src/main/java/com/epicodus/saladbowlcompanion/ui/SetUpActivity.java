package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.saladbowlcompanion.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetUpActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.quickModeButton) Button mQuickModeButton;
    @Bind(R.id.creativeModeButton) Button mCreativeModeButton;
    @Bind(R.id.teamEditText) EditText mTeamEditText;

    int team;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ButterKnife.bind(this);
        mQuickModeButton.setOnClickListener(this);
        mCreativeModeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        team = Integer.parseInt(mTeamEditText.getText().toString());
        Log.v("SetUpActivity", "the number of teams is: " + team);
        if (view == mQuickModeButton) {
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            startActivity(intent);
        }
        if (view == mCreativeModeButton) {
            Intent intent = new Intent(SetUpActivity.this, CreativeModeActivity.class);
            startActivity(intent);
        }

    }
}
