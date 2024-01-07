/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgame;

/**
 *
 * @author jasom
 */
public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
    public Piece piece(int row, int column){
        return pieces[row][column];
    }
    
     public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }
     
     public void placePiece(Piece piece, Position position){ //Função que atribui a posição à peça informada, ou seja recebe a peça e atribui a uma determinada posição.
         pieces[position.getRow()][position.getColumn()] = piece;
         piece.position = position; //Consigo acessar esse atributo pois ele é protected
     } 
     
}
