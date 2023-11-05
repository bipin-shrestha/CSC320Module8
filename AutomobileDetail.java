import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class AutomobileDetail {	
	// Creating AddVehicle method to add new automobile
	public static void AddVehicle(ArrayList<Automobile> vehicles, Automobile vehicle) {
		try {
			vehicles.add(vehicle);
			System.out.println(vehicle.getAutoMake()+ " "+ vehicle.getAutoModel() +" Added Succesfully!");
		}catch(Exception e){
			System.out.println("ERROR MESSAGE: vehicle couldn't be added.");
		}
	}
	// Creating RemoveVehicle method to remove new automobile
	public static void RemoveVehicle(ArrayList<Automobile> vehicles,int index) {
		try {
			Automobile current = vehicles.get(index);
			vehicles.remove(index);
			System.out.println(current.getAutoMake()+ " " + current.getAutoModel() + " is removed.");
		}catch(Exception e) {
			System.out.println("Error message: Vehicle couldn't be removed.");
		}
	}	
	// Creating UpdateVehicle method to update the information of the automobile
	public static void UpdateVehicle(ArrayList<Automobile> vehicles, int index, Automobile newVehicle) {	
		try {
			System.out.println(vehicles.get(index).getAutoMake()+ " "+ vehicles.get(index).getAutoModel() +" updated Succesfully!");
			vehicles.set(index, newVehicle);
			String[] updatedVehicle = ListInventory(vehicles);
			System.out.println("\nVehicle Inventory");
			for(int i=0; i<updatedVehicle.length; i++) {
				System.out.println(updatedVehicle[i]);
			}
		}catch(Exception e) {
			System.out.println("Error message: Vehicle information couldn't be updated.");
		}			
	}
	// Creating ListInventory method to display the list of the automobile
	public static String[] ListInventory(ArrayList<Automobile> vehicles) {
		try {
			String[] vehicleDetails = new String[vehicles.size()];
			for(int i=0; i<vehicles.size(); i++) {
				String vehicleDetail = i +" "+ vehicles.get(i).getAutoMake()+" "+ vehicles.get(i).getAutoModel()+" "+
										vehicles.get(i).getAutoColor()+" "+ vehicles.get(i).getAutoYear()+" "+ vehicles.get(i).getAutoMileage();
				vehicleDetails[i] = vehicleDetail;
			}	
			return vehicleDetails;
		}catch (Exception e) {
			System.out.println("Error message : Vehicle information list cannot be displayed.");
			String[] emptyVehicleDetail = new String[0];
			return emptyVehicleDetail;
		}
	}
	public static void FileWriter(ArrayList<Automobile> vehicles) {
		try {			
			FileWriter fileWriter = new FileWriter("C:\\Temp\\Automobile.txt");
			for(int i=0; i<vehicles.size();i++) { 
				String vehicleDetail = i +" "+ vehicles.get(i).getAutoMake()+" "
						+ vehicles.get(i).getAutoModel()+" "+
						vehicles.get(i).getAutoColor()+" "+ vehicles.get(i).getAutoYear()+" "
						+ vehicles.get(i).getAutoMileage(); 
				fileWriter.write(vehicleDetail + "\n"); 
			}	
			fileWriter.close();
			System.out.println("Sucessfully file saved.");
		}catch(Exception e) {
			System.out.println("File couldnot be saved.");
		}
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Automobile> vehicleInventory = new ArrayList<Automobile>();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter the selection number : ");
			int userSelection = 0;
			while (userSelection != 4) {
				System.out.println("\nWelcome to your Automobile Inventory Application.\n");
				System.out.println("Please select the options below :");
				System.out.println("- Enter 1 to add an automobile \n- Enter 2 to remove an automobile "
						+ "\n- Enter 3 to update the automobile detail \n- Enter 4 to generate text file");
				userSelection = scanner.nextInt();
				if (userSelection == 1) {
					System.out.println("Enter the automobile make :");
					String make = scanner.next();
					System.out.println("Enter the automobile model :");
					String model = scanner.next();
					System.out.println("Enter the automobile color :");
					String color = scanner.next();
					System.out.println("Enter the automobile year :");
					int year = scanner.nextInt();
					System.out.println("Enter the automobile mileage :");
					int mileage = scanner.nextInt();
					Automobile newcar = new Automobile(make, model, color, year, mileage);
					AddVehicle(vehicleInventory, newcar);
					String[] cars = ListInventory(vehicleInventory);
					System.out.println("Current Inventory");
					for(int i=0; i<cars.length; i++) {
						System.out.println(cars[i]);
					}					
				}
				else if (userSelection == 2) {
					if(vehicleInventory.size() < 1) {
						System.out.println("\nThere is no automobiles in the inventory to delete.");
					}else {
						System.out.println("Current Inventory");
						String[] cars = ListInventory(vehicleInventory);
						for(int i=0; i<cars.length; i++) {
							System.out.println(cars[i]);
						}
						System.out.println("Enter the index number of automobile to remove:");
						int userChoiceIndex = scanner.nextInt();
						RemoveVehicle(vehicleInventory, userChoiceIndex);
					}
				}
				else if (userSelection == 3) {
					System.out.println("Update an automobile");
					if(vehicleInventory.size() < 1) {
						System.out.println("\nThere is no automobiles in the inventory to update.");
					}else {
						System.out.println("Current Inventory");
						String[] cars = ListInventory(vehicleInventory);
						for(int i=0; i<cars.length;i++) {
							System.out.println(cars[i]);
						}
						System.out.println("Enter the index number of automobile to update:");
						int userChoiceIndex = scanner.nextInt();
						System.out.println("Enter updated automobile make :");
						String make = scanner.next();
						System.out.println("Enter updated automobile model :");
						String model = scanner.next();
						System.out.println("Enter updated autombobile color :");
						String color = scanner.next();
						System.out.print("Enter updated automobile year :");
						int year = scanner.nextInt();
						System.out.println("Enter updated autombile mileage :");
						int mileage = scanner.nextInt();
						Automobile updatedCar = new Automobile(make, model, color, year, mileage);
						UpdateVehicle(vehicleInventory, userChoiceIndex, updatedCar);						
						System.out.println("\nCurrent Inventory");
						String[] newCars = ListInventory(vehicleInventory);
						for(int i=0; i<newCars.length;i++) {
							System.out.println(newCars[i]);
						}
					}
				}
				else if(userSelection == 4){
					if(vehicleInventory.size()<1) {
						System.out.println("\nThere is no automobile in the inventory to write in file.");
					}else {
						System.out.println("Print the automobile information to file (Y or N) : ");
						String userChar = scanner.next();
						if (userChar.equalsIgnoreCase("y")) {
							FileWriter(vehicleInventory);
							System.out.println("The automobile information to file is printed sucessfully.");
						}else{														
							System.out.println("Your automobile information to file couldnot be printed.");
						}
					}
				}
				else {
					System.out.println("Error Message : Please make a valid selection.");
				}
			}	
			scanner.close();
		}catch(Exception e){
			System.out.println("Error Occured.");
		}		
	}
}



