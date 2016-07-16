import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiloshon on 25-Apr-16.
 *
 * The Take ModelClass. Each attempt of each module creates one take object.
 */
public class Take implements java.io.Serializable{

    private String studentID;
    private String moduleID;
    private String semCode;
    private List<String> marks = new ArrayList<String>();
    private boolean condoned;
    private boolean retaked;

    public List<String> getResitMarks() {
        return resitMarks;
    }

    public boolean isRetaked() {
        return retaked;
    }

    public void setRetaked(boolean retaked) {
        this.retaked = retaked;
    }

    private List<String> resitMarks = new ArrayList<String>();

    public Take(String studentID, String semCode, String moduleID, List<String> marks) {
        this.studentID = studentID;
        this.semCode = semCode;
        this.moduleID = moduleID;
        this.marks = marks;
    }

    public List<String> getMarks() {

        return marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getSemCode() {
        return semCode;
    }

    public String getModuleID() {
        return moduleID;
    }

    public boolean isCondoned() {
        return condoned;
    }

    public void setCondoned(boolean condoned) {
        this.condoned = condoned;
    }

    @Override
    public String toString() {
        return "\n" +
                "condoned=" + condoned +
                ", studentID='" + studentID + '\'' +
                ", moduleID='" + moduleID + '\'' +
                ", semCode='" + semCode + '\'' +
                ", marks=" + marks +
                ", retaked=" + retaked +
                ", resitMarks=" + resitMarks +
                '}';
    }
}
