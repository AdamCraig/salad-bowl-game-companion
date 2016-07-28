package com.epicodus.saladbowlcompanion.ui;

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

public class GameOverActivity extends AppCompatActivity {

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
    public ArrayList<View> textViewArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        ButterKnife.bind(this);

        teamArray = Parcels.unwrap(getIntent().getParcelableExtra("teamArray"));

//        for (int i = 0; i < teamArray.size(); i++) {
//            ArrayList<String> viewNames = new ArrayList<>();
//            String mTeamXRound1 = "mTeam" + (i + 1) + "Round1";
//            viewNames.add(mTeamXRound1);
//            String mTeamXRound2 = "mTeam" + (i + 1) + "Round2";
//            viewNames.add(mTeamXRound2);
//            String mTeamXRound3 = "mTeam" + (i + 1) + "Round3";
//            viewNames.add(mTeamXRound3);
//            String mTeamXFinalScore = "mTeam" + (i + 1) + "FinalScore";
//            viewNames.add(mTeamXFinalScore);
//            for (String viewName : viewNames) {
//                Log.v("GameOverActivity", viewName);
//                View view = (TextView) findViewById(R.id.viewName);
//            }
//        }

        if (teamArray.size() > 1) {
            mTeam1Round1.setText(teamArray.get(0).getRound1Score() + "");
            mTeam1Round2.setText(teamArray.get(0).getRound2Score() + "");
            mTeam1Round3.setText(teamArray.get(0).getRound3Score() + "");
            mTeam1FinalScore.setText(teamArray.get(0).getFinalScore() + "");
        }

        if (teamArray.size() >= 2) {
            mTeam2Round1.setText(teamArray.get(1).getRound1Score() + "");
            mTeam2Round2.setText(teamArray.get(1).getRound2Score() + "");
            mTeam2Round3.setText(teamArray.get(1).getRound3Score() + "");
            mTeam2FinalScore.setText(teamArray.get(1).getFinalScore() + "");
        }

        if (teamArray.size() >= 3) {
            mTeam3Round1.setText(teamArray.get(2).getRound1Score() + "");
            mTeam3Round2.setText(teamArray.get(2).getRound2Score() + "");
            mTeam3Round3.setText(teamArray.get(2).getRound3Score() + "");
            mTeam3FinalScore.setText(teamArray.get(2).getFinalScore() + "");
        }

        if (teamArray.size() >= 4) {
            mTeam4Round1.setText(teamArray.get(3).getRound1Score() + "");
            mTeam4Round2.setText(teamArray.get(3).getRound2Score() + "");
            mTeam4Round3.setText(teamArray.get(3).getRound3Score() + "");
            mTeam4FinalScore.setText(teamArray.get(3).getFinalScore() + "");
        }

        if (teamArray.size() >= 5) {
            mTeam5Round1.setText(teamArray.get(4).getRound1Score() + "");
            mTeam5Round2.setText(teamArray.get(4).getRound2Score() + "");
            mTeam5Round3.setText(teamArray.get(4).getRound3Score() + "");
            mTeam5FinalScore.setText(teamArray.get(4).getFinalScore() + "");
        }

        if (teamArray.size() >= 6) {
            mTeam6Round1.setText(teamArray.get(5).getRound1Score() + "");
            mTeam6Round2.setText(teamArray.get(5).getRound2Score() + "");
            mTeam6Round3.setText(teamArray.get(5).getRound3Score() + "");
            mTeam6FinalScore.setText(teamArray.get(5).getFinalScore() + "");
        }


    }
}
