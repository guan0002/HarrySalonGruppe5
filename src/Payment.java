import java.util.Scanner;

public class Payment {

    Customer customer;
    double amount;
    String paymentMethod;

    public Payment(Customer customer, double amount, String paymentMethod) {
        this.customer = customer;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public static double payment() {
        Scanner klipning = new Scanner(System.in);
        double M = 299.99;
        double W = 599.99;
        double C = 199.99;
        double H = 30.99;
        double S = 40.99;
        double P1 = 25.99;
        double P2 = 20.99;
        double P3 = 15.99;
        boolean haircut = false;
        double total=0;

        System.out.println("Which type of haircut has the customer recieved?");
        System.out.println("Press M for mens cut");
        System.out.println("Press W for womens cut");
        System.out.println("Press C for childrens cut");
        String chooseHaircut;

        while (!haircut) {
            chooseHaircut = klipning.nextLine().trim().toUpperCase();
            if (chooseHaircut.equalsIgnoreCase("M")) {
                System.out.println("The price on the haircut will be " + M + "kr.");
                System.out.println("Would you like to add a product to the purchase?");
                System.out.println("Yes or No?");

                String addProduct = klipning.nextLine().trim().toUpperCase();

                if (addProduct.equalsIgnoreCase("Yes")) {
                    System.out.println("Hair Wax = H \n Shampoo = S \n product1 = P1 \n product2 = P2 \n product3 = P3");
                    String product = klipning.nextLine().trim().toUpperCase();
                    if (product.equalsIgnoreCase("H")) total = M + H;
                    else if (product.equalsIgnoreCase("S")) total = M + S;
                    else if (product.equalsIgnoreCase("P1")) total = M + P1;
                    else if (product.equalsIgnoreCase("P2")) total = M + P2;
                    else if (product.equalsIgnoreCase("P3")) total = M + P3;
                    else total = M;
                    haircut = true;
                } else if (addProduct.equalsIgnoreCase("No")) {
                    total = M;
                    haircut = true;
                } else {
                    System.out.println("Write either Yes or No.");
                }


            } else if (chooseHaircut.equalsIgnoreCase("W")) {
                System.out.println("The price on the haircut will be " + W + "kr.");
                System.out.println("Would you like to add a product to the purchase?");
                System.out.println("Yes or No?");

                String addProduct = klipning.nextLine().trim().toUpperCase();

                if (addProduct.equalsIgnoreCase("Yes")) {
                    System.out.println("Hair Wax = H \n Shampoo = S \n product1 = P1 \n product2 = P2 \n product3 = P3");
                    String product = klipning.nextLine().trim().toUpperCase();
                    if (product.equalsIgnoreCase("H")) total = W + H;
                    else if (product.equalsIgnoreCase("S")) total = W + S;
                    else if (product.equalsIgnoreCase("P1")) total = W + P1;
                    else if (product.equalsIgnoreCase("P2")) total = W + P2;
                    else if (product.equalsIgnoreCase("P3")) total = W + P3;
                    else total = W;
                    haircut = true;
                } else if (addProduct.equalsIgnoreCase("No")) {
                    total = W;
                    haircut = true;
                } else {
                    System.out.println("Write either Yes or No.");
                }

            } else if (chooseHaircut.equalsIgnoreCase("C")) {
                System.out.println("The price on the haircut will be " + C + "kr.");
                System.out.println("Would you like to add a product to the purchase?");
                System.out.println("Yes or No?");

                String addProduct = klipning.nextLine().trim().toUpperCase();

                if (addProduct.equalsIgnoreCase("Yes")) {
                    System.out.println("Hair Wax = H \n Shampoo = S \n product1 = P1 \n product2 = P2 \n product3 = P3");
                    String product = klipning.nextLine().trim().toUpperCase();
                    if (product.equalsIgnoreCase("H")) total = C + H;
                    else if (product.equalsIgnoreCase("S")) total = C + S;
                    else if (product.equalsIgnoreCase("P1")) total = C + P1;
                    else if (product.equalsIgnoreCase("P2")) total = C + P2;
                    else if (product.equalsIgnoreCase("P3")) total = C + P3;
                    else total = C;
                    haircut = true;
                } else if (addProduct.equalsIgnoreCase("No")) {
                    total = C;
                    haircut = true;
                } else {
                    System.out.println("Write either Yes or No.");
                }

            } else {
                System.out.println("You have to press either M, W or C.");
            }


        }
        System.out.println(total);
        boolean gåTilMenu = false;
        while(!gåTilMenu) {
            klipning.nextInt();
            if (klipning.nextInt()==0) {
                gåTilMenu=true;
            }
            else {
                System.out.println("You have to press = to gå bacl to the menu!");
            }
        }
        return total;

    }
}


