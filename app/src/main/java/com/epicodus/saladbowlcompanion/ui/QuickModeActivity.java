package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.models.Team;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuickModeActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> masterWordList = new ArrayList<>();
    int numberOfTeams;
    public boolean newRound = true;


    String[] teamNames = {"Luca", "Adam", "Nadiya", "Ashley", "Dog", "Cat"};
    String [] teamColors = {"#red", "#blue", "#green", "#yellow", "#purple", "#orange"};
    ArrayList<Team> teamArray = new ArrayList<Team>();

    @Bind(R.id.AButton) Button AButton;
    @Bind(R.id.BButton) Button BButton;
    @Bind(R.id.CButton) Button CButton;
    @Bind(R.id.DButton) Button DButton;
    @Bind(R.id.EButton) Button EButton;
    @Bind(R.id.FButton) Button FButton;
    @Bind(R.id.GButton) Button GButton;
    @Bind(R.id.HButton) Button HButton;
    @Bind(R.id.IButton) Button IButton;
    @Bind(R.id.LButton) Button LButton;
    @Bind(R.id.MButton) Button MButton;
    @Bind(R.id.NButton) Button NButton;
    @Bind(R.id.OButton) Button OButton;
    @Bind(R.id.PButton) Button PButton;
    @Bind(R.id.RButton) Button RButton;
    @Bind(R.id.SButton) Button SButton;
    @Bind(R.id.TButton) Button TButton;
    @Bind(R.id.UButton) Button UButton;
    @Bind(R.id.VButton) Button VButton;
    @Bind(R.id.WButton) Button WButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_mode);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        masterWordList = intent.getStringArrayListExtra("masterWordList");
        numberOfTeams = intent.getIntExtra("numberOfTeams", 2);

        for (int i = 0; i < numberOfTeams; i++) { // <-----------------
            Team newTeam = new Team(teamNames[i], teamColors[i]);
            teamArray.add(newTeam);
            Log.v("TeamsCreation", teamArray.get(i).getName() + "");
            Log.v("TeamsCreation", teamArray.get(i).getColor() + "");
        }

        AButton.setOnClickListener(this);
        BButton.setOnClickListener(this);
        CButton.setOnClickListener(this);
        DButton.setOnClickListener(this);
        EButton.setOnClickListener(this);
        FButton.setOnClickListener(this);
        GButton.setOnClickListener(this);
        HButton.setOnClickListener(this);
        IButton.setOnClickListener(this);
        LButton.setOnClickListener(this);
        MButton.setOnClickListener(this);
        NButton.setOnClickListener(this);
        OButton.setOnClickListener(this);
        PButton.setOnClickListener(this);
        RButton.setOnClickListener(this);
        SButton.setOnClickListener(this);
        TButton.setOnClickListener(this);
        UButton.setOnClickListener(this);
        VButton.setOnClickListener(this);
        WButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button pressedButton = (Button) view;
        String letter = pressedButton.getText().toString().toLowerCase();
        ArrayList<String> letterWordList = filterByLetter(masterWordList, letter);

        Intent intent = new Intent(QuickModeActivity.this, GameActivity.class);
        intent.putExtra("masterWordList", calculateCurrentGameWordArray(numberOfTeams, letterWordList));
        intent.putExtra("teamArray", Parcels.wrap(teamArray));
        intent.putExtra("currentTeam", 0);
        intent.putExtra("currentRoundNumber", 1);
        intent.putExtra("newRound", newRound);
        startActivity(intent);
    }

    public ArrayList<String> filterByLetter (ArrayList<String> masterWordList, String letterToFilterBy) {
        ArrayList<String> filteredArray = new ArrayList<>();

        for (int i = 0; i < masterWordList.size(); i++) {
            if (masterWordList.get(i).substring(0, 1).equals(letterToFilterBy)) {
                filteredArray.add(masterWordList.get(i));
            }
        }
        return filteredArray;
    }

    public ArrayList<String> calculateCurrentGameWordArray(int numberOfTeams, ArrayList<String> letterWordList) {
        ArrayList<String> calculatedWordArray = letterWordList;
        Collections.shuffle(calculatedWordArray);

        List calculatedWordList = calculatedWordArray.subList(0, (numberOfTeams * 10));

        ArrayList<String> calculatedWordArrayList = new ArrayList<>();

        for(int i = 0; i < calculatedWordList.size(); i++) {
            calculatedWordArrayList.add(calculatedWordList.get(i).toString());
        }

        return calculatedWordArrayList;
    }
}
