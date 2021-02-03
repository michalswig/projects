package com.michal.projects.tictactoeProject2;

import javafx.scene.shape.Line;

public class Logic {
    TicTacToeRunner ticTacToeRunner;

    private char playerSign;

    Character[] listAvailableSigns = {'X', 'Y', 'Z'};

    public Character[] getListAvailableSigns() {
        return listAvailableSigns;
    }

    public Character getListItem(int index) {
        return listAvailableSigns[index];
    }

    public Logic(TicTacToeRunner ticTacToeRunner) {
        this.ticTacToeRunner = ticTacToeRunner;
    }

    private boolean isPlayerTurn = true;

    public boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    private final char[][] boardLogic = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    public boolean isTheGameFinished() {
        if (hasWon('X')) {
            drawLine('X');
            ticTacToeRunner.labelText.setText("Player won!");
            return true;
        }
        if (hasWon('O')) {
            drawLine('O');
            ticTacToeRunner.labelText.setText("Computer won!");
            return true;
        }
        for (char[] chars : this.boardLogic) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        ticTacToeRunner.labelText.setText("End of game, it`s a tie!");
        return true;
    }

    public boolean hasWon(char symbol) {
        return (this.boardLogic[0][0] == symbol && this.boardLogic[0][1] == symbol && this.boardLogic[0][2] == symbol) ||
                (this.boardLogic[1][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[1][2] == symbol) ||
                (this.boardLogic[2][0] == symbol && this.boardLogic[2][1] == symbol && this.boardLogic[2][2] == symbol) ||

                (this.boardLogic[0][0] == symbol && this.boardLogic[1][0] == symbol && this.boardLogic[2][0] == symbol) ||
                (this.boardLogic[0][1] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][1] == symbol) ||
                (this.boardLogic[0][2] == symbol && this.boardLogic[1][2] == symbol && this.boardLogic[2][2] == symbol) ||

                (this.boardLogic[0][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][2] == symbol) ||
                (this.boardLogic[0][2] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][0] == symbol);
    }

    public boolean isEmptySpaceToMakeTheTurn(int x, int y) {
        if (this.boardLogic[x][y] == ' ') {
            return true;
        } else return false;
    }

    public boolean makeATurn(int x, int y, char symbol) {
        if (isEmptySpaceToMakeTheTurn(x, y)) {
            this.boardLogic[x][y] = symbol;
            return true;
        }
        return false;
    }

    Line line = new Line();

    public void drawLine(char symbol) {
        if ((this.boardLogic[0][0] == symbol && this.boardLogic[0][1] == symbol && this.boardLogic[0][2] == symbol)) {
            line.setStartX(100.0f);
            line.setStartY(100.0f);
            line.setEndX(500.0f);
            line.setEndY(100.0f);
        }
        if ((this.boardLogic[1][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[1][2] == symbol)) {
            line.setStartX(100.0f);
            line.setStartY(300.0f);
            line.setEndX(500.0f);
            line.setEndY(300.0f);
        }
        if ((this.boardLogic[2][0] == symbol && this.boardLogic[2][1] == symbol && this.boardLogic[2][2] == symbol)) {
            line.setStartX(100.0f);
            line.setStartY(500.0f);
            line.setEndX(500.0f);
            line.setEndY(500.0f);
        }
        if ((this.boardLogic[0][0] == symbol && this.boardLogic[1][0] == symbol && this.boardLogic[2][0] == symbol)) {
            line.setStartX(100.0f);
            line.setStartY(100.0f);
            line.setEndX(100.0f);
            line.setEndY(500.0f);
        }
        if ((this.boardLogic[0][1] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][1] == symbol)) {
            line.setStartX(300.0f);
            line.setStartY(100.0f);
            line.setEndX(300.0f);
            line.setEndY(500.0f);
        }
        if ((this.boardLogic[0][2] == symbol && this.boardLogic[1][2] == symbol && this.boardLogic[2][2] == symbol)) {
            line.setStartX(500.0f);
            line.setStartY(100.0f);
            line.setEndX(500.0f);
            line.setEndY(500.0f);
        }
        if ((this.boardLogic[0][0] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][2] == symbol)) {
            line.setStartX(100.0f);
            line.setStartY(100.0f);
            line.setEndX(500.0f);
            line.setEndY(500.0f);
        }
        if ((this.boardLogic[0][2] == symbol && this.boardLogic[1][1] == symbol && this.boardLogic[2][0] == symbol)) {
            line.setStartX(500.0f);
            line.setStartY(100.0f);
            line.setEndX(100.0f);
            line.setEndY(500.0f);
        }
    }


    public void setPlayerSign(Character sign) {
        this.playerSign = sign;
    }

    public Character getPlayerSign() {
        return playerSign;
    }


}
