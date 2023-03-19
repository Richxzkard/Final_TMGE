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

    public Rectangle a;
    public Rectangle b;
    public Rectangle c;
    public Rectangle d;

    private int state = 1;

    public TetrisPiece(String id, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        super(id);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        Color color = colorMap.get(NAME.valueOf(id));
        setTetrisColor(color);
    }

    private void setTetrisColor(Color color) {
        a.setFill(color);
        b.setFill(color);
        c.setFill(color);
        d.setFill(color);
    }

    public boolean isStuckAtTop() {
        return a.getY() == 0 || b.getY() == 0 || c.getY() == 0 || d.getY() == 0;
    }

    public void UpdateState() {
        state = state % 4 + 1;
    }

    public int GetState() {
        return state;
    }

    public void moveDown(int dist) {
        a.setY(a.getY() + dist);
        b.setY(b.getY() + dist);
        c.setY(c.getY() + dist);
        d.setY(d.getY() + dist);
    }

    public void moveLeft(int dist) {
        a.setX(a.getX() - dist);
        b.setX(b.getX() - dist);
        c.setX(c.getX() - dist);
        d.setX(d.getX() - dist);
    }

    public void moveRight(int dist) {
        a.setX(a.getX() + dist);
        b.setX(b.getX() + dist);
        c.setX(c.getX() + dist);
        d.setX(d.getX() + dist);
    }

    public ArrayList<Rectangle> getAllParts(){
        return new ArrayList<Rectangle>(List.of(a, b, c, d));
    }
}
