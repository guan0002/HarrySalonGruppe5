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
        int test1 = 3;
        int test2 = 4;
        int test3 = 5;
        int test4 = 6;
        int test5 = 7;
        int test6 = 8;
        int test7 = 9;

        switch (choice) {
            case 1:
                booking = 1;
                break;

            case 2:
                delete = 2;
                break;

            case 3:
                test1 = 3;
                break;

            case 4:
                test2 = 4;
                break;

            case 5:
                test3 = 5;
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


        }




    }
}
