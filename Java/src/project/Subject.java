package project;


import java.io.IOException;

//Subject interface for the observer (Dispatcher)
public interface Subject {
	void register(Proxy proxy, int ID) throws IOException;
	void remove(Proxy proxy, int ID) throws IOException;
}
