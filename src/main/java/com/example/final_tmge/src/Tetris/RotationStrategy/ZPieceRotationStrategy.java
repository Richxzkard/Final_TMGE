package com.example.final_tmge.src.Tetris.RotationStrategy;

import com.example.final_tmge.src.Tetris.TetrisBoard;
import com.example.final_tmge.src.Tetris.TetrisPiece;
import javafx.scene.shape.Rectangle;

public class ZPieceRotationStrategy implements PieceRotationStrategy{

    TetrisBoard board;

    public ZPieceRotationStrategy(TetrisBoard board){
        this.board = board;
    }

    @Override
    public void rotatePiece(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle first = piece.pieceFirst;
        Rectangle second = piece.pieceSecond;
        Rectangle third = piece.pieceThird;
        Rectangle fourth = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(second, 1, 1) && board.roomToTurn(third, -1, 1) && board.roomToTurn(fourth, -2, 0)) {
            board.rectMoveUp(second);
            board.rectMoveRight(second);
            board.rectMoveLeft(third);
            board.rectMoveUp(third);
            board.rectMoveLeft(fourth);
            board.rectMoveLeft(fourth);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(second, -1, -1) && board.roomToTurn(third, 1, -1) && board.roomToTurn(fourth, 2, 0)) {
            board.rectMoveDown(second);
            board.rectMoveLeft(second);
            board.rectMoveRight(third);
            board.rectMoveDown(third);
            board.rectMoveRight(fourth);
            board.rectMoveRight(fourth);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(second, 1, 1) && board.roomToTurn(third, -1, 1) && board.roomToTurn(fourth, -2, 0)) {
            board.rectMoveUp(second);
            board.rectMoveRight(second);
            board.rectMoveLeft(third);
            board.rectMoveUp(third);
            board.rectMoveLeft(fourth);
            board.rectMoveLeft(fourth);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(second, -1, -1) && board.roomToTurn(third, 1, -1) && board.roomToTurn(fourth, 2, 0)) {
            board.rectMoveDown(second);
            board.rectMoveLeft(second);
            board.rectMoveRight(third);
            board.rectMoveDown(third);
            board.rectMoveRight(fourth);
            board.rectMoveRight(fourth);
            piece.UpdateState();
        }

    }
}
