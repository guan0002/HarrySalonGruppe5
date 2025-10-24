import java.util.Scanner;

public class Gruppe5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your booking system!\n");
        System.out.println("Press 1-9 to access the different menus\n");
        System.out.println("Press 0 to go back to the main menu\n");

        int choice = scanner.nextInt();

        int booking = 1;
        int delete = 2;

        switch (choice) {
            case 1:
                booking = 1;

            case 2:
                delete = 2;

        }




    }
}
