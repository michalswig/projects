package com.michal.projects.tictactoeProject2;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TicTacToeRunner extends Application {
    Logic logic = new Logic();
    Pane pane = new Pane();
    Tile[][] board = new Tile[3][3];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createBoard()));

        primaryStage.setTitle("TicTacToeGame");
        primaryStage.show();
    }

    private Parent createBoard() {
        pane.setPrefSize(600, 600);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Tile tile = new Tile(logic, i, j);
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);
                board[i][j] = tile;
                pane.getChildren().add(tile);

            }

        }

        Computer computer = new Computer(logic, board);
        computer.start();

        return pane;
    }

}
