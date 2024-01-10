package application;


import chess.ChessMacth;
import chess.ChessPiece;
import chess.ChessPosition;
import java.util.Scanner;
/**
 *
 * @author jasom
 */
public class Program {
    public static void main(String[] args) {
       ChessMacth chessMatch = new ChessMacth();
       Scanner sc = new Scanner(System.in);
       
       while(true){
         UI.printBoard(chessMatch.getPieces());
           System.out.println();
          
           System.out.print("Source: ");
           ChessPosition source = UI.readChessPosition(sc);
           
           System.out.println();
           System.out.print("Target: ");
           ChessPosition target = UI.readChessPosition(sc);
          
           
           ChessPiece capturedPiece = chessMatch.performChessMove(source, target);   
       }
    }
}
