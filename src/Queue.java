import java.util.*;

/**
 * Created by Thiloshon on 13-Aug-16.
 */
public class Queue {

    
    static Rent queueArray[] = new Rent[7];
    static int front = -1, end = -1;



    static void addToQueue(Rent rent) {//1 rent, 2 customer, 3 room

        if (front == -1){
            front++;
            end++;
            queueArray[end] = rent;
        } else if (end == 6) {
            System.out.println("The queue is full. The first value will be replaced by the new value");
            end = 0;
            front = 1;
            // TODO Peek Queue Implement here:
            queueArray[end] = rent;
        }else if (front<=end){
            end++;
            queueArray[end] = rent;

        }else if (front==6){
            System.out.println("The queue is full. The first value will be replaced by the new value");
            // TODO Peek Queue Implement here:
            end++;
            front = 0;
            queueArray[end] = rent;
        }else if (end<front){
            System.out.println("The queue is full. The first value will be replaced by the new value");
            // TODO Peek Queue Implement here:
            end++;
            front++;
            queueArray[end] = rent;
        }


    }

    static Rent takeFromQueue() {

    return queueArray[front];

    }

    static void displayqueue() {
        System.out.println("Queue display: ");
        for (int look = front; look < end; look++) {
            System.out.print(" " + queueArray[look]);
        }
        System.out.println("");
    }



}
