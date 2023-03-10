package com.example.final_tmge.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
    }

    //This function would printout a list of options and get user's input
    //INPUT: title of this list, list of options
    //OUTPUT: the int that user enters
    public static int getUserSelection(String title, String options[]){
        //PRINT title
        StringBuilder menuList = new StringBuilder();
        menuList.append("------");
        menuList.append(title);
        menuList.append("------");
        //PRINT option
        if(options.length == 0){
            menuList.append("\n");
            menuList.append(title);
            menuList.append(" is empty");
        }else{
            for(int i=0; i<options.length; i++){
                menuList.append("\n");
                menuList.append(i);
                menuList.append(": ");
                menuList.append(options[i]);
            }
        }
        System.out.println(menuList.toString());

        //GET user input
        String option = Main.getUserInput("Please enter your selection: ");
        while(!option.matches("-?\\d+") || Integer.parseInt(option) < 0 || Integer.parseInt(option) >= options.length) {
            option = Main.getUserInput("Not a Valid Input, Please try again: ");
        }
        return Integer.parseInt(option);
    }

    //INPUT: Message that you want to show to the user
    //OUTPUT: user's input String. It does not check the input format
    public static String getUserInput(String hint){
        //GET user input
        try {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(hint);
            String userInput = stdin.readLine();
            return userInput;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}


