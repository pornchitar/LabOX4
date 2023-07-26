/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pornchitar.labox4;

/**
 *
 * @author ASUS
 */
public class Table {

    private char[][] table = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    private Player player1, player2, currentPlayer;
    private int row, col;
    private int count;

    public Table(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;

    }

    public char[][] getTable() {
        return table;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean setRowCol(int row, int col) {
        if (table[row - 1][col - 1] == '-') {
            table[row - 1][col - 1] = currentPlayer.getSymbol();
            this.row = row;
            this.col = col;
            this.count ++;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if(checkRow()){
            saveWin();
            return true;
        }
        if(checkCol()){
            saveWin();
            return true;
        }
        if(checkX1()){
            saveWin();
            return true;
        }
        if(checkX2()){
            saveWin();
            return true;
        }
        if(checkDiagonals()){
            saveWin();
            return true;
        }
        return false;
    }
    
    public boolean checkDraw(){
        if(count==9){
            player1.draw();
            player2.draw();
            return true;
        }
        return false;
    }

    public boolean checkRow() {
        return table[row-1][0] != '-' && table[row-1][0] == table[row-1][1] && table[row-1][0] == table[row-1][2];
    }

    public boolean checkCol() {
        return false;
    }

    public boolean checkX1() {
        return false;
    }

    public boolean checkX2() {
        return false;
    }

    public boolean checkDiagonals() {
        return false;
    }
    
    private void saveWin(){
        if(currentPlayer==player1){
            player1.win();
            player2.lose();
        }else{
            player2.win();
            player1.lose();
        }
    }
}
