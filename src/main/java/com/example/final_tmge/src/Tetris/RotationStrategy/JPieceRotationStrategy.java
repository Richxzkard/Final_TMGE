package com.example.final_tmge.src.Tetris.RotationStrategy;

import com.example.final_tmge.src.Tetris.TetrisBoard;
import com.example.final_tmge.src.Tetris.TetrisPiece;
import javafx.scene.shape.Rectangle;

public class JPieceRotationStrategy implements PieceRotationStrategy{
    TetrisBoard board;

    public JPieceRotationStrategy(TetrisBoard board){
        this.board = board;
    }
    @Override
    public void rotatePiece(TetrisPiece piece) {
        int state = piece.GetState();
        Rectangle a = piece.pieceFirst;
        Rectangle b = piece.pieceSecond;
        Rectangle c = piece.pieceThird;
        Rectangle d = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(a, 1, -1) && board.roomToTurn(c, -1, -1) && board.roomToTurn(d, -2, -2)) {
            board.rectMoveRight(a);
            board.rectMoveDown(a);
            board.rectMoveDown(c);
            board.rectMoveLeft(c);
            board.rectMoveDown(d);
            board.rectMoveDown(d);
            board.rectMoveLeft(d);
            board.rectMoveLeft(d);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(a, -1, -1) && board.roomToTurn(c, -1, 1) && board.roomToTurn(d, -2, 2)) {
            board.rectMoveDown(a);
            board.rectMoveLeft(a);
            board.rectMoveLeft(c);
            board.rectMoveUp(c);
            board.rectMoveLeft(d);
            board.rectMoveLeft(d);
            board.rectMoveUp(d);
            board.rectMoveUp(d);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(a, -1, 1) && board.roomToTurn(c, 1, 1) && board.roomToTurn(d, 2, 2)) {
            board.rectMoveLeft(a);
            board.rectMoveUp(a);
            board.rectMoveUp(c);
            board.rectMoveRight(c);
            board.rectMoveUp(d);
            board.rectMoveUp(d);
            board.rectMoveRight(d);
            board.rectMoveRight(d);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(a, 1, 1) && board.roomToTurn(c, 1, -1) && board.roomToTurn(d, 2, -2)) {
            board.rectMoveUp(a);
            board.rectMoveRight(a);
            board.rectMoveRight(c);
            board.rectMoveDown(c);
            board.rectMoveRight(d);
            board.rectMoveRight(d);
            board.rectMoveDown(d);
            board.rectMoveDown(d);
            piece.UpdateState();
        }
    }
}
