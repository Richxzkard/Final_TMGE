package com.example.final_tmge.src.BejeweledGame;

import com.example.final_tmge.src.GamePiece;
import com.example.final_tmge.src.Player;
import com.example.final_tmge.src.TMGE;

public class Bejeweled extends TMGE {

    // Gem pieces class inherited from GamePiece, might add more functionality as needed.
    public static class Gem extends GamePiece {
        Gem(String name){
            super(name);
        }

    }

    BejeweledBoard p1Board;
    BejeweledBoard p2Board;

    final int HEIGHT = 8;
    final int WIDTH = 8;
    BejeweledScoreboard scoreboard = new BejeweledScoreboard();

    public Bejeweled(String name, Player p1, Player p2) {
        super(name, p1, p2);
        p1Board = new BejeweledBoard(HEIGHT, WIDTH);
        p2Board = new BejeweledBoard(HEIGHT, WIDTH);
    }

    public BejeweledBoard getBoard(int player){
        if(player == 1) {
            return p1Board;
        }
        return p2Board;
    }

    public int getBoardHeight(){ return HEIGHT; }

    public int getBoardWidth(){ return WIDTH; }

    public BejeweledScoreboard getScoreboard() { return scoreboard; }

    public void setUpBoard(){
        scoreboard.resetScores();
        p1Board.resetBoard();
        p2Board.resetBoard();
        p1Board.setBejeweledBoard();
        p2Board.setBejeweledBoard();
    }

}