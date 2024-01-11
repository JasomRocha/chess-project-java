package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMacth;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author jasom
 */
public class Pawn extends ChessPiece {
    private ChessMacth chessMatch;
    
    public Pawn(Board board, Color color, ChessMacth chessMatch) {
        super(color, board);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0,0);
        
        if(getColor() == Color.WHITE ){
            
            //verifica se a posição a frente está livre
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //Verifica se é a primira jogada, se a primeira posição está livre, para andar duas casas com o peão
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow()-1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //verifica diagonal esquerda
            p.setValues(position.getRow() - 1, position.getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //Verifica diagonal direita
             p.setValues(position.getRow() - 1, position.getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // #specialMove en passant
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn()-1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()){
                    mat[left.getRow()-1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn()+1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()){
                    mat[right.getRow()-1][right.getColumn()] = true;
                }
            }
            
        }
            else{ //Lógica para as pretas
            //verifica se a posição a frente está livre
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //Verifica se é a primira jogada, se a primeira posição está livre, para andar duas casas com o peão
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow()+1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //verifica diagonal esquerda
            p.setValues(position.getRow() + 1, position.getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            //Verifica diagonal direita
             p.setValues(position.getRow() + 1, position.getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            
             // #specialMove en passant
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn()-1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVunerable()){
                    mat[left.getRow()+1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn()+1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVunerable()){
                    mat[right.getRow()+1][right.getColumn()] = true;
                }
            }
        }
       return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
    
}
