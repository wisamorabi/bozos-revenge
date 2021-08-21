package project;

import java.io.IOException;


//The game requires no thread as it is synchronized with
//Whatever it receives from the proxies.
//It does not ask for anything. It just has its call-back function used
//By the proxies when required. (When the proxies receive a message from the dispatcher).

public class Game{
	Context context;

	Game() throws IOException, InterruptedException
	{
		AudioPlayer.init(); //Pre-load all the sound files to prevent delays due to loading mid-game.
		Debug.tracefile("debugtrace.txt"); //Creating a debugtrace file in case it is used.
		// Create a dispatcher
		Dispatcher d = new Dispatcher();
		Proxy p0 = new Proxy(d, (byte) 0b00000000, this);
		Proxy p1 = new Proxy(d, (byte) 0b00000001, this);

		context = new Context(p0); //Creating the instance of context we will be using
		//For the entire game.
		//Must pass the game logic's microcontroller's proxy as it will be used to send
		//Flags from the Java game states to the game logic microcontroller (Proxy ID = 0)
	}


	//Callback function which is used by the proxies.
	//To give the game class the messages they receive
	//From the dispatcher. This message is then sent to the
	//Context.
	public void receive(Msg message) throws IOException
	{
		context.nextState(message);
	}
}
