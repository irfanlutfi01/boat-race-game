// import java.util.Random;

public class NonTrap extends RiverObject{
	
	// constructor
	public NonTrap() {
		super(" _ ") ;
		setStrength(getStrength());
		setLocation(0);
	}
	
	@Override
	public int getStrength() {
		int strength = 0;
		return strength;
	}
	
	@Override
	public String toString() {
	   	return String.format("%s",super.toStringSymbol()); 
	}
 
}