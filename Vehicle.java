//FASIEH KHAN
//500879628
package cps209A2;

import java.util.Random;

public class Vehicle 
{
	

	public enum PowerSource
	{
		GAS_ENGINE, DIESEL_ENGINE, ELECTRIC_MOTOR;
	}
	
	public PowerSource power;
	String mfr;
	String color;
	int    numWheels;
	int VIN;
	public Vehicle()
	{
		this.mfr = "";
	}
	
	public Vehicle(String mfr, String color, int numWheels, PowerSource power, int VIN)
	{
	  this.mfr     = mfr;
	  this.color     = color;
	  this.numWheels = numWheels;
	  this.power     = power;
		// a Random object is created so that an integer between 100 and 499 is randomly assigned to IV VIN
			Random rand = new Random();
			this.VIN = rand.nextInt(400);
	
	}
   // the following method takes an object type Object as a parameter and returns true if the Vehicle objects are equivalent and false when they are not
   // equivalency is determind by the mfr, power and numWheels variables
   public boolean equals(Object other){
	Vehicle other1 = (Vehicle) other;
	if(mfr.equals(other1.mfr) && power == other1.power && numWheels == other1.numWheels)
	{
		return true;  
	}
	return false;
   }
   //this method  takes in no parameters and returns a string with information related to a Vehicle object 

   public String display(){
	return 	"VIN: " + VIN +" "+mfr+" "+color;
        }
     

}






































/*
public class Vehicle extends CarDealershipSimulator
{
	//instance variable 
	private String mfr;
	private String color;
	private int power;
	private int numWheels;
	int ELECTRIC_MOTOR = 0;
	int GAS_ENGINE = 1;
	 int VIN;

	//this constructor method intitalizes instance variables
	public Vehicle(String mfr, String color, int power, int numWheels, int VIN)
	{
		this.mfr = mfr;
		this.color = color;
		this.power = power;
		this.numWheels = numWheels;
		// a Random object is created so that an integer between 100 and 499 is randomly assigned to IV VIN
		Random rand = new Random();
		this.VIN = rand.nextInt(400);
    }

	// the following are get set methods which create methods which when called return the value of a certain variable
	public String getMfr()
	{
	return mfr; 
	}
	public void setMfr(String mfr)
	{
    this.mfr = mfr; 
	}
   public String getColor()
   {
	return color;
   }
   public void setColor(String color)
   {
    this.color = color;
   }	
   public int getPower()
   {
    return power;
    
   }
   public void setPower(int power)
   {
    this.power = power;
   }
*/