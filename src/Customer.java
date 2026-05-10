public class Customer {
    private String name;
    private String idNumber;
    private int drivingLicenseYear;

    public Customer(String name, String idNumber, int drivingLicenseYear) {
        this.name = name;
        this.idNumber = idNumber;
        setDrivingLicenseYear(drivingLicenseYear);
    }

    
    public void setDrivingLicenseYear(int year) {
        if (year < 0 || year > 50) {
            System.out.println("Error: Invalid driving license year. Set to 0.");
            this.drivingLicenseYear = 0;
        } else {
            this.drivingLicenseYear = year;
        }
    }

    public String getName() { return name; }
    public String getIdNumber() { return idNumber; }
    public int getDrivingLicenseYear() { return drivingLicenseYear; }
}