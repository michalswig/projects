package com.michal.projects.tictactoeProject2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToeRunner extends Application {

    Logic logic = new Logic(this);
    Tile[][] board = new Tile[3][3];
    Pane pane = new Pane();

    public GridPane statusMsg = new GridPane();
    public Text labelText = new Text("Ready to play? Go!");

    GridPane upperMenu = new GridPane();
    Text chooseSymbolPlayer = new Text("choose Player`s symbol and start to play");
    ChoiceBox<Character> symbolPlayer = new ChoiceBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        setMenu(statusMsg, labelText);
        statusMsg.setStyle("-fx-background-color: #f5f5dc;");
        labelText.setFont(Font.font(16));

        setMenu(upperMenu, chooseSymbolPlayer);
        upperMenu.add(symbolPlayer, 1, 0);
        upperMenu.setStyle("-fx-background-color: BEIGE;");
        symbolPlayer.getItems().addAll(logic.getListAvailableSigns());
        symbolPlayer.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            int index = symbolPlayer.getSelectionModel().getSelectedIndex();
            logic.setPlayerSign(logic.getListItem(index));
        });
        chooseSymbolPlayer.setFont(Font.font(16));

        borderPane.setTop(upperMenu);
        borderPane.setCenter(new Pane(createBoard()));
        borderPane.setBottom(statusMsg);
        Scene scene = new Scene(borderPane, 600, 702);
        primaryStage.setTitle("TicTacToeGame");
        primaryStage.setScene(scene);
        primaryStage.show();

        Computer computer = new Computer(logic, board);
        computer.start();
    }

    private void setMenu(GridPane upperMenu, Text chooseSymbolPlayer) {
        upperMenu.setPadding(new Insets(10, 10, 10, 10));
        upperMenu.setVgap(5);
        upperMenu.setHgap(5);
        upperMenu.setAlignment(Pos.CENTER);
        upperMenu.setPrefSize(600, 50);
        upperMenu.add(chooseSymbolPlayer, 0, 0);
    }

    private Parent createBoard() {
        pane.setPrefSize(600, 600);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
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
