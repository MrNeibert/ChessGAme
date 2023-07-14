package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {


    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];

        Position p = new Position(0,0);

        if(getColor() ==Color.WHITE){
            //moves Only up:
            p.setValues(position.getRow() -1,position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            //First Movement can go 2 spaces(check space1 and space 2!):
            p.setValues(position.getRow() -2,position.getColumn());
            Position p2 =new Position(position.getRow() -1,position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() ==0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            //Can move sideways if there is an opponent piece there
            //Left Diagonal:
            p.setValues(position.getRow() -1,position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            //Right Diagonal:
            p.setValues(position.getRow() -1,position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }else{
            //Black Pawns:
            //moves Only Down!:
            p.setValues(position.getRow() +1,position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            //First Movement can go 2 spaces(check space1 and space 2!):
            p.setValues(position.getRow() +2,position.getColumn());
            Position p2 =new Position(position.getRow() +1,position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() ==0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            //Can move sideways if there is an opponent piece there
            //Left Diagonal:
            p.setValues(position.getRow() +1,position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            //Right Diagonal:
            p.setValues(position.getRow() +1,position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }




        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
