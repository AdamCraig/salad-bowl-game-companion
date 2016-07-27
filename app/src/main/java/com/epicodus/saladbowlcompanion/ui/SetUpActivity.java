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
    @Bind(R.id.quickModeButton) Button mQuickModeButton;
    @Bind(R.id.creativeModeButton) Button mCreativeModeButton;
    @Bind(R.id.teamEditText) EditText mTeamEditText;

    public ArrayList<String> mAnimals = new ArrayList<>();
    public ArrayList<String> mMoods = new ArrayList<>();
    public ArrayList<String> mFiveLetterWords = new ArrayList<>();
    public ArrayList<String> mSixLetterWords = new ArrayList<>();

    public ArrayList<String> mMasterWordList = new ArrayList<>();

    //TODO: SET BUTTERKNIFE BINDS FOR GAME WORDS

    int numberOfTeamsInt = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ButterKnife.bind(this);

        getAnimalWords();
        getMoodWords();
        getFiveLetterWords();
        getSixLetterWords();

        mQuickModeButton.setOnClickListener(this);
        mCreativeModeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String numberOfTeamsString = mTeamEditText.getText().toString();
        numberOfTeamsInt = Integer.parseInt(numberOfTeamsString);

        if (numberOfTeamsString.equals("") || Integer.parseInt(numberOfTeamsString) > 6 || Integer.parseInt(numberOfTeamsString) < 2) {
            mTeamEditText.setError("Please enter a valid number of teams.");
        } else if (view == mQuickModeButton) {
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
            intent.putExtra("masterWordList", mMasterWordList);
            startActivity(intent);
        } else if (view == mCreativeModeButton) {
            Intent intent = new Intent(SetUpActivity.this, CreativeModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
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

    private void getFiveLetterWords() {
        final WordService wordService = new WordService();
        wordService.getFiveLetterWords(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mFiveLetterWords = wordService.processFiveLetterResults(response);
                mMasterWordList.addAll(mFiveLetterWords);

                SetUpActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

            }
        });
    }

    private void getSixLetterWords() {
        final WordService wordService = new WordService();
        wordService.getSixLetterWords(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mSixLetterWords = wordService.processSixLetterResults(response);
                mMasterWordList.addAll(mSixLetterWords);

                SetUpActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

            }
        });
    }


}

