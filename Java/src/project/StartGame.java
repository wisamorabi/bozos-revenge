package project;

import java.io.IOException;

//Template design pattern implementation!
public abstract class StartGame {
	Context context; //Needs this to be able to move states using context
	Msg msg; //The message containing the flag

	//Constructor
	StartGame(Context context)
	{
		msg = new Msg();
		this.context = context;
	}

	//The "Recipe" of starting the game.
	//Common to all game difficulties
	final void startGameSequence() throws IOException
	{
		gotoRunningState();
		createMsg();
		playDifficultySound();
		playMusic();
		sendDifficultyFlag();
	}
	//1. Set the game state to running
	void gotoRunningState()
	{
		context.setState(new Running());
	}

	//2. [ABSTRACT - IMPLEMENTED IN CHILDREN]: Creates the message with the correct difficulty flag
	//Depending on the child
	abstract void createMsg();

	//3. [ABSTRACT - IMPLEMENTED IN CHILDREN]: Plays the sound effect corresponding to the difficulty
	//Level, depending on the child
	abstract void playDifficultySound();


	//4. Sends the message to the proxy which eventually leads to the microcontrollers.
	void sendDifficultyFlag() throws IOException
	{
		context.p0.send_msg(msg);
	}

	//5. Starts the game atmosphere, regardless of difficulty
	//And plays some sick battle music
	void playMusic()
	{
		AudioPlayer.PREPARE.play(); //"PREPARE TO FACE BOZO!"
		/////////WAIT FOR AUDIO TO FINISH/////////
		try {
			java.util.concurrent.TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////////
		/////////WAIT FOR AUDIO TO FINISH/////////
		AudioPlayer.EVIL.play(); //BOZO LAUGHS
		try {
			java.util.concurrent.TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////////
		AudioPlayer.SONG.playbackgroundsong(); //MUSIC COMMENCES
	}

}
