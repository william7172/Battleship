package Battleship;

public class LocationTester {
	public static void main(String[] args) {
		Location location1 = new Location();
		
		location1.setStatus(0);
		location1.setShip(false);
		System.out.println("Unguessed Location");
		System.out.println("Hit? "+location1.checkHit());
		System.out.println("Miss? "+location1.checkMiss());
		System.out.println("Unguessed? "+location1.isUnguessed());
		System.out.println("Ship? "+location1.hasShip());
		System.out.println("Status:" + location1.getStatus());
		  
		System.out.println("--------------");
		
		location1.setStatus(2);
		location1.setShip(false);
		System.out.println("Missed Location");
		System.out.println("Hit? "+location1.checkHit());
		System.out.println("Miss? "+location1.checkMiss());
		System.out.println("Unguessed? "+location1.isUnguessed());
		System.out.println("Ship? "+location1.hasShip());
		System.out.println("Status:" + location1.getStatus());
		
	    System.out.println("--------------");
		
	    location1.setStatus(1);
		location1.setShip(true);
		System.out.println("Hit Location");
		System.out.println("Hit? "+location1.checkHit());
		System.out.println("Miss? "+location1.checkMiss());
		System.out.println("Unguessed? "+location1.isUnguessed());
		System.out.println("Ship? "+location1.hasShip());
		System.out.println("Status:" + location1.getStatus());
		
		System.out.println("--------------");
		
		location1.setStatus(0);
		location1.setShip(true);
		System.out.println("Set status to 0");
		System.out.println("Hit? "+location1.checkHit());
		System.out.println("Miss? "+location1.checkMiss());
		System.out.println("Unguessed? "+location1.isUnguessed());
		System.out.println("Ship? "+location1.hasShip());
		System.out.println("Status:" + location1.getStatus());
		
	}
}
