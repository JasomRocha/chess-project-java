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
        if(rows < 1 || columns<1 ){ //Programaão defensiva
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)){ //Programação defensiva
            throw new BoardException("Position not on the board.");
        }
        return pieces[row][column];
    }
    
     public Piece piece(Position position){
        if(!positionExists(position)){ //Programação defensiva
            throw new BoardException("Position not on the board.");
        } 
        return pieces[position.getRow()][position.getColumn()];
    }
     
     public void placePiece(Piece piece, Position position){ //Função que atribui a posição à peça informada, ou seja recebe a peça e atribui a uma determinada posição.
         if(thereIsAPiece(position)){
             throw new BoardException("There is already a piece on position: " + position);
         }
         
         pieces[position.getRow()][position.getColumn()] = piece;
         piece.position = position; //Consigo acessar esse atributo pois ele é protected
     } 
     
     public Piece removePiece(Position position){
       if(!positionExists(position)){ //Programação defensiva
            throw new BoardException("Position not on the board.");
        } 
       if (piece(position) == null){
           return null;
       }
       Piece aux = piece(position);
       aux.position = null;

       pieces[position.getRow()][position.getColumn()] = null;
       return aux;
     }
     
     private boolean positionExists(int row, int column){ //Metodo auxiliar, testa os argumentos do objeto position passado pela funcao que a invocou 
         return (row>=0 && row<rows && column >=0 && column < columns);
     }
     
     public boolean positionExists(Position position){ //Recebe o objeto position e invoce a funcao que testa linhas e colunas válidas
         return positionExists(position.getRow(), position.getColumn());
     }
     
     public boolean thereIsAPiece(Position position){
         if(!positionExists(position)){  //Programação defensiva
            throw new BoardException("Position not on the board.");
        }
         return piece(position) != null;
     }
     
     
     
}
