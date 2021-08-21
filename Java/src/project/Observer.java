package project;

import java.io.IOException;

//This interface is to implement the functions
//That all the observers (Proxies) have.
//Which are:
//process_message which moves the message
//From the dispatcher to the game thread.
//send_msg which moves the message
//From the game thread OR states to the dispatcher
public interface Observer
{
	void process_message(Msg message) throws IOException;
	void send_msg(Msg msg) throws IOException;
}
