import java.io.IOException;

import java.util.ArrayList;
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

    public void payment() throws IOException {
        Scanner klipning = new Scanner(System.in);
        double M = 299.99;
        double W = 599.99;
        double C = 199.99;
        double H = 30.99;
        double S = 40.99;
        double HB = 25.99;
        double P2 = 20.99;
        double P3 = 15.99;
        boolean haircut = false;
        double total = 0;

        System.out.println("Which type of haircut has the customer recieved?");
        System.out.println("Press M for Men´s haircut");
        System.out.println("Press W for Women´s haircut");
        System.out.println("Press C for Children´s haircut");
        String chooseHaircut;

        String haircutType = "";
        String[] chosenProduct = new String[10];
        int productIndex = 0;

        while (!haircut) {
            chooseHaircut = klipning.nextLine().trim().toUpperCase();
            if (chooseHaircut.equalsIgnoreCase("M")) {
                haircutType = "Men´s haircut";
                System.out.println("The price on the haircut will be " + M + "kr.");
                System.out.println("Would you like to add a product to the purchase?");
                System.out.println("Yes or No?");

                String addProduct = klipning.nextLine().trim().toUpperCase();

                if (addProduct.equalsIgnoreCase("Yes")) {
                    System.out.println("Hair Wax = H \n Shampoo = S \n HairBrush = HB \n product2 = P2 \n product3 = P3");
                    String product = klipning.nextLine().trim().toUpperCase();
                    if (product.equalsIgnoreCase("H")) {
                        total = total + M + H;
                        chosenProduct[productIndex++] = "Hair Wax";
                    } else if (product.equalsIgnoreCase("S")) {
                        total = total + M + S;
                        chosenProduct[productIndex++] = "Shampoo";
                    } else if (product.equalsIgnoreCase("HB")) {
                        total = total + M + HB;
                        chosenProduct[productIndex++] = "HairBrush";
                    } else if (product.equalsIgnoreCase("P2")) {
                        total = total + M + P2;
                        chosenProduct[productIndex++] = "Product2";
                    } else if (product.equalsIgnoreCase("P3")) {
                        total = total + M + P3;
                        chosenProduct[productIndex++] = "Product3";
                    } else total = total + M;
                    haircut = true;
                } else if (addProduct.equalsIgnoreCase("No")) {
                    total = total + M;
                    haircut = true;
                } else {
                    System.out.println("Write either Yes or No.");
                }


            } else if (chooseHaircut.equalsIgnoreCase("W")) {
                haircutType = "Women´s Haircut";
                System.out.println("The price on the haircut will be " + W + "kr.");
                System.out.println("Would you like to add a product to the purchase?");
                System.out.println("Yes or No?");

                String addProduct = klipning.nextLine().trim().toUpperCase();

                if (addProduct.equalsIgnoreCase("Yes")) {
                    System.out.println("Hair Wax = H \n Shampoo = S \n HairBrush = HB \n product2 = P2 \n product3 = P3");
                    String product = klipning.nextLine().trim().toUpperCase();
                    if (product.equalsIgnoreCase("H")) {
                        total = total + W + H;
                        chosenProduct[productIndex++] = "Hair Wax";
                    } else if (product.equalsIgnoreCase("S")) {
                        total = total + W + S;
                        chosenProduct[productIndex++] = "Shampoo";
                    } else if (product.equalsIgnoreCase("HB")) {
                        total = total + W + HB;
                        chosenProduct[productIndex++] = "HairBrush";
                    } else if (product.equalsIgnoreCase("P2")) {
                        total = total + W + P2;
                        chosenProduct[productIndex++] = "Product2";
                    } else if (product.equalsIgnoreCase("P3")) {
                        total = total + W + P3;
                        chosenProduct[productIndex++] = "Product3";
                    } else total = total + W;
                    haircut = true;
                } else if (addProduct.equalsIgnoreCase("No")) {
                    total = total + W;
                    haircut = true;
                } else {
                    System.out.println("Write either Yes or No.");
                }

            } else if (chooseHaircut.equalsIgnoreCase("C")) {
                haircutType = "Children´s Haircut";
                System.out.println("The price on the haircut will be " + C + "kr.");
                System.out.println("Would you like to add a product to the purchase?");
                System.out.println("Yes or No?");

                String addProduct = klipning.nextLine().trim().toUpperCase();

                if (addProduct.equalsIgnoreCase("Yes")) {
                    System.out.println("Hair Wax = H \n Shampoo = S \n HairBrush = HB \n product2 = P2 \n product3 = P3");
                    String product = klipning.nextLine().trim().toUpperCase();
                    if (product.equalsIgnoreCase("H")) {
                        total = total + C + H;
                        chosenProduct[productIndex++] = "Hair Wax";
                    } else if (product.equalsIgnoreCase("S")) {
                        total = total + C + S;
                        chosenProduct[productIndex++] = "Shampoo";
                    } else if (product.equalsIgnoreCase("HB")) {
                        total = total + C + HB;
                        chosenProduct[productIndex++] = "HairBrush";
                    } else if (product.equalsIgnoreCase("P2")) {
                        total = total + C + P2;
                        chosenProduct[productIndex++] = "Product2";
                    } else if (product.equalsIgnoreCase("P3")) {
                        total = total + C + P3;
                        chosenProduct[productIndex++] = "Product3";
                    } else total = total + C;
                    haircut = true;
                } else if (addProduct.equalsIgnoreCase("No")) {
                    total = total + C;
                    haircut = true;
                } else {
                    System.out.println("Write either Yes or No.");
                }

            } else {
                System.out.println("You have to press either M, W or C.");
            }

        }
        System.out.println("Your total is: " + total + "kr");

        customer.setPaymentDate(total, haircutType, chosenProduct);


        ArrayList<Customer> customers = customerDatabase.loadDatabase();

        for (Customer c : customers) {
            if (c.name.equalsIgnoreCase(customer.name)
                    && c.email.equalsIgnoreCase(customer.email)
                    && c.date.equals(customer.date)) {

                c.lastPayment = customer.lastPayment;
                c.lastHaircutType = customer.lastHaircutType;
                c.lastProducts = customer.lastProducts;
                break;
            }
        }

        customerDatabase.saveCustomersToFile(customers);

        System.out.println("✅ Payment saved for customer: " + customer.name);


        System.out.println("Press 0 to go back to the menu.");
        boolean gåTilMenu = false;

        while (!gåTilMenu) {
            int choice = klipning.nextInt();
            if (choice == 0) {
                gåTilMenu = true;
            } else {
                System.out.println("You have to press 0 to go back to the menu!");
            }
        }

    }
}



