package com.epicodus.saladbowlcompanion.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.models.Team;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;

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

    public ArrayList<Team> teamArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        teamArray = Parcels.unwrap(getIntent().getParcelableExtra("teamArray"));


    }
}
