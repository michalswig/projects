package com.michal.projects.tictactoeProject2;

import com.michal.projects.tictactoeProject.TicTacToeApp;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Logic {
    private boolean isPlayerTurn = true;

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public int boardSize = 3;
    private char[][] boardLogic = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    public boolean isTheGameFinished() {
        if (hasWon('X')) {
            drawLine('X');
            System.out.println("You won!");
            return true;
        }
        if (hasWon('O')) {
            drawLine('O');
            System.out.println("Computer won!");
            return true;
        }
        for(int i = 0; i < this.boardLogic.length; i++) {
            for (int j = 0; j < this.boardLogic[i].length; j++){
                if(this.boardLogic[i][j] == ' '){
                    return false;
                }
            }
        }
        System.out.println("End of game, it`s a tie!");
        return true;
    }

    public boolean hasWon(char symbol) {
        if(     (this.boardLogic[0][0] == symbol && this.boardLogic[0][1] == symbol && this.boardLogic[0][2] == symbol) ||
                (this.boardLogic[1][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[1][2] == symbol) ||
                (this.boardLogic[2][0] == symbol && this.boardLogic[2][1] == symbol && this.boardLogic[2][2] == symbol) ||

                (this.boardLogic[0][0] == symbol && this.boardLogic[1][0] == symbol && this.boardLogic[2][0] == symbol) ||
                (this.boardLogic[0][1] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][1] == symbol) ||
                (this.boardLogic[0][2] == symbol && this.boardLogic[1][2] == symbol && this.boardLogic[2][2] == symbol) ||

                (this.boardLogic[0][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][2] == symbol) ||
                (this.boardLogic[0][2] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][0] == symbol) ) {
            return true;
        }
        return false;
    }


    public boolean isEmptySpaceToMakeTheTurn(int x, int y) {
        if (this.boardLogic[x][y] == ' ') {
            return true;
        } else return false;
    }

    public boolean makeATurn(int x, int y, char symbol){
        if(isEmptySpaceToMakeTheTurn(x, y)){
            this.boardLogic[x][y] = symbol;
            return true;
        }
        return false;
    }

    Line line = new Line();
    public void drawLine(char symbol){
        if((this.boardLogic[0][0] == symbol && this.boardLogic[0][1] == symbol && this.boardLogic[0][2] == symbol)){
            line.setStartX(100.0f);
            line.setStartY(100.0f);
            line.setEndX(500.0f);
            line.setEndY(100.0f);
        }
        if((this.boardLogic[1][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[1][2] == symbol)){
            line.setStartX(100.0f);
            line.setStartY(300.0f);
            line.setEndX(500.0f);
            line.setEndY(300.0f);
        }
        if((this.boardLogic[2][0] == symbol && this.boardLogic[2][1] == symbol && this.boardLogic[2][2] == symbol)){
            line.setStartX(100.0f);
            line.setStartY(500.0f);
            line.setEndX(500.0f);
            line.setEndY(500.0f);
        }
        if((this.boardLogic[0][0] == symbol && this.boardLogic[1][0] == symbol && this.boardLogic[2][0] == symbol)){
            line.setStartX(100.0f);
            line.setStartY(100.0f);
            line.setEndX(100.0f);
            line.setEndY(500.0f);
        }
        if((this.boardLogic[0][1] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][1] == symbol)){
            line.setStartX(300.0f);
            line.setStartY(100.0f);
            line.setEndX(300.0f);
            line.setEndY(500.0f);
        }
        if((this.boardLogic[0][2] == symbol && this.boardLogic[1][2] == symbol && this.boardLogic[2][2] == symbol)){
            line.setStartX(500.0f);
            line.setStartY(100.0f);
            line.setEndX(500.0f);
            line.setEndY(500.0f);
        }
        if((this.boardLogic[0][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][2] == symbol)){
            line.setStartX(100.0f);
            line.setStartY(100.0f);
            line.setEndX(500.0f);
            line.setEndY(500.0f);
        }
        if( (this.boardLogic[0][2] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][0] == symbol)){
            line.setStartX(500.0f);
            line.setStartY(100.0f);
            line.setEndX(100.0f);
            line.setEndY(500.0f);
        }
    }





}
