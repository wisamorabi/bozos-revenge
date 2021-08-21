package project;

public class StartGameHard extends StartGame {
	//Calls super constructor
	StartGameHard(Context context)
	{
		super(context);
	}
	//Overriden functions are the ones with different content than other StartGame children
	@Override
	void playDifficultySound()
	{
		/////////WAIT FOR AUDIO TO FINISH/////////
		AudioPlayer.HARD.play(); //"YOU HAVE CHOSEN HARD!"
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
		//Payload is decimal 6 for hard mode.
		msg.setIDandPayload((byte)(0b00000110));
	}

}
