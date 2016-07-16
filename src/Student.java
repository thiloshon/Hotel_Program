/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class is the model class of Student.
 *
 */
public class Student implements java.io.Serializable {


    private String name;
    private String iDNo;
    private String course;
    private String award;

    public Student(String course, String iDNo, String name) {
        this.course = course;
        this.iDNo = iDNo;
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public String getiDNo() {
        return iDNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "award='" + award + '\'' +
                ", name='" + name + '\'' +
                ", iDNo='" + iDNo + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
