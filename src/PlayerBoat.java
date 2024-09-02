
// Player controlled boat

public class PlayerBoat extends Boat{
	
	// attributes
    private int playerScore;
    
    /**
 	 * This constructor sets the player's name and player's score
 	 * @param playerName
 	 * @param boatNum
 	 * @return Nothing
 	 */
    public PlayerBoat(String playerName, int boatNum) {
        super(boatNum);
        setBoatName(playerName);
    }

	/**
	 * This method returns the player's score
	 * @param args Unused
	 * @return playerScore
	 */
    public int getPlayerScore() {
        return playerScore;
    }
    
	/**
	 * This method sets the player's score
	 * @param playerScore
	 * @return Nothing
	 */
    public void setPlayerScore(int playerScore) {
        if (playerScore >= 0) {
        	this.playerScore = playerScore;
        }
    }

    @Override
    public String toString() {
        return String.format("Player Name: %s\nPlayer Score: %d\nDice Roll: %d\n", getBoatName(), getPlayerScore(), getDiceNo());
    }
}