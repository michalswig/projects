package com.michal.projects.tictactoeProject3;

import javafx.scene.text.Text;

import java.util.Random;

public class gameLogic {

    public static boolean ifCanPlay = true;

    public void ifPlaceToPlay() {

    }

    public static void computerMove(Text text, String X){
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        text.setText("O");

    }

    public static void writeX(Text symbol, String playerSign) {
        symbol.setText("X");
    }

    public static void writeO(Text text, String playerSign) {
        text.setText("O");
    }

}
