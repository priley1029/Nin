/*
 * Activity 2.5.11
 *
 * by Patrick Riley
 * 
 *  The game of nim
 */

import java.util.Scanner;

public class gameOfNin
{
    // this section sets up the main functions so they can be called
    Scanner scan = new Scanner(System.in);
    private Board board = new Board();  
    private Player player1;
    private Player player2;
    //this is the main function that starts the game
    public static void main(String args[])
    {
        gameOfNin gon = new gameOfNin();
        gon.play();
    }
//this is the beginning of the play function which calls the take turn functions in a while loop
    public void play()
    {
        board.setNumPieces();
        System.out.println("Welcome to the game of nin, player one insert your name:");
        String name = scan.nextLine();
        player1 = new Player(name);
//the scanner finds out what the name of both of the players name so the game can refer to them by name
        System.out.println("player two insert your name:");
        name = scan.nextLine();
        player2 = new Player(name);
        double d = Math.random();

        while(board.getNumPieces() >= 1)
        {
            if (d == 0.0)
            {
                if (player1.takeTurn())
                {
                    break;
                }
            }
            if (d == 1.0)
            {
                if (player2.takeTurn())
                {
                    break;
                }
            }
        }
    }

    public class Board
    {
        int numPieces;
//this subtracts the ammount tat the player picks and prints out how much are left
        public void takePieces(int num)
        {
            numPieces -= num;
            System.out.println("there are " + this.numPieces + " elements left.");
        }
//this is what sets the ammount of pieces that are present at the beginning of the game
        public void setNumPieces()
        {
            numPieces = (int) (Math.random()*(40)+10); 

            System.out.println("there are " + numPieces + " elements on the board.");
        }
//this returns the pieces
        public int getNumPieces()
        {
            return numPieces;
        }
    }
//this is the beginning of the player class
    public class Player
    {
        private int score = 0;
        private String name;

        public Player(String name)
        {
            this.name = name;
        }
//this is the beginning of the takeTurn function which does the major parts of the game including player input
        public boolean takeTurn()
        {
 //this section of the program prints out when a player becomes victorious           
            if (board.getNumPieces() == 1)
            {
                System.out.println(this.name + " loses!");
                return true;

                System.out.println("Do you want to play again?");
                String yn = scan.nextLine();
                if(yn == "yes")
                {
                    gon.Play();
                }
            }
//this is where the player can pick how many elements they want to get rid of, since it can only be between half of the total and 1 it has the current ammount divided by 2
            System.out.println(this.name + ", pick a number between 1 and " + board.getNumPieces()/2);
            int takeAway = scan.nextInt();
            System.out.println(board.getNumPieces());
            if(takeAway >= 1 && takeAway <= board.getNumPieces()/2)
            {
                board.takePieces(takeAway);
            }
            else
            {
                System.out.println("please only choose between 1 and " + board.getNumPieces()/2);
                this.takeTurn();
            }

            return false;
        }
    }

        
}