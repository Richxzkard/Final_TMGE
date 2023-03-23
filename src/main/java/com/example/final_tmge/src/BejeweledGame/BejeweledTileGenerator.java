package com.example.final_tmge.src.BejeweledGame;
import com.example.final_tmge.src.BejeweledGame.Bejeweled.*;
import com.example.final_tmge.src.GamePiece;
import com.example.final_tmge.src.TileGenerator;
import java.util.Random;

public class BejeweledTileGenerator implements TileGenerator {

    Random randomGenerator;
    Gem heart;
    Gem jewel;
    Gem question;
    Gem spade;
    Gem star;
    Gem teddy;
    Gem[] gems;

    BejeweledTileGenerator(){

        randomGenerator = new Random();

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
        return gems[randomGenerator.nextInt(gems.length)];
    }
}
