package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.services.WordService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SetUpActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.quickModeButton)
    Button mQuickModeButton;
    @Bind(R.id.creativeModeButton)
    Button mCreativeModeButton;
    @Bind(R.id.teamEditText)
    EditText mTeamEditText;

    public ArrayList<String> mAnimals = new ArrayList<>();
    public ArrayList<String> mMoods = new ArrayList<>();

    public ArrayList<String> mMasterWordList = new ArrayList<>();

    //TODO: SET BUTTERKNIFE BINDS FOR GAME WORDS

    int team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ButterKnife.bind(this);

        getAnimalWords();
        getMoodWords();
        mQuickModeButton.setOnClickListener(this);
        mCreativeModeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mTeamEditText.getText().toString().equals("")) {
            mTeamEditText.setError("Enter number of teams");

        } else if (view == mQuickModeButton) {
            team = Integer.parseInt(mTeamEditText.getText().toString());  // might refactor here
            Log.v("SetUpActivity", "the number of teams is: " + team);
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("teams", team);
            startActivity(intent);
        } else if (view == mCreativeModeButton) {
            team = Integer.parseInt(mTeamEditText.getText().toString());
            Intent intent = new Intent(SetUpActivity.this, CreativeModeActivity.class);
            intent.putExtra("teams", team);
            startActivity(intent);

        }
    }

    private void getAnimalWords() {
        final WordService wordService = new WordService();
        wordService.getAnimalWords(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mAnimals = wordService.processAnimalResults(response);
                mMasterWordList.addAll(mAnimals);

                SetUpActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

            }
        });
    }

    private void getMoodWords() {
        final WordService wordService = new WordService();
        wordService.getMoodWords(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mMoods = wordService.processMoodResults(response);
                mMasterWordList.addAll(mMoods);

                SetUpActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

            }
        });
    }
}

