import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class customerDatabase {
    public static ArrayList<Customer2> loadDatabase() throws IOException {
        ArrayList<Customer2> customers = new ArrayList<>();

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

            Customer2 c = new Customer2(name, email, date, time);
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
                        c.lastProduct = productString.split(";");
                    }
                }
            }
            customers.add(c);

            line = load.readLine();
        }
        load.close();
        return customers;

    }

    static void saveCustomer(Customer2 c) throws IOException {
        FileWriter cbd = new FileWriter("src/customerDatabase.txt", true);
        PrintWriter updateList = new PrintWriter(cbd);

        updateList.println(c.name + "," + c.email + "," + c.date + "," + c.time + System.lineSeparator());
        updateList.close();
    }
    static class Customer implements Comparable<Customer> {
        String name;
        String email;
        LocalDate date;
        LocalTime time;

Customer(String name, String email, LocalDate date, LocalTime time) {
    this.name = name;
        this.email = email;
        this.date = date;
        this.time = time;
}

public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    return date.format(dateFormatter) + " " + time.format(timeFormatter) + " " + name + " " + email;
        }

public int compareTo(Customer o) {
        return this.date.compareTo(o.date);
}
    }


    static void deleteCustomer(String name) throws IOException {
        ArrayList<Customer2> customers = loadDatabase();
        boolean removed = customers.removeIf(c -> c.name.equalsIgnoreCase(name));

        if (!removed) {
            System.out.println("Customer not found.");
            return;
        }

        FileWriter writer = new FileWriter("src/customerDatabase.txt", false);
        PrintWriter dc = new PrintWriter(writer);

        for (Customer2 c : customers) {
            dc.println(c.name + "," + c.email + "," + c.date + "," + c.time);
        }
        dc.close();
        System.out.println("Customer deleted: " + name);
    }
}


