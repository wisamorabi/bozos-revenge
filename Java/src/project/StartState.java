package project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//This is the start state that can only be visited one. It moves to the running state when it receives a message from the microcontroller telling it to do so.
//It cannot be visited again because it is the start state.
public class StartState implements State {
	int number;
	Scanner input;
	public void handlestate(Context context) throws IOException {
		do {

			//Ask user for difficulty then choose the appropriate class from the template pattern.

			AudioPlayer.INTRO.play();
			System.out.println("Please enter the number corresponding to your desired difficulty level:");
			System.out.println("1. Easy");
			System.out.println("2. Medium");
			System.out.print("3. Hard\n>> ");
			InputStreamReader streamReader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(streamReader);
			try {
				number = Integer.parseInt(bufferedReader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
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

	@Override
	public void printStatus() {
		System.out.println("The program has started.");

	}

}
