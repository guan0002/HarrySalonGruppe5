import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Customer implements Comparable<Customer> {

    String name;
    LocalDate date;
    LocalTime time;
    String email;
    double lastPayment;
    String lastHaircutType;
    String[] lastProducts;

    public Customer(String name, String email, LocalDate date, LocalTime time) {
        this.name=name;
        this.email=email;
        this.date=date;
        this.time=time;
        this.lastPayment = 0;
        this.lastHaircutType="";
        this.lastProducts = new String[10];
    }

    public void setPaymentDate(double total, String haircutType, String[] products) {
        this.lastPayment = total;
        this.lastHaircutType = haircutType;
        this.lastProducts = products;
    }

    public String toString() {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    String productList = String.join(";", lastProducts);
    return name + "," + email + "," + date + "," + time + "," +
            lastPayment + "kr," + lastHaircutType + "," + productList;
}

    public int compareTo(Customer o) {
        return this.date.compareTo(o.date);
    }



    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}


