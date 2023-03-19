package com.example.final_tmge;

import com.example.final_tmge.src.Tetris.Tetris;
import com.example.final_tmge.src.Tetris.TetrisBoard;
import com.example.final_tmge.src.Tetris.TetrisPiece;
import com.example.final_tmge.src.Tetris.TetrisPieceGenerator;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class TetrisGameController {
    public Button start;
    private static final Tetris tetris = (Tetris) Application.GamePlay;
    public Pane gameMatrixleft;
    public Pane gameMatrixright;
    public AnchorPane holder;

    public Timer leftTimer;
    public Timer rightTimer;

    // This is the Tetris piece fall down interval in milliseconds. The lower the value the higher the speed.
    private int fallDownInterval = 200;
    private TetrisPiece currentPiece1;

    private TetrisPiece currentPiece2;

    private TetrisPieceGenerator tileGenerator;

    public void initialize() throws IOException {
        start.setOnMouseClicked(event -> startNewGame());
        tileGenerator =  new TetrisPieceGenerator();
        tileGenerator.Initialize(tetris.board1.GetBlockSize(), tetris.getXBlocks());
    }

    public void startNewGame() {
        if (leftTimer != null) {
            leftTimer.cancel();
        }
        if (rightTimer != null) {
            rightTimer.cancel();
        }

        tetris.startNewGame(gameMatrixleft, gameMatrixright);
        startNewGameForPlayer1();
        startNewGameForPlayer2();
    }

    private void startNewGameForPlayer1() {
        updateCurrentPiecesForPlayer1().run();
        leftTimer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                runGame(tetris.board1, currentPiece1, updateCurrentPiecesForPlayer1());
            }
        };
        leftTimer.schedule(task, 0, fallDownInterval);
    }

    private void startNewGameForPlayer2() {
        updateCurrentPiecesForPlayer2().run();
        rightTimer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                runGame(tetris.board2, currentPiece2, updateCurrentPiecesForPlayer2());
            }
        };
        rightTimer.schedule(task, 0, fallDownInterval);
    }

    private void registerKeys() {
        holder.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case W:
                        tetris.board1.MoveTurn(currentPiece1);
                        break;
                    case S:
                        tetris.board1.MoveDown(currentPiece1);
                        break;
                    case A:
                        tetris.board1.MoveLeft(currentPiece1);
                        break;
                    case D:
                        tetris.board1.MoveRight(currentPiece1);
                        break;
                    case I:
                        tetris.board2.MoveTurn(currentPiece2);
                        break;
                    case K:
                        tetris.board2.MoveDown(currentPiece2);
                        break;
                    case J:
                        tetris.board2.MoveLeft(currentPiece2);
                        break;
                    case L:
                        tetris.board2.MoveRight(currentPiece2);
                        break;
                }
            }
        });
    }

    private Runnable updateCurrentPiecesForPlayer1() {
        return () -> {
            currentPiece1 = (TetrisPiece) tileGenerator.generateTile();
            gameMatrixleft.getChildren().addAll(currentPiece1.a, currentPiece1.b, currentPiece1.c, currentPiece1.d);
            registerKeys();
        };
    }
    private Runnable updateCurrentPiecesForPlayer2() {
        return () -> {
            currentPiece2 = (TetrisPiece) tileGenerator.generateTile();
            gameMatrixright.getChildren().addAll(currentPiece2.a, currentPiece2.b, currentPiece2.c, currentPiece2.d);
            registerKeys();
        };
    }

    private void runGame(TetrisBoard board, TetrisPiece piece, Runnable currentPieceUpdater) {
        Platform.runLater(new Runnable() {
            public void run() {
                boolean pieceMoved = board.MoveDown(piece);
                if (!pieceMoved) {
                    if (piece.isStuckAtTop()) {
                        board.GameOver();
                        leftTimer.cancel();
                        rightTimer.cancel();
                    } else {
                        currentPieceUpdater.run();
                    }
                }
            }
        });
    }
}

