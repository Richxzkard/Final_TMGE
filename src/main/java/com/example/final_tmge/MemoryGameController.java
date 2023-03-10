package com.example.final_tmge;

import com.example.final_tmge.src.Memory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;

public class MemoryGameController {
    public GridPane gameMatrix;
    public Memory memory;

    public void initialize() throws IOException {
        for(int r=0; r<memory.getBoard().getHeight(); r++){
            for(int c=0; c<memory.getBoard().getWidth(); c++){
                //creating the image object
                URL url = Application.class.getResource("/img/question.webp");
                Image questionImage = new Image(url.toExternalForm());
                //creating the image view
                ImageView questionView = new ImageView(questionImage);
                questionView.setFitWidth(90);
                questionView.setFitHeight(90);
                gameMatrix.add(questionView, r, c);
            }
        }
    }
}
