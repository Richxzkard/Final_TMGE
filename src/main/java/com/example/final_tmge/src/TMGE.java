package com.example.final_tmge.src;

public abstract class TMGE {

    String name;
    Player player1;
    Player player2;

    public TMGE(String name, Player p1, Player p2){
        this.name = name;
        player1 = p1;
        player2 = p2;
    }

    public TMGE(String name, Player p1){
        this.name = name;
        this.player1 = p1;
        this.player2 = null;
    }

    public TMGE(String name){
        this.name = name;
        this.player1 = null;
        this.player2 = null;
    }

    public String getGameName(){
        return this.name;
    }

    public String getPlayer1Name(){
        return player1.userName;
    }
    public String getPlayer2Name(){
        return player2.userName;
    }

    public static boolean notifyPlayer(int player){
        return true;
    }

    public static void updateGamePiece(int x, int y){
        return;
    }

    public void play(){
    }

    public void refresh(){
        
    }
    
    public Board getBoard(){
        return null;
    }
}
