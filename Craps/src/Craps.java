import java.util.Random;

public class Craps
	{
	private static Random randomNumber = new Random();
	private static int die1Roll;
	private static int die2Roll;
	private static int bothDiceTotal;
	private static enum Status {WIN, LOSE, CONTINUE}
	private static int myPoint;
	
	public static int rollDice()
		{
		die1Roll = 1 + randomNumber.nextInt(6);
		die2Roll = 1 + randomNumber.nextInt(6);;
		bothDiceTotal = die1Roll + die2Roll;
		
		System.out.println("You rolled a " + die1Roll + " and a " + die2Roll
				+ " for a total of " + bothDiceTotal);
		return bothDiceTotal;
		}
	
	public static void play()
		{
		myPoint = 0;
		rollDice();
		Status gameStatus;
		
			switch (bothDiceTotal)
			{
			case 2:
			case 3:
			case 12:
				{
				gameStatus = Status.LOSE;
				break;
				}
			case 7:
				{
				gameStatus = Status.WIN;
				break;
				}
			default:
				{
				gameStatus = Status.CONTINUE;
				myPoint = bothDiceTotal;
				System.out.println("Your point is " + myPoint);
				System.out.println();
				}
			}
			
		while (gameStatus == Status.CONTINUE)
			{
			bothDiceTotal = rollDice();
			System.out.println();
			
			if (bothDiceTotal == myPoint)
				{
				System.out.println("You made your point");
				gameStatus = Status.WIN;
				}
			else if (bothDiceTotal == 7)
				{
				gameStatus = Status.LOSE;
				}
			}
		
		if (gameStatus == Status.LOSE)
			{
			System.out.println("You lose");
			}
		else if (gameStatus == Status.WIN)
			{
			System.out.println("You win");
			}
		else 
			{
			rollDice();
			}
		}
	}
