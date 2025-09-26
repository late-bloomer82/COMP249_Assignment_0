import java.util.Scanner;

/**
 * The Driver class runs the Appliance Store Management System.
 * It allows the store owner to add appliances, update appliances,
 * search by brand, search by price, and quit the program.
 * Password protection is enforced with different rules depending on the option.
 */
public class Driver {

    private static final String PASSWORD = "c249";
    private static final int MAX_FAILED_ATTEMPTS = 12;
    private static int failedAttempts = 0;

    /**
     * The main method displays the menu and handles user input.
     * It loops until the user chooses to quit.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to the Appliance Store Management System!");

        System.out.print("Enter maximum number of appliances your store can hold: ");
        int maxAppliances = sc.nextInt();
        Appliance[] inventory = new Appliance[maxAppliances];
        int count = 0;

        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Enter new appliances (password required)");
            System.out.println("2. Update appliance information (password required)");
            System.out.println("3. Find appliances by brand");
            System.out.println("4. Find appliances cheaper than a given price");
            System.out.println("5. Quit");
            System.out.print("Enter your choice (1-5): ");

            int choice = sc.nextInt();
            if (choice < 1 || choice > 5) continue;

            switch (choice) {
                case 1:
                    if (!checkPassword(sc, true)) break;
                    count = addAppliances(sc, inventory, count);
                    break;
                case 2:
                    if (!checkPassword(sc, false)) break;
                    updateAppliance(sc, inventory, count);
                    break;
                case 3:
                    findAppliancesByBrand(sc, inventory, count);
                    break;
                case 4:
                    findCheaperThan(sc, inventory, count);
                    break;
                case 5:
                    System.out.println("Thank you for using the Appliance Store Management System. Goodbye!");
                    return;
            }
        }
    }

    /**
     * Checks the password with rules depending on the strictMode flag.
     * strictMode true = Option 1 behavior: 3 tries per round, terminate after 12 total failures.
     * strictMode false = Option 2 behavior: 3 tries per round, then back to menu without termination.
     */
    private static boolean checkPassword(Scanner sc, boolean strictMode) {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter password: ");
            String input = sc.next();
            if (input.equals(PASSWORD)) {
                failedAttempts = 0;   // reset counter after success
                return true;
            }
            attempts++;
            failedAttempts++;
        }

        if (strictMode && failedAttempts >= MAX_FAILED_ATTEMPTS) {
            System.out.println("Program detected suspicious activities and will terminate immediately!");
            System.exit(0);
        }

        System.out.println("Incorrect password. Returning to main menu.");
        return false;
    }

    /** Adds appliances to the inventory after validating type and price */
    private static int addAppliances(Scanner sc, Appliance[] inventory, int count) {
        System.out.print("How many appliances do you want to add? ");
        int num = sc.nextInt();
        if (count + num > inventory.length) {
            System.out.println("Not enough space! You can only add " + (inventory.length - count) + " more.");
            return count;
        }

        for (int i = 0; i < num; i++) {
            System.out.print("Enter type: ");
            String type = sc.next();
            System.out.print("Enter brand: ");
            String brand = sc.next();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            inventory[count++] = new Appliance(type, brand, price);

        }
        return count;
    }

    /** Updates information of a specific appliance identified by serial number */
    private static void updateAppliance(Scanner sc, Appliance[] inventory, int count) {
        while (true) {
            System.out.print("Enter serial number to update: ");
            long sn = sc.nextLong();
            Appliance target = null;
            for (int i = 0; i < count; i++) {
                if (inventory[i].getSerial_no() == sn) {
                    target = inventory[i];
                    break;
                }
            }
            if (target == null) {
                System.out.println("No appliance with serial number " + sn);
                System.out.print("Try again? (y/n): ");
                if (sc.next().equalsIgnoreCase("y")) continue;
                else return;
            }

            System.out.println("Current information:\n" + target);
            while (true) {
                System.out.println("\nWhat information would you like to change?");
                System.out.println("1. brand");
                System.out.println("2. type");
                System.out.println("3. price");
                System.out.println("4. Quit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 1) target.setBrand(sc.next());
                else if (choice == 2) target.setType(sc.next());
                else if (choice == 3) target.setPrice(sc.nextDouble());
                else if (choice == 4) break;
                else continue;

                System.out.println("Updated information:\n" + target);
            }
            return;
        }
    }

    /** Finds and displays all appliances with a specific brand */
    private static void findAppliancesByBrand(Scanner sc, Appliance[] inventory, int count) {
        System.out.print("Enter brand to search: ");
        String brand = sc.next();
        for (int i = 0; i < count; i++) {
            if (inventory[i].getBrand().equalsIgnoreCase(brand))
                System.out.println(inventory[i]);
        }
    }

    /** Finds and displays all appliances cheaper than a given price */
    private static void findCheaperThan(Scanner sc, Appliance[] inventory, int count) {
        System.out.print("Enter maximum price: ");
        double price = sc.nextDouble();
        for (int i = 0; i < count; i++) {
            if (inventory[i].getPrice() < price)
                System.out.println(inventory[i]);
        }
    }
}
