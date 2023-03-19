package com.example.final_tmge.src.Tetris;

import javafx.scene.input.KeyCode;
import com.example.final_tmge.src.Board;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TetrisBoard extends Board {
    private static final int BLOCK_SIZE = 25;

    private int xMax;
    private int yMax;

    private final int xBlocks;
    private final int yBlocks;

    private Pane pane;

    public boolean[][] mesh;

    private int removedRows = 0;

    public TetrisBoard(int width, int height) {
        super(height, width);
        xBlocks = width;
        yBlocks = height;
        xMax = BLOCK_SIZE * xBlocks;
        yMax = BLOCK_SIZE * yBlocks;
        mesh = new boolean[xBlocks][yBlocks];
    }

    public boolean roomToFall(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE);
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE) + 1;
            if (yBlock >= yBlocks || mesh[xBlock][yBlock]) {
                return false;
            }
        }
        return true;
    }

    private boolean roomToRight(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE) + 1;
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE);
            if (xBlock >= xBlocks || mesh[xBlock][yBlock]) {
                return false;
            }
        }
        return true;
    }

    private boolean roomToLeft(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE) - 1;
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE);
            if (xBlock < 0 || mesh[xBlock][yBlock]) {
                return false;
            }
        }
        return true;
    }

    public boolean roomToTurn(Rectangle rect, int x, int y) {
        boolean xHasRoom;
        boolean yHasRoom;
        if (x >= 0) {
            xHasRoom = rect.getX() + x * BLOCK_SIZE <= xMax - BLOCK_SIZE;
        } else {
            xHasRoom = rect.getX() + x * BLOCK_SIZE >= 0;
        }
        if (y >= 0) {
            yHasRoom = rect.getY() - y * BLOCK_SIZE > 0;
        } else {
            yHasRoom = rect.getY() + y * BLOCK_SIZE < yMax;
        }
        return xHasRoom && yHasRoom && !mesh[((int) (rect.getX()) / BLOCK_SIZE) + x][((int) (rect.getY() - 0) / BLOCK_SIZE) - y];
    }

    public boolean MoveDown(TetrisPiece piece) {
        if (roomToFall(piece)) {
            piece.moveDown(BLOCK_SIZE);
            return true;
        }
        placePiece(piece);
        removeRows();
        return false;
    }

    public void MoveRight(TetrisPiece piece) {
        if (roomToRight(piece)) {
            piece.moveRight(BLOCK_SIZE);
        }
    }

    public void MoveLeft(TetrisPiece piece) {
        if (roomToLeft(piece)) {
            piece.moveLeft(BLOCK_SIZE);
        }
    }

    public void MoveTurn(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle a = piece.a;
        Rectangle b = piece.b;
        Rectangle c = piece.c;
        Rectangle d = piece.d;
        switch (TetrisPiece.NAME.valueOf(piece.getId())) {
            case I:
                if (state == 1 && roomToTurn(a, 2, 2) && roomToTurn(b, 1, 1) && roomToTurn(d, -1, -1)) {
                    rectMoveUp(a);
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveRight(a);
                    rectMoveUp(b);
                    rectMoveRight(b);
                    rectMoveDown(d);
                    rectMoveLeft(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 2 && roomToTurn(a, -2, -2) && roomToTurn(b, -1, -1) && roomToTurn(d, 1, 1)) {
                    rectMoveDown(a);
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveLeft(a);
                    rectMoveDown(b);
                    rectMoveLeft(b);
                    rectMoveUp(d);
                    rectMoveRight(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 3 && roomToTurn(a, 2, 2) && roomToTurn(b, 1, 1) && roomToTurn(d, -1, -1)) {
                    rectMoveUp(a);
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveRight(a);
                    rectMoveUp(b);
                    rectMoveRight(b);
                    rectMoveDown(d);
                    rectMoveLeft(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 4 && roomToTurn(a, -2, -2) && roomToTurn(b, -1, -1) && roomToTurn(d, 1, 1)) {
                    rectMoveDown(a);
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveLeft(a);
                    rectMoveDown(b);
                    rectMoveLeft(b);
                    rectMoveUp(d);
                    rectMoveRight(d);
                    piece.UpdateState();
                    break;
                }
                break;
            case J:
                if (state == 1 && roomToTurn(a, 1, -1) && roomToTurn(c, -1, -1) && roomToTurn(d, -2, -2)) {
                    rectMoveRight(a);
                    rectMoveDown(a);
                    rectMoveDown(c);
                    rectMoveLeft(c);
                    rectMoveDown(d);
                    rectMoveDown(d);
                    rectMoveLeft(d);
                    rectMoveLeft(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 2 && roomToTurn(a, -1, -1) && roomToTurn(c, -1, 1) && roomToTurn(d, -2, 2)) {
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    rectMoveLeft(d);
                    rectMoveLeft(d);
                    rectMoveUp(d);
                    rectMoveUp(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 3 && roomToTurn(a, -1, 1) && roomToTurn(c, 1, 1) && roomToTurn(d, 2, 2)) {
                    rectMoveLeft(a);
                    rectMoveUp(a);
                    rectMoveUp(c);
                    rectMoveRight(c);
                    rectMoveUp(d);
                    rectMoveUp(d);
                    rectMoveRight(d);
                    rectMoveRight(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 4 && roomToTurn(a, 1, 1) && roomToTurn(c, 1, -1) && roomToTurn(d, 2, -2)) {
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    rectMoveRight(d);
                    rectMoveRight(d);
                    rectMoveDown(d);
                    rectMoveDown(d);
                    piece.UpdateState();
                    break;
                }
                break;
            case L:
                if (state == 1 && roomToTurn(a, 1, -1) && roomToTurn(c, 1, 1) && roomToTurn(b, 2, 2)) {
                    rectMoveRight(a);
                    rectMoveDown(a);
                    rectMoveUp(c);
                    rectMoveRight(c);
                    rectMoveUp(b);
                    rectMoveUp(b);
                    rectMoveRight(b);
                    rectMoveRight(b);
                    piece.UpdateState();
                    break;
                }
                if (state == 2 && roomToTurn(a, -1, -1) && roomToTurn(b, 2, -2) && roomToTurn(c, 1, -1)) {
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveRight(b);
                    rectMoveRight(b);
                    rectMoveDown(b);
                    rectMoveDown(b);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    piece.UpdateState();
                    break;
                }
                if (state == 3 && roomToTurn(a, -1, 1) && roomToTurn(c, -1, -1) && roomToTurn(b, -2, -2)) {
                    rectMoveLeft(a);
                    rectMoveUp(a);
                    rectMoveDown(c);
                    rectMoveLeft(c);
                    rectMoveDown(b);
                    rectMoveDown(b);
                    rectMoveLeft(b);
                    rectMoveLeft(b);
                    piece.UpdateState();
                    break;
                }
                if (state == 4 && roomToTurn(a, 1, 1) && roomToTurn(b, -2, 2) && roomToTurn(c, -1, 1)) {
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveLeft(b);
                    rectMoveLeft(b);
                    rectMoveUp(b);
                    rectMoveUp(b);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    piece.UpdateState();
                    break;
                }
                break;
            case O:
                break;
            case S:
                if (state == 1 && roomToTurn(a, -1, -1) && roomToTurn(c, -1, 1) && roomToTurn(d, 0, 2)) {
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    rectMoveUp(d);
                    rectMoveUp(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 2 && roomToTurn(a, 1, 1) && roomToTurn(c, 1, -1) && roomToTurn(d, 0, -2)) {
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    rectMoveDown(d);
                    rectMoveDown(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 3 && roomToTurn(a, -1, -1) && roomToTurn(c, -1, 1) && roomToTurn(d, 0, 2)) {
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    rectMoveUp(d);
                    rectMoveUp(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 4 && roomToTurn(a, 1, 1) && roomToTurn(c, 1, -1) && roomToTurn(d, 0, -2)) {
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    rectMoveDown(d);
                    rectMoveDown(d);
                    piece.UpdateState();
                    break;
                }
                break;
            case T:
                if (state == 1 && roomToTurn(a, 1, 1) && roomToTurn(d, -1, -1) && roomToTurn(c, -1, 1)) {
                    rectMoveUp(a);
                    rectMoveRight(a);
                    rectMoveDown(d);
                    rectMoveLeft(d);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    piece.UpdateState();
                    break;
                }
                if (state == 2 && roomToTurn(a, 1, -1) && roomToTurn(d, -1, 1) && roomToTurn(c, 1, 1)) {
                    rectMoveRight(a);
                    rectMoveDown(a);
                    rectMoveLeft(d);
                    rectMoveUp(d);
                    rectMoveUp(c);
                    rectMoveRight(c);
                    piece.UpdateState();
                    break;
                }
                if (state == 3 && roomToTurn(a, -1, -1) && roomToTurn(d, 1, 1) && roomToTurn(c, 1, -1)) {
                    rectMoveDown(a);
                    rectMoveLeft(a);
                    rectMoveUp(d);
                    rectMoveRight(d);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    piece.UpdateState();
                    break;
                }
                if (state == 4 && roomToTurn(a, -1, 1) && roomToTurn(d, 1, -1) && roomToTurn(c, -1, -1)) {
                    rectMoveLeft(a);
                    rectMoveUp(a);
                    rectMoveRight(d);
                    rectMoveDown(d);
                    rectMoveDown(c);
                    rectMoveLeft(c);
                    piece.UpdateState();
                    break;
                }
                break;
            case Z:
                if (state == 1 && roomToTurn(b, 1, 1) && roomToTurn(c, -1, 1) && roomToTurn(d, -2, 0)) {
                    rectMoveUp(b);
                    rectMoveRight(b);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    rectMoveLeft(d);
                    rectMoveLeft(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 2 && roomToTurn(b, -1, -1) && roomToTurn(c, 1, -1) && roomToTurn(d, 2, 0)) {
                    rectMoveDown(b);
                    rectMoveLeft(b);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    rectMoveRight(d);
                    rectMoveRight(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 3 && roomToTurn(b, 1, 1) && roomToTurn(c, -1, 1) && roomToTurn(d, -2, 0)) {
                    rectMoveUp(b);
                    rectMoveRight(b);
                    rectMoveLeft(c);
                    rectMoveUp(c);
                    rectMoveLeft(d);
                    rectMoveLeft(d);
                    piece.UpdateState();
                    break;
                }
                if (state == 4 && roomToTurn(b, -1, -1) && roomToTurn(c, 1, -1) && roomToTurn(d, 2, 0)) {
                    rectMoveDown(b);
                    rectMoveLeft(b);
                    rectMoveRight(c);
                    rectMoveDown(c);
                    rectMoveRight(d);
                    rectMoveRight(d);
                    piece.UpdateState();
                    break;
                }
                break;
        }
    }

    public int GetRemovedRows() {
        return removedRows;
    }

    public void BindPane(Pane pane) {
        this.pane = pane;
    }

    public void GameOver() {
        Text over = new Text("GAME OVER");
        over.setFill(Color.RED);
        over.setStyle("-fx-font: 40 arial;");
        over.setY(yMax / 2);
        over.setX(20);
        pane.getChildren().add(over);
    }

    public int GetBlockSize() {
        return BLOCK_SIZE;
    }
    private void placePiece(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE);
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE);
            mesh[xBlock][yBlock] = true;
        }
    }

    private void removeRows() {
        ArrayList<Integer> fullRows = new ArrayList<>();
        for (int y = 0; y < mesh[0].length; y++) {
            if (rowIsFullAtY(y)) {
                fullRows.add(y);
                removedRows++;
            }
        }
        while (fullRows.size() > 0) {
            int targetRow = fullRows.get(0);
            fullRows.remove(0);
            removeRowFromPane(pane, targetRow);
            removedRows++;
        }
    }

    private boolean rowIsFullAtY(int y) {
        for (int x = 0; x < mesh.length; x++) {
            if (!mesh[x][y]) {
                return false;
            }
        }
        return true;
    }

    private void removeRowFromPane(Pane pane, int targetRow) {
        ArrayList<Node> allRectNodes = new ArrayList<>();
        for (Node node : pane.getChildren()) {
            if (!(node instanceof Rectangle)) {
                continue;
            }
            allRectNodes.add(node);
        }

        ArrayList<Node> leftRectNodes = new ArrayList<>();
        for (Node node : allRectNodes) {
            Rectangle r = (Rectangle) node;
            if (r.getY() == targetRow * BLOCK_SIZE) {
                pane.getChildren().remove(node);
            } else {
                leftRectNodes.add(node);
            }
        }

        for (Node node : leftRectNodes) {
            Rectangle r = (Rectangle) node;
            if (r.getY() < targetRow * BLOCK_SIZE) {
                r.setY(r.getY() + BLOCK_SIZE);
            }
        }

        clearMesh();

        for (Node node : leftRectNodes) {
            Rectangle r = (Rectangle) node;
            int xBlock = (int) ((r.getX()) / BLOCK_SIZE);
            int yBlock = (int) ((r.getY()) / BLOCK_SIZE);
            mesh[xBlock][yBlock] = true;
        }
    }

    private void clearMesh() {
        for (int i = 0; i < mesh.length; i++) {
            for (int j = 0; j < mesh[0].length; j++) {
                mesh[i][j] = false;
            }
        }
    }

    private void rectMoveRight(Rectangle rect) {
        rect.setX(rect.getX() + BLOCK_SIZE);
    }

    private void rectMoveLeft(Rectangle rect) {
        rect.setX(rect.getX() - BLOCK_SIZE);
    }

    private void rectMoveUp(Rectangle rect) {
        rect.setY(rect.getY() - BLOCK_SIZE);
    }

    private void rectMoveDown(Rectangle rect) {
        rect.setY(rect.getY() + BLOCK_SIZE);
    }
}
