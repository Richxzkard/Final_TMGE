package com.example.final_tmge.src;

public abstract class GamePiece{
    protected String id; //name of the piece to grab the corresponding webp;
                //for example, if the id is "Diamond", then grab diamond.png

    public GamePiece(String id){
        this.id = id;
    }

    public GamePiece() {

    }

    public String getId(){
        return id;
    }

    public String pngPath(){
        return "/img/" + id + ".png";
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
