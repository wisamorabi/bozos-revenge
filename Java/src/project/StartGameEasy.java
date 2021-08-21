package project;

public class StartGameEasy extends StartGame {
	//Calls super constructor
	StartGameEasy(Context context)
	{
		super(context);
	}


	@Override
	void playDifficultySound()
	{
		AudioPlayer.EASY.play(); //"YOU HAVE CHOSEN EASY!"
		/////////WAIT FOR AUDIO TO FINISH/////////
		try {
			java.util.concurrent.TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////////
	}

	@Override
	void createMsg() 
	{
		//Payload is decimal 4 for easy mode.
		msg.setIDandPayload((byte)(0b00000100));
	}


}
