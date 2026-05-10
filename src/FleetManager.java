import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FleetManager {
    private ArrayList<Car> fleet;
    private String[] categories = {"Sedan", "SUV", "Sport", "Luxury"};
    private final String FILE_NAME = "cars.csv"; 

    public FleetManager() {
        fleet = new ArrayList<>();
        loadFleetFromFile();
    }

    
    private void loadFleetFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(","); 
                    if (data.length == 6) {
                        Car car = new Car(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]));
                        car.setAvailable(Boolean.parseBoolean(data[5]));
                        fleet.add(car);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading the database file: " + e.getMessage());
            }
        } else {
            
            fleet.add(new Car("BMW", "M3", "3.0L Inline-6 Twin-Turbo", "RWD", 450.0));
            fleet.add(new Car("Porsche", "911 Carrera", "3.0L Flat-6 Boxer", "RWD", 600.0));
            fleet.add(new Car("Skoda", "Octavia", 120.0));
            saveFleetToFile(); 
        }
    }

    
    public void saveFleetToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Car car : fleet) {
                writer.write(car.getBrand() + "," + car.getModel() + "," + car.getEngineType() + "," + car.getDrivetrain() + "," + car.getDailyRate() + "," + car.isAvailable() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void addCar(Car car) {
        fleet.add(car);
        saveFleetToFile(); 
        System.out.println("Car successfully added to the fleet.");
    }

    public void listAvailableCars() {
        System.out.println("\n--- Available Cars ---");
        boolean found = false;
        for (Car car : fleet) {
            if (car.isAvailable()) {
                car.displayCarInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No available cars at the moment.");
    }

    public Car searchCarByBrand(String brand) {
        for (Car car : fleet) {
            if (car.getBrand().equalsIgnoreCase(brand) && car.isAvailable()) {
                return car;
            }
        }
        return null;
    }

    public void printFleetStatistics() {
        System.out.println("\n--- Fleet Statistics ---");
        System.out.println("Serviced Categories: " + categories[0] + ", " + categories[1] + ", " + categories[2] + ", " + categories[3]);
        int totalCars = fleet.size();
        double totalValue = 0;

        for (Car car : fleet) {
            totalValue += car.getDailyRate();
        }

        System.out.println("Total Number of Cars: " + totalCars);
        if(totalCars > 0) {
            System.out.println("Fleet Average Daily Rate: $" + (totalValue / totalCars));
        }
    }
}