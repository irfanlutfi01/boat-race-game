import java.util.Random;

// Boat superclass

public class Boat {
	// attributes
	private int location; 		// location on river
	private int boatNum;		// player number, i.e., player 1 or player 2
	private String boatName;	// set by subclass
	private int diceNo;			// dice roll number
	public boolean hasWon;
	private int playerturn;
	

    /**
 	 * This constructor sets the boat number and location
 	 * @param boatNum
 	 * @return Nothing
 	 */
	public Boat(int boatNum) {
		this.boatNum = boatNum;
		location = 0;
	}
	
	/**
	 * This method returns the boat's location
	 * @param args Unused
	 * @return location
	 */
	public int getLocation() {
		return location;
	}
	
	public int getplayerturn() {
		return playerturn;
	}

	/**
	 * This method sets the boat's score
	 * @param location
	 * @return Nothing
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	

	public int turn_count() {
		playerturn=playerturn+1;
		return playerturn;
	}
	
	/**
	 * This method returns the boat's number
	 * @param args Unused
	 * @return boatNum
	 */
	public int getBoatNum() {
		return boatNum;
	}
	
	/**
	 * This method sets the boat's number
	 * @param boatNum
	 * @return Nothing
	 */
	public void setBoatNum(int boatNum) {
		this.boatNum = boatNum;
	}
	
	/**
	 * This method sets the boat's name
	 * @param boatName
	 * @return Nothing
	 */
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	
	/**
	 * This method returns the boat's name
	 * @param args Unused
	 * @return boatName
	 */
	public String getBoatName() {
		return boatName;
	}
	
	/**
	 * This method returns the dice roll number
	 * @param args Unused
	 * @return diceNo
	 */
    public int getDiceNo() {
        return diceNo;
    }
    
    public boolean getHasWon() {
        return hasWon;
    }

   public void setHasWon(boolean w) {
        hasWon = w;
    }
       
	/**
	 * This method rolls the dice by using Random
	 * @param args Unused
	 * @return diceNo
	 */
    public int roll() {
        Random random = new Random();
        diceNo = random.nextInt(5) + 1;
        return diceNo;
    }
    
    public void move(int diceno){
    	location=location+diceno;
    }
    
    
	/**
	 * This method moves the boat forward
	 * @param x
	 * @return Nothing
	 */
	public void moveForward(int x) { //x will be strength
			location =location+ x;
	}

	/**
	 * This method moves the boat backward
	 * @param x
	 * @return Nothing
	 */
	public void moveBackward(int x) {
		location -= x;
	}
	
	/**
	 * This method resets the location to 0, to replay game
	 * @param args Unused
	 * @return Nothing
	 */
	public void resetLocation() {
		location = 0;
	}
	
}	   