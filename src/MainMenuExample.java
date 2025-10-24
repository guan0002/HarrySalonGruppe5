import java.util.Scanner;
    public class MainMenuExample {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\n=== Welcome to your booking system! ===");
                System.out.println("Press 0 to exit");
                System.out.println("Press 1–9 to access the different menus:\n");

                // List of menu names
                String[] menuOptions = {
                        "", // index 0 not used
                        "Booking Menu",
                        "Delete Menu",
                        "Test 1 Menu",
                        "Test 2 Menu",
                        "Test 3 Menu",
                        "Test 4 Menu",
                        "Test 5 Menu",
                        "Test 6 Menu",
                        "Test 7 Menu"
                };

                // Print all menus
                for (int i = 1; i < menuOptions.length; i++) {
                    System.out.println(i + ": " + menuOptions[i]);
                }

                System.out.print("\nEnter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        running = false;
                        break;

                    case 1:
                        bookingMenu(scanner);
                        break;

                    case 2:
                        deleteMenu(scanner);
                        break;

                    case 3:
                        test1Menu(scanner);
                        break;

                    case 4:
                        test2Menu(scanner);
                        break;

                    case 5:
                        test3Menu(scanner);
                        break;

                    case 6:
                        test4Menu(scanner);
                        break;

                    case 7:
                        test5Menu(scanner);
                        break;

                    case 8:
                        test6Menu(scanner);
                        break;

                    case 9:
                        test7Menu(scanner);
                        break;

                    default:
                        System.out.println("Please enter a valid choice (0–9).");
                }
            }

            scanner.close();
        }

        // === Submenus ===

        private static void bookingMenu(Scanner scanner) {
            System.out.println("\n--- Booking Menu ---");
            System.out.println("1. Make a new booking");
            System.out.println("2. View existing bookings");
            System.out.println("3. Return to main menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Function: Create a new booking");
                    break;
                case 2:
                    System.out.println("Function: Display bookings");
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input in Booking Menu.");
            }
        }

        private static void deleteMenu(Scanner scanner) {
            System.out.println("\n--- Delete Menu ---");
            System.out.println("1. Delete a booking");
            System.out.println("2. Clear all bookings");
            System.out.println("3. Return to main menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Function: Delete one booking");
                    break;
                case 2:
                    System.out.println("Function: Clear all bookings");
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid input in Delete Menu.");
            }
        }

        private static void test1Menu(Scanner scanner) {
            System.out.println("\n--- Test 1 Menu ---");
            System.out.println("Functionality for Test 1 goes here.");
        }

        private static void test2Menu(Scanner scanner) {
            System.out.println("\n--- Test 2 Menu ---");
            System.out.println("Functionality for Test 2 goes here.");
        }

        private static void test3Menu(Scanner scanner) {
            System.out.println("\n--- Test 3 Menu ---");
            System.out.println("Functionality for Test 3 goes here.");
        }

        private static void test4Menu(Scanner scanner) {
            System.out.println("\n--- Test 4 Menu ---");
            System.out.println("Functionality for Test 4 goes here.");
        }

        private static void test5Menu(Scanner scanner) {
            System.out.println("\n--- Test 5 Menu ---");
            System.out.println("Functionality for Test 5 goes here.");
        }

        private static void test6Menu(Scanner scanner) {
            System.out.println("\n--- Test 6 Menu ---");
            System.out.println("Functionality for Test 6 goes here.");
        }

        private static void test7Menu(Scanner scanner) {
            System.out.println("\n--- Test 7 Menu ---");
            System.out.println("Functionality for Test 7 goes here.");
        }
    }


