package com.chesstest.model;


/**
 * Class implements PieceType
 */
public enum PieceType {
    // Pieces
    KING("K"){
      public Piece putPiece(int row, int col){
          return new King(row, col);
      }
    },
    QUEEN("Q"){
        public Piece putPiece(int row, int col){
            return new Queen(row, col);
        }
    },
    ROOK("R"){
        public Piece putPiece(int row, int col){
            return new Rook(row, col);
        }
    },
    KNIGHT("N"){
        public Piece putPiece(int row, int col){
            return new Knight(row, col);
        }
    },
    BISHOP("B"){
        public Piece putPiece(int row, int col){
            return new Bishop(row, col);
        }
    },

    // Square States
    EMPTY("-"){
        public Piece putPiece(int row, int col){
            return null;
        }
    };

    private String pieceName;

    PieceType(String pieceName) {
        this.pieceName = pieceName;
    }

    public String pieceName() {
        return pieceName;
    }

    public abstract Piece putPiece(int row, int col);

}
