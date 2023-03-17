package com.example.final_tmge.src;

import java.util.Random;

public class MemoryTileGenerator implements TileGenerator {

    String possiblePieces[];
    Random randomGenerator = new Random();
    int TileSize = 0;
    GamePiece questionGamePiece = new MemoryPiece();
    GamePiece checkGamePiece = new MemoryPiece("cleared");

    public MemoryTileGenerator(){
        possiblePieces  = new String[]{"heart", "jewel", "spade", "star", "teddy"};
        TileSize = 90;
    }

    @Override
    public GamePiece generateTile() {
        //Get Image for this gamePiece
        int nextImageIndex = randomGenerator.nextInt(possiblePieces.length);
        String randomImage = possiblePieces[nextImageIndex];
        return new MemoryPiece(randomImage);
    }

    public MemoryPiece copyTile(MemoryPiece mp){
        return new MemoryPiece(mp.getId());
    }
}
