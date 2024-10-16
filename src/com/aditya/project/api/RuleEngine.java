package com.aditya.project.api;

import com.aditya.project.boards.TicTacToe;
import com.aditya.project.game.Board;
import com.aditya.project.game.GameState;

public class RuleEngine {

    public GameState getState(Board board) {
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
                return new GameState(true, firstChar);
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
                return new GameState(true, firstChar);
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
                return new GameState(true, firstChar);
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
                return new GameState(true, firstChar);
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
                return new GameState(true, "-");
            } else {
                return new GameState(false, "-");
            }
        } else {
            return new GameState(false, "-");
        }
    }
}
