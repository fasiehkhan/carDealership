
//FASIEH KHAN
//500879628
package cps209A2;


public class ElectricCar extends Car
{
	//instance variables
  int    rechargeTime;//minutes
  String batteryType;
  
  //the constructor method below, initializes the instances variables and uses the supercall constructor (super()) to initialize inherited variables 
  // ElectricCar extends from class Car, the instance variables of class Car are inherited 
  public ElectricCar(String mfr, String color, Model model, Vehicle.PowerSource power, 
		     double safety, int range, boolean awd, int price, int rch,String batteryType, int VIN)
{
	  super(mfr, color, model, Vehicle.PowerSource.ELECTRIC_MOTOR, safety, range, awd, price, VIN);
	  rechargeTime = rch;
	  batteryType = "Lithium";
}
  
  //this method sets the recharge time to an argument it takes in
  public void setRechargeTime(int time)
  {
	  rechargeTime = time;
  }
  
  
  //this method sets the battery type to an argument it takes in
  public void batteryType(String type)
  {
	  batteryType = type;
  }
  
//this method overrides the display() method in class Car and returns a string with information related to a Car object 
  //in this case the Car object behaves like an electric car
  public String display()
  {
	  return super.display() + " " + "EL, BAT: " + batteryType + " RCH: " + rechargeTime;
  }
}

