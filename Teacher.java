import java.io.Serializable;

public class Teacher implements Serializable {
    private String teacherName;
    private int yearsOfExperince;

    public Teacher(String teacherName, int yearsOfExperince){
        this.teacherName = teacherName;
        this.yearsOfExperince = yearsOfExperince;
    }
    public void setTeacher();
    
}
