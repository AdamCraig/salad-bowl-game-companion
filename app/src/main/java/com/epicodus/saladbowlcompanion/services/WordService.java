package com.epicodus.saladbowlcompanion.services;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WordService {

    public static void getAnimalWords(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = "http://corpora-api.herokuapp.com/animals/common";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<String> processAnimalResults(Response response) {
        ArrayList<String> words = new ArrayList<>();
        try {
           String jsonData = response.body().string();
           if (response.isSuccessful()) {

               JSONObject wordsListJSON = new JSONObject(jsonData);
               JSONArray wordsJSON = wordsListJSON.getJSONObject("data").getJSONArray("animals");
               for (int i = 0; i < wordsJSON.length(); i++) {
                   words.add(wordsJSON.getString(i));
               }

           }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("animal words", words + "");
        return words;
    }

    public static void getMoodWords(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        String url = "http://corpora-api.herokuapp.com/humans/moods";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<String> processMoodResults(Response response) {
        ArrayList<String> words = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {

                JSONObject wordsListJSON = new JSONObject(jsonData);
                JSONArray wordsJSON = wordsListJSON.getJSONObject("data").getJSONArray("moods");
                for (int i = 0; i < wordsJSON.length(); i++) {
                    words.add(wordsJSON.getString(i));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("mood words", words + "");
        return words;
    }
}
