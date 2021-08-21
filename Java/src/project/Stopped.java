package project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//This state is when the game is lost. It moves to the running game state when it receives the code
//corresponding to that from the microcontroller.
public class Stopped implements State
{
	int number;
	Scanner input; //Scanner variable
	//Constructor
	Stopped()

	{
		input = new Scanner(System.in);
	}
	public void handlestate(Context context) throws IOException
	{
		//Ask user for difficulty then choose the appropriate class from the template pattern.

		do {
			InputStreamReader streamReader = new InputStreamReader(System.in); //Input Stream (Reader)
			BufferedReader bufferedReader = new BufferedReader(streamReader); //Buffered input Stream (Reader)
			AudioPlayer.INTRO.play(); //"PLEASE CHOOSE THE DESIRED DIFFICULTY LEVEL!"
			System.out.println("Please enter the number corresponding to your desired difficulty level:");
			System.out.println("1. Easy");
			System.out.println("2. Medium");
			System.out.print("3. Hard\n>> ");

			try {
				number = Integer.parseInt(bufferedReader.readLine()); //User types in desired difficulty level
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Which difficulty class to be called:
		} while(number > 3 || number < 1);

		if (number == 1)
		{
			StartGameEasy startgame = new StartGameEasy(context);
			startgame.startGameSequence();
		}
		else if (number == 2)
		{
			StartGameMedium startgame = new StartGameMedium(context);
			startgame.startGameSequence();
		}	
		else if (number == 3)
		{
			StartGameHard startgame = new StartGameHard(context);
			startgame.startGameSequence();
		}
	}

	public void printStatus()
	{
		System.out.println("Game Over");
	}
}
