package project;

import java.io.IOException;

//This state is when the game is running and the player did not lose yet.
public class Running implements State
{
	int score = 0;
	public void handlestate(Context context)
	{
		//Message coming from game logic microcontroller
		if (context.msgID == 0)
		{
			if (context.Payload == 0b001010) //Indicating GAME LOST
			{
				AudioPlayer.SONG.stop(); //Stop music
				AudioPlayer.LOSE.play(); //Play losing soundtrack
				printStatus(); //Print final score
				score = 0; //Reset score


				/////////WAIT FOR AUDIO TO FINISH/////////
				try {
					java.util.concurrent.TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				/////////////////////////////////////////////
				context.setState(new Stopped()); //Set the new state to game stopped

				try {
					Msg msg = new Msg(); //Make garbage message to be able to use nextState function
					context.nextState(msg); //Lets context call the handleState function of stopped
					//So player can choose difficulty and restart game
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (context.Payload == 0b001001) //Indicating Bozo attacked
			{
				AudioPlayer.ATTACK.play(); //Plays sword swing sound
				//No delay required.
			}
		}

		//This is the message from the glove to add the scores.
		if (context.msgID == 1)
		{
			AudioPlayer.SCORE.play(); //No delay required.
			//Depending on the speed (payload) received, the score is increased accordingly.
			if (context.Payload == 0b00000000) { printStatus(); }
			else if (context.Payload == 0b000001)  { score += 1; printStatus(); }		
			else if (context.Payload == 0b000010)  { score += 2; printStatus(); }		
			else if (context.Payload == 0b000011)  { score += 3; printStatus(); }	
			else if (context.Payload == 0b000100)  { score += 4; printStatus(); }
			else if (context.Payload == 0b000101)  { score += 5; printStatus(); }
		}	
	}



	public void printStatus()
	{
		System.out.println("Score: " + score); //Print Status… Which is printing the score in this case!
	}

}

