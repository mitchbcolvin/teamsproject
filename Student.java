import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String studentName;
    private int gradeLevel;
    private ArrayList<Course> courses;

    public Student(String studentName, int gradeLevel){
        this.studentName = studentName;
        this.gradeLevel = gradeLevel;
        this.courses = newArrayList<>;
    }
}
