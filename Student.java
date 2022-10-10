import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String studentName;
    private int gradeLevel;
    private int calculateGPA;
    private ArrayList<Course> courses;
    private String bestclass;

    public Student(String studentName, int gradeLevel){
        this.studentName = studentName;
        this.gradeLevel = gradeLevel;
        courses= new ArrayList<>();
    }

    public void setstudentName(String n){
        studentName = n;
    }  

    public ArrayList<Course> getcourses(){
        return courses;
    }

    public void removeCourse(Course c){
        courses.remove (c);
    }
    
    public String getstudentName(){
        return studentName;
    }

    public void setgradeLevel(int gradeLevel){
        this.gradeLevel = gradeLevel;
    }
    
    public int getgradeLevel(){
        return gradeLevel;
    }

    public void addCourse(Course c){
        courses.add(c);
    }

    public void setcalculateGPA(double g){
        g = calculateGPA;
    }
    
    
    public double calculateGPA(){
        int gpaPoints = 0;
        for(int i = 0; i < courses.size(); i++){
            Course c= courses.get(i);
            double grade = c.getgrade();
            if(grade>= 90){
                gpaPoints += 4;
            }
            if(grade >= 80 && grade<90){
                gpaPoints += 3;
            }
            if(grade >= 70 && grade<80){
                gpaPoints += 2;
            }
            if(grade >= 60 & grade<70){
                gpaPoints += 1;
            }
        }
        return (double) gpaPoints/courses.size();
     }

    public void setbestclass(String bestclass){
        this.bestclass= bestclass;
    }

    public Course getbestclass(){
        if(courses.size()== 0){
            return null;
        }
        Course best = courses.get(0);
        for(int i = 0; i < courses.size(); i++){
             Course c = courses.get(i);
            if(c.getgrade() > best.getgrade()){
            best = c;
        }
    
    }
    return best;
}

public String toString(){
    if(getbestclass() == null){
        return "Name:"+studentName+ " "+"Grade Level:"+gradeLevel+ " "+ "GPA: "+ calculateGPA();
    }
    else{
        return "Name:"+ studentName+ " "+ "Grade Level:"+gradeLevel+ " "+ "GPA:"+ calculateGPA()+ "Best Class:"+ getbestclass();
    }
}
        

}
