import java.util.*;
import java.io.*;

public class Score {
	
	// attributes
	private Scanner input;
	private Formatter output;
	private ArrayList<ScoreRecord> scoreList = new ArrayList<ScoreRecord>();
	
	// constructor
	public void Score() {
		createFile();
	}
	
	/**
	 * This method will create file if file does not exist
	 * @param args Unused
	 * @exception IOException on file creation error
	 * @return Nothing
	 */
	public void createFile() {
		try {
            File file = new File("TopScore.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
          } catch (IOException e) {
            System.out.println("Error creating file!");
            e.printStackTrace();
          }
	}
	
	/**
	 * This method will open, read, and close the score file
	 * @param args Unused
	 * @return Nothing
	 */
	public void loadScore() {
		input = openInputFile("TopScore.txt");
		readScoreFile();
		closeInputFile(input);
	}
	
	/**
	 * This method will open, write, and close the score file
	 * @param args Unused
	 * @return Nothing
	 */
	public void saveScore() {
		output = openOutputFile("TopScore.txt");
		writeScoreFile();
		closeOutputFile(output);
	}
	
	/**
	 * This method will open the score file and store it in tempinput
	 * @param filename
	 * @exception FileNotFoundException on error opening file
	 * @return tempinput
	 */
	private Scanner openInputFile(String filename) {
		Scanner tempinput = null;
		try {
			tempinput = new Scanner(new File(filename));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file!");
			System.exit(1); // unsuccessful termination
		}
		return tempinput;
	}

	/**
	 * This method will open the score file and store it in tempoutput
	 * @param filename
	 * @exception FileNotFoundException on error opening file.
	 * @return tempoutput
	 */
	private Formatter openOutputFile(String filename) {
		Formatter tempoutput = null;
		try {
			tempoutput = new Formatter(new File(filename));
		} catch (FileNotFoundException fileNotFoundException) {
			System.err.println("Error opening file!");
			System.exit(1); // unsuccessful termination
		}
		return tempoutput;
	}
	
	/**
	 * This method will read the score file, create temporary object called tempscore to assign data, 
	 * and add object to scoreList 
	 * @param args Unused
	 * @exception NoSuchElementException on file corruption
	 * @exception IllegalStateException on error reading from file
	 * @return tempscore
	 */
	private void readScoreFile() {
		try {
			while (input.hasNext()) {
				ScoreRecord tempscore = new ScoreRecord();
				tempscore.setScore(input.nextInt());
				tempscore.setName(input.next());

				scoreList.add(tempscore);
			}
		} catch (NoSuchElementException elementException) {
			System.err.println("File is corrupted!");
			input.close();
			System.exit(1); // unsuccessful termination
		} catch (IllegalStateException stateException) {
			System.err.println("Error reading from file!");
			System.exit(1); // unsuccessful termination
		}
	}
	
	/**
	 * This method will call the sortScores method, then using a counter controlled loop,
	 * will write the scores into the TopScores.txt file 
	 * @param args Unused
	 * @return Nothing
	 */
	private void writeScoreFile() {
		sortScores();
		for (int i = 0; (i < scoreList.size()) && (i < 5); i++) {
			output.format("%d %s\n", scoreList.get(i).getScore(), scoreList.get(i).getName());
		}
	}
	
	private void closeInputFile(Scanner input) {
		if (input != null) // to avoid NullPointerException
			input.close();
	}
	private void closeOutputFile(Formatter output) {
		if (output != null) // to avoid NullPointerException
			output.close();
	}
	
	/**
	 * This method will create temporary object with one record data
	 * and adds object into the array list 
	 * @param playerBoat
	 * @exception FormatterClosedException on error writing to file
	 * @exception NoSuchElementException on invalid input
	 * @return Nothing
	 */
	// create temporary object and add score into the array list
	public void addScore(PlayerBoat playerBoat) {
		ScoreRecord tempscore = new ScoreRecord();

		try {
			tempscore.setScore(playerBoat.getPlayerScore());
			tempscore.setName(playerBoat.getBoatName());

			scoreList.add(tempscore);
		} catch (FormatterClosedException formatterClosedException) {
			System.err.println("Error writing to file.");
			return;

		} catch (NoSuchElementException elementException) {
			System.err.println("Invalid input");
			return;
		}
	}
	
	/**
	 * This method prints the score board based on the array of scores
	 * @param args Unused
	 * @return Nothing
	 */
	public void displayScore() {
		sortScores();
		System.out.println("---------------------------");
		System.out.println("| NO |   PLAYER   | SCORE |");
		System.out.println("---------------------------");
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.printf("| %2d | %10s | %5d |", (i + 1), scoreList.get(i).getName(), scoreList.get(i).getScore());
			System.out.println("\n---------------------------");
		}
	}
	
	/**
	 * This method sorts the scores in ascending order
	 * @param args Unused
	 * @return Nothing
	 */
	private void sortScores() {
		Comparator<ScoreRecord> comparator = new Comparator<ScoreRecord>(){
			public int compare(ScoreRecord s1, ScoreRecord s2) {
				return s1.getScore() - s2.getScore();
			}
		};
		scoreList.sort(comparator);
	}
}