//import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumberApp {
    
	public static void main(String[] args) {
        displayWelcome();
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {            
            int number = getRandomNumber();  
            displayPleaseGuess();
            int guessNumber = 0;
            int counter = 1;
            while (guessNumber != number) {               
                guessNumber = getIntWithinRange(sc, "Enter number: ", 0, 101);
                if (guessNumber == number) {
                    displayCorrectGuess(counter);
                } else {
                    displayGuessAgain(number, guessNumber);
                }
                counter++;
            }
            choice = getChoiceString(sc, "Try again? (y/n): ", "y", "n");
            System.out.println();
        }
        System.out.println("Bye - Play again soon!\n");
    }
	
    private static void displayWelcome() {
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("====================================\n");
    }
    
    private static int getRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }
    
    private static void displayPleaseGuess() {
        System.out.println("I'm thinking of a number from 1 to 100.");
        System.out.println("Try and guess it.\n");
    }
    
    private static void displayCorrectGuess(int counter) {
        System.out.println("You guessed it in " + counter + " tries.");
        if (counter <= 3) {
            System.out.println("Great work! You are a mathematical wizard.\n");
        } else if (counter > 3 && counter <= 7) {
            System.out.println("Not too bad! You've got some potential.\n");
        } else {
            System.out.println("What took you so long? Maybe you should take some lessons.\n");
        }
    }
    
    private static void displayGuessAgain(int number, int guessNumber) {
        int difference = guessNumber - number;
        if (guessNumber > number) {
            if (difference > 10) {
                System.out.println("Way too high! Guess again.\n");            
            } else {
                System.out.println("Too high! Guess again.\n");
            }
        } else {
            if (difference < -10) {
                System.out.println("Way to low! Guess again.\n");
            } else {
                System.out.println("Too low! Guess again.\n");
            }
        }
    }

    private static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    private static int getIntWithinRange(Scanner sc, String prompt,
            int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println("Error! Number must be greater than " + min);
            } else if (i >= max) {
                System.out.println("Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    private static String getRequiredString(Scanner sc, String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }

    private static String getChoiceString(Scanner sc, String prompt,
            String s1, String s2) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getRequiredString(sc, prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
    }
	
    /*private static void displayWelcome(int limit) {
        System.out.println("Guess the number!");
        System.out.println("I'm thinking of a number from 1 to " + limit);
        System.out.println();
    }
    
    public static int getRandomInt(int limit) {
        double d = Math.random() * limit;   // d is >= 0.0 and < limit
        int randomInt = (int) d;            // convert double to int
        randomInt++;                        // int is >= 1 and <= limit
        return randomInt;
    }

    public static void main(String[] args) {
        final int LIMIT = 10;
        
        displayWelcome(LIMIT);
        int number = getRandomInt(LIMIT);

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);            
        int count = 1;
        while (true) {
            System.out.print("Your guess: ");
            int guess = 0;
           /* try{
            	guess = sc.nextInt();
            }
            catch (InputMismatchException ime) {
				System.out.println("Error... please enter a valid integer.");
				sc.nextLine();
				continue;
            }
            if(sc.hasNextInt()) {
            	guess=sc.nextInt();
            	sc.nextLine();
            }
            else {
            	System.out.println("Error! Please enter a valid interger");
            	sc.nextLine();
            	continue;
            }
            	
            
            if (guess < 1 || guess > LIMIT) {
                System.out.println("Invalid guess. Try again.");
                continue;
            }
            
            if (guess < number) {
                System.out.println("Too low.");
            } else if (guess > number) {
                System.out.println("Too high.");
            } else {
                System.out.println("You guessed it in " + 
                                   count + " tries.\n");
                break;
            }            
            count++;
        }
        System.out.println("Bye!"); 
    }   */
}