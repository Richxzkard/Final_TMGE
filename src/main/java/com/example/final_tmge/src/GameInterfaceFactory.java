package com.example.final_tmge.src;

import com.example.final_tmge.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class GameInterfaceFactory {
    public Scene createScene(String GameName) throws IOException {
        String fxmlFile = "";
        if(GameName.equals("Memory")){
            FXMLLoader fxmlLoader = new FXMLLoader(Application.getResource("MemoryGameUI.fxml"));
            return new Scene(fxmlLoader.load());
        }
        else if(GameName.equals("Bejeweled")){
            FXMLLoader fxmlLoader = new FXMLLoader(Application.getResource("BejeweledGameUI.fxml"));
            return new Scene(fxmlLoader.load());
        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(Application.getResource("TetrisGameUI.fxml"));
            return new Scene(fxmlLoader.load());
        }
    }
}
