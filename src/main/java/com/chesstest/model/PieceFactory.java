package com.chesstest.model;

/**
 * Factory pattern
 */
public class PieceFactory {

    /**
     * Get an object of type piece in the default position
     *
     * @param pieceType
     * @param row
     * @param col
     * @return
     */
    public Piece getPiece(PieceType pieceType, int row, int col) {

        return pieceType.putPiece(row, col);

    }

}
