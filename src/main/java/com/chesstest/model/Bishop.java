package com.chesstest.model;

/**
 * Representation of a Bishop piece.
 * <p/>
 * A Bishop moves any number of vacant squares in any diagonal direction.
 */
public class Bishop extends Piece {

    public Bishop() {
        super(0, 0);
    }

    public Bishop(int row, int col) {
        super(row, col);
    }

    @Override
    public String toString() {
        return PieceType.BISHOP.pieceName();
    }

    /**
     * Is p piece threatened by this piece
     */
    public Boolean isThreatening(Piece p) {

        // The piece is being threatened by the Bishop if the piece stays in any square in a diagonal direction.
        if (Math.abs(this.getRow() - p.getRow()) == Math.abs(this.getCol() - p.getCol()))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

}
