//FASIEH KHAN
//500879628
package cps209A2;

import java.util.LinkedList;
import java.util.Random;
import java.util.ListIterator; 

public class SalesTeam 
	{
	LinkedList<String> llobj = new LinkedList<String>();

	//this method initalizes the arguments which are strings and the names of the salespersons
		public SalesTeam(String Loki, String Thor, String Thanos, String Stark, String Scooby)
		{
			llobj.add(Loki);
			llobj.add(Thor);
			llobj.add(Thanos);
			llobj.add(Stark);
			llobj.add(Scooby);
		}
		//this method uses a random integer and searches through the linked list and returns a String with that random int as its index #
		public String RandoSP()
		{
			Random robj = new Random();
			int SP = robj.nextInt(llobj.size());
			return llobj.get(SP);
		}
		
		// this method returns a string of salespersons names
	public String displayNames()
	{
		String SPN = null;
		ListIterator<String> iterator = null;
		iterator = llobj.listIterator();
		while(iterator.hasNext()) {
			SPN = iterator.next();
		}
		return SPN;
		
	}

	}
