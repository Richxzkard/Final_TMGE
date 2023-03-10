package com.example.final_tmge.src;

public class MemoryScoreboard implements iScore {

    private int score = 0;

    @Override
    public void updateScore(int score) {
        throw new UnsupportedOperationException("Unimplemented method 'updateScore'");
    }

    @Override
    public void resetPoints() {
        throw new UnsupportedOperationException("Unimplemented method 'resetPoints'");
    }

    @Override
    public boolean checkWinCondition() {
        throw new UnsupportedOperationException("Unimplemented method 'checkWinCondition'");
    }

    @Override
    public int getScore(){
        return score;
    }
    
}
