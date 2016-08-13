import java.util.Scanner;

/**
 * Created by Thiloshon on 13-Aug-16.
 */
public class Queue {

    
    static Object queueArray[] = new Object[7];
    static int front = 0, end = 0;

    static void addqueue(Object object) {//1 rent, 2 customer, 3 room

        if (end == 6) {
            System.out.println("The queue is full. The first value will be replaced by the new value");
            end = 0;
            front = 1;
            queueArray[end] = object;

        }else if (front<end){
            queueArray[end] = object;
            end++;
        }else {
            System.out.println("The queue is full. The first value will be replaced by the new value");

        }


    }

    static void takequeue() {
        if (end > front) {
            System.out.println("Item taken :" + queueArray[front]);
            front++;
        } else {
            System.out.println("Empty queue");
        }
    }

    static void displayqueue() {
        System.out.println("Queue display: ");
        for (int look = front; look < end; look++) {
            System.out.print(" " + queueArray[look]);
        }
        System.out.println("");
    }



}
