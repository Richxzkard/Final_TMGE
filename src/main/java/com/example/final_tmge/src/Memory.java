package com.example.final_tmge.src;

import javafx.util.Pair;

public class Memory extends TMGE {

    MemoryBoard board = new MemoryBoard(6, 6);
    
    public Memory(String name, Player p1, Player p2) {
        super(name, p1, p2);
    }

    @Override
    public MemoryBoard getBoard(){
        return board;
    }

    public int getBoardHeight(){
        return board.getHeight();
    }

    public int getBoardWidth(){
        return board.getWidth();
    }

    public void setUpBoard(){
        firstCoordination = null;
        secondCoordination = null;
        board.clearBoard();
        board.setBoard();
    }

    //TODO: JUST FOR GUI DEVELOPMENT, MOVE THE SIZE, 90, TO THE CORRESPONDING FILE AND UPDATE THIS FUNCTION'S BODY LATER ON
    public int getTileSize(){
        return 90;
    }

    //TODO: JUST FOR GUI DEVELOPMENT, CALL THE CORRESPONDING FUNCTION IN SOME FILE AND UPDATE THE BODY OF THIS FUNCTION
    public String getQuestionImage(){
        return "/img/question.png";
    }

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
            if(!checkMatch(firstCoordination, secondCoordination)){
                returnVal = new int[]{
                        firstCoordination.getKey()*getBoardWidth() + firstCoordination.getValue(),
                        secondCoordination.getKey()*getBoardWidth() + secondCoordination.getValue()};
            }
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
