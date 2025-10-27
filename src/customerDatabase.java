import java.io.*;

public class customerDatabase {
    public static void main(String[] args) throws IOException {
        FileReader cdb = new FileReader("src/customerDatabase.txt");
        BufferedReader load = new BufferedReader(cdb);

        String line = load.readLine();
        while (line != null)
        {
            String[] entry = line.split(",");
            String name = entry[0];
            int startNo=Integer.parseInt(entry[1]);
            char startGroup=entry[2].charAt(0);
            saveRegistration(name, startNo, startGroup);
            line = load.readLine();
        }
        load.close();
    } // main

    static void saveRegistration(String name, int startNumber, char startGroup) throws IOException {
        FileWriter fil = new FileWriter("src/Copenhagen Marathon "+name+".txt");
        PrintWriter ud = new PrintWriter(fil);
        ud.println("Dear "+name+" !");
        ud.println("We are happy to receive your registration.");
        ud.println("Your start number is: "+ startNumber);
        ud.println("You start in start group: "+startGroup);
        ud.println("Please check in 10 minutes before start.");
        ud.close();
    }
}