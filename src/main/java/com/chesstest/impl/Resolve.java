package com.chesstest.impl;

import com.chesstest.model.Board;
import com.chesstest.model.Piece;
import com.chesstest.model.PieceFactory;
import com.chesstest.model.PieceType;

import java.util.ArrayList;
import java.util.Map;


public class Resolve {

    public static final PieceFactory pieceFactory = new PieceFactory();

    /**
     * @param board      - oard and list of pieces
     * @param boards     - All solution boards
     * @param lastPieces - Last position for each kind of piece in the board
     */
    public void resolve(Board board, Map<String, Board> boards, Map<String, Piece> lastPieces, boolean printBoards) {

        ArrayList<PieceType> remainingPieces = board.getRemainingPieces();

        // Take the first available piece
        PieceType piece = remainingPieces.remove(0);

        // Last piece on the board of this kind
        Piece lastPiece = lastPieces.get(piece.pieceName());

        int r = 0;
        int c = 0;

        if (lastPiece != null) {
            // Prune duplicate solutions.
            r = lastPiece.getRow();
            c = lastPiece.getCol() + 1;
        }

        for (int row = r; row < board.getRows(); row++) {
            for (int col = c; col < board.getColumns(); col++) {
                // If it isn't empty skip the iteration
                if (board.getBoard()[row][col] != null)
                    continue;

                Piece pieceToPut = pieceFactory.getPiece(piece, row, col);

                // Check if it is possible to put the piece into the board safely
                if (!pieceToPut.isSafe(board))
                    continue;

                // Add piece piece to the board as partial solution
                board.addPiece(pieceToPut);

                lastPieces.put(pieceToPut.toString(), pieceToPut);

                if (remainingPieces.isEmpty()) {
                    // If there is not more pieces is a final solution
                    // Avoid duplicate results using a unique key (the board itself)
                    boards.put(board.toString(), board);
                    if (printBoards)
                        board.printBoard();

                } else {
                    // Partial solution. Resolve a smaller problem
                    resolve(board, boards, lastPieces, printBoards);
                }

                // Backtracking: Remove the piece of the board
                board.removePiece(pieceToPut);
            }
            // Reset column
            c = 0;
        }


        // Backtracking: Return the piece
        remainingPieces.add(0, piece);
        lastPieces.put(piece.pieceName(), null);
    }

}
