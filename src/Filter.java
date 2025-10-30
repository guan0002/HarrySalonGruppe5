import java.util.Scanner;

public class Filter {

    public static Scanner IntFilter = new Scanner(System.in);

    public static int FilterNumber(String filter) {
        while (true) {
            System.out.println(filter);
            String input = IntFilter.nextLine().trim();

            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Please a valid number:");

                }
            } else {
                System.out.println("Please enter a valid number:");
            }
        }

    }
}
