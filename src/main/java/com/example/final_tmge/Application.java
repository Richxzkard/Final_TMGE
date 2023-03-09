package com.example.final_tmge;

import com.example.final_tmge.src.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameMenu menu = new GameMenu();

        String player1Name = Main.getUserInput("Please enter your name Player 1: ");
        String player2Name = Main.getUserInput("Please enter your name Player 2: ");
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Memory memory = new Memory("Memory", player1, player2);
        Bejeweled bejeweled = new Bejeweled("Bejeweled", player1, player2);
        menu.addGame(bejeweled);
        menu.addGame(memory);

        //print out the menu and get user input
        int selection = Main.getUserSelection("GAME MENU", menu.getMenuList());
        System.out.println("User choose " + selection); //TEST

        //Get to know to pop up which game UI
        String title = "";
        String fxmlFile = "";
        if(menu.getGame(selection).getGameName().equals("Memory")){
            title = "Memory Game";
            fxmlFile = "MemoryGameUI.fxml";
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}