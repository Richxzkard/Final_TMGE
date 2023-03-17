package com.example.final_tmge.src.Tetris;

import com.example.final_tmge.src.Board;
import com.example.final_tmge.src.GamePiece;

public class TetrisBoard extends Board {

    GamePiece[][] board;

    public TetrisBoard(int height, int width) {
        super(height, width);
        board = new GamePiece[height][width];
    }

    public GamePiece[][] getBoardPieces(){
        return board;
    }


}
