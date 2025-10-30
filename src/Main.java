import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    static ArrayList<Customer> customerBookings = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        customerBookings = customerDatabase.loadDatabase();


        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\033[1mWelcome to your booking system! 💻\033[0m\n");
            System.out.println("Press 1-4 to access the different menus\n");
            System.out.println("Press 0 to go back to the main menu\n");

            String[] printMenus = {
                    "",
                    "Booking 📇",
                    "Customer Details 👥",
                    "Delete Booking 💸",
                    "Payment 💳",
            };


            for (int i = 1; i < printMenus.length; i++) {
                System.out.println(i + ": " + printMenus[i]);
            }
            System.out.println("Enter a number:");
            int choice = scanner.nextInt();
            scanner.nextLine();

//Switch statement der kalder på de forskellige metoder
            switch (choice) {
                case 1:
                    Booking();
                    break;

                case 2:
                    CustomerList();
                    break;

                case 3:
                    deleteCustomer();
                    break;

                case 4:
                    System.out.println("Enter customer name for payment:");
                    String name = scanner.nextLine();

                    Customer c = customerDatabase.findCustomerByName(name);

                    if (c != null) {
                        Payment pay = new Payment(c, 0, "Card");
                        pay.payment();

                        customerBookings = customerDatabase.loadDatabase();

                    } else {
                        System.out.println("");
                    }

                    break;

                default:
                    System.out.println("Please enter a valid choice");


            }
        }
    }

    public static void Booking() throws IOException {

        customerBookings = customerDatabase.loadDatabase();

        Scanner input = new Scanner(System.in);
        boolean tilbage = false;
        boolean bookingFail = false;
        boolean timeTaken = false;


        System.out.println("Write customer name: ");
        String name = input.nextLine();

        System.out.println("Write customer mail: ");
        String email = input.nextLine();

//Formatering af dato ved bookning
//Bruger Try & Catch til at filtrere uønsket input i konsollen
        LocalDate date = null;
        while (date == null) {
            System.out.println("Please enter a date dd/mm/yyyy:");
            String dateStr = input.nextLine();
            try {
                java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(dateStr, formatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
        //Formatering af tidspunkt ved bookning
//Bruger Try & Catch til at filtrere uønsket input i konsollen
        LocalTime time = null;
        while (time == null) {
            System.out.println("Please enter a time HH:mm:");
            String timeStr = input.nextLine();
            try {
                java.time.format.DateTimeFormatter timeFormatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm");
                time = LocalTime.parse(timeStr, timeFormatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid time format. Please try again.");
            }
        }
        LocalTime open = LocalTime.of(10, 0);
        LocalTime close = LocalTime.of(18, 0);

        if (time.isBefore(open) || time.isAfter(close)) {
            System.out.println("\033[31mYou can only book between 10.00 and 18:00\033[0m");
            while (!bookingFail) {
                System.out.println("Press 0 to get back to the menu or press 1 to try making a booking again. \uD83C\uDFE0");
                int answer = input.nextInt();
                if (answer == 0) {
                    bookingFail = true;

                } else if (answer == 1) {
                    Booking();
                    bookingFail = true;
                } else {
                }
            }
            return;

        }

        for (Customer existing : customerBookings) {
            if (existing.getDate().equals(date) && existing.getTime().equals(time)) {
                System.out.println("This date: " + date + " at " + time + " Is unfortunately booked");
                System.out.println("Please choose another time");
                while (!timeTaken) {
                    System.out.println("Press 0 to get back to the menu or press 1 to try making a booking again. \uD83C\uDFE0");
                    int choice = input.nextInt();
                    if (choice == 0) {
                        timeTaken = true;

                    } else if (choice == 1) {
                        Booking();
                        timeTaken = true;
                    }
                }
                return;
            }
        }


        Customer c = new Customer(name, email, date, time);


        customerBookings.add(c);
        customerDatabase.saveCustomer(c);


        System.out.println("The customer " + name + " has now been added to your booking list, with the time " + date + " - " + time + ". ✅");


        System.out.println("Press 0 to get back to the menu.");
        while (!tilbage) {
            int tilbageTilMenu = input.nextInt();
            if (tilbageTilMenu == 0) {
                tilbage = true;
            } else {
                System.out.println("Press 0 to go back to the menu.");
            }


        }
    }

    public static void CustomerList() throws IOException {



        Scanner inputPass = new Scanner(System.in);

        String password1 = "hairyharry";
        String password2 = "x";
        System.out.print("Enter password to view customer details: ");
        String enteredPassword = inputPass.nextLine();

        if (!enteredPassword.equals(password1) && !enteredPassword.equals(password2)) {
            System.out.println("Wrong password!");
            return;
        }

        customerBookings = customerDatabase.loadDatabase();

        customerBookings.sort(null);
        Scanner input = new Scanner(System.in);
        boolean tilbage = false;

        System.out.println("Customer Details:");
        for (Customer c : customerBookings) {
            System.out.println(c);
        }
        System.out.println("Press 0 to get back to the menu.");
        while (!tilbage) {
            int tilbageTilMenu = input.nextInt();
            if (tilbageTilMenu == 0) {
                tilbage = true;
            } else {
                System.out.println("Press 0 to go back to the menu.");
            }

        }

    }

    public static void deleteCustomer() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the full name of the customer you want to delete:");
        String name = input.nextLine();

        customerDatabase.deleteCustomer(name);

        System.out.println("Press 0 to go back to the main menu.");
        input.nextLine();
    }

}


