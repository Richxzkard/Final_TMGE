package com.example.final_tmge.src;

import java.util.Timer;
import java.util.TimerTask;

public class TetrisScoreboard {

    class CheckMatchTask extends TimerTask{

        @Override
        public void run(){

        }
    }


    private int player1Score;
    private int player2Score;
    int players;

    Timer timer;

    boolean gameIsLive;

    TetrisScoreboard(int players){

        this.players = players;
        timer = new Timer();


        if(players == 1){
            player1Score = 0;
        }
        else{
            player1Score = 0;
            player2Score = 0;
        }

    }





}
