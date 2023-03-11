package com.example.final_tmge.src;

import java.util.List;
import java.util.ArrayList;

class DistantMatch implements iMatch {
    public List<List<Coordinates>> findMatches(GamePiece[][] board) {
        int height = board.length;
        int width = board[0].length;
        List<List<Coordinates>> matchesList = new ArrayList<List<Coordinates>>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                
            }
        }
        return matchesList;
    }
}