package com.example.dicegame;

public class RoundData {
    public final int roundNumber;
    public final int p1Roll;
    public final int p2Roll;
    public final String winner;

    public RoundData(int roundNumber, int p1Roll, int p2Roll, String winner) {
        this.roundNumber = roundNumber;
        this.p1Roll = p1Roll;
        this.p2Roll = p2Roll;
        this.winner = winner;
    }
}
