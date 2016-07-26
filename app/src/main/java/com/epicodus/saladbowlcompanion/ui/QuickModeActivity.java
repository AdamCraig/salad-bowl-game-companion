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

    @Bind(R.id.TButton) Button mTButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_mode);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        masterWordList = intent.getStringArrayListExtra("masterWordList");

        mTButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mTButton) {
            Log.v("Filtered Array", filterByLetter(masterWordList, "t") + "");

        }
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
