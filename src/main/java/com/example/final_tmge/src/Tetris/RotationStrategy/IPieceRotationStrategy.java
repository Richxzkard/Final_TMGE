package com.example.final_tmge.src.Tetris.RotationStrategy;

import com.example.final_tmge.src.Tetris.TetrisPiece;
import javafx.scene.shape.Rectangle;
import com.example.final_tmge.src.Tetris.TetrisBoard;

public class IPieceRotationStrategy implements PieceRotationStrategy{
    TetrisBoard board;

    public IPieceRotationStrategy(TetrisBoard board){
        this.board = board;
    }

    @Override
    public void rotatePiece(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle first = piece.pieceFirst;
        Rectangle second = piece.pieceSecond;
        Rectangle third = piece.pieceThird;
        Rectangle fourth = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(first, 2, 2) && board.roomToTurn(second, 1, 1) && board.roomToTurn(fourth, -1, -1)) {
            board.rectMoveUp(first);
            board.rectMoveUp(first);
            board.rectMoveRight(first);
            board.rectMoveRight(first);
            board.rectMoveUp(second);
            board.rectMoveRight(second);
            board.rectMoveDown(fourth);
            board.rectMoveLeft(fourth);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(first, -2, -2) && board.roomToTurn(second, -1, -1) && board.roomToTurn(fourth, 1, 1)) {
            board.rectMoveDown(first);
            board.rectMoveDown(first);
            board.rectMoveLeft(first);
            board.rectMoveLeft(first);
            board.rectMoveDown(second);
            board.rectMoveLeft(second);
            board.rectMoveUp(fourth);
            board.rectMoveRight(fourth);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(first, 2, 2) && board.roomToTurn(second, 1, 1) && board.roomToTurn(fourth, -1, -1)) {
            board.rectMoveUp(first);
            board.rectMoveUp(first);
            board.rectMoveRight(first);
            board.rectMoveRight(first);
            board.rectMoveUp(second);
            board.rectMoveRight(second);
            board.rectMoveDown(fourth);
            board.rectMoveLeft(fourth);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(first, -2, -2) && board.roomToTurn(second, -1, -1) && board.roomToTurn(fourth, 1, 1)) {
            board.rectMoveDown(first);
            board.rectMoveDown(first);
            board.rectMoveLeft(first);
            board.rectMoveLeft(first);
            board.rectMoveDown(second);
            board.rectMoveLeft(second);
            board.rectMoveUp(fourth);
            board.rectMoveRight(fourth);
            piece.UpdateState();
        }
    }
}
