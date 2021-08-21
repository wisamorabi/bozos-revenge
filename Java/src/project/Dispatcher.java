package project;

import java.io.IOException;
import java.util.ArrayList;

import jssc.SerialPort;
import jssc.SerialPortException;

public class Dispatcher implements Runnable, Subject {

	Hash hashmap; //To make an instance of the hashmap class we have later in the constructor
	ArrayList<Proxy> proxies; // need to keep track of proxies 
	SerialPortHandle sph; //For creating an instance of serial port handle in the constructor
	Msg message; //The message instance that will be used to handle the messages being received throughout the entire thing

	Dispatcher()
	{
		hashmap = new Hash(); //Making instance of the hash class we created
		SerialPortHandle sph = new SerialPortHandle("/dev/cu.usbserial-A700eE9V"); //Serial port being used in the instance of serial port handle
		this.sph = sph; //Setting the serial port handle field to the serial port handle instance we created.
		message = new Msg(); //Creating instance of message to be sent later
		//The reason we do this is so that here is so that we do not have to create
		//a new instance of message for every message received.
		//We just use one instance that changes according to the message received.
		proxies = new ArrayList<Proxy>(); //create an array list to remember proxies 
		new Thread(this).start(); //Start the dispatcher thread (To cause run() to.. run)
	}


	//Add a new proxy to your list of known proxies
	//And add it to the hashmap also
	public void register(Proxy proxy, int ID) throws IOException
	{
		Debug.trace("Adding "+proxy+" to list of proxies known to "+this);
		proxies.add(proxy);
		hashmap.register(ID, proxy);
	}

	//Remove proxy from your list of known proxies
	//And remove it from the hashmap also
	public void remove(Proxy proxy, int ID) throws IOException
	{
		Debug.trace("Removing "+proxy+" from list of proxies known to "+this);
		int i = proxies.indexOf(proxy);
		if (i >= 0) proxies.remove(i);
		hashmap.remove(ID);
	}


	//The message that will be sent to the microcontrollers (Glove is what actually cares about those messages!)
	public void send_msg(Msg message) throws IOException {
		System.out.println("DEBUG Sent " + message.getPayload());
		Byte toSend = (byte) (message.msgID + message.Payload); //Combines the message ID and payload into one full byte.
		sph.printLine(toSend); //Calling the printLine function provided by Mr. Suresh
	}

	//The run function which is what will run while everything else in the Java code is also running (Multithreading implementation over here).
	public void run() {

		//Infinite loop to read what's incoming.
		while(true) {
			String buffer = sph.readLine();
			System.out.println("[DEBUGGING] Received " + buffer); //[DEBUGGING]
			//Parsing the received string into a byte
			byte received = Byte.parseByte(buffer);



			message.setIDandPayload(received); //Creating the ID number

			//Loopback only if received from microcontroller
			//Does not loopback anything sent by the glove as it is
			//Of no use to either microcontrollers.
			try {
				if (message.msgID == 0) //Only allows messages with ID = 0 to be looped back
				{
					send_msg(message);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			Proxy proxytoUse = hashmap.get(message.getID()); //Chooses proxy to use depending on the ID (Key in the hashmap which maps to the proxies)
			try {
				proxytoUse.process_message(message); //Callback function of the correct proxy is used to pass the message to the game logic eventaully.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
}





//Code for handling the serial port.
//PROVIDED by Mr. Suresh.
class SerialPortHandle {

	SerialPort sp;
	String path;

	public SerialPortHandle(String path) {
		super();
		this.sp = new SerialPort(path);
		this.path = path;
		try {
			sp.openPort();
			sp.setParams(9600, 8, 1, 0);
		} catch (SerialPortException e) {
			e.printStackTrace();
		}// Open serial port

	}

	public String readLine() {
		StringBuffer string = new StringBuffer();
		boolean quit = false;
		while (!quit) {
			byte[] buffer;
			try {
				buffer = sp.readBytes(1);
				// Read 1 bytes from serial port
				if (buffer[0] != 13) {
					string.append((char) (buffer[0]));
				}
				if (buffer[0] == 13) {
					// Read the following 10 character
					sp.readBytes(1);
					quit = true;
				}

			} catch (SerialPortException e1) {
				e1.printStackTrace();
			}

		}
		return string.toString();
	}

	public void printLine(Byte msg) {
		try {
			sp.writeByte(msg);
		} catch (SerialPortException e1) {
			e1.printStackTrace();
		}

	}

}	
