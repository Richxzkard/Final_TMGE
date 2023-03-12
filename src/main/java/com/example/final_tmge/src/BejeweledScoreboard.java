package com.example.final_tmge.src;

public class BejeweledScoreboard implements iScore {

    private int score = 0;


    public void updatePlayerScore(int score) {
        throw new UnsupportedOperationException("Unimplemented method 'updateScore'");
    }


    @Override
    public void updatePlayer1Score() {

    }

    @Override
    public void updatePlayer2Score() {

    }

    @Override
    public void resetScores() {
        throw new UnsupportedOperationException("Unimplemented method 'resetPoints'");
    }

    @Override
    public int checkWinCondition() {
        throw new UnsupportedOperationException("Unimplemented method 'checkWinCondition'");
    }

    @Override
    public int getPlayer1Score() {
        return 0;
    }

    @Override
    public int getPlayer2Score() {
        return 0;
    }

    public int getPlayerScore(){
        return score;
    }

}
