package application;


import chess.ChessMacth;
/**
 *
 * @author jasom
 */
public class Program {
    public static void main(String[] args) {
       ChessMacth chessMatch = new ChessMacth();
       UI.printBoard(chessMatch.getPieces());
    }
}
