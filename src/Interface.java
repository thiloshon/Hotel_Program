import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class Deals with all the Interface Inputs and Interface Outputs.
 * Methods: welcomePage, start, modules, viewModules, addNewModules
 */
public class Interface {

    Scanner sc = new Scanner(System.in);


    /**
     * The First output. Welcome page.
     */
    public void welcomePage() {


        loadData(); // First load of data

        System.out.println("");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM ---------------------- THE HOTEL PROGRAM -------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                  WELCOME TO THE HOTEL PROGRAM");
        System.out.println("");

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
        System.out.println("F Find Room From Customer Name");
        System.out.println("S Store Program Array Data Into A Plain Text File");
        System.out.println("L Load Program Data Back From The File Into The Array");
        System.out.println("O View Rooms Ordered Alphabetically By Name");
        System.out.println("");

        String option;

        do {
            while (!sc.hasNextLine()) {
                System.out.println("Please Choose A Letter:");
                sc.next();
            }
            option = sc.nextLine();

            if (!(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("V") ||option.equalsIgnoreCase("D") ||option.equalsIgnoreCase("F") ||option.equalsIgnoreCase("S") ||option.equalsIgnoreCase("L") ||option.equalsIgnoreCase("O") )) {
                System.out.println("Please Choose Your Option Among The Letters Given Above:");
            }
        } while (!(option.equalsIgnoreCase("A") || option.equalsIgnoreCase("V") ||option.equalsIgnoreCase("D") ||option.equalsIgnoreCase("F") ||option.equalsIgnoreCase("S") ||option.equalsIgnoreCase("L") ||option.equalsIgnoreCase("O") ));


        switch (option) {
            case "A":
                addNewStudent();
                break;
            case "V":
                addMarks();
                break;
            case "D":
                viewStudents();
                break;
            case "F":
                generateAwards();
                break;
            case "S":
                modules();
                break;
            case "L":
                generateRecords();
                break;
        }
    }


    /**
     * The menu for generating awards.
     */
    public void generateRecords() {
        System.out.println("1 List of Students with Resits");
        System.out.println("2 List of Students with Retakes");
        System.out.println("3 Resits in a Specific Module");
        System.out.println("4 Retakes in a Specific Module");
        System.out.println("5 List of Passed Students");
        System.out.println("6 List of Exclusions");
        System.out.println("7 Records of Student");
        System.out.println("8 Marks of Student");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Calculations.allResits();
                break;
            case 2:
                Calculations.allRetakes();
                break;
            case 3:
                Calculations.moduleResit();
                break;
            case 4:
                Calculations.moduleRetake();
                break;
            case 5:
                Calculations.passedStudents();
                break;
            case 6:
                Calculations.exclusions();
                break;
            case 7:
                Calculations.studentRecord();
                break;
            case 8:
                Calculations.studentMark();
                break;
        }
        start();
    }


    /**
     * The Modules Menu. Has all the required functions of modules.
     */
    public void modules() {

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Choose your option:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1 Add New Module");
        System.out.println("2 Edit Module");
        System.out.println("3 View Module");
        System.out.println("4 Back");
        System.out.println("");

        int option;

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Please choose your option Between 1 to 4:");
                sc.next();
            }
            option = sc.nextInt();

            if (!(option >= 1 && option <= 4)) {
                System.out.println("Please choose your option Between 1 to 4:");
            }
        } while (option < 1 || option > 4);


        switch (option) {
            case 1:
                addNewModule();
                modules();
                break;
            case 2:
                editModule();
                modules();
                break;
            case 3:
                viewModules();
                modules();
                break;
            case 4: {
                start();
            }
        }

        saveData();
        start();


    }


    /**
     * Method to just view all the modules.
     */
    public void viewModules() {
        for (int x = 0; x < FileHandler.getModules().size(); x++) {
            System.out.print((x + 1) + "   " + FileHandler.getModules().get(x).getModuleCode());
            System.out.print(("  " + FileHandler.getModules().get(x).getModuleName()));
            System.out.print(("  Level " + FileHandler.getModules().get(x).getCreditLevel()));
            System.out.print(("  " + FileHandler.getModules().get(x).getCreditValue() + " Credits\n"));
            System.out.print(("  " + FileHandler.getModules().get(x).getAssignments() + "\n"));

        }
    }


    /**
     * Method to add a module.
     */
    public void addNewModule() {

        System.out.println(FileHandler.getModules());
        System.out.println("Module Name: ");
        sc.nextLine();
        String module = sc.nextLine();
        System.out.println("Module Code: ");
        String code = sc.nextLine();

        boolean bol = false;

        try {
            for (Module md : FileHandler.getModules()) {
                //System.out.print("im in loop");
                bol = true;
                if (md.getModuleCode().equalsIgnoreCase(code)) {
                    System.out.print("Module already Exists!");

                } else {
                    System.out.println("Module Level: ");

                    int choice = 0;
                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Please enter a numeral");
                            sc.next();
                        }
                        choice = sc.nextInt();

                        if (!(choice >= 1 && choice <= 6)) {
                            System.out.println("Invalid level!");
                        }
                    } while (choice < 1 || choice > 6);


                    // String level = sc.nextLine();
                    String level = choice + "";
                    System.out.println("Credit Value: ");

                    //int value = sc.nextInt();

                    int value = 0;
                    do {
                        while (!sc.hasNextInt()) {
                            System.out.println("Please enter a numeral");
                            sc.next();
                        }
                        value = sc.nextInt();

                        if (!(value >= 1 && value <= 40)) {
                            System.out.println("Invalid value!");
                        }
                    } while (value < 1 || value > 40);

                    Module mdl = new Module(module, code, level, value);

                    int total = 0;
                    List<String> Assaignments = new ArrayList<String>();

                    while (total < 100) {
                        while (total != 100 && total <= 100) {
                            System.out.println("Assesment Type: ");
                            sc.nextLine();
                            String type = sc.nextLine();
                            System.out.println("Weigtage: ");

                            //int weigh = sc.nextInt();
                            int weigh = 0;
                            do {
                                while (!sc.hasNextInt()) {
                                    System.out.println("Please enter a numeral");
                                    sc.next();
                                }
                                weigh = sc.nextInt();

                                if (!(weigh >= 1 && weigh <= 100)) {
                                    System.out.println("Invalid weightage!");
                                }
                            } while (weigh < 1 || weigh > 100);

                            Assaignments.add(type);
                            Assaignments.add(weigh + "");
                            Assaignments.add("null");

                            total = total + weigh;
                        }
                        if (total > 100) {
                            System.out.println("Weigtage exceeded 100%: ");
                            Assaignments.clear();
                        }
                    }
                    mdl.setAssignments(Assaignments);
                    FileHandler.getModules().add(mdl);
                    System.out.println(FileHandler.getModules());
                    break;
                }
                saveData();
            }
        } catch (ConcurrentModificationException e) {
            System.out.print("i ate Concurry exception");
        }

        if (bol == false) {
            // System.out.print("im in if");
            System.out.println("Module Level: ");
            String level = sc.nextLine();
            System.out.println("Credit Value: ");
            int value = sc.nextInt();

            Module mdl = new Module(module, code, level, value);

            int total = 0;
            List<String> Assaignments = new ArrayList<String>();

            while (total != 100 && total <= 100) {
                System.out.println("Assesment Type: ");
                sc.nextLine();
                String type = sc.nextLine();
                System.out.println("Weigtage: ");
                int weigh = sc.nextInt();
                Assaignments.add(type);
                Assaignments.add(weigh + "");
                Assaignments.add("null");

                total = total + weigh;
            }

            mdl.setAssignments(Assaignments);
            FileHandler.getModules().add(mdl);
        }
        saveData();
    }


    /**
     * Method to edit the existing modules.
     */
    public void editModule() {
        System.out.println("Module Code: ");
        sc.nextLine();
        String code = sc.nextLine();

        try {
            for (Module md : FileHandler.getModules()) {
                //System.out.println(md);
                //System.out.println(code);

                if (md.getModuleCode().equalsIgnoreCase(code)) {
                    System.out.println("Module Name: " + md.getModuleName());

                    System.out.println("Module Code: " + md.getModuleCode());

                    System.out.println("Module Level: " + md.getCreditLevel());

                    System.out.println("Credit Value: " + md.getCreditValue());

                    for (int x = 0; x < md.getAssignments().size(); x++) {
                        //System.out.print(md.getAssignments());
                        System.out.print(md.getAssignments().get(x));
                        x++;
                        System.out.print(" " + md.getAssignments().get(x) + "%\n");
                        x++;
                    }
                    FileHandler.getModules().remove(md);
                    addNewModule();
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("I ate Concurry Exception");
        }
        saveData();
    }


    /**
     * Method to add new Student.
     */
    public void addNewStudent() {
        System.out.println("Student ID Please: ");
        int studentID = 0;

        while (!sc.hasNextInt()) {
            System.out.println("Integer Please");
            sc.next();
        }
        studentID = sc.nextInt();
        String studentId = studentID + "";

        boolean studentCheck = true;
        for (Student st : FileHandler.getStudentsList()) {
            if (studentId.equalsIgnoreCase(st.getiDNo())) {
                studentCheck = false;
            }
        }

        if (studentCheck) {
            System.out.println("Name of the Student: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Course of the Student: ");
            String course = sc.nextLine();

            Student stu = new Student(course, studentId, name);

            System.out.println("Student " + studentId + " created successfully.");

            FileHandler.getStudentsList().add(stu);
            //System.out.println(FileHandler.getStudentsList());
            start();

            saveData();
        } else {
            System.out.println("Student " + studentId + " already exists. Want to overwrite? (1/0)");

            int ans = sc.nextInt();

            if (ans == 1) {
                System.out.println("Name of the Student: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Course of the Student: ");
                String course = sc.nextLine();

                for (Student st : FileHandler.getStudentsList()) {
                    if (studentId.equalsIgnoreCase(st.getiDNo())) {
                        st.setName(name);
                        st.setCourse(course);
                    }
                }
                //Student stu = new Student(course, studentId, name);

                System.out.println("Student " + studentId + " created successfully.");

                //FileHandler.getStudentsList().add(stu);
                //System.out.println(FileHandler.getStudentsList());
                start();
            } else start();

            //addNewStudent();
        }
    }


    /**
     * This method adds marks of the students.
     */
    public void addMarks() {

        System.out.println("Student ID Please: ");
        //sc.nextLine();
        while (!sc.hasNextInt()) {
            System.out.println("Integer Please");
            sc.next();
        }
        String studentID = sc.nextInt() + "";

        boolean studentCheck = false;
        for (Student st : FileHandler.getStudentsList()) {
            if (studentID.equalsIgnoreCase(st.getiDNo())) {
                studentCheck = true;
            }
        }

        if (studentCheck) {
            System.out.println("Module Please: ");
            sc.nextLine();
            String module = sc.nextLine();

            boolean moduleCheck = false;
            for (Module md : FileHandler.getModules()) {
                if (module.equalsIgnoreCase(md.getModuleCode())) {
                    moduleCheck = true;
                }
            }

            if (moduleCheck) {
                System.out.println("Semester Code Please: ");
                String sem = sc.nextLine();

                boolean bol = false;

                for (Take tk : FileHandler.getTake()) {

                    if ((tk.getStudentID().equalsIgnoreCase(studentID)) && tk.getModuleID().equalsIgnoreCase(module)) {
                        //if (tk.getModuleID().equalsIgnoreCase(module)) {
                        bol = true;
                        for (int x = 0; x < tk.getMarks().size(); x++) {

                            System.out.println(x + ": ");
                            x++;
                            x++;


                            if (tk.getMarks().get(x) != null && tk.getSemCode().equalsIgnoreCase(sem)) {
                                System.out.print("Already mark " + tk.getMarks().get(x) + " is added. Want to overwrite?");
                                int choice = sc.nextInt();

                                if (choice == 1) {
                                    int mark = sc.nextInt();

                                    if (mark < 30) { //Prepare for resit
                                        System.out.println(" That's a resit, resit marks: ");
                                        //tk.getResitMarks().add(mdl.getAssignments().get(x - 1));
                                        int mk2 = 0;
                                        mk2 = sc.nextInt();

                                        //tk.getResitMarks().add(mk + "");
                                        mark = mk2;
                                        if (mk2 < 30) { //Prepare for retake
                                            System.out.println(" That's a retake ");

                                            tk.setRetaked(true);
                                        }


                                    }
                                    x++;
                                    tk.getMarks().add(x, mark + "");


                                    tk.getMarks().add(x, mark + "");
                                }

                            } else {
                                // tk.getMarks().add(x, mark);

                                for (Module mdl : FileHandler.getModules()) {
                                    if (mdl.getModuleCode().equalsIgnoreCase(module)) {


                                        Take tke = new Take(studentID, sem, module, new ArrayList<>());

                                        for (int y = 0; y < mdl.getAssignments().size(); y++) {
                                            tke.getMarks().add(y, mdl.getAssignments().get(y));
                                            System.out.println(mdl.getAssignments().get(y));
                                            y++;
                                            tke.getMarks().add(y, mdl.getAssignments().get(y));
                                            int mk = 0;

                                            do {
                                                while (!sc.hasNextInt()) {
                                                    System.out.println("Please enter a numeral");
                                                    sc.next();
                                                }
                                                mk = sc.nextInt();

                                                if (!(mk >= 1 && mk <= 100)) {
                                                    System.out.println("Invalid Mark!");
                                                }
                                            } while (mk < 1 || mk > 100);


                                            if (mk < 30) { //Prepare for resit
                                                System.out.println(" That's a resit, resit marks: ");
                                                tke.getResitMarks().add(mdl.getAssignments().get(x - 1));
                                                int mk2 = 0;
                                                do {
                                                    while (!sc.hasNextInt()) {
                                                        System.out.println("Please enter a numeral");
                                                        sc.next();
                                                    }
                                                    mk2 = sc.nextInt();

                                                    if (!(mk2 >= 1 && mk2 <= 100)) {
                                                        System.out.println("Invalid Mark!");
                                                    }
                                                } while (mk2 < 1 || mk2 > 100);

                                                //mk2 = sc.nextInt();

                                                tke.getResitMarks().add(mk + "");
                                                mk = mk2;
                                                if (mk2 < 30) { //Prepare for retake
                                                    System.out.println(" Failed Module! ");

                                                    tke.setRetaked(true);
                                                }

                                            }
                                            y++;

                                            if (mk < 40) {
                                                tke.getMarks().add(y, mk + "");
                                            } else {
                                                tke.getMarks().add(y, "40");
                                            }
                                        }

                                        FileHandler.getTake().add(tke);

                                    }
                                }

                            }
                            break;

                        }
                        break;
                    }
                }
                if (bol == false) {
                    Boolean bl = false;

                    for (Module mdl : FileHandler.getModules()) {
                        if (mdl.getModuleCode().equalsIgnoreCase(module)) {


                            Take tke = new Take(studentID, sem, module, new ArrayList<>());

                            int condonedtotal = 0;
                            int condonedtimes = 0;
                            boolean condonable = false;

                            for (int x = 0; x < mdl.getAssignments().size(); x++) {
                                tke.getMarks().add(x, mdl.getAssignments().get(x));
                                System.out.println(mdl.getAssignments().get(x));
                                x++;
                                tke.getMarks().add(x, mdl.getAssignments().get(x));
                                //int mk = sc.nextInt();
                                int mk = 0;


                                do {
                                    while (!sc.hasNextInt()) {
                                        System.out.println("Please enter a numeral");
                                        sc.next();
                                    }
                                    mk = sc.nextInt();

                                    if (!(mk >= 1 && mk <= 100)) {
                                        System.out.println("Invalid Mark!");
                                    } else {
                                        condonedtimes++;
                                        condonedtotal += mk;
                                    }
                                } while (mk < 1 || mk > 100);


                                if (mk < 30) { //Prepare for resit
                                    //condoned+=mk;
                                    condonable = true;
                                    System.out.println(" That's a resit, resit marks: ");
                                    tke.getResitMarks().add(mdl.getAssignments().get(x - 1));
                                    int mk2 = 0;


                                    /*String ans = sc.next();
                                    if (ans.equalsIgnoreCase("condone")){
                                        tke.setCondoned(true);
                                    }else {*/

                                    //mk2=Integer.parseInt(ans);

                                    do {
                                        while (!sc.hasNextInt()) {
                                            System.out.println("Please enter a numeral");
                                            sc.next();
                                        }
                                        mk2 = sc.nextInt();

                                        if (!(mk2 >= 1 && mk2 <= 100)) {
                                            System.out.println("Invalid Mark!");
                                        }
                                    } while (mk2 < 1 || mk2 > 100);

                                    // }
                                    // mk2 = sc.nextInt();

                                    tke.getResitMarks().add(mk + "");
                                    mk = mk2;
                                    if (mk2 < 30) { //Prepare for retake
                                        System.out.println(" That's a retake ");

                                        tke.setRetaked(true);
                                    }


                                }
                                x++;
                                tke.getMarks().add(x, mk + "");
                            }

                            if (condonedtotal / condonedtimes > 40 && condonable) {
                                System.out.println("Module Condonable. Condone Module? (1/0): ");
                                int ans = sc.nextInt();

                                if (ans == 1) {
                                    tke.setCondoned(true);
                                }
                            }
                            FileHandler.getTake().add(tke);


                        } else {
                            bl = true;
                        }
                    }
                    /*if (bl == true) {
                        System.out.println("Such Module Doesn't Exist!");
                    }*/


                }

            } else {
                System.out.println("Such Module Doesn't Exist at all!");
                addMarks();
            }


        } else {
            System.out.println("Student Doesn't Exist");
            addMarks();
        }
        saveData();
        start();

    }


    /**
     * This method gives the award of the student queried.
     */
    public void generateAwards() {

        System.out.println("Student Number");
        sc.nextLine();
        String stuNo = sc.nextLine();
        Calculations.gereneteAwards(stuNo, 1);
        start();
    }


    /**
     * The method prints all the students enrolled.
     */
    public void viewStudents() {
        for (Student st : FileHandler.getStudentsList()) {
            System.out.println(st.getiDNo() + " : " + st.getName());
        }
        start();

    }


    /**
     * This method loads all the data from files.
     */
    public void loadData() {
        FileHandler.LoadModulesDataFromFile();
        FileHandler.LoadStudentDataFromFile();
        FileHandler.LoadTakeDataFromFile();


    }


    /**
     * This method saves all the data to file.
     */
    public void saveData() {
        FileHandler.saveModuleDataToFile();
        FileHandler.saveStudentDataToFile();
        FileHandler.saveTakeDataToFile();


    }

}
