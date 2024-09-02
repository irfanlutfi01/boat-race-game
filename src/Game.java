import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	// attributes
	private River river ;
    private int numPlayers;			// set number of players
    private PlayerBoat player1;		// create player1 instance from PlayerBoat class
    private Boat player2;			// create player2 instance from Boat class
	private RiverObject Riversymbol;
	private ArrayList<RiverObject> GameRiver= new ArrayList<RiverObject>() ;
	
	Scanner input = new Scanner(System.in);
	
	public Game() {
		numPlayers = setNumPlayers();
        player1 = setPlayer1();
        player2 = setPlayer2();
		river = new River();
    
	} // end Game
	
    //set number of players
    public int setNumPlayers() {
        while (true) {
            System.out.print("Single player or two players? (1 or 2): ");
            numPlayers = 0; 
            while(numPlayers < 1 || numPlayers > 2) {
   			 try {
                numPlayers = Integer.parseInt(input.next());
                if (numPlayers == 1 || numPlayers == 2){
                    break;
                }
                //	checking to see if user input any integer besides 1 or 2
                else if (numPlayers < 1 || numPlayers > 2){
                	System.out.print("Invalid entry! Please enter 1 or 2 only!\n\n");
                	System.out.print("Single player or two players? (1 or 2): ");
                }
   			 }
   			 //	checking to see if user input non integers
   			 catch(NumberFormatException e) {
   				 System.out.print("Invalid entry! Please enter 1 or 2 only!\n\n");
   				 System.out.print("Single player or two players? (1 or 2): ");
   			 }
   		 } // end while
            
         return numPlayers;
         
        } // end while
    } // end setNumPlayers
				
    //ask for player names
    public PlayerBoat setPlayer1() {
        input.nextLine();
        while (true) {
            System.out.print("Enter player 1 name: ");
            String pname1 = input.nextLine();
            PlayerBoat player1 = new PlayerBoat(pname1, 1); // Player 1
            //System.out.println(player1);
            return player1;
            } // end while
    } // end setPlayer1
		
    public Boat setPlayer2() {
        if (numPlayers == 1) {
            ComputerBoat player2 = new ComputerBoat();
            return player2;
        } // end if
		else {
            while (true) {
                System.out.print("Enter player 2 name: ");
                String pname2 = input.nextLine();
                PlayerBoat player2 = new PlayerBoat(pname2, 2);
                //System.out.println(player2);
                return player2;
                }
            } // end else
    } // end setPlayer2
    
	public River getRiver() {
		return river;		
	}
	
	public void start() {
    	Scanner input = new Scanner(System.in);
       
    	River river = new River();
    	GameRiver=river.getGame_River(); //create game river
    	
    	player1.setLocation(0);
    	player2.setLocation(0);
    	
        while(player1.getHasWon() == false && player2.getHasWon() == false){
           
            if (player1.getLocation() <= 100 || player2.getLocation() <=100) {
            	System.out.printf("\n%s",GameRiver);
            	System.out.println(" ");
            	
            	System.out.printf("\n%s turn to roll the dice!",player1.getBoatName() );
            	

            	System.out.print("\nInput 1 to roll dice:"); //player 1 roll dice
            	Scanner scanner = new Scanner(System.in);
                boolean diceinput = false;

                while (!diceinput) {
                    //System.out.print("\nInput 1 to roll dice:");
                    //String next = scanner.next();
                    try {
                        int input1 = Integer.parseInt(scanner.next());
                        
                        if (input1==1) {
                            diceinput = true;
                            player1.roll();
                            System.out.printf("\n%s dice value:%d", player1.getBoatName(), player1.getDiceNo());
                        }
                        
                        else if(input1!=1) {
                            System.out.println("Error: Input 1");
                        }
       
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Input numeric values only.");
                    }
                } // end while
                
                
                player1.turn_count(); //turn counter +1
            	player1.setPlayerScore(player1.getplayerturn()); //player score set as turn counts
            	player1.moveForward(player1.getDiceNo());  //getLocation + dice no
            	
             	if (player1.getLocation()>=100) {
          		  player1.setHasWon(true);
                    System.out.print("\nPlayer 1 has won");
                    System.out.printf("\n%s final score: %d\n",player1.getBoatName(), player1.getPlayerScore());
                    player1.setPlayerScore(player1.getPlayerScore());
                    addPlayerScore(player1);
                    break;
              	} //end if
             	
            	if (GameRiver.get(player1.getLocation()) instanceof NonTrap){
            		System.out.printf("\n%s current position: %d ",player1.getBoatName(), player1.getLocation());
            		System.out.printf("\n%s turn count: %d ",player1.getBoatName(), player1.getplayerturn());
            		System.out.printf("\n%s current score: %d",player1.getBoatName(), player1.getPlayerScore());
            	} // end if
            	
            	else if (GameRiver.get(player1.getLocation()) instanceof Current) {
            		System.out.printf("\n%s moved forward by %d ", player1.getBoatName(),GameRiver.get(player1.getLocation()).getStrength());
            		player1.moveForward(GameRiver.get(player1.getLocation()).getStrength()); //2(getLocation) + 3(strength) now our getLocation is 5
            		System.out.printf("\n%s current position: %d ",player1.getBoatName(), player1.getLocation());
            		System.out.printf("\n%s turn count: %d ",player1.getBoatName(), player1.getplayerturn());
            		System.out.printf("\n%s current score: %d",player1.getBoatName(), player1.getPlayerScore());
            	} // end else if
            	
             	else if (GameRiver.get(player1.getLocation()) instanceof Trap) {
             		System.out.printf("\n%s moved backward by %d ", player1.getBoatName(),GameRiver.get(player1.getLocation()).getStrength());
            		
             		player1.moveBackward(GameRiver.get(player1.getLocation()).getStrength()); //3(getLocation) - 1(strength) now our getLocation is 2
            		 if (player1.getLocation()<0) {
            			 player1.resetLocation();
            		 }
            		System.out.printf("\n%s current position: %d ",player1.getBoatName(), player1.getLocation());
            		System.out.printf("\n%s turn count: %d ",player1.getBoatName(), player1.getplayerturn());
            		System.out.printf("\n%s current score: %d",player1.getBoatName(), player1.getPlayerScore());
            	} // end else if
            	
            	System.out.printf("\n%s",GameRiver);
             	System.out.println(" ");
            	
            	System.out.printf("\n%s turn to roll the dice!",player2.getBoatName() );
            	System.out.print("\nInput 1 to roll dice:"); //player 2 roll dice
            	
                int input2 = 0;
                boolean diceinput1 = false;
                while (!diceinput1) {
                    //System.out.print("\nInput 1 to roll dice:");
                    //String next1 = scanner.next();
                    try {
                        input2 = Integer.parseInt(scanner.next());
                        
                        if (input2==1) {
                            diceinput1 = true;
                            player2.roll();
                            System.out.printf("\n%s dice value:%d", player2.getBoatName(), player2.getDiceNo());
                        }
                        
                        else if(input2!=1) {
                            System.out.println("Error: input 1");
                        }      
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Input numeric values only.");
                    }
                } // end while

            	player2.turn_count();	//turn counter +1
  
            	player2.moveForward(player2.getDiceNo()); 
             	if (player2.getLocation()>=100) {
          		  player2.setHasWon(true);
                  System.out.print("\nPlayer 2 has won");
                  System.out.printf("\n%s final score: %d\n",player2.getBoatName(), player2.getplayerturn());
                  if (player2 instanceof PlayerBoat) {
                	  ((PlayerBoat) player2).setPlayerScore(player2.getplayerturn());
                      addPlayerScore((PlayerBoat) player2);
                  } // end if
                  break;
            	} // end if
            	
            	
            	if (GameRiver.get(player2.getLocation()) instanceof NonTrap){
            		//GameRiver.set(boat1_location,player1.getBoatName());
            		System.out.printf("\n%s current position: %d ",player2.getBoatName(), player2.getLocation());
            		System.out.printf("\n%s turn count: %d ",player2.getBoatName(), player2.getplayerturn());
            		System.out.printf("\n%s current score: %d ",player2.getBoatName(), player2.getplayerturn());
            	} // end if
            	
            	else if (GameRiver.get(player2.getLocation()) instanceof Current) {
            		System.out.printf("\n%s moved forward by %d ", player2.getBoatName(),GameRiver.get(player2.getLocation()).getStrength());
            		player2.moveForward(GameRiver.get(player2.getLocation()).getStrength()); //2(getLocation) + 3(strength) now our getLocation is 5
            		System.out.printf("\n%s current position: %d ",player2.getBoatName(), player2.getLocation());
            		System.out.printf("\n%s turn count: %d ",player2.getBoatName(), player2.getplayerturn());
            		System.out.printf("\n%s current score: %d ",player2.getBoatName(), player2.getplayerturn());
            	} // end else if
            	
             	else if (GameRiver.get(player2.getLocation()) instanceof Trap) {
             		System.out.printf("\n%s moved backward by %d ", player2.getBoatName(),GameRiver.get(player2.getLocation()).getStrength());
            		
             		player2.moveBackward(GameRiver.get(player2.getLocation()).getStrength()); 
            		 if (player2.getLocation()<0) {
            			 player2.resetLocation();
            		 }
            		System.out.printf("\n%s current position: %d ",player2.getBoatName(), player2.getLocation());
            		System.out.printf("\n%s turn count: %d ",player2.getBoatName(), player2.getplayerturn());
            		System.out.printf("\n%s current score: %d ",player2.getBoatName(), player2.getplayerturn());
            	} // end else if

            } // end if
           
        } // end while
        
    } // end start 
	
	private void addPlayerScore(PlayerBoat player) {
        Score score = new Score();
        score.createFile();
        score.loadScore();
        score.addScore(player);
        score.saveScore();
    } // end addPlayerScore
  
}