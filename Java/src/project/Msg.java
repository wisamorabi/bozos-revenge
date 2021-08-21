package project;



//This class is used to split any recieved code/message
//into the corresponding hardware ID and payload which
//is the meaning to the message.
public class Msg {
	int Payload;
	int msgID;

	Msg()
	{
		msgID = -1;
		Payload = -1;
	}

	//Setters and getters.
	public int getID()
	{
		return msgID;
	}



	public int getPayload()
	{
		return Payload;
	}
	public void setPayload(int payload)
	{
		Payload = payload;
	}
	public void setID(int iD) {
		msgID = iD;	
	}
	//Function to dissect the data received
	//and converting it to a message instance
	public void setIDandPayload(byte received)
	{
		msgID = ((received & (0b11000000)) >> 6); //Creating the ID of the message using ANDing and Bit Shifting

		Payload = (byte) (received & 0b00111111); //Creating the payload while removing the ID bits.
	}

}
