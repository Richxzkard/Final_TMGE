package com.example.final_tmge.src;

public abstract class Board {
    private int height;
    private int width;
    protected GamePiece[][] matrix;

    public Board(int height, int width){
        this.height = height;
        this.width = width;
        this.matrix = new GamePiece[this.height][this.width];
    }

    public GamePiece getGamePiece(int height, int width){
        return matrix[height][width];
    }

    public void setGamePiece(GamePiece piece, int height, int width){
        matrix[height][width] = piece;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void setBoard(){
    }

    public boolean isBoardFull(){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    public void clearBoard(){
        matrix = new GamePiece[this.height][this.width];
    }
}
