import java.io.Serializable;

public class Course implements Serializable{
    private String subject;
    private int grade;
    private boolean current;
    private Teacher teacher;

    public Course(String subject, int grade){
        this.subject = subject;
        this.grade = grade;
    }

    public void setTeacher(Teacher t){
        this.teacher = t;
    }

    public int totalGrade()

    
}
