package com.example.final_tmge.src;

import java.util.List;
import java.util.ArrayList;

class HorizontalMatch implements iMatch {
    public List<List<Coordinates>> findMatches(GamePiece[][] board) {
        int height = board.length;
        int width = board[0].length;
        List<List<Coordinates>> matchesList = new ArrayList<List<Coordinates>>();
        for (int i = 0; i < height; i++) {
            List<Coordinates> matchSet = new ArrayList<Coordinates>();
            for (int j = 0; j < width-1; j++) {
                matchSet.add(new Coordinates(i,j));
                if (!board[i][j].equals(board[i][j+1])) {
                    if (matchSet.size() >= 3) {
                        matchesList.add(matchSet);
                    }
                    matchSet = new ArrayList<Coordinates>();
                }
                if (j+1 == width-1) {
                    matchSet.add(new Coordinates(i,j+1));
                    if (matchSet.size() >= 3) {
                        matchesList.add(matchSet);
                    }
                }
            }
        }
        return matchesList;
    }
}