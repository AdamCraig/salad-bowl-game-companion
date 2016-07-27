package com.epicodus.saladbowlcompanion.models;


import android.util.Log;


public class Team {
    private String name;
    private String color;
    private int round1Score;
    private int round2Score;
    private int round3Score;
    private int finalScore;

    public Team (String name, String color) {
        this.name = name;
        this.color = color;
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
