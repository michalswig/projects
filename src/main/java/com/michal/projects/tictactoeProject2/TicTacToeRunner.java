package com.michal.projects.tictactoeProject2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeRunner extends Application {
    Logic logic = new Logic(this);
    Pane pane = new Pane();
    public Pane statusMsg = new Pane();
    public Text labelText = new Text("Ready to play? Go!");
    Tile[][] board = new Tile[3][3];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(new Pane(createBoard()));
        labelText.setFont(Font.font(16));
        statusMsg.getChildren().add(labelText);
        borderPane.setBottom(statusMsg);
        Scene scene = new Scene(borderPane, 600, 650);
        primaryStage.setTitle("TicTacToeGame");
        primaryStage.setScene(scene);
        primaryStage.show();
        Computer computer = new Computer(logic, board);
        computer.start();
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
        pane.getChildren().add(logic.line);
        return pane;
    }







}
