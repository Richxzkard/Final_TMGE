package com.example.final_tmge;

import com.example.final_tmge.src.Memory;
import com.example.final_tmge.src.TMGE;
import com.example.final_tmge.src.Tetris.Tetris;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class TetrisGameController {
    public Button start;
    private final Tetris tetris = (Tetris)Application.GamePlay;
    public Pane gameMatrixleft;
    public Pane gameMatrixright;

    public void initialize() throws IOException {
        startNewGame();
        start.setOnMouseClicked(event -> startNewGame());
    }

    public void startNewGame(){
        gameMatrixright.getChildren().addAll();
        gameMatrixleft.getChildren().clear();




        }
    }

