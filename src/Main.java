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

            switch (choice) {
                case 0:
                    System.out.println("You have exited the system, goodbye");
                    run = false;
                    break;

                case 1:
                    Booking(scanner);
                    break;

                case 2:
                    CustomerList(scanner);
                    break;

                case 3:
                    Creditors(scanner);
                    break;

                case 4:
                    Economics(scanner);
                    break;

                case 5:
                    Vacation(scanner);
                    break;

                case 6:
                    test4(scanner);
                    break;

                case 7:
                    test5(scanner);
                    break;

                case 8:
                    test6(scanner);
                    break;

                case 9:
                    test7(scanner);
                    break;

                default:
                    System.out.println("Please enter a valid choice");

            }
        }
        scanner.close();
    }





            ArrayList<Customer> customerBookings = new ArrayList<>();
            Scanner imput = new Scanner(System.in);


            System.out.println("Write customer name: ");
            String name = imput.nextLine();

            System.out.println("Write customer mail: ");
            String email = imput.nextLine();

            System.out.println("Write year: ");
            int year = imput.nextInt();

            System.out.println("Write month: ");
            int month = imput.nextInt();

            System.out.println("Write day: ");
            int day = imput.nextInt();

            System.out.println("Write hour: ");
            int hour = imput.nextInt();

            System.out.println("Write minute: ");
            int minute = imput.nextInt();


            LocalDate date = LocalDate.of(year, month, day);
            LocalTime time = LocalTime.of(hour, minute);


            Customer c = new Customer(name, email, date, time);


            customerBookings.add(c);

            imput.close();


        }

    }
}
