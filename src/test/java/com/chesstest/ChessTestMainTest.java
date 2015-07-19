package com.chesstest;

import static org.junit.Assert.assertEquals;

import com.chesstest.impl.Resolve;
import com.chesstest.model.Board;
import com.chesstest.model.Piece;
import com.chesstest.util.ChessUtil;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Unit test for simple App.
 */
public class ChessTestMainTest {

    private static Resolve resolve;
    private int rows = 7;
    private int cols = 7;
    private int kings = 2;
    private int queens = 2;
    private int bishops = 2;
    private int knights = 1;
    private int rooks = 0;

    @BeforeClass
    public static void beforeTests() {
        resolve = new Resolve();
    }

    @Test
    public void test8x8QQQQQQQQ() {

        rows = 8;
        cols = 8;
        kings = 0;
        queens = 8;
        bishops = 0;
        knights = 0;
        rooks = 0;

        Board board = ChessUtil.fillBoard(rows, cols, kings, queens, bishops, knights, rooks);

        HashMap<String, Board> boards = new HashMap<String, Board>();
        Map<String, Piece> lastPieces = new HashMap<String, Piece>();
        resolve.resolve(board, boards, lastPieces, false);

        assertEquals(92, boards.size());
        System.out.println("Test test8x8QQQQQQQQ passed");
    }

    @Test
    @Ignore
    public void test11x11Q11() {

        rows = 11;
        cols = 11;
        kings = 0;
        queens = 11;
        bishops = 0;
        knights = 0;
        rooks = 0;

        Board board = ChessUtil.fillBoard(rows, cols, kings, queens, bishops, knights, rooks);

        HashMap<String, Board> boards = new HashMap<String, Board>();
        Map<String, Piece> lastPieces = new HashMap<String, Piece>();
        resolve.resolve(board, boards, lastPieces, false);

        assertEquals(2680, boards.size());
        System.out.println("Test test11x11Q11 passed");
    }

    @Test
    public void test9x9Q9() {

        rows = 9;
        cols = 9;
        kings = 0;
        queens = 9;
        bishops = 0;
        knights = 0;
        rooks = 0;

        Board board = ChessUtil.fillBoard(rows, cols, kings, queens, bishops, knights, rooks);

        HashMap<String, Board> boards = new HashMap<String, Board>();
        Map<String, Piece> lastPieces = new HashMap<String, Piece>();
        resolve.resolve(board, boards, lastPieces, false);

        assertEquals(352, boards.size());
        System.out.println("Test test9x9Q9 passed");
    }


    @Test
    public void test3x3KKR() {

        rows = 3;
        cols = 3;
        kings = 2;
        queens = 0;
        bishops = 0;
        knights = 0;
        rooks = 1;

        Board board = ChessUtil.fillBoard(rows, cols, kings, queens, bishops, knights, rooks);

        HashMap<String, Board> boards = new HashMap<String, Board>();
        Map<String, Piece> lastPieces = new HashMap<String, Piece>();
        resolve.resolve(board, boards, lastPieces, false);

        assertEquals(4, boards.size());
        String positions = boards.keySet().toString();
        assertEquals("" +
               "[K - K \n" +
                "- - - \n" +
                "- R - \n" +
              ", K - - \n" +
                "- - R \n" +
                "K - - \n" +
              ", - - K \n" +
                "R - - \n" +
                "- - K \n" +
              ", - R - \n" +
                "- - - \n" +
                "K - K \n" +
                "]", positions);
        System.out.println("Test test3x3KKR passed");
    }


    @Test
    public void test4x4RRNNNN() {

        rows = 4;
        cols = 4;
        kings = 0;
        queens = 0;
        bishops = 0;
        knights = 4;
        rooks = 2;

        Board board = ChessUtil.fillBoard(rows, cols, kings, queens, bishops, knights, rooks);

        HashMap<String, Board> boards = new HashMap<String, Board>();
        Map<String, Piece> lastPieces = new HashMap<String, Piece>();
        resolve.resolve(board, boards, lastPieces, false);

        assertEquals(8, boards.size());
        String positions = boards.keySet().toString();
        assertEquals("" +
               "[R - - - \n" +
                "- N - N \n" +
                "- - R - \n" +
                "- N - N \n" +
              ", N - N - \n" +
                "- - - R \n" +
                "N - N - \n" +
                "- R - - \n" +
              ", - - R - \n" +
                "- N - N \n" +
                "R - - - \n" +
                "- N - N \n" +
              ", - R - - \n" +
                "N - N - \n" +
                "- - - R \n" +
                "N - N - \n" +
              ", - - - R \n" +
                "N - N - \n" +
                "- R - - \n" +
                "N - N - \n" +
              ", - N - N \n" +
                "R - - - \n" +
                "- N - N \n" +
                "- - R - \n" +
              ", N - N - \n" +
                "- R - - \n" +
                "N - N - \n" +
                "- - - R \n" +
              ", - N - N \n" +
                "- - R - \n" +
                "- N - N \n" +
                "R - - - \n" +
                "]", positions);
        System.out.println("Test test4x4RRNNNN passed");
    }

}
