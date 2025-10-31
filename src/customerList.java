import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class customerList {


    public static ArrayList<Customer> show() throws IOException {


    Scanner inputpass = new Scanner(System.in);


    String password1 = "hairyharry";                //harry's password
    String password2 = "x";                         //password til testing *(under udvikling af systemet)*
    System.out.print("Enter password to view customer details: ");
    String enteredPassword = inputpass.nextLine();

    if (!enteredPassword.equals(password1) && !enteredPassword.equals(password2)) {     //password2 = test password
        System.out.println("Wrong password!");
        return null;
    }

        ArrayList<Customer> customerBookings = customerDatabase.loadDatabase();     //loader database listen før vi kalder den

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

        return customerBookings;
    }

}



