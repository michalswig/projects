package com.michal.projects.tictactoeProject2;

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

    private boolean isTheGameFinished() {
        if (hasWon('X')) {
            System.out.println("You wins!");
            return true;
        }
        if (hasWon('O')) {
            System.out.println("Computer wins!");
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

    private boolean hasWon(char symbol) {
        if( (this.boardLogic[0][0] == symbol && this.boardLogic[0][1] == symbol && this.boardLogic[0][2] == symbol) ||
                (this.boardLogic[1][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[1][2] == symbol) ||
                (this.boardLogic[2][0] == symbol && this.boardLogic[2][1] == symbol && this.boardLogic[2][2] == symbol) ||

                (this.boardLogic[0][0] == symbol && this.boardLogic[1][0] == symbol && this.boardLogic[2][0] == symbol) ||
                (this.boardLogic[0][1] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][1] == symbol) ||
                (this.boardLogic[0][2] == symbol && this.boardLogic[1][2] == symbol && this.boardLogic[2][2] == symbol) ||

                (this.boardLogic[0][1] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][2] == symbol) ||
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

}
