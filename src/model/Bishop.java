package model;

import board.Position;
import enums.PieceColor;

public class Bishop extends Piece{
    public Bishop(PieceColor color, Position position){
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int rowDiff = Math.abs(position.getRow() - newPosition.getRow());
        int colDiff = Math.abs(position.getColumn() - newPosition.getColumn());

        if (rowDiff != colDiff) {
            return false; // the move isn't diagonal
        }

        int rowStep = newPosition.getRow() > position.getRow() ? 1 : -1;
        int colStep = newPosition.getColumn() > position.getColumn() ? 1 : -1;
        int steps = rowDiff - 1; // number of squares to check for obstruction

        //check for obstruction along th path
        for (int i=1; i <= steps; i++) {
            if(board[position.getRow() + i * rowStep][position.getColumn() + i * colStep] != null ) {
                return false;
            }
        }

        // Check the destination square for capturing or moving to an empty square
        Piece destinationPiece = board[newPosition.getRow()][newPosition.getColumn()];
        if(destinationPiece == null){
            return true; // the destination is empty, the move is valid
        } else if (destinationPiece.getColor() != this.getColor()) {
            return true; // the destination has an opponent's piece, capturing it
        }

        return false;
    }
}
