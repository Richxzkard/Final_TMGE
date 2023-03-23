package com.example.final_tmge.src.Tetris.RotationStrategy;

import com.example.final_tmge.src.Tetris.TetrisBoard;
import com.example.final_tmge.src.Tetris.TetrisPiece;
import javafx.scene.shape.Rectangle;

public class SPieceRotationStrategy implements PieceRotationStrategy{
    TetrisBoard board;

    public SPieceRotationStrategy(TetrisBoard board){
        this.board = board;
    }

    @Override
    public void rotatePiece(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle first = piece.pieceFirst;
        Rectangle second = piece.pieceSecond;
        Rectangle third = piece.pieceThird;
        Rectangle fourth = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(first, -1, -1) && board.roomToTurn(third, -1, 1) && board.roomToTurn(fourth, 0, 2)) {
            board.rectMoveDown(first);
            board.rectMoveLeft(first);
            board.rectMoveLeft(third);
            board.rectMoveUp(third);
            board.rectMoveUp(fourth);
            board.rectMoveUp(fourth);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(first, 1, 1) && board.roomToTurn(third, 1, -1) && board.roomToTurn(fourth, 0, -2)) {
            board.rectMoveUp(first);
            board.rectMoveRight(first);
            board.rectMoveRight(third);
            board.rectMoveDown(third);
            board.rectMoveDown(fourth);
            board.rectMoveDown(fourth);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(first, -1, -1) && board.roomToTurn(third, -1, 1) && board.roomToTurn(fourth, 0, 2)) {
            board.rectMoveDown(first);
            board.rectMoveLeft(first);
            board.rectMoveLeft(third);
            board.rectMoveUp(third);
            board.rectMoveUp(fourth);
            board.rectMoveUp(fourth);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(first, 1, 1) && board.roomToTurn(third, 1, -1) && board.roomToTurn(fourth, 0, -2)) {
            board.rectMoveUp(first);
            board.rectMoveRight(first);
            board.rectMoveRight(third);
            board.rectMoveDown(third);
            board.rectMoveDown(fourth);
            board.rectMoveDown(fourth);
            piece.UpdateState();
        }
    }
}
