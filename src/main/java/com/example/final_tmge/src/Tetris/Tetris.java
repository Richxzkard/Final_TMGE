package com.example.final_tmge.src.Tetris;

import com.example.final_tmge.src.Player;
import com.example.final_tmge.src.TMGE;

public class Tetris extends TMGE {
    private int width = 12;
    private int height = 24;

    TetrisScoreboard scoreboard;
    TetrisBoard board;

    public Tetris(String name, Player p1, Player p2) {
        super(name, p1, p2);
        board = new TetrisBoard(width, height);
        scoreboard = new TetrisScoreboard(2, board);
    }

    public void setUpBoard(){

    }

    public int getBoardWidth(){
        return this.width;
    }
    public int getBoardHeight(){
        return this.height;
    }

}
