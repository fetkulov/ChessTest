package com.chesstest.model;

/**
 * Representation of a Rook piece.
 * <p/>
 * A rook moves any number of vacant squares in an horizontal or vertical direction.
 */
public class Rook extends Piece {

    public Rook() {
        super(0, 0);
    }

    public Rook(int row, int col) {
        super(row, col);
    }

    @Override
    public String toString() {
        return PieceType.ROOK.pieceName();
    }

    public Boolean isThreatening(Piece p) {

        // The piece is being threatened by the rook if the piece stays in the same row or the same column
        if (this.getRow() == p.getRow() // Horizontal
                || this.getCol() == p.getCol() // Vertical
                )
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
