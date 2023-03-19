package com.example.final_tmge.src.Tetris;

import java.util.Random;

import com.example.final_tmge.src.GamePiece;
import com.example.final_tmge.src.TileGenerator;
import javafx.scene.shape.Rectangle;

public class TetrisPieceGenerator implements TileGenerator {
    private int blockSize;
    private int xMax;
    public void Initialize(int blockSize, int xBlocks){
        this.blockSize = blockSize;
        this.xMax = blockSize * xBlocks;
    }
    @Override
    public GamePiece generateTile() {
        Random rand = new Random();
        int randNum = rand.nextInt(TetrisPiece.NAME.values().length);
        return genTetrisPieceByName(TetrisPiece.NAME.values()[randNum]);
    }

    private TetrisPiece genTetrisPieceByName(TetrisPiece.NAME name) {
        Rectangle a = new Rectangle(blockSize - 1, blockSize - 1);
        Rectangle b = new Rectangle(blockSize - 1, blockSize - 1);
        Rectangle c = new Rectangle(blockSize - 1, blockSize - 1);
        Rectangle d = new Rectangle(blockSize - 1, blockSize - 1);
        if (name == TetrisPiece.NAME.I) {
            a.setX(xMax / 2 - 2 * blockSize);
            b.setX(xMax / 2 - blockSize);
            c.setX(xMax / 2);
            d.setX(xMax / 2 + blockSize);
        } else if (name == TetrisPiece.NAME.J) {
            a.setX(xMax / 2 - blockSize);
            b.setX(xMax / 2 - blockSize);
            b.setY(blockSize);
            c.setX(xMax / 2);
            c.setY(blockSize);
            d.setX(xMax / 2 + blockSize);
            d.setY(blockSize);
        } else if (name == TetrisPiece.NAME.L) {
            a.setX(xMax / 2 + blockSize);
            b.setX(xMax / 2 - blockSize);
            b.setY(blockSize);
            c.setX(xMax / 2);
            c.setY(blockSize);
            d.setX(xMax / 2 + blockSize);
            d.setY(blockSize);
        } else if (name == TetrisPiece.NAME.O) {
            a.setX(xMax / 2 - blockSize);
            b.setX(xMax / 2);
            c.setX(xMax / 2 - blockSize);
            c.setY(blockSize);
            d.setX(xMax / 2);
            d.setY(blockSize);
        } else if (name == TetrisPiece.NAME.S) {
            a.setX(xMax / 2 + blockSize);
            b.setX(xMax / 2);
            c.setX(xMax / 2);
            c.setY(blockSize);
            d.setX(xMax / 2 - blockSize);
            d.setY(blockSize);
        } else if (name == TetrisPiece.NAME.T) {
            a.setX(xMax / 2 - blockSize);
            b.setX(xMax / 2);
            c.setX(xMax / 2);
            c.setY(blockSize);
            d.setX(xMax / 2 + blockSize);
        } else if (name == TetrisPiece.NAME.Z) {
            a.setX(xMax / 2 + blockSize);
            b.setX(xMax / 2);
            c.setX(xMax / 2 + blockSize);
            c.setY(blockSize);
            d.setX(xMax / 2 + 2 * blockSize);
            d.setY(blockSize);
        } else {
            throw new IllegalArgumentException("Invalid Tetris piece ID: " + name.toString());
        }
        return new TetrisPiece(name.toString(), a, b, c, d);
    }
}
