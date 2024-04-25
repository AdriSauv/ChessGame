package model;

import board.Position;
import enums.PieceColor;

/**
 * Defined the abstract class model.Piece which is the parent class of all the pieces in the game.
 * It has a position and a color. and an abstract method isValidMove which will be implemented by the child classes.
 * It also has a method setPosition which will be used to set the position of the piece.
 * It also has a method getPosition which will be used to get the position of the piece.
 */
public abstract class Piece {
    protected Position position;
    protected PieceColor color;

    public Piece(PieceColor color, Position position){
        this.position = position;
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public abstract boolean isValidMove(Position newPosition, Piece[][] board);
}
