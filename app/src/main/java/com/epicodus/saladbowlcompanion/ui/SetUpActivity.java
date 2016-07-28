package com.epicodus.saladbowlcompanion.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    @Bind(R.id.twoTeamButton) Button mTwoTeamButton;
    @Bind(R.id.threeTeamButton) Button mThreeTeamButton;
    @Bind(R.id.fourTeamButton) Button mFourTeamButton;
    @Bind(R.id.fiveTeamButton) Button mFiveTeamButton;
    @Bind(R.id.sixTeamButton) Button mSixTeamButton;
    @Bind(R.id.teamsTextView) TextView mTeamTextView;

    public ArrayList<String> mAnimals = new ArrayList<>();
    public ArrayList<String> mMoods = new ArrayList<>();
    public ArrayList<String> mFiveLetterWords = new ArrayList<>();
    public ArrayList<String> mSixLetterWords = new ArrayList<>();

    public ArrayList<String> mMasterWordList = new ArrayList<>();

    //TODO: SET BUTTERKNIFE BINDS FOR GAME WORDS

    int numberOfTeamsInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ButterKnife.bind(this);

        getAnimalWords();
        getMoodWords();
        getFiveLetterWords();
        getSixLetterWords();

        mTwoTeamButton.setOnClickListener(this);
        mThreeTeamButton.setOnClickListener(this);
        mFourTeamButton.setOnClickListener(this);
        mFiveTeamButton.setOnClickListener(this);
        mSixTeamButton.setOnClickListener(this);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf");
        mTeamTextView.setTypeface(font);
    }

    @Override
    public void onClick(View view) {
        if (view == mTwoTeamButton) {
            numberOfTeamsInt = 2;
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
            intent.putExtra("masterWordList", mMasterWordList);
            startActivity(intent);
        } else if (view == mThreeTeamButton) {
            numberOfTeamsInt = 3;
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
            intent.putExtra("masterWordList", mMasterWordList);
            startActivity(intent);
        } else if (view == mFourTeamButton) {
            numberOfTeamsInt = 4;
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
            intent.putExtra("masterWordList", mMasterWordList);
            startActivity(intent);
        } else if (view == mFiveTeamButton) {
            numberOfTeamsInt = 5;
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
            intent.putExtra("masterWordList", mMasterWordList);
            startActivity(intent);
        } else if (view == mSixTeamButton) {
            numberOfTeamsInt = 6;
            Intent intent = new Intent(SetUpActivity.this, QuickModeActivity.class);
            intent.putExtra("numberOfTeams", numberOfTeamsInt);
            intent.putExtra("masterWordList", mMasterWordList);
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

