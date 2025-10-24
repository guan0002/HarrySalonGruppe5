import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Gruppe5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        ArrayList<Customer> CustomerBookings = new ArrayList<>();
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

            System.out.println(printMenus[0]);
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
                Economics= 4;
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



        Customer c1 = new Customer("Jens", "jens@pik.dk", LocalDate.of(2025, 10, 24), LocalTime.of(13, 12));
        CustomerBookings.add(c1);

    }
}
