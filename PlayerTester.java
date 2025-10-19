package Battleship;

public class PlayerTester {
	public static void main(String[] args) {
		Player Will = new Player();
        Player Zuck = new Player();
        
        Ship w1 = new Ship(2);
        Will.chooseShipLocation(w1, 0, 0, 0); // horizontal
        Ship w2 = new Ship(3);
        Will.chooseShipLocation(w2, 2, 0, 1); // vertical
        Ship w3 = new Ship(3);
        Will.chooseShipLocation(w3, 5, 5, 0); // horizontal

        Ship z1 = new Ship(4);
        Zuck.chooseShipLocation(z1, 3, 3, 1); // vertical
        Ship z2 = new Ship(5);
        Zuck.chooseShipLocation(z2, 6, 2, 0); // horizontal
        
        System.out.println("=== Will's Ships ===");
        Will.printMyShips();

        System.out.println("=== Zuck's Ships ===");
        Zuck.printMyShips();
        
        System.out.println("=== Will's Board After Opponent Guesses ===");
        Will.recordOpponentGuess(0, 0); // hit
        Will.recordOpponentGuess(9, 9); // miss
        Will.printOpponentGuesses();
        
        System.out.println("===Will's Guesses on ZUck ===");
        Will.markGuess(3, 3, true); // hit
        Will.markGuess(4, 4, false); // miss
        Will.printMyGuesses();
        
	}
	
}
