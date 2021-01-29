package com.michal.projects.tictactoeProject2;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

class Tile extends StackPane {
    int x;
    int y;
    Text text = new Text();
    TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
    Logic logic;
    public Tile(Logic logic, int x, int y) {
        System.out.println("test run()");

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
                if(!logic.isPlayerTurn()) return;
                if(logic.isEmptySpaceToMakeTheTurn(x, y)){
                    logic.makeATurn(x, y, 'X');
                    drawX();
                    logic.setPlayerTurn(false);
                }
            }
        });

    }

    public void drawX() {
        text.setText("X");
    }

    public void drawO() {
        text.setText("O");
    }


}
