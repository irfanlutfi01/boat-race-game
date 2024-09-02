import java.util.Scanner;

public class Menu {
					
//	prints header once then prints the menu, gets input choice and performs the action 
//	until you exit
	public void runMenu() {
		printHeader();
		while(true){
			printMenu();
			int choice = getInput();
			performAction(choice);
		} // end while
	} // end runMenu
	
//	 prints header 
	 private void printHeader() {
		 System.out.println("==========================================");
		 System.out.println("|            Welcome to our              |");
		 System.out.println("|             Menu section               |");
		 System.out.println("==========================================");
	 } // end printHeader

//	  prints menu
	 private void printMenu() {
		 System.out.println("\nPlease make your selection: ");
		 System.out.println("1) Start game");
		 System.out.println("2) Display Top Scores");
		 System.out.println("3) Exit game");
	 } // end printMenu
	 
//	 gets user's choice
	 private int getInput() {
		 Scanner sk = new Scanner(System.in);
		 int choice = 0;
		 while(choice < 1 || choice > 3) {
			 try {
				 System.out.print("\nEnter your choice: ");
				 choice = Integer.parseInt(sk.nextLine());
				 
	                if (choice == 1 || choice == 2 || choice == 3){
	                    break;
	                }
	                //	checking to see if user input any integer besides 1, 2 or 3
	                else if (choice < 1 || choice > 3){		
	                	System.out.print("Invalid entry! Please enter 1, 2 or 3 only!\n");
	                }
			 }
			 //	checking to see if user input non integers
			 catch(NumberFormatException e) {
				 System.out.print("Invalid entry! Please enter 1, 2 or 3 only!\n");
			 }
		 } // end while
		 return choice;
	 } // end getInput
	 
	 private void performAction(int choice) {
		 
		 switch(choice) {
		 
		 	case 3:
		 		System.out.println("Thank you for playing our game!");
		 		System.exit(0); //successful termination
		 		break;
		 		
		 	case 2:
		 		Score scores = new Score();
		 		scores.createFile();
		        scores.loadScore();
		        scores.displayScore();
		 		break;
		 		
			case 1:
				Game game=new Game();
				game.start();
				break;
				
			default:
				System.out.println("Unknown error has occured!");
		 } // end switch
	 } // end performAction
}