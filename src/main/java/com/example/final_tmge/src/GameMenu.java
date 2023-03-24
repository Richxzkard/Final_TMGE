package com.example.final_tmge.src;

import java.util.ArrayList;

public class GameMenu {
    private ArrayList<TMGE> GameList = new ArrayList<>();

    public GameMenu(){
        
    }

    public void addGame(TMGE newGame){
        GameList.add(newGame);
    }

    public void removeGame(int gameID){
        GameList.remove(GameList.get(gameID));
    }

    public TMGE getGame(int gameID){
        if(gameID >= GameList.size()){
            return null;
        }
        else{
            return GameList.get(gameID);
        }
    }

    public String[] getMenuList(){
        String[] gameNames = new String[GameList.size()+1];
        for (int i = 0; i < GameList.size(); i++) {
            gameNames[i] = GameList.get(i).getGameName();
        }
        gameNames[GameList.size()] = "Exit";
        return gameNames;
    }
}
