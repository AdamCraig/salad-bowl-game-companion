package com.epicodus.saladbowlcompanion.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.saladbowlcompanion.R;
import com.epicodus.saladbowlcompanion.services.WordService;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GameActivity extends AppCompatActivity {

    public ArrayList<String> mAnimals = new ArrayList<>();

    //TODO: SET BUTTERKNIFE BINDS FOR GAME WORDS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getAnimalWords();
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
}
