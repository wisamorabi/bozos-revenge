package project;


public class StartGameMedium extends StartGame {
	//Calls super constructor
	StartGameMedium(Context context)
	{
		super(context);
	}
	//Overriden functions are the ones with different content than other StartGame children

	@Override
	void playDifficultySound()
	{
		/////////WAIT FOR AUDIO TO FINISH/////////
		AudioPlayer.MEDIUM.play();
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
		//Payload is decimal 5 for medium mode.
		msg.setIDandPayload((byte)(0b00000101));
	}

}
