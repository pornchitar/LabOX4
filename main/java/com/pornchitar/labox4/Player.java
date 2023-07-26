/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pornchitar.labox4;

/**
 *
 * @author ASUS
 */
public class Player {
    private char symbol;
    private int winCount, loseCount, drawCount;

    public char getSymbol() {
        return symbol;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }

    public int getDrawCount() {
        return drawCount;
    }
    
    public void win(){
        winCount++;
    }
    
    public void lose(){
        loseCount++;
    }
    
    public void draw(){
        drawCount++;
    }
    
}
