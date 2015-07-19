package com.chesstest.model;

/**
 * Representation of a Knight piece.
 * <p/>
 * A Knight moves to the nearest square not on the same rank, file, or diagonal.
 */
public class Knight extends Piece {

    public Knight() {
        super(0, 0);
    }

    public Knight(int row, int col) {
        super(row, col);
    }

    @Override
    public String toString() {
        return PieceType.KNIGHT.pieceName();
    }

    /**
     * Is p piece threatened by this piece
     */
    public Boolean isThreatening(Piece p) {

        // The piece is being threatened by the Knight if the piece stays in any square nearest square not on the same rank, file, or diagonal.
        if (Math.abs(this.getRow() - p.getRow()) <= 2 && Math.abs(this.getCol() - p.getCol()) <= 2 // Limit a 5x5 area
                && this.getRow() != p.getRow() // Not same horizontal
                && this.getCol() != p.getCol() // Not same vertical
                && (Math.abs(this.getRow() - p.getRow()) != Math.abs(this.getCol() - p.getCol())) // Not same diagonal
                )
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
