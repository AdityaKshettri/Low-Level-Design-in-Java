package com.aditya.project;

import com.aditya.project.api.AIEngine;
import com.aditya.project.api.GameEngine;
import com.aditya.project.api.RuleEngine;
import com.aditya.project.game.Board;
import com.aditya.project.game.Cell;
import com.aditya.project.game.Move;
import com.aditya.project.user.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AIEngine aiEngine = new AIEngine();
        GameEngine gameEngine = new GameEngine();
        RuleEngine ruleEngine = new RuleEngine();
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("O");
            Player human = new Player("X");
            System.out.println("Make your move!");
            System.out.println(board);
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move humanMove = new Move(new Cell(row, col), human);
            gameEngine.move(board, humanMove);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
            System.out.println("Game Result: " + ruleEngine.getState(board));
        }
    }
}
