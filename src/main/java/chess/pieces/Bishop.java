package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author jasom
 */
public class Bishop extends ChessPiece {
    
    public Bishop(Board board, Color color) {
        super(color, board);
    }

    @Override
    public String toString() {
        return "B";
    }
    
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0,0); 
        
        //nw - verificando acima
        p.setValues(position.getRow() - 1, position.getColumn()-1); //recebe o valor da peça para linha-1 e mesmo valor para a coluna-1, verifica noroeste
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        //ne
         p.setValues(position.getRow()-1, position.getColumn()+1); //recebe o valor da peça para coluna-1 e mesmo valor para a linha, verifica para esquerda
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1, p.getColumn()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
         //se
         p.setValues(position.getRow()+1, position.getColumn()+1); //recebe o valor da peça para coluna-1 e mesmo valor para a linha, verifica para esquerda
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1, p.getColumn()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        //sw
        p.setValues(position.getRow() + 1, position.getColumn()-1); //recebe o valor da peça para linha-1 e mesmo valor para a coluna, verifica acima
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+ 1, p.getColumn()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        
        return mat;
    }
}