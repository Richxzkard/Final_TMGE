package com.example.final_tmge;

import com.example.final_tmge.src.Memory;
import com.example.final_tmge.src.MemoryPiece;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class MemoryGameController {
    public GridPane gameMatrix;
    public ListView scoreBoard;
    public Button start;
    private Memory memory = (Memory)Application.GamePlay;

    private ObservableList<String> scoreList;

    public void initialize() throws IOException {
        //Set Up Score Board, initailize scoreBoard
        scoreList = FXCollections.observableArrayList("Turns Left: ", "0",
                memory.getPlayer1Name() + "'s Score: ", "0",
                memory.getPlayer2Name() + "'s Score: ", "0");
        scoreBoard.setSelectionModel(null); //disable the selection mode
        scoreBoard.setItems(scoreList);
        //Set Up The Game Matrix
        startNewGame();
        //Set Up the Start Game Button
        start.setOnMouseClicked(event -> startNewGame());
    }

    public void updateScoreBoard(String[] scoreBoardInfo){
        //Update Score List
        scoreList.set(1, scoreBoardInfo[0]); //matching left
        scoreList.set(3, scoreBoardInfo[1]); //player1 score
        scoreList.set(5, scoreBoardInfo[2]); //player2 score

        //Game Ends
        if(scoreBoardInfo[0].equals("16")){

            // Create a new Alert with a type of INFORMATION
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            // Set the alert content
            alert.setTitle("Memory Game End");
            alert.setHeaderText(memory.getWinnerMessage());
            alert.setContentText("Click OK to Finish the Game");
            // Show the alert and wait for user response
            alert.showAndWait();
            //Close the game Window
            Stage stage = (Stage) scoreBoard.getScene().getWindow();
            stage.close();
            Application application = new Application();
            application.restart();
        }
    }

    //TODO: CHECK IF THE GAME END
    public void cardListener(MouseEvent event){
        Node sourceComponent = (Node) event.getSource();
        String rowAndColumn = (String) sourceComponent.getUserData();
        int rowSelected = Integer.parseInt(rowAndColumn.split(",")[0]);
        int colSelected = Integer.parseInt(rowAndColumn.split(",")[1]);
        String image = memory.getPath(rowSelected, colSelected);
        if(image != null){
            Image newImage = new Image(Application.getResource(image).toExternalForm());
            ((ImageView)sourceComponent).setImage(newImage);
            int[] checkMatchPair = memory.storePiece(rowSelected, colSelected);
            Image updateImage;
            if(checkMatchPair != null && checkMatchPair[0] == 1){ //MATCH
                updateImage = new Image(Application.getResource(memory.getClearImage()).toExternalForm());
                updateScoreBoard(memory.getScoreBoardInfo()); //update scoreboard information
            }
            else{ //NOT MATCH
                updateImage = new Image(Application.getResource(memory.getQuestionImage()).toExternalForm());
            }

            if(checkMatchPair != null && updateImage != null){
                ((ImageView)gameMatrix.getChildren().get(checkMatchPair[1])).setImage(updateImage);
                ((ImageView)gameMatrix.getChildren().get(checkMatchPair[2])).setImage(updateImage);
            }
        }
    }


    public void startButtonClick(){
        startNewGame();
    }

    //START NEW GAME
    public void startNewGame(){
        //Clear and Set Up game Matrix
        memory.setUpBoard();
        gameMatrix.getChildren().clear();

        //creating the image object
        Image questionImage = new Image(Application.getResource(memory.getQuestionImage()).toExternalForm());

        for(int r=0; r<memory.getBoardHeight(); r++){
            for(int c=0; c<memory.getBoardWidth(); c++){
                //creating the image view
                ImageView imageView = new ImageView(questionImage);
                imageView.setFitWidth(memory.getTileSize());
                imageView.setFitHeight(memory.getTileSize());
                imageView.setUserData(r +"," + c);
                imageView.setOnMouseClicked(mouseEvent -> cardListener(mouseEvent));
                gameMatrix.add(imageView, c, r);
            }
        }

        //Clear and Set up score Board
        String[] scoreInfo = memory.getScoreBoardInfo();
        updateScoreBoard(scoreInfo);
    }
}
