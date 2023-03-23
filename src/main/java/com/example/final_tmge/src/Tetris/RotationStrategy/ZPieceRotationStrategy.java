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
        Rectangle a = piece.pieceFirst;
        Rectangle b = piece.pieceSecond;
        Rectangle c = piece.pieceThird;
        Rectangle d = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(b, 1, 1) && board.roomToTurn(c, -1, 1) && board.roomToTurn(d, -2, 0)) {
            board.rectMoveUp(b);
            board.rectMoveRight(b);
            board.rectMoveLeft(c);
            board.rectMoveUp(c);
            board.rectMoveLeft(d);
            board.rectMoveLeft(d);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(b, -1, -1) && board.roomToTurn(c, 1, -1) && board.roomToTurn(d, 2, 0)) {
            board.rectMoveDown(b);
            board.rectMoveLeft(b);
            board.rectMoveRight(c);
            board.rectMoveDown(c);
            board.rectMoveRight(d);
            board.rectMoveRight(d);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(b, 1, 1) && board.roomToTurn(c, -1, 1) && board.roomToTurn(d, -2, 0)) {
            board.rectMoveUp(b);
            board.rectMoveRight(b);
            board.rectMoveLeft(c);
            board.rectMoveUp(c);
            board.rectMoveLeft(d);
            board.rectMoveLeft(d);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(b, -1, -1) && board.roomToTurn(c, 1, -1) && board.roomToTurn(d, 2, 0)) {
            board.rectMoveDown(b);
            board.rectMoveLeft(b);
            board.rectMoveRight(c);
            board.rectMoveDown(c);
            board.rectMoveRight(d);
            board.rectMoveRight(d);
            piece.UpdateState();
        }

    }
}
