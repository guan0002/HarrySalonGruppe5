import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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

            String name = entry[0];
            String email= entry[1];
            LocalDate date = LocalDate.parse(entry[2]);
            LocalTime time = LocalTime.parse(entry[3]);

            Customer c = new Customer(name, email, date, time);
            customers.add(c);

            line = load.readLine();
        }
        load.close();
        return customers;
    }



    static void saveCustomer(Customer c) throws IOException {
        FileWriter cbd = new FileWriter("src/customerDatabase.txt", true);
        PrintWriter updateList = new PrintWriter(cbd);

        updateList.println(c.name + "," + c.email + "," + c.date + "," + c.time + System.lineSeparator());
        updateList.close();
    }

    static void deleteCustomer(String email) throws IOException {
        ArrayList<Customer> customers = loadDatabase();
        boolean removed = customers.removeIf(c -> c.email.equalsIgnoreCase(email));

        if (!removed) {
            System.out.println("Customer not found.");
            return;
        }


        FileWriter writer = new FileWriter("src/customerDatabase.txt", false); // overwrite
        PrintWriter dc = new PrintWriter(writer);

        for (Customer c : customers) {
            dc.println(c.name + "," + c.email + "," + c.date + "," + c.time);
        }
        dc.close();
        System.out.println("Customer deleted: " + email);
    }
}


