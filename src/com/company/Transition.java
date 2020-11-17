package com.company;

public class Transition{
    Transition(int from, char symbol, int to){
        this.from = from;
        this.symbol = symbol;
        this.to = to;
    }
    public int from;
    public char symbol;
    public int to;
}

