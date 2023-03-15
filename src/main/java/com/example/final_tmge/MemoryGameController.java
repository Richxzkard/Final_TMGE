package com.example.final_tmge;

import com.example.final_tmge.src.Memory;
import com.example.final_tmge.src.MemoryPiece;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class MemoryGameController {
    public GridPane gameMatrix;
    public Button start;
    public Memory memory = (Memory)Application.GamePlay;


    public void initialize() throws IOException {
       startNewGame();
       start.setOnMouseClicked(event -> startNewGame());
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
            if(checkMatchPair != null && checkMatchPair[0] == 1){
                updateImage = new Image(Application.getResource(memory.getClearImage()).toExternalForm());
            }
            else{
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
    }
}
