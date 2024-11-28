import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String preferences;
    double budget;

    public Destination(String name, String date, String preferences, double budget) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nDate: " + date + "\nPreferences: " + preferences + "\nBudget: $" + budget;
    }
}

public class TravelItineraryPlanner {

    private static final ArrayList<Destination> itinerary = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Travel Itinerary Planner!");
        
        boolean continuePlanning = true;

        while (continuePlanning) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a destination");
            System.out.println("2. View itinerary");
            System.out.println("3. Calculate total budget");
            System.out.println("4. Exit");

            int choice = getChoice();
            switch (choice) {
                case 1:
                    addDestination();
                    break;
                case 2:
                    viewItinerary();
                    break;
                case 3:
                    calculateTotalBudget();
                    break;
                case 4:
                    continuePlanning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
    }

    private static int getChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addDestination() {
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter the destination name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the travel date (e.g., YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter your preferences (e.g., activities, food): ");
        String preferences = scanner.nextLine();

        System.out.print("Enter your budget for this destination: ");
        double budget = scanner.nextDouble();

        Destination destination = new Destination(name, date, preferences, budget);
        itinerary.add(destination);

        System.out.println("Destination added successfully!");
    }

    private static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added yet.");
            return;
        }

        System.out.println("\nYour Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println(destination);
            System.out.println("---------------");
        }
    }

    private static void calculateTotalBudget() {
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added yet.");
            return;
        }

        double totalBudget = 0;
        for (Destination destination : itinerary) {
            totalBudget += destination.budget;
        }

        System.out.println("Total estimated budget for your trip: $" + totalBudget);
    }
}
