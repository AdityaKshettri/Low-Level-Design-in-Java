package com.aditya.project;

import com.aditya.project.api.GameEngine;
import com.aditya.project.game.Board;
import com.aditya.project.game.Cell;
import com.aditya.project.game.Move;
import com.aditya.project.user.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("O");
            Player human = new Player("X");
            System.out.println("Make your move!");
            System.out.println(board);
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move humanMove = new Move(new Cell(row, col));
            gameEngine.move(board, human, humanMove);
            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
            }
            System.out.println("Game Result: " + gameEngine.isComplete(board));
        }
    }
}
