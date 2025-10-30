import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class customerDatabase {
    public static ArrayList<Customer> loadDatabase() throws IOException {
        ArrayList<Customer> customers = new ArrayList<>();

        FileReader cdb = new FileReader("src/customerDatabase.txt");
        BufferedReader load = new BufferedReader(cdb);

        String line = load.readLine();
        while (line != null) {
            String[] entry = line.split(",");

            if (entry.length < 4) {
                line = load.readLine();
                continue; // hopper over den forkerte linje
            }

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MM yyyy", Locale.ENGLISH);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalDate date = LocalDate.parse(entry[0].trim(), dateFormatter);
            LocalTime time = LocalTime.parse(entry[1].trim(), timeFormatter);
            String name = entry[2];
            String email = entry[3];


            Customer c = new Customer(name, email, date, time);
            if (entry.length > 4) {
                try {
                    c.lastPayment = Double.parseDouble(entry[4]);
                } catch (Exception e) {
                    c.lastPayment = 0;
                }

                if (entry.length > 5) {
                    c.lastHaircutType = entry[5];
                }

                if (entry.length > 6) {
                    String productString = entry[6];
                    if (!productString.isEmpty()) {
                        c.lastProducts = productString.split(";");
                    }
                }
            }
            customers.add(c);

            line = load.readLine();
        }
        load.close();
        return customers;

    }

    public static void saveCustomersToFile(ArrayList<Customer> customers) throws IOException {

        FileWriter file = new FileWriter("src/customerDatabase.txt", false);
        PrintWriter out = new PrintWriter(file);

        for (Customer c : customers) {
            out.println(c.toString());
        }

        out.close();
    }

    static void saveCustomer(Customer c) throws IOException {
        FileWriter file = new FileWriter("src/customerDatabase.txt", true);
        PrintWriter updateList = new PrintWriter(file);

        updateList.println(c.toString());
        updateList.close();
    }

    public static Customer findCustomerByName(String name) throws IOException {
        ArrayList<Customer> customer = loadDatabase();

        for (Customer c : customer) {
            if (name.equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    static void deleteCustomer(String name) throws IOException {
        ArrayList<Customer> customers = loadDatabase();
        boolean removed = customers.removeIf(c -> c.name.equalsIgnoreCase(name));

        if (!removed) {
            System.out.println("Customer not found.");
            return;
        }

        FileWriter writer = new FileWriter("src/customerDatabase.txt", false);
        PrintWriter dc = new PrintWriter(writer);

        for (Customer c : customers) {
            dc.println(c.toString());
        }
        dc.close();
        System.out.println("Customer deleted: " + name);
    }
}


