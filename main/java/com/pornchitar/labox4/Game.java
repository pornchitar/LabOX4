/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pornchitar.labox4;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Game {
    private Player player1, player2;
    private Table table;

    public Game() {
        player1 = new Player('X');
        player2 = new Player('O');
    }
    
    public void play(){
        boolean isFinish = false;
        printWelcome();
        newGame();
        while(!isFinish){
            printTable();
            printTurn();
            inputRowCol();
            if(table.checkWin()){
                printTable();
                printWinner();
                isFinish = true;
            }
            if(table.checkDraw()){
                printTable();
                printDraw();
                isFinish = true;
            }
        }
    }

    private void printWelcome(){
        System.out.println("OX GAME");
    }
    
    private void printTable(){
        char[][] t = table.getTable();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(t[i][j] + " ");

            }
            System.out.println("");

        }
    }
    
    private void printTurn(){
        System.out.println(table.getCurrentPlayer().getSymbol() + " Turn");
    }
    
    private void inputRowCol(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Input row&Col :");
        int row = sc.nextInt();
        int col = sc.nextInt();
        table.setRowCol(row, col);
    }

    private void newGame() {
        table = new Table(player1, player2);
    }

    private void printWinner() {
        System.out.println(table.getCurrentPlayer()+" Win!!!");
    }

    private void printDraw() {
        System.out.println(" Draw!!!");
    }
}
