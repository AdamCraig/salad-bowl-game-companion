package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.models.Team;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.team1Round1) TextView mTeam1Round1;
    @Bind(R.id.team1Round2) TextView mTeam1Round2;
    @Bind(R.id.team1Round3) TextView mTeam1Round3;
    @Bind(R.id.team1FinalScore) TextView mTeam1FinalScore;
    @Bind(R.id.team2Round1) TextView mTeam2Round1;
    @Bind(R.id.team2Round2) TextView mTeam2Round2;
    @Bind(R.id.team2Round3) TextView mTeam2Round3;
    @Bind(R.id.team2FinalScore) TextView mTeam2FinalScore;
    @Bind(R.id.team3Round1) TextView mTeam3Round1;
    @Bind(R.id.team3Round2) TextView mTeam3Round2;
    @Bind(R.id.team3Round3) TextView mTeam3Round3;
    @Bind(R.id.team3FinalScore) TextView mTeam3FinalScore;
    @Bind(R.id.team4Round1) TextView mTeam4Round1;
    @Bind(R.id.team4Round2) TextView mTeam4Round2;
    @Bind(R.id.team4Round3) TextView mTeam4Round3;
    @Bind(R.id.team4FinalScore) TextView mTeam4FinalScore;
    @Bind(R.id.team5Round1) TextView mTeam5Round1;
    @Bind(R.id.team5Round2) TextView mTeam5Round2;
    @Bind(R.id.team5Round3) TextView mTeam5Round3;
    @Bind(R.id.team5FinalScore) TextView mTeam5FinalScore;
    @Bind(R.id.team6Round1) TextView mTeam6Round1;
    @Bind(R.id.team6Round2) TextView mTeam6Round2;
    @Bind(R.id.team6Round3) TextView mTeam6Round3;
    @Bind(R.id.team6FinalScore) TextView mTeam6FinalScore;
    @Bind(R.id.playButton) Button mPlayButton;

    public ArrayList<Team> teamArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        ButterKnife.bind(this);
        mPlayButton.setOnClickListener(this);

        teamArray = Parcels.unwrap(getIntent().getParcelableExtra("teamArray"));

        if (teamArray.size() > 1) {
            mTeam1Round1.setText(teamArray.get(0).getRound1Score() + "");
            mTeam1Round2.setText(teamArray.get(0).getRound2Score() + "");
            mTeam1Round3.setText(teamArray.get(0).getRound3Score() + "");
            mTeam1FinalScore.setText(teamArray.get(0).getFinalScore() + "");
            mTeam1FinalScore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (teamArray.size() >= 2) {
            mTeam2Round1.setText(teamArray.get(1).getRound1Score() + "");
            mTeam2Round2.setText(teamArray.get(1).getRound2Score() + "");
            mTeam2Round3.setText(teamArray.get(1).getRound3Score() + "");
            mTeam2FinalScore.setText(teamArray.get(1).getFinalScore() + "");
            mTeam2FinalScore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (teamArray.size() >= 3) {
            mTeam3Round1.setText(teamArray.get(2).getRound1Score() + "");
            mTeam3Round2.setText(teamArray.get(2).getRound2Score() + "");
            mTeam3Round3.setText(teamArray.get(2).getRound3Score() + "");
            mTeam3FinalScore.setText(teamArray.get(2).getFinalScore() + "");
            mTeam3FinalScore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (teamArray.size() >= 4) {
            mTeam4Round1.setText(teamArray.get(3).getRound1Score() + "");
            mTeam4Round2.setText(teamArray.get(3).getRound2Score() + "");
            mTeam4Round3.setText(teamArray.get(3).getRound3Score() + "");
            mTeam4FinalScore.setText(teamArray.get(3).getFinalScore() + "");
            mTeam4FinalScore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (teamArray.size() >= 5) {
            mTeam5Round1.setText(teamArray.get(4).getRound1Score() + "");
            mTeam5Round2.setText(teamArray.get(4).getRound2Score() + "");
            mTeam5Round3.setText(teamArray.get(4).getRound3Score() + "");
            mTeam5FinalScore.setText(teamArray.get(4).getFinalScore() + "");
            mTeam5FinalScore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        if (teamArray.size() >= 6) {
            mTeam6Round1.setText(teamArray.get(5).getRound1Score() + "");
            mTeam6Round2.setText(teamArray.get(5).getRound2Score() + "");
            mTeam6Round3.setText(teamArray.get(5).getRound3Score() + "");
            mTeam6FinalScore.setText(teamArray.get(5).getFinalScore() + "");
            mTeam6FinalScore.setTextColor(Color.parseColor("#FFFFFF"));
        }

        int highestScore = 0;

        for(int i = 0; i < teamArray.size(); i++) {
            int teamFinalScore = teamArray.get(i).getFinalScore();
            if (teamFinalScore > highestScore) {
                highestScore = teamFinalScore;
            }
        }

        if (Integer.parseInt(mTeam1FinalScore.getText().toString()) == highestScore) {
            mTeam1FinalScore.setBackgroundColor(Color.parseColor("#dadada"));
            mTeam1FinalScore.setTextColor(Color.parseColor("#000000"));
        }
        if (Integer.parseInt(mTeam2FinalScore.getText().toString()) == highestScore) {
            mTeam2FinalScore.setBackgroundColor(Color.parseColor("#dadada"));
            mTeam2FinalScore.setTextColor(Color.parseColor("#000000"));
        }
        if (Integer.parseInt(mTeam3FinalScore.getText().toString()) == highestScore) {
            mTeam3FinalScore.setBackgroundColor(Color.parseColor("#dadada"));
            mTeam3FinalScore.setTextColor(Color.parseColor("#000000"));
        }
        if (Integer.parseInt(mTeam4FinalScore.getText().toString()) == highestScore) {
            mTeam4FinalScore.setBackgroundColor(Color.parseColor("#dadada"));
            mTeam4FinalScore.setTextColor(Color.parseColor("#000000"));
        }
        if (Integer.parseInt(mTeam5FinalScore.getText().toString()) == highestScore) {
            mTeam5FinalScore.setBackgroundColor(Color.parseColor("#dadada"));
            mTeam5FinalScore.setTextColor(Color.parseColor("#000000"));
        }
        if (Integer.parseInt(mTeam6FinalScore.getText().toString()) == highestScore) {
            mTeam6FinalScore.setBackgroundColor(Color.parseColor("#dadada"));
            mTeam6FinalScore.setTextColor(Color.parseColor("#000000"));
        }



    }

    @Override
    public void onClick(View view) {
        if (view == mPlayButton) {
            Intent intent = new Intent(GameOverActivity.this, SetUpActivity.class);
            startActivity(intent);
        }
    }
}
