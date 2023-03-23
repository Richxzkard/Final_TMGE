package com.example.final_tmge.src;

public interface iScore {
    public void updatePlayer1Score();
    public void updatePlayer2Score();
    public void resetScores();

    public int checkWinCondition();

    public int getPlayer1Score();
    public int getPlayer2Score();
}

