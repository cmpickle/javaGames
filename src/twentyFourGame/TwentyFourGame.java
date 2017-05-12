package twentyFourGame;

import java.util.Random;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * A program that randomly chooses and displays four digits, each from one to nine, with repetitions allowed. The
 * program prompts for the player to enter an arithmetic expression using just those, and all of those four digits, used
 * exactly once each. The program should check then evaluate the expression. The goal is for the player to enter an
 * expression that evaluates to 24
 * 
 * Only multiplication, division, addition, and subtraction operators/functions are allowed. 
 * Division uses rational arithmetic to preserve remainders.
 * Brackets are allowed.
 * Forming multiple digit numbers from the supplied digits is disallowed. (So an answer of 12+12 when given 1, 2, 2, and 1 is wrong). 
 * The order of the digits when given does not have to be preserved.
 * 
 * @author Cameron Pickle
 *
 */
public class TwentyFourGame {

	public static void main(String[] args) throws ScriptException
	{
		System.out.println("You must create an arithmetic expression using all four given numbers that totals 24.");
		System.out.println();
		System.out.println("The rules are:");
		System.out.println("Only multiplication, division, addition, and subtraction operators/functions are allowed.");
		System.out.println("Brackets are allowed.");
		System.out.println("Forming multiple digit numbers from the supplied digits is disallowed. (So an answer of 12+12 when given 1, 2, 2, and 1 is wrong).");
		System.out.println("The order of the digits when given does not have to be preserved.");
		System.out.println();
		Start: while (true)
		{
			int[] nums = new int[4];
			boolean[] check =
			{ false, false, false, false };
			boolean currentIsNumber = false;
			String input;
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");

			System.out.print("Compute a arithmetic expression with the four numbers ");

			nums = generateNumbers();

			System.out.println(nums[0] + ", " + nums[1] + ", " + nums[2] + ", "
					+ nums[3] + " to compute the number 24.");

			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);

			while (in.hasNext())
			{
				input = in.nextLine();

				for (int i = 0; i < input.length(); i++)
				{
					/***********************************************
					 * Make sure each given number is only used once
					 ***********************************************/
					if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& Character.getNumericValue(input
									.charAt(i)) == nums[0]
							&& !check[0])
					{
						check[0] = true;
					} else if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& Character.getNumericValue(input
									.charAt(i)) == nums[1]
							&& !check[1])
					{
						check[1] = true;
					} else if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& Character.getNumericValue(input
									.charAt(i)) == nums[2]
							&& !check[2])
					{
						check[2] = true;
					} else if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& Character.getNumericValue(input
									.charAt(i)) == nums[3]
							&& !check[3])
					{
						check[3] = true;
					} else if ((input.charAt(i) > 47 && input.charAt(i) < 58))
					{
						System.out.println("Invalid Input");
						continue Start;
					}

					/***********************************************
					 * Check if the char is a valid symbol and if the char is a number check if it
					 * is one of the four given
					 ***********************************************/
					if (!(input.charAt(i) > 39 && input.charAt(i) < 58
							&& input.charAt(i) != 44 && input.charAt(i) != 46))
					{
						System.out.println("Invalid Input");
						continue Start;
					} else if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& !(Character.getNumericValue(input
									.charAt(i)) == nums[0]
									|| Character.getNumericValue(input
											.charAt(i)) == nums[1]
									|| Character.getNumericValue(input
											.charAt(i)) == nums[2] || Character
									.getNumericValue(input
											.charAt(i)) == nums[3]))
					{
						System.out.println("Invalid Input");
						continue Start;
					}

					/***********************************************
					 * Make sure that each digit is used in singularly
					 ***********************************************/
					if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& !currentIsNumber)
						currentIsNumber = true;
					else if (!(input.charAt(i) > 47 && input.charAt(i) < 58))
					{
						currentIsNumber = false;
					} else if ((input.charAt(i) > 47 && input.charAt(i) < 58)
							&& currentIsNumber)
					{
						System.out.println("Invalid Input");
						continue Start;
					}
				}

				/************************************
				 * Checks if the User's input computes 24
				 ***********************************/
				if ((double) engine.eval(input) == 24.0)
					System.out.println("Correct! You did it! You got 24!");
				else
					System.out.println("Incorrect, you got "
							+ (double) engine.eval(input));
				continue Start;
			}
		}

	}

	/**
	 * Generates four random ints from 1-9 and returns them in a int[]
	 * 
	 * @return --the four random ints in the int[]
	 */
	public static int[] generateNumbers()
	{
		Random rand = new Random();
		int[] nums = new int[4];

		for (int i = 0; i < 4; i++)
			nums[i] = rand.nextInt(9) + 1;

		return nums;
	}
}
