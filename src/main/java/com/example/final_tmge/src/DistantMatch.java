package com.example.final_tmge.src;

import java.util.List;
import java.util.ArrayList;

class DistantMatch implements iMatch {
    public List<List<Coordinates>> findMatches(GamePiece[][] board) {
        int height = board.length;
        int width = board[0].length;
        List<List<Coordinates>> matchesList = new ArrayList<List<Coordinates>>();
        boolean[][] tileVisits = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tileVisits[i][j] = false;
            }
        }
        for (int i1 = 0; i1 < height; i1++) {
            for (int j1 = 0; j1 < width; j1++) {
                if (!tileVisits[i1][j1]) {
                    tileVisits[i1][j1] = true;
                    List<Coordinates> matchSet = new ArrayList<Coordinates>();
                    matchSet.add(new Coordinates(i1,j1));
                    boolean matchFound = false;
                    for (int i2 = i1; i2 < height && !matchFound; i2++) {
                        for (int j2 = 0; j2 < width && !matchFound; j2++) {
                            if (!tileVisits[i2][j2] && board[i1][j1].equals(board[i2][j2])) {
                                tileVisits[i2][j2] = true;
                                matchSet.add(new Coordinates(i2,j2));
                                matchesList.add(matchSet);
                                matchFound = true;
                            }
                        }
                    }
                }
            }
        }
        return matchesList;
    }
}