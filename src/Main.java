import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Customer> CustomerBookings= new ArrayList<>();

        Customer c1 = new Customer("Jens", "jens@pik.dk", LocalDate.of(2025, 10, 24), LocalTime.of(13, 12));
        CustomerBookings.add(c1);
    }
}
