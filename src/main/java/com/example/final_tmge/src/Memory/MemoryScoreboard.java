package com.example.final_tmge.src.Memory;

import com.example.final_tmge.src.iScore;

public class MemoryScoreboard implements iScore {

    //MEMORY KEEPS TRACK OF MATCHES INSTEAD OF SCORES

    private int player1Matches = 0;
    private int player2Matches = 0;
    private int matchesLeft = 17;

    private boolean recordTurn = true; //true: player1's turn, false: player2's turn

    @Override
    public void updatePlayer1Score() {
        player1Matches++;
    }

    @Override
    public void updatePlayer2Score(){
        player2Matches++;
    }

    //UPDATE SCORE BASE ON TURN
    public void updateScore(){
        //update player1's score or player2's score base on turn
        if(recordTurn){
            updatePlayer1Score();
        }else{
            updatePlayer2Score();
        }
        decrementMatchesLeft(); //decrement a match
    }

    @Override
    public void resetScores() {
        player1Matches = 0;
        player2Matches = 0;
        matchesLeft = 17;
        recordTurn = true;
    }

    @Override
    public int checkWinCondition() {
        if (player1Matches > player2Matches){
            return 1; //PLAYER 1 WINS
        }
        else if (player1Matches < player2Matches){
            return 2; //PLAYER 2 WINS
        }
        return 0; //NOBODY WINS; TIE
    }

    @Override
    public int getPlayer1Score(){
        return player1Matches;
    }

    @Override
    public int getPlayer2Score(){
        return player2Matches;
    }

    public int getMatchesLeft(){
        return matchesLeft;
    }

    public void decrementMatchesLeft(){
        matchesLeft--;
    }


    public void toggleTurn(){
        recordTurn = !recordTurn;
    }
    
}
