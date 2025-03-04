
package lists_in_Java;

import java.util.ArrayList;
import java.util.Scanner;

public class Exp3_S7_Grupo25 {

    // Theater details
    private static String theaterName = "Teatro Moro";
    private static int hallCapacity = 100;
    private static int availableTickets = hallCapacity;
    private static double vipBasePrice = 5000;
    private static double plateaBasePrice = 4000;
    private static double balconyBasePrice = 3000;
    private static double totalRevenue = 0;
    private static ArrayList<String> sales = new ArrayList<>();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("=== " + theaterName + " ===");
            System.out.println("1. Ticket Sales");
            System.out.println("2. View Sales Summary");
            System.out.println("3. Generate Receipt");
            System.out.println("4. Calculate Total Revenue");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    sellTickets(scanner);
                    break;
                case 2:
                    viewSalesSummary();
                    break;
                case 3:
                    generateReceipt();
                    break;
                case 4:
                    calculateTotalRevenue();
                    break;
                case 5:
                    continueLoop = false;
                    System.out.println("Thank you for your purchase.");
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        }
    }

    public static void sellTickets(Scanner scanner) {
        System.out.println("=== Ticket Sales ===");
        System.out.print("Select seating (VIP, Platea, Balcony): ");
        String seating = scanner.next();
        double basePrice = 0;

        switch (seating.toLowerCase()) {
            case "vip":
                basePrice = vipBasePrice;
                break;
            case "platea":
                basePrice = plateaBasePrice;
                break;
            case "balcony":
                basePrice = balconyBasePrice;
                break;
            default:
                System.out.println("Invalid seating option.");
                return;
        }

        System.out.print("Are you a student? (Yes / No): ");
        String isStudent = scanner.next();
        double discount = 0;

        if (isStudent.equalsIgnoreCase("yes")) {
            discount = 0.1; // 10% discount for students
        } else {
            System.out.print("Are you a senior citizen? (Yes / No): ");
            String isSenior = scanner.next();
            if (isSenior.equalsIgnoreCase("yes")) {
                discount = 0.15; // 15% discount for senior citizens
            }
        }

        double finalPrice = basePrice - (basePrice * discount);
        double discountPercentage = discount * 100;

        if (availableTickets > 0) {
            System.out.println("Seating: " + seating);
            System.out.println("Base Price: $" + basePrice);
            System.out.println("Discount Applied: " + (int)(discountPercentage) + "%");
            System.out.println("Final Price: $" + finalPrice);
            System.out.println("Ticket sold! Enjoy the show at: " + seating);
            totalRevenue += finalPrice;
            availableTickets--;
            sales.add("Seating: " + seating + ", Base Price: $" + basePrice + ", Discount Applied: " + (int)(discountPercentage) + "%, Final Price: $" + finalPrice);
        } else {
            System.out.println("Sorry, no tickets available.");
        }
    }

    public static void viewSalesSummary() {
        System.out.println("=== Sales Summary ===");
        for (String sale : sales) {
            System.out.println(sale);
        }
    }

    public static void generateReceipt() {
        System.out.println("=== Receipt ===");
        System.out.println("---------------------------------------");
        System.out.println("              " + theaterName);
        System.out.println("---------------------------------------");
        for (String sale : sales) {
            System.out.println(sale);
        }
        System.out.println("---------------------------------------");
        System.out.println("Thank you for visiting " + theaterName);
        System.out.println("---------------------------------------");
    }

    public static void calculateTotalRevenue() {
        System.out.println("=== Total Revenue ===");
        System.out.println("Total Revenue: $" + totalRevenue);
    }
}
