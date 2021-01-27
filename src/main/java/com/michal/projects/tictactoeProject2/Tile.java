package com.michal.projects.tictactoeProject2;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;
import java.util.Scanner;

class Tile extends StackPane {
    int x;
    int y;
    Text text = new Text();
    TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
    Logic logic;
    public Tile(Logic logic, int x, int y) {
        this.x = x;
        this.y = y;
        this.logic = logic;
        Rectangle r = new Rectangle(200, 200);
        text.setFont(Font.font(72));
        r.setFill(null);
        r.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(r, text);

        setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                if(logic.isEmptySpaceToMakeTheTurn(x, y)){
                    logic.makeATurn(x, y, 'X');
                    drawX();
                }

               computerTurn();
            }
        });

    }

    private void drawX() {
        text.setText("X");
    }

    private void drawO() {
        text.setText("O");
    }

    private void computerTurn() {
        Random random = new Random();
        int randomX = random.nextInt(3);
        int randomY = random.nextInt(3);
        while(!logic.isEmptySpaceToMakeTheTurn(randomX, randomY)){
            randomX = random.nextInt(3);
            randomY = random.nextInt(3);
        }
        logic.makeATurn(randomX, randomY, 'O');
        drawO();
    }






}
