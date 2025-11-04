package com.example.dicegame;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();
    private int value;

    public int roll() {
        value = random.nextInt(6) + 1;
        return value;
    }

    public int getValue() { return value; }
}
