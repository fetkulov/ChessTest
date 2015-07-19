package com.chesstest.util;

import com.chesstest.model.Board;
import com.chesstest.model.PieceType;

import java.util.ArrayList;

/**
 * Util class
 */
public class ChessUtil {
    /**
     * Fill the board with input pieces
     */
    public static Board fillBoard(int rows, int cols, int kings, int queens,
                                  int bishops, int knights, int rooks) {

        Board board = new Board(rows, cols);

        ArrayList<PieceType> remainingPieces = board.getRemainingPieces();

        for (int i = 0; i < queens; i++) {
            remainingPieces.add(PieceType.QUEEN);
        }
        for (int i = 0; i < bishops; i++) {
            remainingPieces.add(PieceType.BISHOP);
        }
        for (int i = 0; i < rooks; i++) {
            remainingPieces.add(PieceType.ROOK);
        }
        for (int i = 0; i < knights; i++) {
            remainingPieces.add(PieceType.KNIGHT);
        }
        for (int i = 0; i < kings; i++) {
            remainingPieces.add(PieceType.KING);
        }

        return board;

    }
}
