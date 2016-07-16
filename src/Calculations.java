import java.util.Scanner;

/**
 * Created by Thiloshon on 26-Apr-16.
 * This Class is responsible for all the calculations required.
 * The methods are: generateAwards, allResits, allRetakes, moduleResits, moduleRetake, studentRecord, studentMark, exclusions, passedStudents.
 */
public class Calculations {
    static Scanner sc = new Scanner(System.in);



    /**
     * This Method calculates the award of the student required. Three other methods can call this method.
     * 1. generateAward method in Interface Class
     * 2. exclusion method in this Class
     * 3. passedStudents method in this Class.
     *
     * @param stuNo  this is the index number of the student.
     * @param choice this helps to identify which method out of the three above mentioned method calls this method.
     */
    public static void gereneteAwards(String stuNo, int choice) {

        double average = 0; // average of the student
        int creditL4 = 0;// credit of level 4
        int creditL5 = 0;// credit of level 5
        int creditL6 = 0;// credit of level 6
        boolean resit = false;

        for (Take take : FileHandler.getTake()) {
            if ((stuNo.equalsIgnoreCase(take.getStudentID()) && take.isRetaked() == false) || (stuNo.equalsIgnoreCase(take.getStudentID()) && take.isRetaked() == true && take.isCondoned())) {
                double moduleTotal = 0;

                for (int x = 0; x < take.getMarks().size(); x++) {
                    x++;
                    int weightage = Integer.parseInt(take.getMarks().get(x));
                    x++;
                    int mark = Integer.parseInt(take.getMarks().get(x));
                    double assesmentContribution = (weightage * mark) / 100;

                    moduleTotal += assesmentContribution;
                }

                for (Module mdl : FileHandler.getModules()) {
                    if (take.getModuleID().equalsIgnoreCase(mdl.getModuleCode())) {
                        if (Integer.parseInt(mdl.getCreditLevel()) == 5) {
                            moduleTotal = moduleTotal / 3.0 / 6;
                            average += moduleTotal;
                            creditL5 += 20;

                        } else if (Integer.parseInt(mdl.getCreditLevel()) == 6 && mdl.getCreditValue() == 40) {
                            moduleTotal = moduleTotal * 2 / 3.0 / 6;
                            average += moduleTotal;
                            average += moduleTotal;
                            creditL6 += 40;

                        } else if (Integer.parseInt(mdl.getCreditLevel()) == 6) {
                            moduleTotal = moduleTotal * 2 / 3.0 / 6;
                            average += moduleTotal;
                            creditL6 += 20;

                        } else if (Integer.parseInt(mdl.getCreditLevel()) == 4) {
                            creditL4 += 20;
                        }
                    }
                }


            }

            if (take.getResitMarks().size() > 0) {
                resit = true;
            }

        }


        if (creditL6 >= 120 && creditL5 >= 120 && creditL4 >= 120 && (choice == 1 || choice == 3)) {
            if ((average) >= 70) {
                System.out.println(stuNo + ": 1st Class Hons");
            } else if ((average) >= 60) {
                System.out.println(stuNo + ": 2nd Class upper Hons");
            } else if ((average) >= 50) {
                System.out.println(stuNo + ": 2nd Class lower Hons");
            } else if ((average) >= 40) {
                System.out.println(stuNo + ": 2rd class Hons");
            }
        } else if (creditL6 >= 60 && creditL5 >= 120 && creditL4 >= 120 && (choice == 1 || choice == 2)) {
            if (!resit) System.out.println(stuNo + ": Non Hons Distinction / Merit Degree");
            else System.out.println(stuNo + ": Non Hons Degree");
        } else if (creditL5 >= 120 && creditL4 >= 120 && (choice == 1 || choice == 2)) {
            if (!resit) System.out.println(stuNo + ": DipHE Distinction / Merit Degree");
            else System.out.println(stuNo + ": DipHE");
        } else if (creditL4 >= 120 && (choice == 1 || choice == 2)) {
            if (!resit) System.out.println(stuNo + ": CertHE Distinction / Merit Degree");
            else System.out.println(stuNo + ": CertHE");
        } else if (choice == 1) {
            System.out.print(stuNo + ": Not eligible for any awards  ");
        }


    }


    /**
     * This method prints all the resits.
     */
    public static void allResits() {
        for (Take take : FileHandler.getTake()) {
            if (take.getResitMarks().size() > 0) {
                System.out.println(take.getStudentID() + "  " + take.getModuleID());
                for (String stg : take.getResitMarks()) {
                    System.out.println(stg);
                }
            }
        }
    }


    /**
     * This method prints all the retakes.
     */
    public static void allRetakes() {
        for (Take take : FileHandler.getTake()) {
            if (take.isRetaked()) {
                System.out.println(take.getStudentID() + "  " + take.getModuleID());
            }
        }
    }


    /**
     * This method prints all the resits of a particular module.
     */
    public static void moduleResit() {
        System.out.println("Module Code");
        String modCode = sc.nextLine();

        for (Take take : FileHandler.getTake()) {
            if (take.getModuleID().equalsIgnoreCase(modCode)) {
                if (take.getResitMarks().size() > 0) {
                    System.out.println(take.getStudentID());
                    for (String stg : take.getResitMarks()) {
                        System.out.println(stg);
                    }
                }


            }
        }

    }


    /**
     * This method prints all the retakes of a particular module.
     */
    public static void moduleRetake() {
        System.out.println("Module Code");
        String modCode = sc.nextLine();
        for (Take take : FileHandler.getTake()) {
            if (take.getModuleID().equalsIgnoreCase(modCode) && take.isRetaked()) {
                System.out.println(take.getStudentID() + " " + take.getModuleID());
            }
        }
    }


    /**
     * This method prints records of students.
     * like student name, id number, resits and retakes of the student.
     */
    public static void studentRecord() {

        System.out.println("Student Number");
        String stuNo = sc.nextLine();

        for (Student stu : FileHandler.getStudentsList()) {
            if (stuNo.equalsIgnoreCase(stu.getiDNo())) {
                System.out.println(stu.getName());
                System.out.println(stu.getCourse());

                boolean isThereResits = false;

                for (Take take : FileHandler.getTake()) {
                    if (stuNo.equalsIgnoreCase(take.getStudentID())) {
                        if (take.getResitMarks().size() > 0) {
                            System.out.println("Resits");
                            for (String stg : take.getResitMarks()) {
                                System.out.println(stg);
                            }
                        } else {
                            isThereResits = true;
                        }


                    }
                }
                if (isThereResits) {
                    System.out.println("There are no resits for the student");
                }
            }
        }


    }


    /**
     * This method prints all the marks of the student
     */
    public static void studentMark() {

        System.out.println("Student Number");
        String stuNo = sc.nextLine();
        System.out.println("[Type, Weightage, Marks, ...]");

        for (Take tk : FileHandler.getTake()) {
            if (stuNo.equalsIgnoreCase(tk.getStudentID())) {

                System.out.print(tk.getModuleID() + "   ");
                System.out.println(tk.getMarks());
            }
        }
    }


    /**
     * This method prints list of students who are possible exclusions.
     */
    public static void exclusions() {
        for (Student st : FileHandler.getStudentsList()) {
            gereneteAwards(st.getiDNo(), 2);
        }
    }


    /**
     * This method prints list of students who has completed all four years of degree.
     */
    public static void passedStudents() {
        for (Student st : FileHandler.getStudentsList()) {
            gereneteAwards(st.getiDNo(), 3);
        }
    }


}
