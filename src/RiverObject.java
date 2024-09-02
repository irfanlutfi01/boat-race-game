
public class RiverObject {
	private int location ;
	private String symbol ;
	private int strength;

	public RiverObject (String s) {
		symbol = s ; 
		strength = getStrength();		
	}
	
	public void setStrength (int s) { 
		strength = s;
	}
	
	public int getStrength() {
		return strength ;
	}

	public void setLocation (int l) { //index of river
		location = l ;
	}
	
	public int getLocation() {
		
		return location ;
	}
	
	public String getSymbol() {
		return symbol ;
	}
	
	public void setSymbol (String symbol) {
		this.symbol = symbol ;
	}
	
    public String toStringSymbol() {
    	return String.format("%s",symbol); 
    }
	
}