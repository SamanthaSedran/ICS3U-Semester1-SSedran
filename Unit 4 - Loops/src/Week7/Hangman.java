package Week7;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;
        while(playAgain){
            play("READY TO USE SURFACE CLEANER", in);
            playAgain = playAgain(in);
        }
    }

    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while(!validInput){
            System.out.println("Do you want to play again ([Y]ES / [N]O)");
            String answer = in.nextLine().toUpperCase();
            if(answer.equals("YES") || answer.equals("Y")){
                return true;
            }else if(answer.equals("NO") || answer.equals("N")){
                return false;
            }else{
                System.out.println("Invalid Input: YES or NO only!");
            }
        }
        return false;
    }

    /*
     O
    /|\
     |
    / \
    7 pieces to build hangman
    */
    private static void play(String hint, Scanner in) {
        String lettersUsed = "";
        int numPieces = 0;
        boolean gameOver = false;
        String availibleLetters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";

        while(!gameOver){
            String encryptedHint = encryptHint(hint, lettersUsed);
            System.out.println(encryptedHint);
            String letter = getLetter(in, availibleLetters);
            lettersUsed += letter;

            availibleLetters = availibleLetters.replace(letter, "_");
            if(hint.indexOf(letter) < 0){
                numPieces++;
            }
            
            if(numPieces>0){
            drawHangman(numPieces);
            }

            if(numPieces == 7){
                System.out.println("You lose!!!");
                gameOver = true;
            }else if(encryptHint(hint, lettersUsed).indexOf("_") < 0){
                System.out.println("You win!");
                gameOver = true;
            }

            }
        }

    private static String getLetter(Scanner in, String availibleLetters) {
        System.out.println("Availible Letters: \n" + availibleLetters);
        boolean validInput = false;
        String letter = "";

        while(!validInput){
            System.out.print("Please choose a letter: ");
            letter = in.nextLine().toUpperCase(); //convert user input to uppercase

            if (letter.length()==1 && availibleLetters.indexOf(letter)>=0){
                validInput = true; // might have to change this so player can't guess _ or " "(space) using indexOf
            }else{
                System.out.println("Invalid choice. Single letters only.");
                System.out.println("Availible Letters: \n" + availibleLetters);
            }
        }
        return letter;
        
    }

    private static String encryptHint(String hint, String lettersUsed) {
        String result = "";
        for(int i=0; i < hint.length(); i++){
            String s = hint.substring(i, i+1);
            if(s.equals(" ")){
                result += "/ ";
            }else if(lettersUsed.indexOf(s) >= 0){
                result += s + ' ';
            }else {
                result += "_ ";
            }
        }
        return result;
    }

    private static void drawHangman(int numPieces){
        System.out.println();
        System.out.println("Hangman: ");
        if(numPieces == 7){
            System.out.println(" O");
            System.out.println("/|\\");
            System.out.println(" |");
            System.out.println("/ \\");
        }else if(numPieces == 6){
            System.out.println(" O");
            System.out.println("/|\\");
            System.out.println(" |");
            System.out.println("/ ");
        }else if(numPieces == 5){
            System.out.println(" O");
            System.out.println("/|\\");
            System.out.println(" |");
        }else if(numPieces == 4){
            System.out.println(" O");
            System.out.println("/|\\");
        }else if(numPieces == 3){
            System.out.println(" O");
            System.out.println("/|");
        }else if(numPieces == 2){
            System.out.println(" O");
            System.out.println("/");
        }else if(numPieces == 1){
            System.out.println(" O");
        }
        System.out.println();
    }
}
