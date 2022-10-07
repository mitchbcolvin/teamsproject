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
    public boolean calculateGPA(){
        if(totalGrade = (totalGrade >= 90),(totalGrade <= 100));
        System.out.println("GPA is 4");

        if(totalGrade = (totalGrade >= 80), (totalGrade <= 89));
        System.out.println("GPA is 3");

        if(totalGrade = (totalGrade >=70), (totalGrade <= 79));
        System.out.println("GPA is 2");

        if(totalGrade = (totalGrade >= 60),(totalGrade <= 69));
        System.out.ptintln("Gpa is 1");

        if(totalGrade = (totalGrade >=0),(totalGrade <= 59));
        System.out.ptintln("GPA is 0");
        
        
    }

}
