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
        Rectangle a = piece.pieceFirst;
        Rectangle b = piece.pieceSecond;
        Rectangle c = piece.pieceThird;
        Rectangle d = piece.pieceFourth;

        if (state == 1 && board.roomToTurn(a, 1, -1) && board.roomToTurn(c, 1, 1) && board.roomToTurn(b, 2, 2)) {
            board.rectMoveRight(a);
            board.rectMoveDown(a);
            board.rectMoveUp(c);
            board.rectMoveRight(c);
            board.rectMoveUp(b);
            board.rectMoveUp(b);
            board.rectMoveRight(b);
            board.rectMoveRight(b);
            piece.UpdateState();
        }
        else if (state == 2 && board.roomToTurn(a, -1, -1) && board.roomToTurn(b, 2, -2) && board.roomToTurn(c, 1, -1)) {
            board.rectMoveDown(a);
            board.rectMoveLeft(a);
            board.rectMoveRight(b);
            board.rectMoveRight(b);
            board.rectMoveDown(b);
            board.rectMoveDown(b);
            board.rectMoveRight(c);
            board.rectMoveDown(c);
            piece.UpdateState();
        }
        else if (state == 3 && board.roomToTurn(a, -1, 1) && board.roomToTurn(c, -1, -1) && board.roomToTurn(b, -2, -2)) {
            board.rectMoveLeft(a);
            board.rectMoveUp(a);
            board.rectMoveDown(c);
            board.rectMoveLeft(c);
            board.rectMoveDown(b);
            board.rectMoveDown(b);
            board.rectMoveLeft(b);
            board.rectMoveLeft(b);
            piece.UpdateState();
        }
        else if (state == 4 && board.roomToTurn(a, 1, 1) && board.roomToTurn(b, -2, 2) && board.roomToTurn(c, -1, 1)) {
            board.rectMoveUp(a);
            board.rectMoveRight(a);
            board.rectMoveLeft(b);
            board.rectMoveLeft(b);
            board.rectMoveUp(b);
            board.rectMoveUp(b);
            board.rectMoveLeft(c);
            board.rectMoveUp(c);
            piece.UpdateState();
        }
    }
}
