package com.example.final_tmge.src;

public abstract class Board {
    private int height;
    private int width;
    private GamePiece[][] matrix;

    public Board(int height, int width){
        this.height = height;
        this.width = width;
        this.matrix = new GamePiece[this.height][this.width];
    }

    public GamePiece getGamePiece(int height, int width){
        return matrix[height][width];
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void setBoard(){
    }

}
