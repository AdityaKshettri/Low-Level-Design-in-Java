package com.aditya.project;

public class Main {

    public static void main(String[] args) {

    }

    public Board start() {
        return new Board();
    }

    public void move(Board board, Player player, Move move) {

    }

    public GameResult isComplete(Board board) {
        if (board instanceof TicTacToe ticTacToe) {
            String firstChar = "-";
            boolean rowComplete = true;
            for (int i = 0; i < 3; i++) {
                rowComplete = true;
                firstChar = ticTacToe.cells[i][0];
                for (int j = 1; j < 3; j++) {
                    if (!ticTacToe.cells[i][j].equals(firstChar)) {
                        rowComplete = false;
                        break;
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
                colComplete = true;
                firstChar = ticTacToe.cells[i][0];
                for (int j = 1; j < 3; j++) {
                    if (!ticTacToe.cells[i][j].equals(firstChar)) {
                        colComplete = false;
                        break;
                    }
                }
                if (colComplete) {
                    break;
                }
            }

            if (colComplete) {
                return new GameResult(true, firstChar);
            }

            boolean diagComplete = true;
            for (int i = 0; i < 3; i++) {
                firstChar = ticTacToe.cells[0][0];
                if (!ticTacToe.cells[i][i].equals(firstChar)) {
                    diagComplete = false;
                    break;
                }
            }

            if (diagComplete) {
                return new GameResult(true, firstChar);
            }

            boolean revDiagComplete = true;
            for (int i = 0; i < 3; i++) {
                firstChar = ticTacToe.cells[0][0];
                if (!ticTacToe.cells[i][2 - i].equals(firstChar)) {
                    revDiagComplete = false;
                    break;
                }
            }

            if (revDiagComplete) {
                return new GameResult(true, firstChar);
            }

            int countOfFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ticTacToe.cells[i][j] != null) {
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
}

class Board {
}

class TicTacToe extends Board {
    String[][] cells = new String[3][3];
}

class Player {
}

class Move {
}

class GameResult {
    boolean isOver;
    String winner;

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }
}
