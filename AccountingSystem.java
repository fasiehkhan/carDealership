//FASIEH KHAN
//500879628
package cps209A2;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class AccountingSystem 
{
	
	//an arraylist holding Transaciton objects is created
	//a transaction object is created
	ArrayList<Transaction> trans = new ArrayList<Transaction>();
	 Transaction obj = new Transaction();

	 //this add method takes in arguments int, Car, String, etc and returns a string with all the transaction info
	public String add(int id, Calendar date, Car car, String salesPerson, String type, double salePrice) 
		{
		
		 Transaction TOBJ = new Transaction();

			if(type.equals("BUY")) 
		{
			Random ew = new Random();
			  id = ew.nextInt(100);
			 trans.add(TOBJ);

		}
			return TOBJ.display();
			
	}
	// this method takes in an int id as argument and returns the transaction with that id
	public Transaction getTransaction(int id)
	{
		for(int i =0; i<trans.size();i++)
		{
			if(id == trans.get(i).getID()) 
			{		
				return trans.get(i);
			}
		}
		
		return null;
	}

	
}

		

	


