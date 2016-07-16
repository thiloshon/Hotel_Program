import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiloshon on 25-Apr-16.
 * This Class is the model class of Module
 */
public class Module implements java.io.Serializable {
    private String moduleCode;
    private String moduleName;
    private String creditLevel;
    private int creditValue;
    private List<String> Assignments = new ArrayList<String>();


    public void setAssignments(List<String> assignments) {
        Assignments = assignments;
    }

    public Module(String moduleName, String moduleCode, String creditLevel, int creditValue) {
        this.creditLevel = creditLevel;
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.creditValue = creditValue;

    }

    public List<String> getAssignments() {
        return Assignments;
    }

    public String getCreditLevel() {

        return creditLevel;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getCreditValue() {
        return creditValue;
    }

    @Override
    public String toString() {
        return
                "\nAssignments=" + Assignments +
                        ", moduleCode='" + moduleCode +
                        '\'' + ", moduleName='" + moduleName +
                        '\'' + ", creditLevel='" + creditLevel +
                        '\'' + ", creditValue=" + creditValue +
                        "}";
    }
}
