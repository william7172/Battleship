package Battleship;

public class ShipTester {
	public static void main(String[] args) {
	
	Ship ship1 = new Ship(4);
	ship1.toString();
	System.out.println("Location set: "+ship1.isLocationSet());
	System.out.println("Direction set: "+ship1.isDirectionSet());

	
	ship1.setLocation(4,5);
	ship1.setDirection(0);
	ship1.toString();
	System.out.println("ship1: "+ship1);
	System.out.println("Location set: "+ship1.isLocationSet());
	System.out.println("Direction set: "+ship1.isDirectionSet());
	System.out.println("Length: "+ship1.getLength());
	System.out.println("Row: "+ship1.getRow());
	System.out.println("Col: "+ship1.getCol());
}
}