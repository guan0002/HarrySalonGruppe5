import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Welcome to your booking system!\n");
            System.out.println("Press 1-9 to access the different menus\n");
            System.out.println("Press 0 to go back to the main menu\n");

            String[] printMenus = {
                    "",
                    "Booking",
                    "CustomerList",
                    "Creditors",
                    "Economics",
                    "Vacation",
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
                    break;

                case 2:
                    CustomerList = 2;
                    break;

                case 3:
                    Creditors = 3;
                    break;

                case 4:
                    Economics = 4;
                    break;

                case 5:
                    Vacation = 5;
                    break;

                case 6:
                    test4 = 6;
                    break;

                case 7:
                    test5 = 7;
                    break;

                case 8:
                    test6 = 8;
                    break;

                case 9:
                    test7 = 9;
                    break;

                default:
                    System.out.println("Please enter a valid choice");


            }
        }
    }

         public void Booking() {

            ArrayList<Customer> customerBookings = new ArrayList<>();
            Scanner input = new Scanner(System.in);


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


            Customer c = new Customer(name, email, date, time);


            customerBookings.add(c);

            input.close();


        }
}
