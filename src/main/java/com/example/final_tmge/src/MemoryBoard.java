package com.example.final_tmge.src;

import java.util.Random;

public class MemoryBoard extends Board {

    MemoryTileGenerator mtg;
    Random randomGenerator = new Random();
    public MemoryBoard(int height, int width) {
        super(height, width);
        mtg = new MemoryTileGenerator();
    }

    @Override
    public void setBoard(){
        while(!isBoardFull()){
            //Randomly generate a memory piece
            MemoryPiece mp1 = (MemoryPiece) mtg.generateTile();
            int[] mp1_coord = RowColumnGenerator(getHeight(), getWidth());
            setGamePiece(mp1, mp1_coord[0], mp1_coord[1]);
            //make a copy of the tile (for match)
            MemoryPiece mp2 = mtg.copyTile(mp1);
            int[] mp2_coord = RowColumnGenerator(getHeight(), getWidth());
            setGamePiece(mp2, mp2_coord[0], mp2_coord[1]);
        }
    }

    //Randomly generate a coordination for a new game piece
    public int[] RowColumnGenerator(int rowMax, int columnMax){
        int randomRow = randomGenerator.nextInt(rowMax);
        int randomColumn = randomGenerator.nextInt(columnMax);
        while(getGamePiece(randomRow, randomColumn) != null){
            randomRow = randomGenerator.nextInt(rowMax);
            randomColumn = randomGenerator.nextInt(columnMax);
        }
        return new int[]{randomRow, randomColumn};
    }
}
