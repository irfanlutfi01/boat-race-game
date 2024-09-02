
// Computer controlled boat, has no input name or score

public class ComputerBoat extends Boat {
	
    /**
 	 * This constructor sets the computer as player 2 and name as "Computer"
 	 * @param args Unused
 	 * @return Nothing
 	 */
    public ComputerBoat() {
        super(2);
        setBoatName("Computer");
    }
}