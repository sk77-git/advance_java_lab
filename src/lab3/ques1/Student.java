package lab3.ques1;

//1.	Create a student javabeans with all possible properties and use it in another class.
class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1);
        student.setName("John Doe");
        student.setAge(18);
        student.setGrade("A");
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Grade: " + student.getGrade());
    }
}

public class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student() {
    }

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}