package Battleship;

public class Player {
	private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5}; 
	private static final int HORIZONTAL = 0;
	private static final int VERTICAL = 1;
	private Ship[] ships;
    private Grid myGrid;
    private Grid opponentGrid;
    private int hitsTaken = 0;
    
    
    /**
     * Constructs a Player with initialized ships and empty grids.
     */
    public Player() {
    	ships = new Ship[SHIP_LENGTHS.length];
        for (int i = 0; i < SHIP_LENGTHS.length; i++) {
            ships[i] = new Ship(SHIP_LENGTHS[i]);
        }
        myGrid = new Grid();
        opponentGrid = new Grid();
    }
    
    
    
    /**
     * Returns the grid with the player's own ships.
     * 
     * @return the player's grid
     */
    public Grid getMyGrid() {
        return myGrid;
    }
    
    
    
    /**
     * Places a ship on the player's grid at the specified location and direction.
     * 
     * @param s the ship to place
     * @param row the starting row
     * @param col the starting column
     * @param direction the direction (0 = horizontal, 1 = vertical)
     */
    public void chooseShipLocation(Ship s, int row, int col, int direction) {
    	s.setLocation(row, col);
        s.setDirection(direction);
        myGrid.addShip(s);
    }
    
    
    /**
     * Prints the player's own grid with ship locations.
     */
    public void printMyShips() {
    	myGrid.printShips();
    }
    
    
    /**
     * Prints the opponent's guesses on the player's grid.
     */
    public void printOpponentGuesses() {
    	myGrid.printStatus();
    }
    
    
    /**
     * Prints the player's guesses on the opponent's grid.
     */
    public void printMyGuesses() {
    	opponentGrid.printStatus();
    }
    
    
    /**
     * Records an opponent's guess on the player's grid.
     * Marks hit or miss and updates the hit count if necessary.
     * 
     * @param row the guessed row
     * @param col the guessed column
     * @return true if the guess was a hit, false otherwise
     */
    public boolean recordOpponentGuess(int row, int col) {
    	  if (myGrid.hasShip(row, col)) {
              myGrid.markHit(row, col);
              hitsTaken++;
              return true;
          } 
    	  else {
              myGrid.markMiss(row, col);
              return false;
          }
    }
    
    
    /**
     * Marks a guess made by this player on the opponent's grid.
     * 
     * @param row the guessed row
     * @param col the guessed column
     * @param val true if the guess was a hit, false otherwise
     */
    public void markGuess(int row, int col, boolean val) {
    	if (val) {
            opponentGrid.markHit(row, col);
        } 
    	else {
            opponentGrid.markMiss(row, col);
        }
    }
    
    
    /**
     * Checks if a ship can be placed at the specified location and direction.
     * 
     * @param ship: the ship to place
     * @return true if the ship can be placed, false otherwise
     */
    public boolean canPlaceShip(Ship ship) {
    	 int row = ship.getRow();
    	 int col = ship.getCol();
    	 int len = ship.getLength();
    	 int dir = ship.getDirection();
    	 
    	 if (dir == 0) { 						// Horizontal
    		 if (col + len > Grid.NUM_COLS) 
    	        	return false;
    	     	for (int i = 0; i < len; i++) {
    	            if (myGrid.hasShip(row, col + i)) 
    	            return false;
    	        }
    	    } 
    	 else if (dir == 1) { 					// Vertical
    	      if (row + len > Grid.NUM_ROWS) 
    	    	  return false;
    	        for (int i = 0; i < len; i++) {
    	            if (myGrid.hasShip(row + i, col)) 
    	            return false;
    	        }
    	    }		
    	 else {									// direction is not set	
    	        return false; 								
    	    }
    	 return true;
    }
    
    
    /**
     * Randomly places all ships on the player's grid.
     * Ships are placed in valid positions without overlapping.
     */
    public void initializeShipsRandomly() {

        for (int i = 0; i < SHIP_LENGTHS.length; i++) {
            int length = SHIP_LENGTHS[i];
            boolean placed = false;

            while (!placed) {
                int dir = Randomizer.nextInt(2); 
                int row = Randomizer.nextInt(Grid.NUM_ROWS);
                int col = Randomizer.nextInt(Grid.NUM_COLS);

                Ship ship = new Ship(length);
                ship.setDirection(dir);
                ship.setLocation(row, col);

                if (canPlaceShip(ship)) {
                    ships[i] = ship;
                    myGrid.addShip(ship);
                    placed = true;
                }
            }
        }
    	 }
    
    
    /**
     * Checks if the player has lost the game (all the ships are sunk).
     * 
     * @return true if all ships are sunk (17 hits), false otherwise
     */
    public boolean hasLost() {
        return hitsTaken == 17; //total amount of ships: 2 + 3 + 3 + 4 + 5 = 17
    }
    
    

}

	


