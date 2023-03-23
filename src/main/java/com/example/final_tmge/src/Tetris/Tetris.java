package com.example.final_tmge.src.Tetris;

import com.example.final_tmge.TetrisGameController;
import com.example.final_tmge.src.Player;
import com.example.final_tmge.src.TMGE;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class Tetris extends TMGE {
    private static final int X_BLOCKS = 12;
    private static final int Y_BLOCKS = 24;

    public static TetrisBoard board1;
    public static TetrisBoard board2;

    public Tetris(String name, Player p1, Player p2) {
        super(name, p1, p2);
        board1 = new TetrisBoard(X_BLOCKS, Y_BLOCKS);
        board2 = new TetrisBoard(X_BLOCKS, Y_BLOCKS);
//        board2.xMin = 330;
    }

    public void startNewGame(Pane leftPane, Pane rightPane, Label left, Label right) {
        left.setText(player1.userName);
        right.setText(player2.userName);

        board1.BindPane(leftPane);
        board2.BindPane(rightPane);
        leftPane.getChildren().clear();
        rightPane.getChildren().clear();
        board1.clearMesh();
        board2.clearMesh();
    }

    public int getXBlocks() {
        return X_BLOCKS;
    }
}
