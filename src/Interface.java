import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Apr-16.
 * Base Template copied from SDP 1 CW 2.
 * This Class Deals with all the Interface Inputs and Interface Outputs.
 * Methods: welcomePage, start, modules, viewModules, addNewModules
 */
public class Interface {

    Scanner sc = new Scanner(System.in);


    /**
     * The First output. Welcome page.
     */
    public void run() {


        //loadData(); // First load of data

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM -------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                  WELCOME TO THE HOTEL PROGRAM");
        System.out.println("");

        start();
    }


    /**
     * The First Menu. Other methods calls this method often since this is the primary menu.
     */
    public void start() {

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your option:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("A Add New Customer To A Room");
        System.out.println("V View All Rooms");
        System.out.println("D Delete Customer From Room");
        //System.out.println("F Find Room From Customer Name");
        System.out.println("S Store Program Array Data Into A Plain Text File");
        System.out.println("L Load Program Data Back From The File Into The Array");
        //System.out.println("O View Rooms Ordered Alphabetically By Name");
        System.out.println("T View First Three Customers");
        System.out.println("");

        String option;

        do {
            while (!sc.hasNextLine()) {
                System.out.println("Please Choose A Letter:");
                sc.next();
            }
            option = sc.nextLine();
            option = option.toUpperCase();

            if (!(option.equals("A") || option.equals("V") || option.equals("E") || option.equals("D") || option.equals("F")
                    || option.equals("S") || option.equals("L") || option.equals("T"))) {
                System.out.println("Please Choose Your Option Among The Letters Given Above:");
            }
        }
        while (!(option.equals("A") || option.equals("V") || option.equals("E") || option.equals("D")
                || option.equals("F") || option.equals("S") || option.equals("L") || option.equals("T")));


        switch (option) {
            case "A":
                addNewCustomer();
                break;
            case "V":
                viewRooms();
                break;
            case "E":
                displayEmptyRooms();
                break;
            case "D":
                deleteCustomer();
                break;
            case "F":
                //findRoomFromName();
                break;
            case "S":
                saveData();
                break;
            case "L":
                loadData();
                break;
            case "T":
                sortData();//TODO Change method name
                break;

        }
    }


    /**
     * The Modules Menu. Has all the required functions of modules.
     */
    public void findRoomFromName() {
        System.out.println("Customer name Please: ");
        String name = sc.nextLine();

        String id = null;
        for (Customer cus : FileHandler.getCustomerList()) {
            if (cus.getName().equalsIgnoreCase(name)) {
                id = cus.getiDNo();
            }
        }

        if (id == null) {
            System.out.println("No such Customer");
        } else {
            /*for(Rent rt : FileHandler.getRentList()){
               if (rt.getCustomerID().equalsIgnoreCase(id)){
                   System.out.print(rt.getRoomID());
               }
            }*/
        }

        start();

    }


    /**
     * Method to add new Student.
     */
    public void addNewCustomer() { //TODO Validations
        System.out.println("Customer ID Please: ");
        String customerID = sc.nextLine();

        System.out.println("Room ID Please: ");
        String roomID = sc.nextLine();

        Rent rent = new Rent(customerID, roomID, 4, 1000, 500);


        FileHandler.getRentQueue().addToQueue(rent);

        FileHandler.getRentQueue().testPeek();
       /* while (!sc.hasNextLine()) {
            System.out.println("Integer Please");
            customerID=sc.nextLine();
        }*/



       /* boolean customerCheck = true;
        for (Customer st : FileHandler.getCustomerList()) {
            if (customerID.equalsIgnoreCase(st.getiDNo())) {
                customerCheck = false;
            }
        }

        if (customerCheck) {
            System.out.println("Name of the Customer: ");
            //sc.nextLine();
            String name = sc.nextLine();
            *//*System.out.println("ID of the Student: ");
            String iD = sc.nextLine();*//*

            Customer stu = new Customer(name, customerID);

            System.out.println("Customer " + name + " created successfully.");

            FileHandler.getCustomerList().add(stu);
            //System.out.println(FileHandler.getStudentsList());
            System.out.println("Room No: ");
            String roomID = sc.nextLine();

            boolean roomCheck = true;
            for (Room st : FileHandler.getRoomList()) {
                if (roomID.equalsIgnoreCase(st.getRoomID())) {
                    roomCheck=false;

                }
            }
            if (roomCheck){
                System.out.println("No Such Room, Creating one...");
                Room room = new Room(roomID, "King");
                FileHandler.getRoomList().add(room);
            }

            System.out.println("No of days staying:");
            int days = sc.nextInt();

            System.out.println("Amount paid: ");
            int paid = sc.nextInt();

            Rent rent = new Rent(customerID, roomID, days, paid, 0);
            FileHandler.getRentList().add(rent);


            start();

            //saveData();
        } else {
            System.out.println("Room No: ");
            String roomID = sc.nextLine();

            boolean roomCheck = true;
            for (Room st : FileHandler.getRoomList()) {
                if (roomID.equalsIgnoreCase(st.getRoomID())) {
                    roomCheck=false;

                }
            }
            if (roomCheck){
                System.out.println("No Such Room, Creating one...");
                Room room = new Room(roomID, "King");
                FileHandler.getRoomList().add(room);
            }

            System.out.println("No of days staying:");
            int days = sc.nextInt();

            System.out.println("Amount paid: ");
            int paid = sc.nextInt();

            Rent rent = new Rent(customerID, roomID, days, paid, 0);
            FileHandler.getRentList().add(rent);


            start();
        }*/

        start();
    }


    /**
     * This method adds marks of the students.
     */
    public void viewRooms() {
        FileHandler.getRentQueue().traverseThroughQueue();


        start();

    }


    /**
     * This method gives the award of the student queried.
     */
    public void deleteCustomer() {


        start();

    }


    /**
     * The method prints all the students enrolled.
     */
    public void displayEmptyRooms() {
        for (Room rm : FileHandler.getRoomList()) {
            //System.out.print(rm.getRoomID());
            boolean isFree = true;

            for (int x = FileHandler.getRentQueue().front; x <= FileHandler.getRentQueue().end; ) {
                if (rm.getRoomID().equalsIgnoreCase(FileHandler.getRentQueue().queueArray[x].getCustomerID())) {
                    isFree = false;
                }
            }


            //System.out.println("Occupied by " + rent.getCustomerID());

            if (isFree) {
                System.out.println(rm.getRoomID());
            }
        }

    }


    /**
     * This method loads all the data from files.
     */
    public void loadData() {

        FileHandler.LoadCustomerDataFromFile();
        FileHandler.LoadRentDataFromFile();
        FileHandler.LoadRoomDataFromFile();
        System.out.println("Data Loaded Successfully");
        start();


    }


    /**
     * This method saves all the data to file.
     */
    public void saveData() {
        FileHandler.saveCustomerDataToFile();
        FileHandler.saveRentDataToFile();
        FileHandler.saveRoomDataToFile();

        System.out.println("Data Saved Successfully");

        start();


    }

    /**
     * This method dequeue and print it to the screen.
     */
    public void sortData() {
        FileHandler.getRentQueue().displayQueue();
        start();
    }

}
