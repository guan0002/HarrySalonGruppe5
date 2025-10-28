import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    static ArrayList<Customer> customerBookings = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        customerBookings = customerDatabase.loadDatabase();


        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\033[1mWelcome to your booking system! 💻\033[0m\n");
            System.out.println("Press 1-9 to access the different menus\n");
            System.out.println("Press 0 to go back to the main menu\n");

            String[] printMenus = {
                    "",
                    "Booking 📇",
                    "CustomerList 👥",
                    "Creditors 💸",
                    "Economics 📈",
                    "Vacation 🏖",
                    "test4",
                    "test5",
                    "test6",
                    "test7",
            };


            for (int i = 1; i < printMenus.length; i++) {
                System.out.println(i + ": " + printMenus[i]);
            }
            System.out.println("Enter a number:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            int Booking = 1;
            int CustomerList = 2;
            int Creditors = 3;
            int Economics = 4;
            int Vacation = 5;
            int test4 = 6;
            int test5 = 7;
            int test6 = 8;
            int test7 = 9;

            switch (choice) {
                case 1:
                    Booking = 1;
                    Booking();
                    break;

                case 2:
                    CustomerList = 2;
                    CustomerList();
                    break;

                case 3:
                    Creditors = 3;
                    //Metode her
                    break;

                case 4:
                    Economics = 4;
                    //Metode her
                    break;

                case 5:
                    Vacation = 5;
                    //Metode her
                    break;

                case 6:
                    test4 = 6;
                    //Metode her
                    break;

                case 7:
                    test5 = 7;
                    //Metode her
                    break;

                case 8:
                    test6 = 8;
                    //Metode her
                    break;

                case 9:
                    test7 = 9;
                    //Metode her
                    break;

                default:
                    System.out.println("Please enter a valid choice");


            }
        }
    }

    public static void Booking() throws IOException {

        Scanner input = new Scanner(System.in);
        boolean tilbage = false;
        boolean bookingFail = false;


        System.out.println("Write customer name: ");
        String name = input.nextLine();

        System.out.println("Write customer mail: ");
        String email = input.nextLine();

        System.out.println("Write year: ");
        int year = input.nextInt();

        System.out.println("Write month: ");
        int month = input.nextInt();

        System.out.println("Write day: ");
        int day = input.nextInt();

        System.out.println("Write hour: ");
        int hour = input.nextInt();

        System.out.println("Write minute: ");
        int minute = input.nextInt();


        LocalDate date = LocalDate.of(year, month, day);
        LocalTime time = LocalTime.of(hour, minute);

        if (date.getDayOfWeek().toString().equals("SATURDAY") || date.getDayOfWeek().toString().equals("SUNDAY")) {
            System.out.println("Sorry, you cannot book on weekends, choose another date. ⛔");
            while (!bookingFail) {
                System.out.println("Press 0 to get back to the menu or press 1 to try making a booking again. \uD83C\uDFE0");
                int answer = input.nextInt();
                if (!input.hasNextInt()) {
                    System.out.println("Please enter a number");

                } else if (answer == 0) {
                    bookingFail = true;
                } else if (answer == 1) {
                    Booking();
                    bookingFail = true;
                } else {
                }
            }
            return;
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


        Customer c = new Customer(name, email, date, time);


        customerBookings.add(c);
        customerDatabase.saveCustomer(c);


        System.out.println("The customer " + name + " has now been added to your booking list, with the time " + date + " - " + time + ".");

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

    public static void CustomerList() {

        Scanner input = new Scanner(System.in);
        boolean tilbage = false;

        System.out.println("Customer List:");
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
}

