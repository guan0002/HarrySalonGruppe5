import java.time.LocalDate;
import java.time.LocalTime;

public class Customer {

    String name;
    LocalDate date;
    LocalTime time;
    String email;

    public Customer(String name, String email, LocalDate date, LocalTime time) {
        this.name=name;
        this.email=email;
        this.date=date;
        this.time=time;
    }

    @Override
    public String toString() {
        return "name";
    }
}
