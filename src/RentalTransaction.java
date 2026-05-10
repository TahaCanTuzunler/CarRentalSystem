public class RentalTransaction {
    private Car car;
    private Customer customer;
    private int days;
    private double totalCost;

    public RentalTransaction(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.totalCost = calculateCost();
        car.setAvailable(false); 
    }

    private double calculateCost() {
        return car.getDailyRate() * days;
    }

    public void printReceipt() {
        System.out.println("----- Rental Receipt -----");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Car: " + car.getBrand() + " " + car.getModel());
        System.out.println("Duration: " + days + " days");
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("--------------------------");
    }
}