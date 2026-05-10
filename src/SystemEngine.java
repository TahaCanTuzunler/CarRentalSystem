import java.util.Scanner;

public class SystemEngine {
    private FleetManager fleetManager;
    private Scanner scanner;

    public SystemEngine() {
        fleetManager = new FleetManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== CAR RENTAL SYSTEM ===");
            System.out.println("1. List Available Cars");
            System.out.println("2. Rent a Car (Search by Brand)");
            System.out.println("3. Add a New Car");
            System.out.println("4. Fleet Statistics");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
                continue; 
            }

            switch (choice) {
                case 1:
                    fleetManager.listAvailableCars();
                    break;
                case 2:
                    rentCarProcess();
                    break;
                case 3:
                    addNewCarProcess();
                    break;
                case 4:
                    fleetManager.printFleetStatistics();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the system. Have a good day!");
                    break;
                default:
                    System.out.println("Error: Invalid choice.");
            }

            if (running) {
                System.out.print("\nPress Enter to return to the main menu...");
                scanner.nextLine();
            }
        }
    }

    private void rentCarProcess() {
        System.out.print("Enter the brand of the car you want to rent: ");
        String brand = scanner.nextLine();
        Car selectedCar = fleetManager.searchCarByBrand(brand);

        if (selectedCar != null) {
            System.out.println("Car found!");
            System.out.print("Your Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Your ID Number: ");
            String idNumber = scanner.nextLine();
            
            System.out.print("How many years have you had your driving license?: ");
            try {
                int licenseYear = Integer.parseInt(scanner.nextLine());
                
                if (licenseYear < 3) {
                    System.out.println("Sorry, you cannot rent a car with less than 3 years of driving experience.");
                    return; 
                }
                
                System.out.print("How many days will you rent it for?: ");
                int days = Integer.parseInt(scanner.nextLine());
                
                Customer customer = new Customer(name, idNumber, licenseYear);
                RentalTransaction transaction = new RentalTransaction(selectedCar, customer, days);
                transaction.printReceipt();
                
                
                fleetManager.saveFleetToFile();
                
            } catch (NumberFormatException e) {
                System.out.println("Operation cancelled. You must enter a valid number for years and days.");
            }
        } else {
            System.out.println("No available car found for the specified brand.");
        }
    }

    private void addNewCarProcess() {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Daily Rate: ");
        
        try {
            double rate = Double.parseDouble(scanner.nextLine());
            Car newCar = new Car(brand, model, rate);
            fleetManager.addCar(newCar);
        } catch (NumberFormatException e) {
            System.out.println("Operation cancelled. You must enter only numbers for the daily rate.");
        }
    }
}