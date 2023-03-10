package com.example.final_tmge.src;

public interface TileGenerator {
    public GamePiece generateTile();

    class Bejeweled extends TMGE {

        BejeweledBoard board = new BejeweledBoard(10, 10);
        public Bejeweled(String name, Player p1, Player p2) {
            super(name, p1, p2);
        }

    }
}
