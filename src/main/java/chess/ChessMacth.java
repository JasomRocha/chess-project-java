package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

/**
 *
 * @author jasom
 */
public class ChessMacth {
    private Board board;

    public ChessMacth() {
        board = new Board(8, 8); //Define o tamanho do tabuleiro no construtor
        initialSetup();
    }
    
    public ChessPiece[][] getPieces(){
        
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; //Imprimir as peças no tabuleiro
        
        for(int i=0; i < board.getRows(); i++){
            for(int j=0; j<board.getColumns(); j++){
               mat[i][j] = (ChessPiece) board.piece(i,j); //Matriz que percorre todas as posicoes do tabuleiro, fazendo um downcasting Chesspiece para piece
            }
        }
        return mat;
    }
    
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    
    private void initialSetup(){
        placeNewPiece('b', 8, new Rook(Color.WHITE, board));
        placeNewPiece('e', 8, new King(Color.WHITE, board));
        placeNewPiece('e', 1, new King(Color.BLACK, board));
        placeNewPiece('b', 1, new Rook(Color.BLACK, board));
       
    }
    
    
    
}
