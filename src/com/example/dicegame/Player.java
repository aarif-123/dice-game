package com.example.dicegame;

public class Player {
    private String name;
    private int score;
    private int roundsWon;
    private final String playerID;

    public Player(String name, String playerID) {
        this.name = name;
        this.playerID = playerID;
        this.score = 0;
        this.roundsWon = 0;
    }

    public String getName() { return name; }
    public int getScore() { return score; }
    public int getRoundsWon() { return roundsWon; }
    public String getPlayerID() { return playerID; }

    public void addScore(int points) { this.score += points; }
    public void winRound() { this.roundsWon++; }
    public void reset() {
        score = 0;
        roundsWon = 0;
    }
}
