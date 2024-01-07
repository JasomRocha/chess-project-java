package chess;

import boardgame.Board;

/**
 *
 * @author jasom
 */
public class ChessMacth {
    private Board board;

    public ChessMacth() {
        board = new Board(8, 8); //Define o tamanho do tabuleiro no construtor
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
    
    
    
    
}
