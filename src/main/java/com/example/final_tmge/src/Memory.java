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
}
