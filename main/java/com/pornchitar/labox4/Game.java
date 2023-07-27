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
    Table table = new Table(player1, player2);
    String[][] t = table.getTable();

    public Game() {
        player1 = new Player("X", 0, 0, 0);
        player2 = new Player("O", 0, 0, 0);

    }

    public void play() {
        boolean isFinish = false;
        printWelcome();
        newGame();
        while (!isFinish) {
            printTable();
            printTurn();
            inputRowCol();
            if (table.checkWin()) {
                printTable();
                printWinner();
                printPlayers();
                if (table.endGame()) {
                    t = table.getTable();
                } else {
                    isFinish = false;

                }
//                isFinish = true;
            }
            if (table.checkDraw()) {
                printTable();
                printDraw();
                printPlayers();
                if (table.endGame()) {
//                table.reset();
                } else {
                    isFinish = false;

                }
//                isFinish = true;
            }
            table.switchPlayer();
        }
    }

    private void printWelcome() {
        System.out.println("Welcome to OX GAME");
    }

    private void printTable() {
        String[][] t = table.getTable();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(t[i][j] + " ");

            }
            System.out.println("");

        }
    }

    private void printTurn() {
        System.out.println(table.getCurrentPlayer().getSymbol() + " Turn");
    }

    private void inputRowCol() {
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
        System.out.println(table.getCurrentPlayer().getSymbol() + " Win!!!");
    }

    private void printDraw() {
        System.out.println(" Draw!!!");
    }

    private void printPlayers() {
        System.out.println(player1);
        System.out.println(player2);
    }

}
