package project;

import java.io.IOException;

//this class control the flow of states.
public class Context
{
	int msgID; //Stores ID of the message received from the Microcontroller
	int Payload; //Stores ID of the message received from the Microcontroller
	State state; //Current state
	Proxy p0; //After the player chooses the difficulty level,
	//this will be passed to the StartGame class later
	//to send the difficulty flag to the proxy and then
	//eventually to the dispatcher and then microcontroller
	//to begin the game
	Context(Proxy p0) throws IOException //Proxy must now be passed.
	{
		this.p0 = p0;
		state = new StartState(); //Initial State
		state.handlestate(this);
	}
	public void nextState(Msg message) throws IOException
	{
		//Sets the fields according to the message
		msgID = message.msgID;
		Payload = message.Payload;
		state.handlestate(this); //Calls the handle state function which lets the current state
		//act according to the data received.
	}

	void setState(State state)
	{
		this.state = state;
	}
}
