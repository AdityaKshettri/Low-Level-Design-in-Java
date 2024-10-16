package com.aditya.project.game;

public interface Board {
    void move(Move move);

    Board copy();
}
