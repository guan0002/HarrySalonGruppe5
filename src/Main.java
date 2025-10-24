import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

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

        System.out.println("Write time: ");
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
