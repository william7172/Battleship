package Battleship;
import java.util.Scanner;

public class Battleship {
    /**
     * 
     * This is battleship class to run the whole game
     * It allows the user to place ships, then alternates turns between the player and computer
     * until one side has all ships sunk.
     * @param args
     */
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player();     // set up human player
        Player computer = new Player();   // set up computer player

        //Player places ships
        //Player is asked to enter the row, column, length, and direction
        //this process repeat 5 times to place 5 ships
        System.out.println("Place your 5 ships.");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ship #" + i);
            System.out.print("Enter row (0-9): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-9): ");
            int col = scanner.nextInt();
            System.out.print("Enter length (2–5): ");
            int length = scanner.nextInt();
            System.out.print("Horizontal? (true/false): ");
            boolean isHorizontal = scanner.nextBoolean();

            Ship ship = new Ship(length);
            int direction;
            if (isHorizontal) {
                direction = 0;
            } else {
                direction = 1;
            }
            //set ships in the grid
            ship.setLocation(row, col);
            ship.setDirection(direction);
            if (player.canPlaceShip(ship)) {
                player.chooseShipLocation(ship, row, col, direction);
            } 
    
        }

        //Computer places ships randomly each time
        computer.initializeShipsRandomly();
        //computer.printMyShips();
        

        //Game loop
        while (true) {
            // Print boards
            System.out.println("\nYour Ships:");
            player.printMyShips();
            System.out.println("\nYour Guesses:");
            player.printMyGuesses();

            //Player's turn
            System.out.println("\nYour turn to guess.");
            System.out.print("Enter row (0-9): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-9): ");
            int col = scanner.nextInt();
            //check if the player hit the ship in the computer grid
            //return you hit if player hit the ship, you missed otherwise
            boolean playerHit = computer.recordOpponentGuess(row, col);
            player.markGuess(row, col, playerHit);
            if (playerHit) {
                System.out.println("You hit!");
            } 
            else {
                System.out.println("You missed.");
            }
            //if player knock out 17 ships which is the total amount of ships in the computer grid, return player win
            if (computer.hasLost()) {
                System.out.println("You win! All computer ships sunk.");
                break;
            }

            //Computer's turn 
            int compRow = (int)(Math.random() * 10);
            int compCol = (int)(Math.random() * 10);
            boolean computerHit = player.recordOpponentGuess(compRow, compCol);
            computer.markGuess(compRow, compCol, computerHit);
            //check if the computer hit the ship in the player grid
            //return you hit if computer hit the ship, you missed otherwise
            if (computerHit) {
                System.out.println("Computer guessed (" + compRow + ", " + compCol + ") and hit!");
            } else {
                System.out.println("Computer guessed (" + compRow + ", " + compCol + ") and missed.");
            }
            //if computer knock out 17 ships which is the total amount of ships in the player grid, return computer win
            if (player.hasLost()) {
                System.out.println("You lose! All your ships are sunk.");
                break;
            }
        }

       
    }
}
