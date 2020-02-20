import java.util.Scanner;
import java.text.DecimalFormat;

public class GumballMachine {
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double balance = 0.0;
		int redGumball = 0;
		int yellowGumball = 0;
		System.out.println("Please insert coin(s) .05, .10, .25.");
		System.out.println("Enter '1' in order to proceed to the gumball menu");
		System.out.println("Enter '2' to return change");
		while (scan.hasNext()) {
			String input = scan.next();

//			 Checks to see if input is valid
			if (input.equals(".05") || input.equals(".1") || input.equals(".25")) {
				double coin = Double.parseDouble(input);
				balance += coin;
				System.out.println("Total Balance: " + df.format(balance));
			} else if (input.equals("1")) {
				System.out.println("Red Gumball: 0.05, Yellow Gumball: 0.10");
				System.out.println("Enter 'exit' to leave the gumball menu'");
				System.out.println("Please enter what color gumball you would like to purchase: ");

				while (scan.hasNext()) {
					String color = scan.next().toLowerCase();
//					doubles aren't reliable for a straight 0 answer here
					if (balance < 0.01) {
						System.out.println("Insufficient funds.");
						System.out.println("Please insert more coin(s) .05, .10, .25.");
						System.out.println("Enter '1' in order to proceed to the gumball menu");
						System.out.println("Enter '2' to return change");
						break;
					}

					if (color.equals("red")) {
						redGumball++;
						System.out.println("Red Gumball dispensing...");
						balance = balance - 0.05;
						System.out.println("Total Balance: " + df.format(balance));

					}

					else if (color.equals("yellow")) {

						yellowGumball++;
						System.out.println("Yellow Gumball dispensing...");
						balance = balance - 0.10;
						System.out.println("Total Balance: " + df.format(balance));

					}

					else if(color.equals("exit")) {
						System.out.println("Please insert coin(s) .05, .10, .25.");
						System.out.println("Enter '1' in order to proceed to the gumball menu");
						System.out.println("Enter '2' to return change");
						break;
					}
				}
			} 
			
			else if (input.equals("2") && balance > 0) {
				System.out.println("Balance: " + balance);
				System.out.println("Change dispensing...");
				break;
			}
			else if(input.equals("exit")) {
				break;
			}
			else {
				System.out.println("Please enter a valid input value!");
			}
		}
		System.out.println("Total red gumballs dispensed: " + redGumball);
		System.out.println("Total yellow gumballs dispensed: " + yellowGumball);

	}
}
