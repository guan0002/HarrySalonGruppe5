import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Customer {

    String name;
    LocalDate date;
    LocalTime time;
    ArrayList<Customer> CustomerBookings= new ArrayList<>();

    public Customer(String name, LocalDate date, LocalTime time) {
        this.name=name;
        this.date=date;
        this.time=time;
    }

    public void BookCustomer() {

    }

}
