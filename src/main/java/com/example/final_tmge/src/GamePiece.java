package com.example.final_tmge.src;

public abstract class GamePiece{
    private String id; //name of the piece to grab the corresponding webp;
                //for example, if the id is "Diamond", then grab diamond.png

    public GamePiece(){
        id = "empty";
    }

    public GamePiece(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String pngPath(){
        return "../img/" + id + ".webp";
    }

    public void disappear(){
        id = "empty";
    }

    public static void observer(){

    }

    public boolean equals(GamePiece otherPiece) {
        return id.equals(otherPiece.getId());
    }

}
