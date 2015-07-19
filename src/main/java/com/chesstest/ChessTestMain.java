package com.chesstest;

import com.chesstest.impl.Resolve;
import com.chesstest.model.Board;
import com.chesstest.model.Piece;
import com.chesstest.util.ChessUtil;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class ChessTestMain {

    public static void main(String[] args) {

        Board board;

        // Main task intput
        int rows = 7;
        int cols = 7;
        int kings = 2;
        int queens = 2;
        int bishops = 2;
        int knights = 1;
        int rooks = 0;


        Scanner in = new Scanner(System.in);
        System.out.println("**************************************************************************************");
        System.out.println("******                          Chess Test                                      ******");
        System.out.println("******                                                                          ******");
        System.out.println("****** Default input: 7x7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight  ******");
        System.out.println("**************************************************************************************");
        System.out.println("");
        System.out.println("[1] Default input.");
        System.out.println("[2] Default input - printing all boards.");
        System.out.println("[3] Custom input.");
        System.out.println("[4] Custom input - printing all boards.");
        System.out.print("Please select an option: ");
        int option = readInt(in, "Please select an option: ");

        while (option < 1 || option > 4) {
            System.out.print("Incorrect value. Please select an option: ");
            option = readInt(in, "Please select an option: ");
        }

        // Custom board options
        if (option == 3 || option == 4) {
            System.out.println("Please select board's size");
            System.out.print("Rows: ");
            rows = readInt(in, "Rows: ");
            System.out.print("Columns: ");
            cols = readInt(in, "Columns: ");
            System.out.println();
            System.out.println("Please, for each piece, introduce the number of occurrences.");
            System.out.print("[K] Kings: ");
            kings = readInt(in, "[K] Kings: ");
            System.out.print("[Q] Queens: ");
            queens = readInt(in, "[Q] Queens: ");
            System.out.print("[B] Bishops: ");
            bishops = readInt(in, "[B] Bishops: ");
            System.out.print("[N] Knights: ");
            knights = readInt(in, "[N] Knights: ");
            System.out.print("[R] Rooks: ");
            rooks = readInt(in, "[R] Rooks: ");

        }

        boolean printBoards = false;
        if (option == 2 || option == 4) {
            printBoards = true;
        }

        System.out.println();
        System.out.println();

        board = ChessUtil.fillBoard(rows, cols, kings, queens, bishops, knights, rooks);

        HashMap<String, Board> boards = new HashMap<String, Board>();
        long start = System.currentTimeMillis();

        Resolve resolve = new Resolve();

        resolve.resolve(board, boards, new HashMap<String, Piece>(), printBoards);

        long end = System.currentTimeMillis();

        long totalTime = end - start;

        System.out.println("Number of boards: " + boards.size());

        if (totalTime > 60000) {
            System.out.println("Total time : " + TimeUnit.MILLISECONDS.toMinutes(totalTime) + " minutes " + (TimeUnit.MILLISECONDS.toSeconds(totalTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalTime))) + " seconds");
        } else if (totalTime > 1000) {
            System.out.println("Total time : " + TimeUnit.MILLISECONDS.toSeconds(totalTime) + " seconds");
        } else {
            System.out.println("Total time : " + (totalTime) + " ms");
        }

    }


    /**
     * Read an int from the input.
     */
    private static int readInt(Scanner in, String inputStr) {
        int input;
        try {
            input = in.nextInt();
        } catch (Exception e) {
            System.out.print("Incorrect value. Please try again: " + inputStr);
            in.next();
            return readInt(in, inputStr);
        }
        return input;
    }

}
