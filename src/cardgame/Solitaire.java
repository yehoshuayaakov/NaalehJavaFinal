package cardgame;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Solitaire{
    public static int index = 52;
    public static void main(String[] args) {
        System.out.println("Please enter a file you want to copy the results to");
        Scanner keyboard = new Scanner(System.in);
        String file = keyboard.nextLine();
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(file);
        }
        catch (FileNotFoundException f){
            System.out.println(f.getMessage());
        }
        char [] deck = new char[52];
    }
    public char [] placeFourCards(char[] deck){


        char [] fourCards = new char[4];
        for (int i = 1; i<5; i++){

            fourCards[i-1] = deck[index-i];
            --index;

        }
            return fourCards;
    }
}