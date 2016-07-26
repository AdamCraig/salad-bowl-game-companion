package com.epicodus.saladbowlcompanion.ui;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class GameActivity extends AppCompatActivity {
    @Bind(R.id.timerTextView) TextView mTimerTextView;

    public ArrayList<String> mAnimals = new ArrayList<>();

    //TODO: SET BUTTERKNIFE BINDS FOR GAME WORDS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        getAnimalWords();
        countDownTimer.start();
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

                GameActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                    }
                });

            }


        });
    }

    CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
        // https://developer.android.com/reference/android/os/CountDownTimer.html

        public void onTick(long millisUntilFinished) {
            mTimerTextView.setText("seconds remaining" + millisUntilFinished / 1000);
        }

        public void onFinish() {
            mTimerTextView.setText("done!");
        }
    };


}
