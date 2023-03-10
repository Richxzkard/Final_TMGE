package com.example.final_tmge;

import com.example.final_tmge.src.Memory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;

public class MemoryGameController {
    public GridPane gameMatrix;
    public Memory memory = (Memory)Application.GamePlay;

    public void initialize() throws IOException {
        for(int r=0; r<memory.getBoardHeight(); r++){
            for(int c=0; c<memory.getBoardWidth(); c++){
                //creating the image object
                URL url = Application.class.getResource("/img/question.png");
                Image questionImage = new Image(url.toExternalForm());
                //creating the image view
                ImageView questionView = new ImageView(questionImage);
                questionView.setFitWidth(memory.getTileSize());
                questionView.setFitHeight(memory.getTileSize());
                gameMatrix.add(questionView, r, c);
            }
        }
    }


}
