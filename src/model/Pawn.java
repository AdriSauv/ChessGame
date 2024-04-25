package model;

import board.Position;
import enums.PieceColor;

public class Pawn extends Piece {
    public Pawn(PieceColor color, Position position){
        super(color, position);
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        int forwardDirection = color == PieceColor.WHITE ? -1 : 1;
        int rowDiff = (newPosition.getRow() - position.getRow()) * forwardDirection;
        int colDiff = newPosition.getColumn() - position.getColumn();

        //Forward move
        if (colDiff == 0 && rowDiff == 1 && board[newPosition.getRow()][newPosition.getColumn()] == null) {
            return true; // move forward one square
        }

        //  Initial 2 square move
        boolean isStartingPosition = (color == PieceColor.WHITE && position.getRow() == 6) || (color == PieceColor.BLACK && position.getRow() == 1);

        if(colDiff == 0 && rowDiff == 2 && isStartingPosition && board[newPosition.getRow()][newPosition.getColumn()] == null){
            //check the square in between for blocking pieces
            int middleRow = position.getRow() + forwardDirection;
            if(board[middleRow][position.getColumn()] == null) {
                return true; // moves forward 2 squares
            }
        }

        //Diagonal capture
        if (Math.abs(colDiff) == 1 && rowDiff == 1 && board[newPosition.getRow()][newPosition.getColumn()] != null && board[newPosition.getRow()][newPosition.getColumn()].color != this.color) {
            return true; //captures opponent's piece
        }
        return false;
    }
}
