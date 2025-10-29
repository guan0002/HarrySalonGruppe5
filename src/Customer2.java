import java.time.LocalDate;
import java.time.LocalTime;

public class Customer2 {

    String name;
    LocalDate date;
    LocalTime time;
    String email;
    double lastPayment;
    String lastHaircutType;
    String[] lastProducts;

    public Customer2(String name, String email, LocalDate date, LocalTime time) {
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

    @Override
    public String toString() {
        String productList = String.join(";", lastProducts);
        return name + "," + email + "," + date + "," + time + "," +
                lastPayment + "," + lastHaircutType + "," + productList;
    }


    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
