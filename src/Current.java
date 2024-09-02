import java.util.Random;

public class Current extends RiverObject{
	
	public Current() {
		super(" C ") ;
		//Random r = new Random() ;
		setLocation(getLocation()); 
		setStrength(getStrength());
	}
	
	@Override
	public int getStrength() {
		Random r = new Random() ;
		int strength = 1 + r.nextInt(5);
		return strength;
	}
	
	@Override
	public int getLocation() {
		Random r = new Random() ;
		int location = 1 + r.nextInt(99);
		return location;
	}
	
	@Override
    public String toString() {
    	return String.format("%s",super.toStringSymbol()); 
    }
	
}