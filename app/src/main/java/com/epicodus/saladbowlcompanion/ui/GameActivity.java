package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import com.epicodus.saladbowlcompanion.R;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    public ArrayList<String> masterWordList = new ArrayList<String>();
    public int numberOfTeams = 2;

    @Bind(R.id.timerTextView) TextView mTimerTextView;
    @Bind(R.id.teamNameTextView) TextView mTeamNameTextView;
    @Bind(R.id.roundTextView) TextView mRoundTextView;
    @Bind(R.id.roundRulesTextView) TextView mRoundRulesTextView;
    @Bind(R.id.wordTextView) TextView mWordTextView;
    @Bind(R.id.correctButton) Button mGuessButton;
    @Bind(R.id.passButton) Button mPassButton;


    int wordCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        mGuessButton.setOnClickListener(this);
        mPassButton.setOnClickListener(this);
        Intent intent = getIntent();
        masterWordList = getIntent().getStringArrayListExtra("gameWordList");
        numberOfTeams = getIntent().getIntExtra("numberOfTeams", 2);

        countDownTimer.start();
    }


    CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
        // https://developer.android.com/reference/android/os/CountDownTimer.html

        public void onTick(long millisUntilFinished) {
            mTimerTextView.setText("seconds remaining" + millisUntilFinished / 1000);
        }

        public void onFinish() {
            mTimerTextView.setText("done!");
            Intent intent = new Intent (GameActivity.this, TeamTransitionActivity.class);
            startActivity(intent);
        }
    };


    @Override
    public void onClick(View view) {

        if (view == mGuessButton) {
//            wordsFromApi.splice();

        }
        if (view == mPassButton) {
            // do nothing
        }
        wordCounter ++;
        mWordTextView.setText(masterWordList.get(wordCounter));
    }


}
