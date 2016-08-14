import java.util.*;

/**
 * Created by Thiloshon on 13-Aug-16.
 */
public class Queue implements java.io.Serializable{


     Rent queueArray[] = new Rent[7];
     int front = -1, end = -1;


     void addToQueue(Rent rent) {//1 rent, 2 customer, 3 room

         // The best algorithm would be :
         //     var nextIndex = (lastKnownIndex + 1) % 7
         //

        if (front == -1) {
            front++;
            end++;
            queueArray[end] = rent;
        } else if (end == 6) {
            System.out.println("The queue is full. The first value will be replaced by the new value");
            end = 0;
            front = 1;
            peekQueue();
            queueArray[end] = rent;
        } else if (front <= end) {
            end++;
            queueArray[end] = rent;

        } else if (front == 6) {
            System.out.println("The queue is full. The first value will be replaced by the new value");
            peekQueue();
            end++;
            front = 0;
            queueArray[end] = rent;
        } else if (end < front) {
            System.out.println("The queue is full. The first value will be replaced by the new value");
            peekQueue();
            end++;
            front++;
            queueArray[end] = rent;
        }


    }

     Rent takeFromQueue() {

        Rent rentTemp = null;

        if (end == -1) {
            System.out.println("Empty Queue! Populate queue first!");

        } else {
            rentTemp = queueArray[front];

            if (end == front) {
                end = front = -1;
            } else if (front == 6) {
                front = 0;
            } else {
                front++;
            }
        }

        return rentTemp;

    }

     void displayQueue() {

        for (int x = 0; x < 3; x++) {
            Rent ren = takeFromQueue();
            if (ren != null){
                System.out.println(ren.getCustomerID());
                testPeek();
            }


        }


    }

     void peekQueue() {

        System.out.println(queueArray[front].getCustomerID());
        // TODO Finish Peek Queue Implementation:

    }

     void testPeek() {

        System.out.println("Front is " + front);
        System.out.println("End is " + end);

        for (int x =0; x<7; x++){
            if (queueArray[x]!=null){
                System.out.println(x + " is " + queueArray[x].getCustomerID());
            }else {
                System.out.println(x + " is null" );
            }
        }



    }

    void traverseThroughQueue(){

        for (int x = front; x<=end; ){
            System.out.println(queueArray[x].getRoomID() + " is rented by " + queueArray[x].getCustomerID());

            x = ++x % queueArray.length;

        }

    }

}
