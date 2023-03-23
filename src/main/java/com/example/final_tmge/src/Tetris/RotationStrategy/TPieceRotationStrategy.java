package com.example.final_tmge.src.Tetris.RotationStrategy;

import com.example.final_tmge.src.Tetris.TetrisBoard;
import com.example.final_tmge.src.Tetris.TetrisPiece;
import javafx.scene.shape.Rectangle;

public class TPieceRotationStrategy implements PieceRotationStrategy{
    TetrisBoard board;

    public TPieceRotationStrategy(TetrisBoard board){
        this.board = board;
    }
    @Override
    public void rotatePiece(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle first = piece.pieceFirst;
        Rectangle second = piece.pieceSecond;
        Rectangle third = piece.pieceThird;
        Rectangle fourth = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(first, 1, 1) && board.roomToTurn(fourth, -1, -1) && board.roomToTurn(third, -1, 1)) {
            board.rectMoveUp(first);
            board.rectMoveRight(first);
            board.rectMoveDown(fourth);
            board.rectMoveLeft(fourth);
            board.rectMoveLeft(third);
            board.rectMoveUp(third);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(first, 1, -1) && board.roomToTurn(fourth, -1, 1) && board.roomToTurn(third, 1, 1)) {
            board.rectMoveRight(first);
            board.rectMoveDown(first);
            board.rectMoveLeft(fourth);
            board.rectMoveUp(fourth);
            board.rectMoveUp(third);
            board.rectMoveRight(third);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(first, -1, -1) && board.roomToTurn(fourth, 1, 1) && board.roomToTurn(third, 1, -1)) {
            board.rectMoveDown(first);
            board.rectMoveLeft(first);
            board.rectMoveUp(fourth);
            board.rectMoveRight(fourth);
            board.rectMoveRight(third);
            board.rectMoveDown(third);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(first, -1, 1) && board.roomToTurn(fourth, 1, -1) && board.roomToTurn(third, -1, -1)) {
            board.rectMoveLeft(first);
            board.rectMoveUp(first);
            board.rectMoveRight(fourth);
            board.rectMoveDown(fourth);
            board.rectMoveDown(third);
            board.rectMoveLeft(third);
            piece.UpdateState();
        }
    }
}
