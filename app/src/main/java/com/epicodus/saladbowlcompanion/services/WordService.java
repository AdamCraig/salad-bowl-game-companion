package com.epicodus.saladbowlcompanion.services;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<String> animals = new ArrayList<>();

        try {
           String jsonData = response.body().string();
           if (response.isSuccessful()) {
               JSONObject animalListJSON = new JSONObject(jsonData);
               JSONArray animalsJSON = animalListJSON.getJSONObject("data").getJSONArray("animals");
               for (int i = 0; i < animalsJSON.length(); i++) {
                   animals.add(animalsJSON.getString(i));
               }

           }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("animals", animals + "");
        return animals;
    }
}
