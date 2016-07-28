package com.epicodus.saladbowlcompanion.models;


import android.util.Log;

import org.parceler.Parcel;

@Parcel

public class Team {
    String name;
    String color;
    int round1Score;
    int round2Score;
    int round3Score;
    int finalScore;

    public Team (String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Team(){
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getRound1Score() {
        return round1Score;
    }

    public void incrementRoundScore(int score, int roundNumber) {
        if (roundNumber == 1) {
            round1Score += score;
        } else if (roundNumber == 2) {
            round2Score += score;
        } else if (roundNumber == 3) {
            round3Score += score;
        } else {
            Log.v("Team.java", "Invalid round number or score");
        }
    }

    public int getRound2Score() {
        return round2Score;
    }

    public int getRound3Score() {
        return round3Score;
    }

    public int getFinalScore() {
        return round1Score + round2Score + round3Score;
    }

    public void setFinalScore(int score) {
        finalScore = score;
    }

    public void incrementScore(int roundNumber) {
        if (roundNumber == 1) {
            round1Score++;
        } else if (roundNumber == 2) {
            round2Score++;
        } else if (roundNumber == 3) {
            round3Score++;
        } else {
            Log.v("Team.java", "Invalid round number");
        }
    }


}
