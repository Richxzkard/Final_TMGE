package com.example.final_tmge.src.Tetris.RotationStrategy;

import com.example.final_tmge.src.Tetris.TetrisBoard;
import com.example.final_tmge.src.Tetris.TetrisPiece;
import javafx.scene.shape.Rectangle;

public class LPieceRotationStrategy implements PieceRotationStrategy{

    TetrisBoard board;

    public LPieceRotationStrategy(TetrisBoard board){
        this.board = board;
    }

    @Override
    public void rotatePiece(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle first = piece.pieceFirst;
        Rectangle second = piece.pieceSecond;
        Rectangle third = piece.pieceThird;
        Rectangle fourth = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(first, 1, -1) && board.roomToTurn(third, 1, 1) && board.roomToTurn(second, 2, 2)) {
            board.rectMoveRight(first);
            board.rectMoveDown(first);
            board.rectMoveUp(third);
            board.rectMoveRight(third);
            board.rectMoveUp(second);
            board.rectMoveUp(second);
            board.rectMoveRight(second);
            board.rectMoveRight(second);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(first, -1, -1) && board.roomToTurn(second, 2, -2) && board.roomToTurn(third, 1, -1)) {
            board.rectMoveDown(first);
            board.rectMoveLeft(first);
            board.rectMoveRight(second);
            board.rectMoveRight(second);
            board.rectMoveDown(second);
            board.rectMoveDown(second);
            board.rectMoveRight(third);
            board.rectMoveDown(third);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(first, -1, 1) && board.roomToTurn(third, -1, -1) && board.roomToTurn(second, -2, -2)) {
            board.rectMoveLeft(first);
            board.rectMoveUp(first);
            board.rectMoveDown(third);
            board.rectMoveLeft(third);
            board.rectMoveDown(second);
            board.rectMoveDown(second);
            board.rectMoveLeft(second);
            board.rectMoveLeft(second);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(first, 1, 1) && board.roomToTurn(second, -2, 2) && board.roomToTurn(third, -1, 1)) {
            board.rectMoveUp(first);
            board.rectMoveRight(first);
            board.rectMoveLeft(second);
            board.rectMoveLeft(second);
            board.rectMoveUp(second);
            board.rectMoveUp(second);
            board.rectMoveLeft(third);
            board.rectMoveUp(third);
            piece.UpdateState();
        }
    }
}
