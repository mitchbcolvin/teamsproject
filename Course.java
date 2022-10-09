import java.io.Serializable;

public class Course implements Serializable, Cloneable{
    private String subject;
    private int grade;
    private boolean current;
    private Teacher teacher;

    public Course(String subject, int grade){
        this.subject = subject;
        this.grade = grade;
    }

    public Course(String subject, Teacher t){
        this.subject = subject;
        this.teacher = t;
    }

    public void setsubject( String subject){
        this.subject = subject;
    }
    public String getsubject(){
        return subject;
    }

    public void setTeacher(Teacher t){
        this.teacher = t;
    }

    public void setgrade(int grade){
        this.grade = grade;
    }
    public int getgrade(){
        return grade;
    }

    public void setcurrent(boolean current){
        this.current = current;
    }
    public boolean getcurrent(){
        return current;
    }

    public Course clone() {
        try {
            return (Course) super.clone();
        } catch (Exception e) {
        }
        return null;
    }

    public int totalGrade()

    
}
