//FASIEH KHAN
//500879628
package cps209A2;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Random;

public class CarDealership{
	
	//instance variables 
	 ArrayList<Car> cars;
	 SalesTeam STobj; 
	 AccountingSystem Aobj; 
	 Transaction tobj;
	 ElectricCar eobj; 
	 //Filters
     boolean AWDFilter = false;  
     boolean electricFilter = false ;
     boolean priceFilter = false ;
    public  double minPrice = 0; 
    public  double maxPrice = 0;
	Random dates = new Random();

    

    //constructor method  creates an empty ArrayList of Car objects
     //instance variable cars acts as a refference to it
    public  CarDealership() 
    {
    	cars = new ArrayList<Car> ();
    	
    }
    
    //this method takes a referrence to an ArrayList as a parameter and adds the Car objects it refers to, to the instance variable 
    public void addCars(ArrayList<Car> newCars)
    {
         cars.addAll(newCars);
   	     newCars.clear();
        
    } 
    
    
    //this method takes a Car object as a parameter and checks to see if it is not null, then it adds the object to the ArrayList cars
    public void returnCar(Car car){
        if(car != null){
            cars.add(car);
        }
    }
    
    // this method prints information about car objects in the cars ArrayList
    // this method filters the cars using filter values
    
    public void displayInventory(){
    	//no filter is set 
    	for(int i = 0;i<cars.size();i++)
		{
    		Car car = cars.get(i);
    	
    		
    		if(AWDFilter && priceFilter && electricFilter) 
    		continue;
 
        //priceFilter is set, car objects will be filtered by price
    		if( priceFilter && minPrice < car.price || maxPrice > car.price) 
    			continue;
    	if( electricFilter == true&&car.power != Vehicle.PowerSource.ELECTRIC_MOTOR) //
    	{
    			ElectricCar carE = (ElectricCar) cars.get(i);
    			System.out.println(" " + carE.display());
    	}
    		 if(priceFilter  && electricFilter &&car.power != Vehicle.PowerSource.ELECTRIC_MOTOR&&minPrice < car.price && maxPrice > car.price)
    		{
    			ElectricCar carE = (ElectricCar) cars.get(i);
    			System.out.println(" " + carE.display() + car.display());
    		}

    		
    		 if(AWDFilter  && priceFilter &&minPrice < car.price && maxPrice > car.price&&!car.AWD)
    		continue;
    		 
    		if (AWDFilter  &&!car.AWD) 
    			continue;
    			 
    		 if(AWDFilter && electricFilter&&!car.AWD&&car.power != Vehicle.PowerSource.ELECTRIC_MOTOR)
    		 {
    			 ElectricCar carE = (ElectricCar) cars.get(i);
     			System.out.println(" " + carE.display());
    		 }
    	
				System.out.println(" " + car.display());

    }
    }

    
    //this method returns electricFilter's value
    public void filterByElectric() 
    {
    	electricFilter = true; 
    	
    		
    }
    //this method returns the pricefilters value
    public void filterByPrice(double minPrice, double maxPrice) 
    {
    	priceFilter = true;
    	this.minPrice = minPrice;
    	this.maxPrice = maxPrice; 
    }
    
    public void filterByAWD() 
    {
    	AWDFilter = true;
    }
    
    
    public void filtersClear() 
    {
    	AWDFilter = false;
    	electricFilter = false;
    	priceFilter = false; 
    }
    
    public void sortByPrice() 
    {
    	Collections.sort(cars);
    }
    
    //this method sorts the car objects using the comparator interface and anonymous inner classes
    // the cars are sorted based off safteyRating variable 
	public void sortBySafetyRating() {
		Comparator<Car> safetyRating = new Comparator<Car>()
				{
					public int compare(Car c1, Car c2)
					{
						if (c1.getSafetyRating()<c2.getSafetyRating()) {return -1;}
						else if (c1.getSafetyRating()>c2.getSafetyRating()) {return 1;}
						else {return 0;}
					}
				};
				Collections.sort(cars, safetyRating);
				}
				
	
    //this method sorts the car objects using the comparator interface and anonymous inner classes
	// the cars are sorted based off maxRange variable
	public void sortByMaxRange()
	{
		Comparator<Car> maxRange = new Comparator<Car>()
				{
					public int compare(Car c1, Car c2)
					{
						if (c1.getMaxRange()<c2.getMaxRange())
						{
							return -1;
						}
						else if (c1.getMaxRange()>c2.getMaxRange())
						{
							return 1;
						}
						else
						{
							return 0;
						}
					}
				};
				Collections.sort(cars, maxRange);
	}
	
	public String buyCar(int VIN)
	{
		Calendar cal = new GregorianCalendar(); 

		if(VIN <= 400 && cars.size()>0) {
		for(int i = 0; i< cars.size(); i++)
		{
			if(VIN == cars.get(i).getVIN())
			{
				cars.remove(i);
			}
		}
		
		STobj.RandoSP();
		SimpleDateFormat sdf = new SimpleDateFormat( Calendar.DAY_OF_WEEK +"MMM dd yyyy"); 
		cal.set(Calendar.MONTH, dates.nextInt(12));
		cal.set(Calendar.DAY_OF_MONTH, dates.nextInt(31));
		cal.set(Calendar.YEAR, 2019);
		}
		
		else 
		{        
			throw new IllegalArgumentException("Invalid VIN");
		}
			return Aobj.add(tobj.getID(), cal, tobj.car, STobj.RandoSP(), tobj.type, tobj.salePrice);
}
	
	
	public void returnCar(int transaction) 
	{
	 Aobj.getTransaction(transaction);	
	 Calendar cal2 = new GregorianCalendar();
	SimpleDateFormat format = new SimpleDateFormat( Calendar.DAY_OF_WEEK +"MMM dd yyyy"); 

	 cal2.set(Calendar.MONTH, dates.nextInt(12) + 1);
	 cal2.set(Calendar.DAY_OF_MONTH, dates.nextInt(31) + 1);
	 cal2.set(Calendar.YEAR, 2019);
	 Aobj.add(tobj.getID(), cal2, tobj.car, STobj.RandoSP(), tobj.type, tobj.salePrice);
	
	}
}

    
   //YooooooooOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOoooooooooooooooooooo	o		ooooo	o	o	o	ooooooooooooooo 
    
    
    
    
    
    
    
    
    
    /*
     *  public void displayInventory(){
    	//no filter is set 
    	if(AWDFilter == false && priceFilter == false && electricFilter == false ) 
    	{
    		for(int i = 0;i<cars.size();i++)
    		{
    				cars.get(i).display(); 
    	}
    	}
    	continue;
        //priceFilter is set, car objects will be filtered by price
    	 if(AWDFilter == false && priceFilter == true &&electricFilter == false) 
    	{
        	for(int i = 0;i<cars.size();i++)
        	{
        		if(minPrice <= cars.get(i).price && maxPrice >= cars.get(i).price)
       
                cars.get(i).display(); 

        }
        }
    	 continue; 
    	 if(AWDFilter == false  && priceFilter == false && electricFilter == true) { 
                for(int i = 0;i<cars.size();i++){
                	//Car is casted to ElectricCar to filter cars with battery
                	ElectricCar carFilter = (ElectricCar) cars.get(i);
                	if(carFilter.batteryType != null)
                	{
                    cars.get(i).display(); 

        	}
        	}
    	}
    	 continue; 
    	 if(AWDFilter == false && priceFilter == true && electricFilter == true) {
                for(int i = 0;i<cars.size();i++)
                {
                	ElectricCar carFilter = (ElectricCar) cars.get(i);
                	if(carFilter.batteryType != null && minPrice <= cars.get(i).price && maxPrice >= cars.get(i).price)
                	{
                    cars.get(i).display(); 
                	
                	}
        	}
        }
    	 continue; 
    	 if(AWDFilter == true && priceFilter == true && electricFilter == false){
        	        for(int i = 0;i<cars.size();i++){

        				if (cars.get(i).AWD != false && cars.get(i).price <= maxPrice && cars.get(i).price >= minPrice)
        				{
        					cars.get(i).display();
        				}
            }
    	}
    	 continue; 
    	 if(AWDFilter == true && priceFilter == false && electricFilter == false ) {
                for(int i = 0; i<cars.size();i++) 
                {
                	if(cars.get(i).AWD != false) 
                	{
    					cars.get(i).display();

        	}
        	
            }
        }
    	 continue; 
        	 if(AWDFilter == true && priceFilter == false && electricFilter == true)
                for(int i = 0;i<cars.size();i++){
                	ElectricCar carFilter = (ElectricCar) cars.get(i);
                	if(carFilter.batteryType != null && cars.get(i).AWD != false)
                	{
                    cars.get(i).display(); 
                	}
                }
        	//after going through all possibilities(2^3) all filters are set
        	else
        		{
        		for(int i = 0; i<cars.size();i++) {
        			ElectricCar filter_car = (ElectricCar) cars.get(i);
    				if (filter_car.batteryType != null && cars.get(i).AWD != false && cars.get(i).price <= maxPrice && cars.get(i).price >= minPrice)
    				{
    					cars.get(i).display();
    				}
    			System.out.println(""+ i + " " + car.display());

        		}
        	}

}
     */
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * newer one here 
 * public void displayInventory()
    {
    	for(int i = 0;i<cars.size();i++)
		{
			Car car = cars.get(i); 
			
	    	//no filter is set 
    	if(AWDFilter == false && priceFilter == false && electricFilter == false ) 
    	
            cars.get(i).display(); 

    	
    	
    	continue; 
        //priceFilter is set, car objects will be filtered by price
    	 
    	if(AWDFilter == false && priceFilter == true &&electricFilter == false) 
    	 
        	
        		if(minPrice <= cars.get(i).price && maxPrice >= cars.get(i).price)
       
                cars.get(i).display(); 

        
    	 
        
    	 continue; 
    	 if(AWDFilter == false  && priceFilter == false && electricFilter == true) 
                	//Car is casted to ElectricCar to filter cars with battery
                	ElectricCar carFilter = (ElectricCar) cars.get(i);
                	if(carFilter.batteryType != null)
                	
                    cars.get(i).display(); 

        	
        	
    	
    	 continue; 
    	 if(AWDFilter == false && priceFilter == true && electricFilter == true) 
    	 
                   if(carFilter.batteryType != null && minPrice <= cars.get(i).price && maxPrice >= cars.get(i).price)
                	
                    cars.get(i).display(); 
                	
    	 
                	
        	
        
    	 continue; 
    	 if(AWDFilter == true && priceFilter == true && electricFilter == false)

        				if (cars.get(i).AWD != false && cars.get(i).price <= maxPrice && cars.get(i).price >= minPrice)
        				
        					cars.get(i).display();
        				
            
    	
    	 continue; 
    	 if(AWDFilter == true && priceFilter == false && electricFilter == false ) 
                
                	if(cars.get(i).AWD != false) 
                	
    					cars.get(i).display();
    	 continue; 
    	 
        if(AWDFilter == true && priceFilter == false && electricFilter == true)
                	if(carFilter.batteryType != null && cars.get(i).AWD != false)
                	
                    cars.get(i).display(); 
                	
                
        	//after going through all possibilities(2^3) all filters are set
        	else
        		{
    				if (carFilter.batteryType != null && cars.get(i).AWD != false && cars.get(i).price <= maxPrice && cars.get(i).price >= minPrice)
    				{
    					cars.get(i).display();
    				}
    			System.out.println(""+ i + " " + car.display());

        		}
        	}
		}

}
 */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    	  
    

    


