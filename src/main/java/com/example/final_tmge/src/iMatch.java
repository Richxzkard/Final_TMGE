package com.example.final_tmge.src;

import java.util.List;

public interface iMatch {
    // Takes a game board (a 2D array of GamePiece class objects)
    // as a parameter and returns a List of all respective matches,
    // with each match being in the form of a List of Coordinates
    public List<List<Coordinates>> findMatches(GamePiece[][] board);
}
