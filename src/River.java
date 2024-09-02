import java.util.ArrayList; 
import java.util.Random ;

public class River {
	
	// attributes
	private ArrayList<RiverObject> rlist = new ArrayList<RiverObject>() ;
	private ArrayList<RiverObject> game_river = new ArrayList<RiverObject>() ;
	
	// constructor
	public River() {
		Random r = new Random() ;
		int currentcount = r.nextInt(15) ;
		int trapcount = r.nextInt(15) ; //when constructing river, need x amount of trap / current
		
		Current c = new Current();
		Trap t= new Trap();

		for(int i = 0 ; i <currentcount ; i++) {
			rlist.add(c);			
		}
		
		for(int i = 0 ; i <trapcount ; i++) {
			rlist.add(t);
		}
		
		game_river=getGame_River();
	} // end constructor
		
	public ArrayList <RiverObject> getGame_River(){
		
		for (int i = 0; i<100; i++) {
			boolean isCT= false;
			
			for (RiverObject k: rlist) {
			
				if (k.getLocation() == i) {
					isCT = true ;
					game_river.add(k);					
				}
			} // end for
	
			if (!isCT) {
				game_river.add(new NonTrap());
			}
		} // end for
		return game_river;
	} // end getGame_River

		
	@Override	
	public String toString() {		
		return String.format("%s", game_river);	
	}

}