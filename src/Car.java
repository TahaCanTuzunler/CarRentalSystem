public class Car {
    private String brand;
    private String model;
    private String engineType; 
    private String drivetrain;
    private double dailyRate;
    private boolean isAvailable;

    public Car(String brand, String model, double dailyRate) {
        this.brand = brand;
        this.model = model;
        this.engineType = "Standard";
        this.drivetrain = "FWD";
        setDailyRate(dailyRate);
        this.isAvailable = true;
    }

    public Car(String brand, String model, String engineType, String drivetrain, double dailyRate) {
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.drivetrain = drivetrain;
        setDailyRate(dailyRate);
        this.isAvailable = true;
    }

    
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getEngineType() { return engineType; }
    public String getDrivetrain() { return drivetrain; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public double getDailyRate() { return dailyRate; }

    public void setDailyRate(double rate) {
        if (rate <= 0) {
            System.out.println("Error: Daily rate cannot be 0 or negative. Standard rate assigned.");
            this.dailyRate = 1000.0;
        } else {
            this.dailyRate = rate;
        }
    }

    public void displayCarInfo() {
        System.out.println(brand + " " + model + " [" + engineType + ", " + drivetrain + "] - Daily Rate: $" + dailyRate + (isAvailable ? " (Available)" : " (Rented)"));
    }
}