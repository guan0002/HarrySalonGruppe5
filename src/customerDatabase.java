import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class customerDatabase {
    public static void loadDatabase() throws IOException {
        FileReader cdb = new FileReader("src/customerDatabase.txt");
        BufferedReader load = new BufferedReader(cdb);

        String line = load.readLine();
        while (line != null)
        {
            String[] entry = line.split(",");
            String name = entry[0];
            String email= entry[1];
            LocalDate date = LocalDate.parse(entry[3]);
            LocalTime time = LocalTime.parse(entry[4]);
            saveCustomer(name, email, date, time);
            line = load.readLine();
        }
        load.close();
    } // main

    static void saveCustomer(String name, String email, LocalDate date, LocalTime time) throws IOException {
        FileWriter fil = new FileWriter("src/customerDatabase.txt");
        PrintWriter ud = new PrintWriter(fil);
        ud.println("Saved.");
        ud.close();
    }
}