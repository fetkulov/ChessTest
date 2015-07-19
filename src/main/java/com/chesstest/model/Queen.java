package com.chesstest.model;

/**
 * Representation of a Queen piece.
 * <p/>
 * A Queen moves any number of vacant squares in a horizontal, vertical, or diagonal direction.
 */
public class Queen extends Piece {

    public Queen() {
        super(0, 0);
    }

    public Queen(int row, int col) {
        super(row, col);
    }

    @Override
    public String toString() {
        return PieceType.QUEEN.pieceName();
    }

    /**
     * Is p piece threatened by this piece
     */
    public Boolean isThreatening(Piece p) {

        // The piece is being threatened by the Queen if the piece stays in any square in a horizontal, vertical, or diagonal direction.
        if (this.getRow() == p.getRow() // Horizontal
                || this.getCol() == p.getCol() // Vertical
                || (Math.abs(this.getRow() - p.getRow()) == Math.abs(this.getCol() - p.getCol())) // Diagonal
                )
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
