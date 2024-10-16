package com.aditya.project;

import com.aditya.project.api.AIEngine;
import com.aditya.project.api.GameEngine;
import com.aditya.project.api.RuleEngine;
import com.aditya.project.game.Board;
import com.aditya.project.game.Cell;
import com.aditya.project.game.Move;
import com.aditya.project.user.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GamePlayTest {

    private AIEngine aiEngine;
    private GameEngine gameEngine;
    private RuleEngine ruleEngine;

    @Before
    public void setup() {
        aiEngine = new AIEngine();
        gameEngine = new GameEngine();
        ruleEngine = new RuleEngine();
    }

    @Test
    public void checkForRowWin() {
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        int[][] moves = new int[][]{{1, 0}, {1, 1}, {1, 2}};
        playGame(board, moves);
        assertTrue(ruleEngine.getState(board).isOver());
        assertEquals("X", ruleEngine.getState(board).getWinner());
    }

    @Test
    public void checkForColWin() {
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        int[][] moves = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        playGame(board, moves);
        assertTrue(ruleEngine.getState(board).isOver());
        assertEquals("X", ruleEngine.getState(board).getWinner());
    }

    @Test
    public void checkForDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        int[][] moves = new int[][]{{0, 0}, {1, 1}, {2, 2}};
        playGame(board, moves);
        assertTrue(ruleEngine.getState(board).isOver());
        assertEquals("X", ruleEngine.getState(board).getWinner());
    }

    @Test
    public void checkForRevDiagWin() {
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        int[][] moves = new int[][]{{0, 2}, {1, 1}, {2, 0}};
        playGame(board, moves);
        assertTrue(ruleEngine.getState(board).isOver());
        assertEquals("X", ruleEngine.getState(board).getWinner());
    }

    @Test
    public void checkForComputerWin() {
        Board board = gameEngine.start("TicTacToe");
        // make moves in a loop
        int[][] moves = new int[][]{{1, 0}, {1, 1}, {2, 0}};
        playGame(board, moves);
        assertTrue(ruleEngine.getState(board).isOver());
        assertEquals("O", ruleEngine.getState(board).getWinner());
    }

    private void playGame(Board board, int[][] moves) {
        int row, col;
        int next = 0;
        while (!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("O");
            Player human = new Player("X");
            row = moves[next][0];
            col = moves[next][1];
            next++;
            Move humanMove = new Move(new Cell(row, col), human);
            gameEngine.move(board, humanMove);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
    }
}
