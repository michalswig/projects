package com.michal.projects.tictactoeProject3;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

public class Cell extends StackPane {
    TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
    Text sign = new Text();

    public Cell() {
        Rectangle r = new Rectangle(200, 200);
        r.setFill(null);
        r.setStroke(Color.BLACK);
        sign.setFont(Font.font(72));

        this.getChildren().addAll(r, sign);

        setOnMouseClicked(e -> {

            if(e.getButton() == MouseButton.PRIMARY){
                if(!gameLogic.ifCanPlay) return;
                gameLogic.writeX(this.sign, "X");
                gameLogic.ifCanPlay = false;
            }
        });

    }

    public void computerMove(){
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);

    }

}
