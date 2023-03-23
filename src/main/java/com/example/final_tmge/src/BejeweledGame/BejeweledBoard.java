package com.example.final_tmge.src.BejeweledGame;

import com.example.final_tmge.src.Board;
import com.example.final_tmge.src.Coordinates;
import com.example.final_tmge.src.GamePiece;
import com.example.final_tmge.src.HorizontalMatch;
import com.example.final_tmge.src.VerticalMatch;

import java.util.Random;
import java.util.List;

public class BejeweledBoard extends Board {

    BejeweledTileGenerator generator;
    Random randomGenerator;
    HorizontalMatch hMatch;
    VerticalMatch vMatch;

    int totalMatches;

    int boardHeight;
    int boardWidth;
    boolean matchesExist;

    public BejeweledBoard(int height, int width) {
        super(height, width);
        generator = new BejeweledTileGenerator();
        randomGenerator = new Random();
        boardHeight = height;
        boardWidth = width;
        totalMatches = 0;
        hMatch = new HorizontalMatch();
        vMatch = new VerticalMatch();
        matchesExist = false;
    }

    public void setBejeweledBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                setGamePiece(generator.generateTile(), i, j);
            }
        }
    }

    public void resetBoard() {
        clearBoard();
        setBejeweledBoard();
    }

    public void updateBoard(List<Coordinates> coordinates){

        for(int i = 0; i < coordinates.size(); i++) {
            removeGamePiece(coordinates.get(i).getX(), coordinates.get(i).getY());
            setGamePiece(generator.generateTile(), coordinates.get(i).getX(), coordinates.get(i).getY());
        }

    }

    void removeGamePiece(int row, int column){
        matrix[row][column] = null;
    }

    void moveGamePieces(Coordinates tile1, Coordinates tile2){
        //swap the two pieces
        GamePiece temp = matrix[tile1.getX()][tile1.getY()];
        matrix[tile1.getX()][tile1.getY()] = matrix[tile2.getX()][tile2.getY()];
        matrix[tile2.getX()][tile2.getY()] = temp;

        //check if it results in any matches, and update the board if it does
        matchGamePieces();

        //if there were no matches then the game needs to swap the two pieces back
       if(matchesExist == false){
           //swap back
           temp = matrix[tile1.getX()][tile1.getY()];
           matrix[tile1.getX()][tile1.getY()] = matrix[tile2.getX()][tile2.getY()];
           matrix[tile2.getX()][tile2.getY()] = temp;

       }

       matchesExist = false;

    }

    void matchGamePieces(){

        List<List<Coordinates>> verticalMatches = vMatch.findMatches(matrix);


        List<List<Coordinates>> horizontalMatches = hMatch.findMatches(matrix);

        //if matches are found, leave the game pieces as is then call updateBoard with the list of coordinates with a match
        if(verticalMatches.size() != 0){
            matchesExist = true;
            for(int i = 0; i < verticalMatches.size(); i++) {
                updateBoard(verticalMatches.get(i));
            }
            totalMatches = totalMatches + 1;
        }

        if(horizontalMatches.size() != 0){
            matchesExist = true;
            for(int i = 0; i < horizontalMatches.size(); i++) {
                updateBoard(horizontalMatches.get(i));
            }
            totalMatches = totalMatches + 1;
        }
        //else if there are no matches, swap the two gamepieces back to their original spots

    }



}


