import java.io.*;
import java.util.ArrayList;

/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class takes care of all File Handling. The methods are: saveStudentDataToFile, LoadStudentDataFromFile
 */
public class FileHandler {

    private static ArrayList<Student> studentsList = new ArrayList<Student>();
    private static ArrayList<Take> take = new ArrayList<Take>();
    private static ArrayList<Module> modules = new ArrayList<Module>();


    /**
     * This method saves the student objects in the binary format to the file.
     */
    public static void saveStudentDataToFile(){
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI Temporary\\Students");


        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student stu : studentsList) {
            try {
                oos.writeObject(stu);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * This method loads the student objects in the binary format from the file.
     */
    public static void LoadStudentDataFromFile() {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI Temporary\\Students");
        FileInputStream fis = null;
        //System.out.print("hi1");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found1");
        }
        ObjectInputStream ois = null;


        try {

            if (fis.available() != 0) {
                //System.out.print("hi2");
                ois = new ObjectInputStream(fis);
                while (ois != null) {
                    try {
                        Student st = (Student) ois.readObject();
                        // for(Student stu : studentsList){
                        //    if(st.getiDNo()!=stu.getiDNo()){
                        studentsList.add(st);
                        //   }
                        //  }


                      //  System.out.println("hi3");
                        //System.out.print(st);

                    } catch (EOFException e) {
                        break;
                    }


                }
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

            //e3.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }



    /**
     * This method saves the Take objects in the binary format to the file.
     */
    public static void saveTakeDataToFile()  {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI Temporary\\Take");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Take tke : take) {
            try {
                oos.writeObject(tke);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



    /**
     * This method loads the take objects in the binary format from the file.
     */
    public static void LoadTakeDataFromFile()  {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI Temporary\\Take");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found2");
        }
        ObjectInputStream ois = null;
        try {
            if (fis.available() != 0) {
                ois = new ObjectInputStream(fis);
                while (ois != null) {
                    try{
                        Take st = (Take) ois.readObject();
                        take.add(st);
                    }catch (EOFException e){
                    break;
                    }

                }
            }
        } catch (ClassNotFoundException cnfe) {
            //cnfe.printStackTrace();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }



    /**
     * This method save the module objects in the binary format to the file.
     */
    public static void saveModuleDataToFile() {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI Temporary\\Module");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Module mde : modules) {
            try {
                oos.writeObject(mde);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            oos.flush();
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    /**
     * This method loads the module objects in the binary format from the file.
     */
    public static void LoadModulesDataFromFile()  {
        File file = new File("C:\\Users\\Thiloshon\\IdeaProjects\\Award Calculation System of UoG CLI Temporary\\Module");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found3");
        }
        ObjectInputStream ois = null;


        try {

            if (fis.available() != 0) {
                ois = new ObjectInputStream(fis);
                while (ois != null) {
                    try {
                        Module mde = (Module) ois.readObject();
                        modules.add(mde);
                    } catch (EOFException e) {
                        break;
                    }

                }
            }
        } catch (ClassNotFoundException cnfe) {
            //cnfe.printStackTrace();
        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        //System.out.println("modules" + getModules());


    }


    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public static ArrayList<Module> getModules() {
        return modules;
    }

    public static ArrayList<Take> getTake() {
        return take;
    }

}
