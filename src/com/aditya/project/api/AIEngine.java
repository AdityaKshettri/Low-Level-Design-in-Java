package com.aditya.project.api;

import com.aditya.project.boards.TicTacToe;
import com.aditya.project.game.Board;
import com.aditya.project.game.Cell;
import com.aditya.project.game.Move;
import com.aditya.project.user.Player;

public class AIEngine {

    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToe ticTacToe) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTacToe.getCell(i, j) == null) {
                        return new Move(new Cell(i, j), computer);
                    }
                }
            }
        }
        throw new IllegalStateException();
    }
}
