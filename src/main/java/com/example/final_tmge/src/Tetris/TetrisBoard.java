package com.example.final_tmge.src.Tetris;

import com.example.final_tmge.src.Board;
import com.example.final_tmge.src.Tetris.RotationStrategy.*;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TetrisBoard extends Board {
    private static final int BLOCK_SIZE = 25;

    private int x_block;
    private int y_block;

    private final int xBlocks;
    private final int yBlocks;

    private Pane pane;

    public boolean[][] boardinfo;

    private int removedRows = 0;

    public TetrisBoard(int width, int height) {
        super(height, width);
        xBlocks = width;
        yBlocks = height;
        x_block = BLOCK_SIZE * xBlocks;
        y_block = BLOCK_SIZE * yBlocks;
        boardinfo = new boolean[xBlocks][yBlocks];
    }

    public boolean roomToFall(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE);
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE) + 1;
            if (yBlock >= yBlocks || boardinfo[xBlock][yBlock]) {
                return false;
            }
        }
        return true;
    }

    private boolean roomToRight(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE) + 1;
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE);
            if (xBlock >= xBlocks || boardinfo[xBlock][yBlock]) {
                return false;
            }
        }
        return true;
    }

    private boolean roomToLeft(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE) - 1;
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE);
            if (xBlock < 0 || boardinfo[xBlock][yBlock]) {
                return false;
            }
        }
        return true;
    }

    public boolean roomToTurn(Rectangle rect, int x, int y) {
        boolean xHasRoom;
        boolean yHasRoom;
        if (x >= 0) {
            xHasRoom = rect.getX() + x * BLOCK_SIZE <= x_block - BLOCK_SIZE;
        } else {
            xHasRoom = rect.getX() + x * BLOCK_SIZE >= 0;
        }
        if (y >= 0) {
            yHasRoom = rect.getY() - y * BLOCK_SIZE > 0;
        } else {
            yHasRoom = rect.getY() + y * BLOCK_SIZE < y_block;
        }
        return xHasRoom && yHasRoom && !boardinfo[((int) (rect.getX()) / BLOCK_SIZE) + x][((int) (rect.getY() - 0) / BLOCK_SIZE) - y];
    }

    public boolean down(TetrisPiece piece) {
        if (roomToFall(piece)) {
            piece.moveDown(BLOCK_SIZE);
            return true;
        }
        placePiece(piece);
        removeRows();
        return false;
    }

    public void right(TetrisPiece piece) {
        if (roomToRight(piece)) {
            piece.moveRight(BLOCK_SIZE);
        }
    }

    public void left(TetrisPiece piece) {
        if (roomToLeft(piece)) {
            piece.moveLeft(BLOCK_SIZE);
        }
    }

    public void pieceReverse(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle a = piece.pieceFirst;
        Rectangle b = piece.pieceSecond;
        Rectangle c = piece.pieceThird;
        Rectangle d = piece.pieceFourth;

        switch (TetrisPiece.NAME.valueOf(piece.getId())) {
            case I:
                PieceRotationStrategy istrategy = new IPieceRotationStrategy(this);
                istrategy.rotatePiece(piece);
                break;
            case J:
                PieceRotationStrategy jstrategy = new JPieceRotationStrategy(this);
                jstrategy.rotatePiece(piece);
                break;
            case L:
                PieceRotationStrategy lstrategy = new LPieceRotationStrategy(this);
                lstrategy.rotatePiece(piece);
                break;
            case O:
                break;
            case S:
                PieceRotationStrategy sstrategy = new SPieceRotationStrategy(this);
                sstrategy.rotatePiece(piece);
                break;
            case T:
                PieceRotationStrategy tstrategy = new TPieceRotationStrategy(this);
                tstrategy.rotatePiece(piece);
                break;
            case Z:
                PieceRotationStrategy zstrategy = new ZPieceRotationStrategy(this);
                zstrategy.rotatePiece(piece);
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
        Text over = new Text("Game Over");
        over.setFill(Color.BLACK);
        over.setStyle("-fx-font: 20 arial;");
        over.setY(3 * y_block / 4);
        over.setX(100);
        pane.getChildren().add(over);
    }

    public int GetBlockSize() {
        return BLOCK_SIZE;
    }
    private void placePiece(TetrisPiece piece) {
        for (Rectangle part : piece.getAllParts()) {
            int xBlock = (int) ((part.getX()) / BLOCK_SIZE);
            int yBlock = (int) ((part.getY()) / BLOCK_SIZE);
            boardinfo[xBlock][yBlock] = true;
        }
    }

    private void removeRows() {
        ArrayList<Integer> fullRows = new ArrayList<>();
        for (int y = 0; y < boardinfo[0].length; y++) {
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
        for (int x = 0; x < boardinfo.length; x++) {
            if (!boardinfo[x][y]) {
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
            boardinfo[xBlock][yBlock] = true;
        }
    }

    public void clearMesh() {
        for (int i = 0; i < boardinfo.length; i++) {
            for (int j = 0; j < boardinfo[0].length; j++) {
                boardinfo[i][j] = false;
            }
        }
    }

    public void rectMoveRight(Rectangle rect) {
        rect.setX(rect.getX() + BLOCK_SIZE);
    }

    public void rectMoveLeft(Rectangle rect) {
        rect.setX(rect.getX() - BLOCK_SIZE);
    }

    public void rectMoveUp(Rectangle rect) {
        rect.setY(rect.getY() - BLOCK_SIZE);
    }

    public void rectMoveDown(Rectangle rect) {
        rect.setY(rect.getY() + BLOCK_SIZE);
    }
}
