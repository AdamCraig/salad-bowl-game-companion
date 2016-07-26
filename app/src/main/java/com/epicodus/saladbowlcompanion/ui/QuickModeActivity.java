package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.epicodus.saladbowlcompanion.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuickModeActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> masterWordList = new ArrayList<>();

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
        Log.v("Filtered Array", filterByLetter(masterWordList, letter) + "");
    }

    public ArrayList<String> filterByLetter (ArrayList<String> masterWordList, String letterToFilterBy) {
        ArrayList<String> filteredArray = new ArrayList<>();

        for (int i = 0; i < masterWordList.size(); i++) {
            if (masterWordList.get(i).substring(0, 1).equals(letterToFilterBy)) {
                filteredArray.add(masterWordList.get(i));
            }
        }
        Log.v("Size", filteredArray.size() + "");
        return filteredArray;
    }
}
