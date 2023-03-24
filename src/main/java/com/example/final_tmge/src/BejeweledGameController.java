package com.example.final_tmge.src;


import com.example.final_tmge.Application;
import com.example.final_tmge.src.BejeweledGame.Bejeweled;
import com.example.final_tmge.src.BejeweledGame.BejeweledBoard;
import com.example.final_tmge.src.BejeweledGame.BejeweledScoreboard;
import com.example.final_tmge.src.BejeweledGame.BejeweledTileGenerator;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;

import java.io.IOException;

public class BejeweledGameController {

    public GridPane gameMatrix1;
    public GridPane gameMatrix2;
    public Button start;
    public Button end;
    private Bejeweled bejeweled = (Bejeweled)Application.GamePlay;

    private ObservableList<String> scoreList;

    public void initialize() throws IOException {

    }

}
