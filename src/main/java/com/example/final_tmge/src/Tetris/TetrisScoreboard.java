package com.example.final_tmge.src.Tetris;

import com.example.final_tmge.src.HorizontalMatch;
import com.example.final_tmge.src.Tetris.TetrisBoard;

import java.util.Timer;
import java.util.TimerTask;

public class TetrisScoreboard {

    class CheckMatchTask extends TimerTask{
        @Override
        public void run(){
            match.findMatches(board.getBoardPieces());
        }
    }

    private int player1Score;
    private int player2Score;
    TetrisBoard board;
    HorizontalMatch match;
    int players;
    Timer timer;
    boolean gameIsLive;
    CheckMatchTask task;

    TetrisScoreboard(int players, TetrisBoard board){

        this.players = players;
        this.board = board;

        timer = new Timer();
        match = new HorizontalMatch();
        task = new CheckMatchTask();

        if(players == 1){
            player1Score = 0;
        }
        else{
            player1Score = 0;
            player2Score = 0;
        }

        timer.schedule(task, 1000, 1000);

    }





}
