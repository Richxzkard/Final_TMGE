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
        Rectangle a = piece.pieceFirst;
        Rectangle b = piece.pieceSecond;
        Rectangle c = piece.pieceThird;
        Rectangle d = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(a, 2, 2) && board.roomToTurn(b, 1, 1) && board.roomToTurn(d, -1, -1)) {
            board.rectMoveUp(a);
            board.rectMoveUp(a);
            board.rectMoveRight(a);
            board.rectMoveRight(a);
            board.rectMoveUp(b);
            board.rectMoveRight(b);
            board.rectMoveDown(d);
            board.rectMoveLeft(d);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(a, -2, -2) && board.roomToTurn(b, -1, -1) && board.roomToTurn(d, 1, 1)) {
            board.rectMoveDown(a);
            board.rectMoveDown(a);
            board.rectMoveLeft(a);
            board.rectMoveLeft(a);
            board.rectMoveDown(b);
            board.rectMoveLeft(b);
            board.rectMoveUp(d);
            board.rectMoveRight(d);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(a, 2, 2) && board.roomToTurn(b, 1, 1) && board.roomToTurn(d, -1, -1)) {
            board.rectMoveUp(a);
            board.rectMoveUp(a);
            board.rectMoveRight(a);
            board.rectMoveRight(a);
            board.rectMoveUp(b);
            board.rectMoveRight(b);
            board.rectMoveDown(d);
            board.rectMoveLeft(d);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(a, -2, -2) && board.roomToTurn(b, -1, -1) && board.roomToTurn(d, 1, 1)) {
            board.rectMoveDown(a);
            board.rectMoveDown(a);
            board.rectMoveLeft(a);
            board.rectMoveLeft(a);
            board.rectMoveDown(b);
            board.rectMoveLeft(b);
            board.rectMoveUp(d);
            board.rectMoveRight(d);
            piece.UpdateState();
        }
    }
}
