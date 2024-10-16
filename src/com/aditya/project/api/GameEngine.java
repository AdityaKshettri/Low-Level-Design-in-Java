package com.aditya.project.api;

import com.aditya.project.boards.TicTacToe;
import com.aditya.project.game.Board;
import com.aditya.project.game.Move;

public class GameEngine {

    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToe();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void move(Board board, Move move) {
        if (board instanceof TicTacToe) {
            board.move(move);
        } else {
            throw new IllegalArgumentException();
        }
    }
}

