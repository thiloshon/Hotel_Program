import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiloshon on 25-Apr-16.
 *
 * The Rent ModelClass. Each renting of room creates one rent object.
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



    public String getRoomID() {
        return roomID;
    }



    public String getCustomerID() {
        return customerID;
    }


}
