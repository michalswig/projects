package com.michal.projects.tictactoeProject3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToeRunner extends Application {

    Cell[][] cell = new Cell[3][3];
    public static GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) {

        for(int i = 0; i<3; i++){
            for(int j = 0; j < 3; j++){
                int count = 0;
                cell[i][j] = new Cell();
                gridPane.add(cell[i][j], i, j);
            }
        }

        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
