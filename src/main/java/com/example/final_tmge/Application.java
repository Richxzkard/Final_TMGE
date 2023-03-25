package com.example.final_tmge;

import com.example.final_tmge.src.*;
import com.example.final_tmge.src.BejeweledGame.Bejeweled;
import com.example.final_tmge.src.Memory.Memory;
import com.example.final_tmge.src.Tetris.Tetris;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {

    public static TMGE GamePlay;

    public static String player1Name;
    public static String player2Name;

    public static final GameInterfaceFactory interfaceFactory = new GameInterfaceFactory();

    @Override
    public void start(Stage stage) throws IOException{
        startGame(stage);
    }

    public void restart() {
        try {
            startGame(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startGame(Stage stage) throws IOException{
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        Memory memory = new Memory("Memory", player1, player2);
        Bejeweled bejeweled = new Bejeweled("Bejeweled", player1, player2);
        Tetris tetris = new Tetris("Tetris", player1, player2);
        TetrisGameController.tetris = tetris;
        
        GameMenu gameMenu = new GameMenu();
        gameMenu.addGame(bejeweled);
        gameMenu.addGame(memory);
        gameMenu.addGame(tetris);

        //print out the menu and get user input
        int selection = Main.getUserSelection("GAME MENU", gameMenu.getMenuList());
        GamePlay = gameMenu.getGame(selection);
        if(GamePlay == null){ //END GAME
            System.exit(0);
        }else{
            //Get to know to pop up which game UI
            //Following the factory pattern that create the new game interface through factory
            Scene scene = interfaceFactory.createScene(GamePlay.getGameName());
            stage.setTitle(GamePlay.getGameName());
            stage.setScene(scene);
            stage.show();
        }

    }

    public static URL getResource(String path){
        return Application.class.getResource(path);
    }

    public static void main(String[] args) {
        Application.player1Name = Main.getUserInput("Please enter your name Player 1: ");
        Application.player2Name = Main.getUserInput("Please enter your name Player 2: ");
        launch(args);
    }
}