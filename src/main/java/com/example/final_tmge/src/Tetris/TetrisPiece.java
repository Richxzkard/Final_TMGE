package com.example.final_tmge.src.Tetris;

import com.example.final_tmge.src.GamePiece;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TetrisPiece extends GamePiece {
    public enum NAME {
        I, J, L, O, S, T, Z
    }

    // Define the static hashmap
    private static Map<NAME, Color> colorMap = new HashMap<>();

    static {
        colorMap.put(NAME.I, Color.RED);
        colorMap.put(NAME.J, Color.ORANGE);
        colorMap.put(NAME.L, Color.YELLOW);
        colorMap.put(NAME.O, Color.GREEN);
        colorMap.put(NAME.S, Color.BLUE);
        colorMap.put(NAME.T, Color.PURPLE);
        colorMap.put(NAME.Z, Color.PINK);
    }

    public Rectangle pieceFirst;
    public Rectangle pieceSecond;
    public Rectangle pieceThird;
    public Rectangle pieceFourth;

    private int state = 1;

    public TetrisPiece(String id, Rectangle pieceFirst, Rectangle pieceSecond, Rectangle pieceThird, Rectangle pieceFourth) {
        super(id);
        this.pieceFirst = pieceFirst;
        this.pieceSecond = pieceSecond;
        this.pieceThird = pieceThird;
        this.pieceFourth = pieceFourth;
        Color color = colorMap.get(NAME.valueOf(id));
        setTetrisColor(color);
    }

    private void setTetrisColor(Color color) {
        pieceFirst.setFill(color);
        pieceSecond.setFill(color);
        pieceThird.setFill(color);
        pieceFourth.setFill(color);
    }

    public boolean isStuckAtTop() {
        return pieceFirst.getY() == 0 || pieceSecond.getY() == 0 || pieceThird.getY() == 0 || pieceFourth.getY() == 0;
    }

    public void UpdateState() {
        state = state % 4 + 1;
    }

    public int GetState() {
        return state;
    }

    public void moveDown(int dist) {
        pieceFirst.setY(pieceFirst.getY() + dist);
        pieceSecond.setY(pieceSecond.getY() + dist);
        pieceThird.setY(pieceThird.getY() + dist);
        pieceFourth.setY(pieceFourth.getY() + dist);
    }

    public void moveLeft(int dist) {
        pieceFirst.setX(pieceFirst.getX() - dist);
        pieceSecond.setX(pieceSecond.getX() - dist);
        pieceThird.setX(pieceThird.getX() - dist);
        pieceFourth.setX(pieceFourth.getX() - dist);
    }

    public void moveRight(int dist) {
        pieceFirst.setX(pieceFirst.getX() + dist);
        pieceSecond.setX(pieceSecond.getX() + dist);
        pieceThird.setX(pieceThird.getX() + dist);
        pieceFourth.setX(pieceFourth.getX() + dist);
    }

    public ArrayList<Rectangle> getAllParts(){
        return new ArrayList<Rectangle>(List.of(pieceFirst, pieceSecond, pieceThird, pieceFourth));
    }
}
