package com.aditya.project.user;

public class Player {

    private final String playerSymbol;

    public Player(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public String symbol() {
        return playerSymbol;
    }

    public Player flip() {
        return new Player(playerSymbol.equals("X") ? "O" : "X");
    }
}
