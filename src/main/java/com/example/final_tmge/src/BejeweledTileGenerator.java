package com.example.final_tmge.src;
import com.example.final_tmge.src.Bejeweled.*;
public class BejeweledTileGenerator implements TileGenerator{

    Gem heart;
    Gem jewel;
    Gem question;
    Gem spade;
    Gem star;
    Gem teddy;
    Gem[] gems;

    BejeweledTileGenerator(){
        heart = new Gem("heart");
        jewel = new Gem("jewel");
        question = new Gem("question");
        spade = new Gem("spade");
        star = new Gem("star");
        teddy = new Gem("teddy");

        gems = new Gem[]{heart, jewel, question, spade, star, teddy};

    }
    @Override
    public GamePiece generateTile(){

        return null;
    }
}
