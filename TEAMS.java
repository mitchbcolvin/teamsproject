import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TEAMS{
    static ArrayList<Student> students;
    static ArrayList<Teacher> teachers;
    static ArrayList<Course> courses;

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        
        //Load the data if available ### DO NOT CHANGE THIS PART
        try{
            students =(ArrayList<Student>)loadData("students");

        }catch(Exception e){
            students = new ArrayList<>();
        }
        try{
            teachers =(ArrayList<Teacher>)loadData("teachers");
        }catch(Exception e){
            teachers = new ArrayList<>();
        }
        try{
            courses =(ArrayList<Course>)loadData("courses");
        }catch(Exception e){
            courses = new ArrayList<>();
        }


        //############## MAIN MENU STARTS HERE ##############

        System.out.println("Welcome to Teams!");
       
        int choice = 1;
        while(choice > 0){
            System.out.println();
            System.out.println("1) Add Students ");
            System.out.println("2) Add Teacher ");
            System.out.println("3) Add Course ");
            System.out.println("4) Edit Students ");
            System.out.println("5) List All Students ");
            System.out.println("6) List All Courses ");
            System.out.println("7) Search For a Student");
            System.out.println("8) Exit ");
            System.out.println();
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1) {
                optionOne();
            }else if (choice == 2){
                optionTwo();
            }else if (choice == 3){
                optionThree();
            }else if (choice == 4){
                optionFour();
            }else if (choice == 5){
                optionFive();
            }else if (choice == 6){
                optionSix();
            }else if (choice == 7){
                optionSeven();
            }else if (choice == 8){
                optionEight();
            }
        
        }
    }

   private static void optionEight() {
        try{

        saveData();
        
        }catch (Exception e){
        }
    }

    private static void optionSeven() {
        boolean found = false;
        System.out.println("Enter Student Name");
        String studentName = sc.nextLine();
        for (int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            System.out.println(i + " " + students.get(i));
            if (s.getstudentName().equals(studentName)){
                System.out.println(s);
                found = true;
            }
        }
        if(! found){
            System.out.println("Not Found");
        }


    }

    private static void optionSix(){
        System.out.println("Listing Courses");
        for (int i = 0; i < courses.size(); i ++){
            System.out.println( i + " " + courses.get(i));
        }
    }


    private static void optionFive(){
        System.out.println("Listing Students");
        for (int i = 0; i < students.size(); i++){
            System.out.println(i + " " + students.get(i));
        }
    }

    private static void optionFour(){
        System.out.println("Pick Student to Edit");
        for (int i = 0; i < students.size(); i++){
            System.out.println(i + " " + students.get(i));
        }
        int choice = sc.nextInt();
        Student student = students.get(choice);
        sc.nextLine();

        System.out.println("1) Modify Name");
        System.out.println("2) Modify Grade Level");
        System.out.println("3) Add Class");
        System.out.println("4) Remove Class");
        System.out.println();
        System.out.println("Choice");
        int choice2 = sc.nextInt();
        sc.nextLine();

        if(choice2 == 1){
            modifyname(student);
        }else if (choice2 == 2){
            modifygradelevel(student);
        }else if (choice2 == 3){
            addclass(student);
        }else if (choice2 == 4){
            removeclass(student);
        }

    }
    private static void removeclass(Student s) {
        System.out.println("Pick a class to remove:");
        ArrayList<Course> courses = s.getcourses();
        for(int i = 0; i < courses.size(); i++){
            System.out.println(i + " "+ courses.get(i));
        }
        System.out.println("Choice");
        int ans = sc.nextInt();
        Course c = courses.get(ans);
        s.removeCourse(c);
    }

    private static void addclass(Student s) {
        System.out.println("Pick a Class");
        optionSix();
        System.out.println();
        System.out.println("Choice:");
        int ans = sc.nextInt();
        sc.nextLine();
        if (ans > -1 && ans < courses.size()){
            Course c = courses.get(ans).clone();
            System.out.println("Enter grade for the course:");
            int grade = sc.nextInt();
            c.setgrade(grade);
            sc.nextLine();
            System.out.println("Currently taking it (y/n)?");
            String yesNo = sc.nextLine();
            if (yesNo.equals("y")){
                c.setcurrent(true);
            }
        s.addCourse(c);

        }
        

    }

    private static void modifygradelevel(Student s) {
        System.out.println("Enter New Grade");
        int newgradeLevel = sc.nextInt();
        s.setgradeLevel(newgradeLevel);
    }

    private static void modifyname(Student s) {
        System.out.println("Enter New Name");
        String newName = sc.nextLine();
        s.setstudentName(newName);
    }

    private static void optionThree() {
        System.out.println("Enter Subject");
        String subject = sc.nextLine();
        System.out.println("Choose a Teacher");
        for (int i = 0; i < teachers.size(); i++){
            System.out.println(i + " " + teachers.get(i));
        }
        int choice = sc.nextInt();
        sc.nextLine();
        Teacher t = teachers.get(choice);

        Course newCourse = new Course( subject, t);
        courses.add(newCourse);
    }
    private static void optionTwo() {
        System.out.println("Enter Teacher's Name");
        String teacherName = sc.nextLine();
        System.out.println("Enter Years of Experince");
        int yearsOfExperience = sc.nextInt();
        sc.nextLine();
        Teacher t = new Teacher( teacherName, yearsOfExperience);
        teachers.add(t);
    }
    private static void optionOne() {
        System.out.println("Enter Student's Name");
        String studentName = sc.nextLine();
        System.out.println("Enter Student's Grade Level");
        int gradeLevel = sc.nextInt();
        sc.nextLine();
        Student s = new Student( studentName,  gradeLevel);
        students.add(s);
    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static void saveData()throws Exception{
        FileOutputStream f1 = new FileOutputStream("students");
        ObjectOutputStream os = new ObjectOutputStream(f1);
        os.writeObject(students);
        os.close();
        f1.close();

        FileOutputStream f2 = new FileOutputStream("courses");
        os = new ObjectOutputStream(f2);
        os.writeObject(courses);
        os.close();
        f2.close();

        FileOutputStream f3 = new FileOutputStream("teachers");
        os = new ObjectOutputStream(f3);
        os.writeObject(teachers);
        os.close();
        f3.close();
    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static Object loadData(String name) throws Exception{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new  ObjectInputStream(fis);   
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}