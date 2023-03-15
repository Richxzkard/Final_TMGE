package com.example.final_tmge.src;

public class MemoryPiece extends GamePiece {

    private boolean isUp; //if this piece has been guessed

    public MemoryPiece(){
        super("question");
        isUp = false;
    }

    public MemoryPiece(String id){
        super(id);
        isUp = false;
    }

    @Override
    public void disappear(){
        id = "question";
    }

    public boolean isUp(){
        return isUp;
    }
    public void toggleIsUp(){
        isUp = !isUp;
    }
    public void clearedPiece(){
        id = "cleared";
    }
}
