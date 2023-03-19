package com.example.final_tmge;

import com.example.final_tmge.src.*;
import com.example.final_tmge.src.Tetris.Tetris;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {

    public static TMGE GamePlay;

    String player1Name;
    String player2Name;

    @Override
    public void start(Stage stage) throws IOException{
        player1Name = Main.getUserInput("Please enter your name Player 1: ");
        player2Name = Main.getUserInput("Please enter your name Player 2: ");

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
        TileGenerator.Bejeweled bejeweled = new TileGenerator.Bejeweled("Bejeweled", player1, player2);

        Tetris tetris = new Tetris("Tetris", player1, player2);
        
        GameMenu gameMenu = new GameMenu();
        gameMenu.addGame(bejeweled);
        gameMenu.addGame(memory);
        gameMenu.addGame(tetris);

        //print out the menu and get user input
        int selection = Main.getUserSelection("GAME MENU", gameMenu.getMenuList());

        //Get to know to pop up which game UI
        String title = "";
        String fxmlFile = "";
        GamePlay = gameMenu.getGame(selection);
        if(GamePlay.getGameName().equals("Memory")){
            title = "Memory Game";
            fxmlFile = "MemoryGameUI.fxml";
        }
        else if(GamePlay.getGameName().equals("Bejeweled")){
            title = "Bejeweled";
            fxmlFile = ""; //TODO: BEJEWELED.FXML
        }
        else{
            title = "Tetris";
            fxmlFile = "TetrisGameUI.fxml";
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Application.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static URL getResource(String path){
        return Application.class.getResource(path);
    }

    public static void main(String[] args) {
        launch();
    }
}