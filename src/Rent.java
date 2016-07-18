import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiloshon on 25-Apr-16.
 *
 * The Take ModelClass. Each attempt of each module creates one take object.
 */
public class Rent implements java.io.Serializable{

    private String customerID;
    private String roomID;
    private int days;
    private int payment;
    private int paid;



    public Rent(String customerID, String roomID, int days, int payment, int paid) {
        this.customerID = customerID;
        this.roomID = roomID;
        this.days = days;
        this.payment = payment;
        this.paid = paid;

    }

    @Override
    public String toString() {
        return "Take{" +
                "customerID='" + customerID + '\'' +
                ", roomID='" + roomID + '\'' +
                ", days=" + days +
                ", payment=" + payment +
                ", paid=" + paid +
                '}';
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
