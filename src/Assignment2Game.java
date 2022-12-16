import java.util.Scanner;

public class Assignment2Game {
	
	static int random = 0;
	static int tries = 5;
	static Scanner scanner;
	static int guess;
	
	//maybe i will make the game store the input statically
	//static int input;

	Assignment2Game () {
		random = (int)(Math.floor(Math.random()*(100-0+1)+0));
		//System.out.println(random);
		scanner = new Scanner(System.in);
	}
	
	public static int newGuess () {
		System.out.println("Pick a number between 1 and 100...");
		guess = scanner.nextInt();
		setGuess(guess);
		//System.out.println(getGuess());
		return guess;
	}
	
	public static int getRandom() {
		return random;
	}
	
	public static int getGuess() {
		return guess;
	}
	
	public static void setGuess(int guess) {
		guess = guess;
	}
	public static int getTries() {
		return tries;
	}
	
	public static void subtractTry() {
		tries = tries - 1;
		if (getTries() == 0) {
			System.out.println("Sorry, you ran out of tries. End of game. The number was: " + getRandom());
			System.exit(0);
		}
			
	}
	
	public static void highOrLow (int guess) {
		subtractTry();
		if (guess > random) 
			System.out.println("Please pick a lower number");
		else
			System.out.println("Please pick a higher number");
		
	}
	
	public static boolean validityCheck (int guess) {
		/**
		 * returns true if it's valid
		 */
		if (guess < 1 || guess > 100) {
			System.out.println("Your guess is not between 1 and 100, please try again");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Assignment2Game game = new Assignment2Game();
		
		while (newGuess() != game.random) {
			
			//check the validity of the guess
			while(!(validityCheck(game.getGuess()))) {
				game.newGuess();
			}
			highOrLow(game.getGuess());
		}
		
		System.out.println("Good game, the number was " + game.getRandom());
		
	}
	
}
