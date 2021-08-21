package project;

import java.util.Hashtable;
//This class is to handle the hash table
//Without it cluttering the game thread
//With homeless/Randomly placed looking code.
public class Hash {
	Hashtable<Integer, Proxy> hash;
	Hash()
	{
		hash = new Hashtable<Integer, Proxy>();
	}
	void register(int id, Proxy p)
	{
		hash.put(id, p);
	}
	void remove(int id)
	{
		hash.remove(id);
	}
	Proxy get(int choice)
	{
		return hash.get(choice);
	}
}
