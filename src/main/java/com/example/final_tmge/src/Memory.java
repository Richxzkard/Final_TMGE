package com.example.final_tmge.src;

import com.example.final_tmge.MemoryGameController;
import javafx.util.Pair;

public class Memory extends TMGE {

    MemoryBoard board = new MemoryBoard(6, 6);
    MemoryScoreboard scoreboard = new MemoryScoreboard();
    
    public Memory(String name, Player p1, Player p2) {
        super(name, p1, p2);
    }

    @Override
    public MemoryBoard getBoard(){
        return board;
    }

    public MemoryScoreboard getScoreboard(){
        return scoreboard;
    }

    public int getBoardHeight(){
        return board.getHeight();
    }

    public int getBoardWidth(){
        return board.getWidth();
    }

    //Starting a new game, Reset all the things
    public void setUpBoard(){
        //Reset last two piece data
        firstCoordination = null;
        secondCoordination = null;
        //reset score board
        scoreboard.resetScores();
        //reset game board
        board.clearBoard();
        board.setBoard();
    }

    //Return a String array that contains these information:
    //[Match Left: Player1's Score, Player2's Score]
    public String[] getScoreBoardInfo(){
        return new String[]{String.valueOf(scoreboard.getMatchesLeft()),
                String.valueOf(scoreboard.getPlayer1Score()),
                String.valueOf(scoreboard.getPlayer2Score())};
    }

    //Return winner information
    public String getWinnerMessage(){
        int getWinCondition = scoreboard.checkWinCondition();
        String winner = null;
        if(getWinCondition == 1){
            winner = "Winner is " + this.getPlayer1Name();
        }else if(getWinCondition == 2){
            winner = "Winner is " + this.getPlayer2Name();
        }else{
            winner = "The Game is a Tie";
        }
        return winner;
    }

    public int getTileSize(){
        return board.mtg.TileSize;
    }
    public String getQuestionImage(){
        return board.mtg.questionGamePiece.pngPath();
    }

    public String getClearImage(){return board.mtg.checkGamePiece.pngPath();}

    //TODO: JUST FOR GUI DEVELOPMENT
    //RETURN THE IMAGE PATH BY ROW AND COLUMN AND SET THAT PIECE UP
    public String getPath(int row, int column){
        MemoryPiece mp = (MemoryPiece)board.getGamePiece(row, column);
        //Already been clicked
        if(mp.isUp()){
            return null;
        }else{
            mp.toggleIsUp();
            return mp.pngPath();
        }
    }

    /*TODO: JUST FOR GUI DEVELOPMENT, STORE THE COORDINATION OF LAST TWO TILES AND CHECK IF THEY MATCHED
    INPUT: row and column of the current tile
    OUTPUT:
    IS MATCH: return null
    NOT MATCH: return the coordination of last two piece in the format of row * getWidth() + column;
    */
    Pair<Integer, Integer> firstCoordination = null;
    Pair<Integer, Integer> secondCoordination = null;
    public int[] storePiece(int row, int column){
        int[] returnVal = null;
        if(firstCoordination == null){
            firstCoordination = new Pair<>(row, column);
        }else if(secondCoordination == null){
            secondCoordination = new Pair<>(row, column);
        }else{
            if(!checkMatch(firstCoordination, secondCoordination)){ //NOT MATCH
                returnVal = new int[]{0,
                        firstCoordination.getKey()*getBoardWidth() + firstCoordination.getValue(),
                        secondCoordination.getKey()*getBoardWidth() + secondCoordination.getValue()};
            }else{ //MATCH
                scoreboard.updateScore(); //new match happens, update score
                returnVal = new int[]{1,
                        firstCoordination.getKey()*getBoardWidth() + firstCoordination.getValue(),
                        secondCoordination.getKey()*getBoardWidth() + secondCoordination.getValue()};
            }
            scoreboard.toggleTurn(); //next turn
            firstCoordination = new Pair<>(row, column);
            secondCoordination = null;
        }
        return returnVal;
    }

    //TODO: JUST FOR GUI DEVELOPMENT, HELPER FUNCTION FOR storePiece, CHECK IF THE LAST TWO TILES ARE MATCHED
    //TODO: CHECK IF THE GAME END
    public boolean checkMatch(Pair<Integer, Integer> first, Pair<Integer, Integer> second){
        MemoryPiece firstPiece = (MemoryPiece) board.getGamePiece(first.getKey(), first.getValue());
        MemoryPiece secondPiece = (MemoryPiece) board.getGamePiece(second.getKey(), second.getValue());
        if(firstPiece.equals(secondPiece)){
            return true;
        }else{
            firstPiece.toggleIsUp();
            secondPiece.toggleIsUp();
            return false;
        }
    }
}
