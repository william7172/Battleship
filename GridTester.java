package Battleship;

public class GridTester {
	public static void main(String[] args) {
		Grid playerGrid = new Grid();
		playerGrid.setShip(1, 1, true); 
        playerGrid.setShip(2, 1, true); 
        playerGrid.setShip(4, 0, true); 
        playerGrid.setShip(4, 1, true); 
        playerGrid.setShip(4, 2, true); 
        playerGrid.setShip(7, 3, true); 
        playerGrid.setShip(7, 4, true); 
        playerGrid.setShip(7, 5, true); 
        playerGrid.setShip(7, 6, true); 
        playerGrid.setShip(7, 8, true); 
        playerGrid.setShip(8, 8, true); 
        playerGrid.setShip(9, 8, true); 
        
        System.out.println("Seeing all of your ships:");
        playerGrid.printShips();
      
        playerGrid.markMiss(3, 3);
        playerGrid.markMiss(4, 3); 
        playerGrid.markHit(4, 0);  
        playerGrid.markHit(4, 1); 
        playerGrid.markHit(4, 2);  
        playerGrid.markMiss(5, 2); 
        System.out.println();
        System.out.println("Seeing an opponent guess until they sink one of your ships:");
        playerGrid.printStatus();
        
        
        
        
        //addShip() method tester
        Grid g = new Grid();
		Ship s1 = new Ship(4);
		s1.setLocation(4,5);
		s1.setDirection(0);
		g.addShip(s1);
		g.printShips();
       
	}
}
