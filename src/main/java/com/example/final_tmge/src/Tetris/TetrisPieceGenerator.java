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
        Rectangle first = new Rectangle(blockSize - 1, blockSize - 1);
        Rectangle second = new Rectangle(blockSize - 1, blockSize - 1);
        Rectangle third = new Rectangle(blockSize - 1, blockSize - 1);
        Rectangle fourth = new Rectangle(blockSize - 1, blockSize - 1);
        if (name == TetrisPiece.NAME.I) {
            first.setX(xMax / 2 - 2 * blockSize);
            second.setX(xMax / 2 - blockSize);
            third.setX(xMax / 2);
            fourth.setX(xMax / 2 + blockSize);
        } else if (name == TetrisPiece.NAME.J) {
            first.setX(xMax / 2 - blockSize);
            second.setX(xMax / 2 - blockSize);
            second.setY(blockSize);
            third.setX(xMax / 2);
            third.setY(blockSize);
            fourth.setX(xMax / 2 + blockSize);
            fourth.setY(blockSize);
        } else if (name == TetrisPiece.NAME.L) {
            first.setX(xMax / 2 + blockSize);
            second.setX(xMax / 2 - blockSize);
            second.setY(blockSize);
            third.setX(xMax / 2);
            third.setY(blockSize);
            fourth.setX(xMax / 2 + blockSize);
            fourth.setY(blockSize);
        } else if (name == TetrisPiece.NAME.O) {
            first.setX(xMax / 2 - blockSize);
            second.setX(xMax / 2);
            third.setX(xMax / 2 - blockSize);
            third.setY(blockSize);
            fourth.setX(xMax / 2);
            fourth.setY(blockSize);
        } else if (name == TetrisPiece.NAME.S) {
            first.setX(xMax / 2 + blockSize);
            second.setX(xMax / 2);
            third.setX(xMax / 2);
            third.setY(blockSize);
            fourth.setX(xMax / 2 - blockSize);
            fourth.setY(blockSize);
        } else if (name == TetrisPiece.NAME.T) {
            first.setX(xMax / 2 - blockSize);
            second.setX(xMax / 2);
            third.setX(xMax / 2);
            third.setY(blockSize);
            fourth.setX(xMax / 2 + blockSize);
        } else if (name == TetrisPiece.NAME.Z) {
            first.setX(xMax / 2 + blockSize);
            second.setX(xMax / 2);
            third.setX(xMax / 2 + blockSize);
            third.setY(blockSize);
            fourth.setX(xMax / 2 + 2 * blockSize);
            fourth.setY(blockSize);
        } else {
            throw new IllegalArgumentException("Invalid Tetris piece ID: " + name.toString());
        }
        return new TetrisPiece(name.toString(), first, second, third, fourth);
    }
}
