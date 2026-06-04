public class Student {

    int studentId;
    String name;
    String department;
    int age;
    double marks;

    public Student(int studentId, String name, String department, int age, double marks) {

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.age = age;
        this.marks = marks;
    }

    public void displayStudent() {

        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}