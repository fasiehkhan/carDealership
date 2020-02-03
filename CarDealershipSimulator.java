//FASIEH KHAN
//500879628
package cps209A2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDealershipSimulator 
{	
	//this function reads from the txt file using a scanner
	public static ArrayList<Car> readF(String filename) throws FileNotFoundException, InputMismatchException
    {
     
      File file=new File(filename);
      Scanner sc =new Scanner(file);
      
	  ArrayList<Car> cars=new ArrayList<Car>();
	  while(sc.hasNextLine())
	  {
		  String [] bl=sc.nextLine().split("\\s+");
		  if (bl.length==9)
		  {
			  cars.add(new Car(bl[0],bl[1],Car.Model.valueOf(bl[2]),Vehicle.PowerSource.valueOf(bl[3]),Double.valueOf(bl[4]),Integer.valueOf(bl[5]),
					  Boolean.valueOf(bl[6]),Integer.valueOf(bl[7]),Integer.valueOf(8)));
		  }
		  else if (bl.length==11)
		  {
			  cars.add(new ElectricCar(bl[0],bl[1],Car.Model.valueOf(bl[2]),Vehicle.PowerSource.valueOf(bl[3]),Double.valueOf(bl[4]),Integer.valueOf(bl[5]),
					  Boolean.valueOf(bl[6]),Integer.valueOf(bl[7]),Integer.valueOf(8),bl[9],Integer.valueOf(10)));
		  }
	  }
	  sc.close();
	  return cars;
    }		
public static void main(String[] args) 
	{ 
		  
		  
		CarDealership dealership = new CarDealership();		//Creates a CarDealership object

		Transaction trans = new Transaction();		//Creates a Transaction object to access the methods within that class
		AccountingSystem aobj =new AccountingSystem();

		  // Then creates an (initially empty) array list of type Car

		ArrayList<Car> cars = new ArrayList<Car>();
		   // Then creates some new car objects of different types
		  // Adds the car objects to the array list
		 Car c = null;

		try
		{
			cars=readF("/Users/fasiehkhan/eclipse-workspace/cps209A2/cars.txt");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No File");
		}
		catch(InputMismatchException E)
		{
			System.out.println("Wrong type");
		}
		
	
		
	  Scanner in = new Scanner(System.in);
	  Car CAR = null;

	  while(in.hasNextLine())
		 {
			 Scanner newC= new Scanner (in.nextLine());
			 if (newC.hasNext())
			 {
				 String comm= newC.next();
			// If the customer enter L then the displayInventory will run	 
				 if(comm.equalsIgnoreCase("L"))
				 {
					 dealership.displayInventory();
				 }
			// If the customer enter Q then it will exit the program and it will run the returnCar function
				 else if (comm.equalsIgnoreCase("Q"))
				 {
					  System.exit(0);
				 }
			// reads an integer from the current input line that represents an index of a car the user wants to buy
				 else if (comm.equalsIgnoreCase("BUY"))
				 {
					 if (newC.hasNextInt())
					 {
						 
						 try
						 {
							 int i=newC.nextInt();
							 
						 String displ =dealership.buyCar(i);
						 
						 
							 System.out.println(displ);
						 }
						 
						 catch(Exception e)
						 {
						 
							 System.out.println("Invalid VIN");
						 
						 }
					 }
					}
				 
				 else if(comm.equalsIgnoreCase("RET"))
				 {
					 	if (newC.hasNextInt()) 
					 	{
					 		try 
					 		{
					 			int id=newC.nextInt();
					 			dealership.returnCar(id);
					 		}
					 		catch (Exception e)
	 				 		{
					 			System.out.println("Invalid ");
					 		}
					 	}
				 } 
					
				 else if (comm.equalsIgnoreCase("ADD"))
				 {
					dealership.addCars(cars); 
				 }
				 
				 else if (comm.equalsIgnoreCase("SPR"))
				 {
					 dealership.sortByPrice();
				 }
			 
				 else if (comm.equalsIgnoreCase("SSR"))
				 {
					 dealership.sortBySafetyRating();
				 }
				 
				 else if (comm.equalsIgnoreCase("SMR"))
				 {
					 dealership.sortByMaxRange();
				 }
			 
				 else if (comm.equalsIgnoreCase("FPR"))
				 {
					 if (newC.hasNextDouble())
					 {
						 double min=newC.nextDouble();
						 if (newC.hasNextDouble())
						 {
							 double max=newC.nextDouble();
							 dealership.filterByPrice(min,max);
						 }
					 }
				 }
				 else if (comm.equalsIgnoreCase("FEL"))
				 {
					 dealership.filterByElectric();
				 }
				 else if (comm.equalsIgnoreCase("FAW"))
				 {
					 dealership.filterByAWD();
				 }
				 else if (comm.equalsIgnoreCase("FCL"))
				 {
					 dealership.filtersClear();
				 }
				 
					 
				  
				 else 
				 {
					 System.out.println("Error Invalid Command");
				 }
			 
			 }
		
			}
	 }
	}
		 
	




	 

