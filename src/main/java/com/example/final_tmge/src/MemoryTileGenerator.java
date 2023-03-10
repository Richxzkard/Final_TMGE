package com.example.final_tmge.src;

public class MemoryTileGenerator implements TileGenerator {

    String possiblePieces[];
    public MemoryTileGenerator(){
        possiblePieces  = new String[]{"blue_gem", "green_gem", "orange_gem", "purple_gem", "red_gem", "white_gem", "yellow_gem"};
    }

    @Override
    public GamePiece generateTile() {
        throw new UnsupportedOperationException("Unimplemented method 'generateTile'");
    }
    
}
