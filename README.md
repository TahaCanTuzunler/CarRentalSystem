Project Title: Car Rental System

- [Taha Can Tuzunler]

How to Run:
1. Open the project folder in any standard Java IDE (e.g., VS Code, IntelliJ).
2. Ensure JDK 21 (or any compatible Java version) is installed and configured.
3. Locate the 'App.java' file inside the 'src' directory.
4. Run/Compile 'App.java'. The application will launch via the console terminal.

List of Implemented Features:
1. List Available Cars: Iterates through the fleet and displays vehicles that are currently available for rent.
2. Rent a Car: Searches for a specific car brand. It includes a business logic validation that rejects customers with less than 3 years of driving experience. It then calculates the total cost and prints a rental receipt.
3. Add a New Car: Allows the administrator to add new vehicles to the system dynamically.
4. Fleet Statistics: Calculates and displays the total number of cars in the system and the average daily rental rate.

Data Structures Used:
- ArrayList: Used in the 'FleetManager' class ('ArrayList<Car> fleet') as the primary dynamic collection to store, search, and manage all Car objects.
- Array: Used in the 'FleetManager' class ('String[] categories = {"Sedan", "SUV", "Sport", "Luxury"}') to store and display the fixed vehicle segments during statistical outputs.

File I/O Implementation:
- The system includes File I/O capabilities using standard Java standard libraries (java.io.File, java.io.FileWriter, java.util.Scanner).
- Format: Data is stored and parsed using a comma-separated values (CSV) format in a file named "cars.csv".
- Behavior: Upon startup, 'FleetManager' reads "cars.csv", parses the data, and loads the cars into the ArrayList. Whenever a new car is added or a car is successfully rented (changing its availability status), the system overwrites the CSV file to preserve the updated state.
- Robustness: File reading operations are wrapped in try-catch blocks to prevent application crashes if the file is corrupted or unreadable.