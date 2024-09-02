
public class ScoreRecord {
	
	// attributes
    private String name;
    private int score;
    
    /**
	 * This is the default constructor for this class
	 * Sets the default values for name and score as null and 0 respectively
	 * @return Nothing
	 */
    public ScoreRecord() {
		name = "";
		score = 0;
	}
    
    /**
 	 * This constructor sets the player's name and player's score
 	 * @param name
 	 * @param score
 	 * @return Nothing
 	 */
    public ScoreRecord(String name, int score) {
		this.name = name;
		this.score = score;
	}
    
	/**
	 * This method sets the player's name
	 * @param name
	 * @return Nothing
	 */
    public void setName(String name) {
        this.name = name;
    }
    
	/**
	 * This method returns the player's name
	 * @param args Unused
	 * @return name
	 */
    public String getName() {
        return name;
    }
    
	/**
	 * This method sets the player's score
	 * @param score
	 * @return Nothing
	 */
    public void setScore(int score) {
        this.score = score;
    }
    
	/**
	 * This method returns the player's score
	 * @param args Unused.
	 * @return score
	 */
    public int getScore() {
        return score;
    }

}