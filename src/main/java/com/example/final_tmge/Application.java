package com.example.final_tmge;

import com.example.final_tmge.src.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {

    public static TMGE GamePlay;
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        GameMenu menu = new GameMenu();

        String player1Name = Main.getUserInput("Please enter your name Player 1: ");
        String player2Name = Main.getUserInput("Please enter your name Player 2: ");
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Memory memory = new Memory("Memory", player1, player2);
        TileGenerator.Bejeweled bejeweled = new TileGenerator.Bejeweled("Bejeweled", player1, player2);
        menu.addGame(bejeweled);
        menu.addGame(memory);

        //print out the menu and get user input
        int selection = Main.getUserSelection("GAME MENU", menu.getMenuList());

        //Get to know to pop up which game UI
        String title = "";
        String fxmlFile = "";
        GamePlay = menu.getGame(selection);
        if(GamePlay.getGameName().equals("Memory")){
            title = "Memory Game";
            fxmlFile = "MemoryGameUI.fxml";
        }
        else{
            title = "Bejeweled";
            fxmlFile = ""; //TODO: BEJEWELED.FXML
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Application.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public void restart() {
        try {
            start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static URL getResource(String path){
        return Application.class.getResource(path);
    }

    public static void main(String[] args) {
        launch();
    }


}