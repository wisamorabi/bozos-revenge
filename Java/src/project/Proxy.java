package project;

import java.io.IOException;

public class Proxy implements Runnable, Observer {

	Dispatcher d;
	byte id;
	Game game;

	Proxy(Dispatcher d, byte id, Game g) throws IOException, InterruptedException{

		//Set the ID and the dispatcher being used for the proxy.
		//The game instance also.
		this.d = d;
		this.id = id;
		game = g;

		//register yourself as a proxy with the dispatcher
		d.register(this, id);

		//start your thread
		new Thread(this).start();
	}


	public void run()
	{
		//DEPRECATED.
		//There is no reason to use threads for the proxy
		//Given that process_message exists as a callback function.
	}
	//Callback function gets called by the dispatcher when a
	//message gets received. This will send the message to
	//The game class.
	public void process_message(Msg message) throws IOException
	{
		game.receive(message);
	}
	//Sends message from game.java to dispatcher.
	//Also capable of skipping game.java by being called from the Java states
	public void send_msg(Msg msg) throws IOException {
		// Tell the dispatcher to send your message
		d.send_msg(msg);
	}
}
