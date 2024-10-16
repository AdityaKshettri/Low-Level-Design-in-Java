package com.aditya.project.api;

import com.aditya.project.boards.TicTacToe;
import com.aditya.project.game.Board;
import com.aditya.project.game.Cell;
import com.aditya.project.game.GameResult;
import com.aditya.project.game.Move;
import com.aditya.project.user.Player;

public class GameEngine {

    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToe();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void move(Board board, Player player, Move move) {
        if (board instanceof TicTacToe ticTacToe) {
            ticTacToe.setCell(move.getCell(), player.symbol());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public GameResult isComplete(Board board) {
        if (board instanceof TicTacToe ticTacToe) {
            String firstChar = "-";
            boolean rowComplete = true;
            for (int i = 0; i < 3; i++) {
                firstChar = ticTacToe.getCell(i, 0);
                rowComplete = firstChar != null;
                if (firstChar != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstChar.equals(ticTacToe.getCell(i, j))) {
                            rowComplete = false;
                            break;
                        }
                    }
                }
                if (rowComplete) {
                    break;
                }
            }

            if (rowComplete) {
                return new GameResult(true, firstChar);
            }

            boolean colComplete = true;
            for (int i = 0; i < 3; i++) {
                firstChar = ticTacToe.getCell(0, i);
                colComplete = firstChar != null;
                if (firstChar != null) {
                    for (int j = 1; j < 3; j++) {
                        if (!firstChar.equals(ticTacToe.getCell(j, i))) {
                            colComplete = false;
                            break;
                        }
                    }
                }
                if (colComplete) {
                    break;
                }
            }

            if (colComplete) {
                return new GameResult(true, firstChar);
            }

            firstChar = ticTacToe.getCell(0, 0);
            boolean diagComplete = firstChar != null;
            if (firstChar != null) {
                for (int i = 0; i < 3; i++) {
                    if (!firstChar.equals(ticTacToe.getCell(i, i))) {
                        diagComplete = false;
                        break;
                    }
                }
            }

            if (diagComplete) {
                return new GameResult(true, firstChar);
            }

            firstChar = ticTacToe.getCell(0, 2);
            boolean revDiagComplete = firstChar != null;
            if (firstChar != null) {
                for (int i = 0; i < 3; i++) {
                    if (!firstChar.equals(ticTacToe.getCell(i, 2 - i))) {
                        revDiagComplete = false;
                        break;
                    }
                }
            }

            if (revDiagComplete) {
                return new GameResult(true, firstChar);
            }

            int countOfFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTacToe.getCell(i, j) != null) {
                        countOfFilledCells++;
                    }
                }
            }

            if (countOfFilledCells == 9) {
                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }
        } else {
            return new GameResult(false, "-");
        }
    }

    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToe ticTacToe) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTacToe.getCell(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
        }
        throw new IllegalStateException();
    }
}

