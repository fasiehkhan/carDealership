//FASIEH KHAN
//500879628


package cps209A2;

import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Scanner;
public class Car extends Vehicle implements Comparable<Car>
{
  
	public static enum Model
	  {
		  SEDAN, SUV, SPORTS, MINIVAN;
	  }
	  
	  Model   model; 
	  int     maxRange; 
	  double  safetyRating;
	  boolean AWD;
	  double  price;
	  
	  public Car()
	  {
		  this.model = Model.SEDAN;
	  }
	  
	  public Car(String mfr, String color, Model model, Vehicle.PowerSource power, 
			     double safety, int range, boolean awd, double price, int VIN)
	  {
		  super(mfr, color, 4, power, VIN);
		  this.model = model;
		  this.price = price;
		  AWD = awd;
		  safetyRating = safety;
		  maxRange = range;
	  }
	  
	// this method overrides the display() method in class Vehicle and returns a string with information related to a Car object 

  public String display()
  {
	  return super.display() + " " + model + " " + price + "$" + " SF: " + safetyRating + " RNG: " + maxRange;
  }
  
  public String toString()
  {
	return "";
  }
  
    
    //this method returns the VIN # of a car object(used in CarDealership)
    public int getVIN() {return VIN;}

	
    //this is a get method which returns the safetyRating of the car object (double)
	public double getSafetyRating() 
	{
		return safetyRating; 
	}
	
    //this is a get method which returns the maxRange of the car object (double)

	public int getMaxRange() {
		return maxRange; 
	}
		
	
	//this method compares the this Car object with other Car object and returns a boolean 
	// equivalence is based on whether the model type is same and if both Car objects are AWD(AllWheelDrive)
    public boolean equals(Object other){
        Car other1 = (Car) other;
        if(super.equals(other) == true){
            if( model == other1.model && AWD == other1.AWD){
                return true;
            }
        }
        return false;
    }

   // the Car class implements the Comparable interface and as a result the compareTo method takes in a Car object (other), casts it, and then compares the objects on the basis of price
    public int compareTo(Car other){
        Car other1 = (Car) other;
        if(price < other1.price) {return 1;}
        if(price > other1.price) {return -1;}
        return 0; 

    }
    	
    }

    
