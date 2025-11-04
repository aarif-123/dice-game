package com.example.dicegame;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private final Player p1;
    private final Player p2;
    private final Dice dice1;
    private final Dice dice2;
    private final int totalRounds;
    private int currentRound;
    private boolean active;
    private final List<RoundData> history;

    public GameEngine(String p1Name, String p2Name, int totalRounds) {
        this.p1 = new Player(p1Name, "P1");
        this.p2 = new Player(p2Name, "P2");
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.totalRounds = totalRounds;
        this.currentRound = 0;
        this.active = true;
        this.history = new ArrayList<>();
    }

    public RoundData playRound() {
    if (!active) return null;

    currentRound++;
    int roll1 = dice1.roll();
    int roll2 = dice2.roll();

    // Update scores for both players
    p1.addScore(roll1);
    p2.addScore(roll2);

    String winner;
    if (roll1 > roll2) {
        p1.winRound();
        winner = p1.getName();
    } else if (roll2 > roll1) {
        p2.winRound();
        winner = p2.getName();
    } else {
        winner = "Tie";
    }
// using dsa  to track round sore data so that we can conculdel to winner
    RoundData rd = new RoundData(currentRound, roll1, roll2, winner);
    history.add(rd);

    if (currentRound >= totalRounds) active = false;

    return rd;
    }


    public String getGameWinner() {
        if (p1.getRoundsWon() > p2.getRoundsWon()) return p1.getName();
        if (p2.getRoundsWon() > p1.getRoundsWon()) return p2.getName();
        return "Tie Game";
    }

    public List<RoundData> getHistory() { return history; }
    public Player getP1() { return p1; }
    public Player getP2() { return p2; }
    public int getCurrentRound() { return currentRound; }
    public int getTotalRounds() { return totalRounds; }
    public boolean isActive() { return active; }
}
