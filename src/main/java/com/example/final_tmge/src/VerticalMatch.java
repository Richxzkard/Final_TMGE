package com.example.final_tmge.src;

import java.util.List;
import java.util.ArrayList;

public class VerticalMatch implements iMatch {
    public List<List<Coordinates>> findMatches(GamePiece[][] board) {
        int height = board.length;
        int width = board[0].length;
        List<List<Coordinates>> matchesList = new ArrayList<List<Coordinates>>();
        for (int j = 0; j < width; j++) {
            List<Coordinates> matchSet = new ArrayList<Coordinates>();
            for (int i = 0; i < height-1; i++) {
                matchSet.add(new Coordinates(i,j));
                if (!board[i][j].equals(board[i+1][j])) {
                    if (matchSet.size() >= 3) {
                        matchesList.add(matchSet);
                    }
                    matchSet = new ArrayList<Coordinates>();
                }
                if (i+1 == height-1) {
                    matchSet.add(new Coordinates(i+1,j));
                    if (matchSet.size() >= 3) {
                        matchesList.add(matchSet);
                    }
                }
            }
        }
        return matchesList;
    }
}