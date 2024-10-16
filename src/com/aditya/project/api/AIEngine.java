package com.aditya.project.api;

import com.aditya.project.boards.TicTacToe;
import com.aditya.project.game.Board;
import com.aditya.project.game.Cell;
import com.aditya.project.game.Move;
import com.aditya.project.user.Player;

public class AIEngine {

    public Move suggestMove(Player player, Board board) {
        if (board instanceof TicTacToe ticTacToe) {
            Move suggestion;
            if (countMoves(ticTacToe) < 4) {
                suggestion = getBasicMove(player, ticTacToe);
            } else {
                suggestion = getSmartMove(player, ticTacToe);
            }
            if (suggestion != null) {
                return suggestion;
            }
        }
        throw new IllegalStateException();
    }

    private int countMoves(TicTacToe board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) != null) {
                    count++;
                }
            }
        }
        return count;
    }

    private Move getSmartMove(Player player, TicTacToe board) {
        RuleEngine ruleEngine = new RuleEngine();

        // Victorious moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player);
                    board.move(move);
                    if (ruleEngine.getState(board).isOver()) {
                        return move;
                    }
                }
            }
        }

        // Defensive moves
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToe boardCopy = board.copy();
                    boardCopy.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return new Move(new Cell(i, j), player);
                    }
                }
            }
        }

        return null;
    }

    private Move getBasicMove(Player player, TicTacToe board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) == null) {
                    return new Move(new Cell(i, j), player);
                }
            }
        }
        return null;
    }
}
