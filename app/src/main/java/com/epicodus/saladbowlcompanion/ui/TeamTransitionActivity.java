package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.models.Team;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamTransitionActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.scoreTitleTextView) TextView mScoreTitleTextView;
    @Bind(R.id.scoreTextView) TextView mScoreTextView;
    @Bind(R.id.scoreClosingTextView) TextView mScoreClosingTextView;
    @Bind(R.id.nextTurnButton) Button mNextTurnButton;
    @Bind(R.id.getReadyTextView) TextView mGetReadyTextView;

    public ArrayList<String> masterWordList = new ArrayList<String>();
    public ArrayList<String> currentWordList = new ArrayList<String>();
    public ArrayList<Team> teamArray = new ArrayList<>();
    public int currentRoundNumber;
    public int currentTeam;
    public boolean newRound;
    public int pointsThisTurn;
    public long timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_transitions);
        ButterKnife.bind(this);

        masterWordList = getIntent().getStringArrayListExtra("masterWordList");
        currentWordList = getIntent().getStringArrayListExtra("currentWordList");
        currentTeam = getIntent().getIntExtra("currentTeam", 0);
        currentRoundNumber = getIntent().getIntExtra("currentRoundNumber", 1);
        teamArray = Parcels.unwrap(getIntent().getParcelableExtra("teamArray"));
        pointsThisTurn = getIntent().getIntExtra("pointsThisTurn", 0);
        newRound = getIntent().getBooleanExtra("newRound", false);

        mScoreTitleTextView.setText("Team " + teamArray.get(currentTeam).getName() + " got");
        mScoreTextView.setText(pointsThisTurn + "");
        if (currentTeam + 1 == teamArray.size()) {
            mGetReadyTextView.setText("Team " + teamArray.get(0).getName() + ", get ready!");
            currentTeam = 0;
        } else {
            currentTeam++;
            mGetReadyTextView.setText("Team " + teamArray.get(currentTeam).getName() + ", get ready!");
        }
        mNextTurnButton.setText("START " + teamArray.get(currentTeam).getName() + "'S TURN");

        if (newRound) {
            currentRoundNumber++;
        }

        mNextTurnButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mNextTurnButton) {
            Intent intent = new Intent(TeamTransitionActivity.this, GameActivity.class);
            intent.putExtra("masterWordList", masterWordList);
            intent.putExtra("currentWordList", currentWordList);
            intent.putExtra("currentTeam", currentTeam);
            intent.putExtra("currentRoundNumber", currentRoundNumber);
            intent.putExtra("teamArray", Parcels.wrap(teamArray));
            intent.putExtra("newRound", newRound);
            startActivity(intent);
        }
    }
}
