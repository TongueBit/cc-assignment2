import java.util.Scanner;

public class Assignment2Game {
	
	static int random = 0;
	static int tries = 5;
	static Scanner scanner;
	static int guess;
	
	public static int newGuess () {
		/**
		 * This method is used to take input and set the static variable guess
		 * 
		 * returns: int which is the number guessed
		 */
		System.out.println("Pick a number between 1 and 100...");
		guess = scanner.nextInt();
		
		//System.out.println(getGuess());
		return guess;
	}
	
	public static int getRandom() {
		return random;
	}
	
	public static int getGuess() {
		return guess;
	}
	
	public static int getTries() {
		return tries;
	}
	
	public static void subtractTry() {
		/**
		 * This method subtracts a try and ends the game if the user has no more tries
		 */
		tries = tries - 1;
		if (getTries() == 0) {
			System.out.println("Sorry, you ran out of tries. End of game. The number was: " + getRandom());
			System.exit(0);
		}
			
	}
	
	public static void highOrLow (int guess) {
		/**
		 *  This method lets us know if the guess compared to the random number the game generates is
		 *  within the set of numbers higher than the guess or lower
		 */
		subtractTry();
		if (guess > random) 
			System.out.println("Please pick a lower number");
		else
			System.out.println("Please pick a higher number");
		
	}
	
	public static boolean validityCheck (int guess) {
		/**
		 * returns true if it's between 1 or 100 inclusive
		 */
		if (guess < 1 || guess > 100) {
			System.out.println("Your guess is not between 1 and 100, please try again");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		random = (int)(Math.floor(Math.random()*(100-0+1)+0));
		//System.out.println(random);
		scanner = new Scanner(System.in);
		
		while (newGuess() != random) {
			
			//check the validity of the guess
			while(!(validityCheck(getGuess()))) {
				newGuess();
			}
			highOrLow(getGuess());
		}
		
		System.out.println("Good game, the number was " + getRandom());
		
	}
	
}
