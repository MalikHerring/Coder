import java.util.Scanner;

public class PhraseCoderCL {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan;
		String input;
		int letter, decodedLetter, codedLetter;
		System.out.println("Do you have an encoded phrase?");
		scan = new Scanner(System.in);
		if (scan.hasNextLine()){
			input = scan.nextLine();
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")){ //Checks if they have an encoded phrase
				System.out.println("Okay, please enter your phrase");
				scan = new Scanner(System.in);
				input = scan.nextLine();
				for (int i = 0; i < input.length(); i++){
					if (input.charAt(i) == ' '){ //prints a space if the character is a space
						System.out.print(" ");
					} else {
						char character = input.charAt(i);
						letter = (int)character;
						decodedLetter = (letter + 10); //reverts character change
						System.out.print((char)decodedLetter); //prints out decoded message
					}
				}
				scan.close();
			} else {
				System.out.println("Please enter the phrase you wish to be coded");
				scan = new Scanner(System.in);
				input = scan.nextLine();
				for (int i = 0; i < input.length(); i++){
					if (input.charAt(i) == ' '){
						System.out.print(" ");
					} else {
						char character = input.charAt(i);
						letter = (int)character;
						codedLetter = (letter - 10); //changes the character
						System.out.print((char)codedLetter); //prints out coded message
					}
				}
				
			}
		} else {
			System.err.println("Incorrect response, good bye");
			System.exit(0);
		}
		
		scan.close();
	}

}
