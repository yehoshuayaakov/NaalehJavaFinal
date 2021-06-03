// b"H
//Yehoshua Shaneson - java Final - cool solitaire game
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Solitaire{
    //public static variable that is accessible to all parts of the program
    //in order to keep track of the number of cards left in deck
    public static int index = 52; 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String filename;
        System.out.println("Would you like to save the results to a specific file? (y/n)");
        String answer = keyboard.next();
        String answerUpperCase = answer.toUpperCase();
            if ( answerUpperCase.equals("Y")) {
                System.out.println("Enter file you would like to copy your results to");
                 filename = keyboard.next();
                //String filename = newfilename;
                //runProgram(filename);
            }
            else {
                 filename = "results.txt";
                //runProgram(filename);
            }
            runProgram(filename);
    }

    //methods for running the game: 
    //method to run the game
     private static void runProgram(String filename) {    
       //char [] deck = new char [52];
        //my hard coded deck for testing 
        char [] deck = {'R','B','B','B','B','B','R','R','B','R','B','B','B','R','B','R','R','R','B','B','R','B','R','B','B','R','R','B','R','R','R','B','R','B','B','R','R','B','B','R','B','R','R','B','B','R','R','B','B','R','B','R'};
        String currentHand = "";
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(filename);
            outputStream.println("Here is your game! Good Luck!!!!");
            while (index > 0){
                currentHand = checkCards(currentHand, deck);
                outputStream.println(printhand(currentHand));           
                outputStream.println("cards left " + index);
                 System.out.println("cards left " + index);
            }    
            
            outputStream.println(finalHand(currentHand, deck));
         
        }
        catch(FileNotFoundException f){ 
                System.out.println(f.getMessage()  + "hey!");
                System.exit(0);
        }
        outputStream.close();
        
    }

    //method to check final results
    private static String finalHand (String currentHand, char [] deck) {
        currentHand = checkCards(currentHand, deck);
        if (currentHand.length()==0){
            System.out.println("Congratulations! You Won!");
            return  "Last hand: " + currentHand + "\n"  + "Congratulations! You Won!";
        }
        else {
            System.out.println("You still have cards on the table!  Better luck next time!");
            return "Last hand: " + currentHand + "\n"   + "You still have cards on the table!  Better luck next time!";
        }
    }

    //method to print hand 
    public static String printhand(String currentHand){
        System.out.println(
            "Current hand: " + currentHand
        );
        return "Current hand: " + currentHand;
        
    }

    //method to place four cards when neccessary using for-loop
    public static String placeFourCards (char [] deck, String currentHand){
        for (int i = 0; i<4; i++){
            
            currentHand = currentHand +  deck[index-1];
            //testing the indexing - 
            //System.out.println("before degeridation " + index);
            --index;
            //System.out.println("after " + index);
        }
        
        return currentHand;
    }

    //method to place single card
    public static String placeSingleCard(char [] deck, String currentHand){
            currentHand = currentHand + deck[index-1];
            --index;
            return currentHand;
        }

    //main program method that checks hand and places/removes cards according to rules of the game
    public static String checkCards(String currentHand, char [] deck){
        //condition for last 3 cards when there are less than for cards on the table
        if (index <4 && currentHand.length()<4){
            currentHand = placeSingleCard(deck, currentHand);
        }
        //add four cards call
        else if (currentHand.length() == 0)
        {
                currentHand = placeFourCards(deck, currentHand);
        }
        //add single card if less than 4 cards on table
        else if (currentHand.length()<4)
        {
            currentHand = placeSingleCard(deck, currentHand);
        }
        //conditiions for removing cards when there is a match
        else if (currentHand.length() >= 4 &&  currentHand.charAt(currentHand.length()-1) == (currentHand.charAt(currentHand.length()-4)))
            {
            if (currentHand.charAt(currentHand.length()-4) == currentHand.charAt(currentHand.length()-3) && currentHand.charAt(currentHand.length()-3) ==  currentHand.charAt(currentHand.length()-2)){
                 currentHand = currentHand.substring(0, currentHand.length()-4);    
            }
            else 
            {
                 currentHand = currentHand.substring(0, currentHand.length()-3) + currentHand.charAt(currentHand.length()-1);
               
            }
            
        }
        //if no other conditions met - add single card
        else
        {
            currentHand = placeSingleCard(deck, currentHand);
        }
        
        return currentHand;
    }
}