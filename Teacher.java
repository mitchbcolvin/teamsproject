import java.io.Serializable;

public class Teacher implements Serializable {
    private String teacherName;
    private int yearsOfExperience;

    public Teacher(String teacherName, int yearsOfExperience){
        this.teacherName = teacherName;
        this.yearsOfExperience = yearsOfExperience;
    }
    public void setTeacherName(String teacherName){
        this.teacherName = teacherName;
    }
    public String getTeacherName(){
        return this.teacherName;
    }

    public void setyearsOfExperience(int yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getyearsOfExperience(){
        return yearsOfExperience;
    }
    
    
}
