package com.example.final_tmge;

import java.io.IOException;

public interface GameController {
    public void initialize() throws IOException;
    public void startNewGame();
    public void closeGame();
}
