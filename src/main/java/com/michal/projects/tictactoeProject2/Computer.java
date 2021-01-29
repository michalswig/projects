package com.michal.projects.tictactoeProject2;

import java.util.Random;

public class Computer extends Thread {
    Logic logic;
    Tile[][] board;

    public Computer(Logic logic, Tile[][] board) {
        this.logic = logic;
        this.board = board;
    }

    public void run() {

        while(true){
            System.out.println("test run()");
            if(!logic.isPlayerTurn()) {
                computerTurn();
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void computerTurn() {
        Random random = new Random();
        int computerTurnX = random.nextInt(3);
        int computerTurnY = random.nextInt(3);
        while(logic.isEmptySpaceToMakeTheTurn(computerTurnX, computerTurnY)){
            computerTurnX = random.nextInt(3);
            computerTurnY = random.nextInt(3);
        }
        logic.makeATurn(computerTurnX, computerTurnY, 'O');
        board[computerTurnX][computerTurnY].drawO();
        logic.setPlayerTurn(true);
    }
}
