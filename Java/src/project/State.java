package project;

import java.io.IOException;

//This is the state interface that has the functions which
//will behave differently depending on the state, but
//every single state will contain them.
public interface State
{
	void handlestate(Context context) throws IOException;
	void printStatus();
}
