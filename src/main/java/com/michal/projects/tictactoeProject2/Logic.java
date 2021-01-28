package com.michal.projects.tictactoeProject2;

import java.util.Random;

public class Logic {
    public boolean isComputerTurn = true;
    public int boardSize = 3;
    private char[][] board = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    private boolean isTheGameFinished() {
        if (hasWon('X')) {
            System.out.println("You wins!");
            return true;
        }
        if (hasWon('O')) {
            System.out.println("Computer wins!");
            return true;
        }
        for(int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++){
                if(this.board[i][j] == ' '){
                    return false;
                }
            }
        }
        System.out.println("End of game, it`s a tie!");
        return true;
    }

    private boolean hasWon(char symbol) {
        if( (this.board[0][0] == symbol && this.board[0][1] == symbol && this.board[0][2] == symbol) ||
                (this.board[1][0] == symbol && this.board[1][1] == symbol && this.board[1][2] == symbol) ||
                (this.board[2][0] == symbol && this.board[2][1] == symbol && this.board[2][2] == symbol) ||

                (this.board[0][0] == symbol && this.board[1][0] == symbol && this.board[2][0] == symbol) ||
                (this.board[0][1] == symbol && this.board[1][1] == symbol && this.board[2][1] == symbol) ||
                (this.board[0][2] == symbol && this.board[1][2] == symbol && this.board[2][2] == symbol) ||

                (this.board[0][1] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol) ||
                (this.board[0][2] == symbol && this.board[1][1] == symbol && this.board[2][0] == symbol) ) {
            return true;
        }
        return false;
    }

    private void computerTurn() {
        Random random = new Random();
        int computerTurnX = random.nextInt(boardSize);
        int computerTurnY = random.nextInt(boardSize);
        while(!isEmptySpaceToMakeTheTurn(computerTurnX, computerTurnY)){
            computerTurnX = random.nextInt(boardSize);
            computerTurnY = random.nextInt(boardSize);
        }
        makeATurn(computerTurnX, computerTurnY, 'O');
    }

    public boolean isEmptySpaceToMakeTheTurn(int x, int y) {
        if (this.board[x][y] == ' ') {
            return true;
        } else return false;
    }

    public boolean makeATurn(int x, int y, char symbol){
        if(isEmptySpaceToMakeTheTurn(x, y)){
            this.board[x][y] = symbol;
            return true;
        }
        return false;
    }

}
