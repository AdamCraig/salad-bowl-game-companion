package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;
import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.models.Team;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    public Random randomNumberGenerator = new Random();
    public ArrayList<String> masterWordList = new ArrayList<String>();
    public ArrayList<String> currentWordList = new ArrayList<String>();
    public ArrayList<Team> teamArray = new ArrayList<>();
    public int randomNumber = 0;
    public int currentRoundNumber;
    public int currentTeam;
    public long timeLeft;
    public boolean newRound;
    public int pointsThisTurn = 0;

    @Bind(R.id.timerTextView) TextView mTimerTextView;
    @Bind(R.id.teamNameTextView) TextView mTeamNameTextView;
    @Bind(R.id.roundTextView) TextView mRoundTextView;
    @Bind(R.id.roundRulesTextView) TextView mRoundRulesTextView;
    @Bind(R.id.wordTextView) TextView mWordTextView;
    @Bind(R.id.correctButton) Button mGuessButton;
    @Bind(R.id.passButton) Button mPassButton;
    @Bind(R.id.gameActivityBackground) RelativeLayout mGameActivityBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        mGuessButton.setOnClickListener(this);
        mPassButton.setOnClickListener(this);
        masterWordList = getIntent().getStringArrayListExtra("masterWordList");
        newRound = getIntent().getBooleanExtra("newRound", false);

        if (newRound) {
            currentWordList = (ArrayList<String>) masterWordList.clone();
        } else {
            currentWordList = getIntent().getStringArrayListExtra("currentWordList");
        }

        newRound = false;
        currentTeam = getIntent().getIntExtra("currentTeam", 0);
        currentRoundNumber = getIntent().getIntExtra("currentRoundNumber", 1);
        teamArray = Parcels.unwrap(getIntent().getParcelableExtra("teamArray"));

        mGameActivityBackground.setBackgroundColor(Color.parseColor(teamArray.get(currentTeam).getColor()));
        countDownTimer.start();
        mTeamNameTextView.setText(teamArray.get(currentTeam).getName());
        mRoundTextView.setText("Round " + currentRoundNumber + "");
        mRoundRulesTextView.setText(getRoundRules(currentRoundNumber));
        mWordTextView.setText(currentWordList.get(randomNumber));
    }


    CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
        // https://developer.android.com/reference/android/os/CountDownTimer.html

        public void onTick(long millisUntilFinished) {
            mTimerTextView.setText(millisUntilFinished / 1000 + "");
            timeLeft = millisUntilFinished;
        }

        public void onFinish() {
            teamArray.get(currentTeam).incrementRoundScore(pointsThisTurn, currentRoundNumber);
            Intent intent = new Intent (GameActivity.this, TeamTransitionActivity.class);
            intent.putExtra("masterWordList", masterWordList);
            intent.putExtra("currentWordList", currentWordList);
            intent.putExtra("currentTeam", currentTeam);
            intent.putExtra("currentRoundNumber", currentRoundNumber);
            intent.putExtra("teamArray", Parcels.wrap(teamArray));
            intent.putExtra("newRound", newRound);
            intent.putExtra("pointsThisTurn", pointsThisTurn);
            startActivity(intent);
        }
    };


    @Override
    public void onClick(View view) {

        if (view == mGuessButton) {
            currentWordList.remove(randomNumber);
            Log.v("current list", currentWordList.size() + "");

            pointsThisTurn++;

            if (currentWordList.isEmpty()) {
                teamArray.get(currentTeam).incrementRoundScore(pointsThisTurn, currentRoundNumber);
                newRound = true;
                Intent intent = new Intent(GameActivity.this, TeamTransitionActivity.class);
                intent.putExtra("masterWordList", masterWordList);
                intent.putExtra("currentTeam", currentTeam);
                intent.putExtra("currentRoundNumber", currentRoundNumber);
                intent.putExtra("teamArray", Parcels.wrap(teamArray));
                intent.putExtra("newRound", newRound);
                intent.putExtra("pointsThisTurn", pointsThisTurn);
                startActivity(intent);
                // Transition to new round, pass turn to next team
                // Pass "round over" boolean to TeamTransition?
                // Pass timeLeft to next activity to save it and perhaps add it to that team's next turn?
            }
        }

        if (!currentWordList.isEmpty()) {
            randomNumber = randomNumberGenerator.nextInt(currentWordList.size());
            mWordTextView.setText(currentWordList.get(randomNumber));
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    public String getRoundRules(int currentRoundNumber) {
        if (currentRoundNumber == 1) {
            return "(Describe the word without using the word itself!)";
        } else if (currentRoundNumber == 2) {
            return "(Use only one KEYWORD to describe the word!)";
        } else if (currentRoundNumber == 3) {
            return "(Don't speak at all, only use gestures!)";
        } else {
            return "Invalid round number.";
        }
    }

}