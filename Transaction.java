//FASIEH KHAN
//500879628
package cps209A2;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;


public class Transaction 
	{
		double salePrice;
		int id;
		Calendar date = new GregorianCalendar(); 
		Car car;
		String salesPerson = "";
		String type=""; 
		
		public Transaction() {}
		
		public int getID() {
			return id;
		}
		public Transaction(double salePrice, int id, Calendar date, Car car, String salesPerson, String type)
		{
			this.salePrice = salePrice;
			this.id =id;
			this.date = date;
			this.car = car;
			this.salesPerson = salesPerson;
			this.type = type;
		}
		
		public String display()
		{
			SimpleDateFormat dateform = new SimpleDateFormat(Calendar.DAY_OF_WEEK+" MMM dd,yyyy");
			return "ID: " + id + " " + dateform + " " + type +" "+"SalesPerson: " + salesPerson+" Car: VIN: "+ car;
		}
	 
	
	

    }
