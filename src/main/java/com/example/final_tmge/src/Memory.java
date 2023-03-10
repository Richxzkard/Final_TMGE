package com.example.final_tmge.src;

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

    //TODO: JUST FOR GUI DEVELOPMENT, MOVE THE SIZE, 90, TO THE CORRESPONDING FILE AND UPDATE THIS FUNCTION'S BODY LATER
    public int getTileSize(){
        return 90;
    }

    //TODO: JUST FOR GUI DEVELOPMENT, CALL THE CORRESPONDING FUNCTION IN SOME FILE AND UPDATE THE BODY OF THIS FUNCTION
    public String getQuestionImage(){
        return "/img/question.png";
    }

}
