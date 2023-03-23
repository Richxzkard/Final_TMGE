package com.example.final_tmge.src.BejeweledGame;

import com.example.final_tmge.src.iScore;

public class BejeweledScoreboard implements iScore {

    private int p1Score;
    private int p2Score;
    public int p1Matches;
    public int p2Matches;

    BejeweledScoreboard(){
        p1Score = 0;
        p2Score = 0;
    }

    public void setP1Matches(int matches){
        p1Matches = matches;
    }
    public void setP2Matches(int matches){
        p2Matches = matches;
    }

    @Override
    public void updatePlayer1Score() {
        p1Score = p1Matches * 100;
    }

    @Override
    public void updatePlayer2Score() {
        p2Score = p2Matches * 100;
    }

    @Override
    public void resetScores() {
        p1Score = 0;
        p2Score = 0;
    }

    @Override
    public int checkWinCondition() {
        if(p1Score == 1000) {
            return 1;
        } else if (p2Score == 1000) {
            return 2;
        }
        else {
            return 0;
        }
    }

    @Override
    public int getPlayer1Score() {
        return p1Score;
    }

    @Override
    public int getPlayer2Score() {
        return p2Score;
    }


}
