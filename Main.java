import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Connection con = DatabaseConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Student Count");
            System.out.println("7. Average Marks");
            System.out.println("8. Top Student");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                try {

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    String query =
                            "INSERT INTO students VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    pst.setInt(1, id);
                    pst.setString(2, name);
                    pst.setString(3, dept);
                    pst.setInt(4, age);
                    pst.setDouble(5, marks);

                    pst.executeUpdate();

                    System.out.println("Student Added Successfully!");

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 2) {

                try {

                    String query = "SELECT * FROM students";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    ResultSet rs = pst.executeQuery();

                    while (rs.next()) {

                        System.out.println("Student ID : "
                                + rs.getInt("studentId"));
                        System.out.println("Name : "
                                + rs.getString("name"));
                        System.out.println("Department : "
                                + rs.getString("department"));
                        System.out.println("Age : "
                                + rs.getInt("age"));
                        System.out.println("Marks : "
                                + rs.getDouble("marks"));

                        System.out.println("--------------------");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 3) {

                try {

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    String query =
                            "SELECT * FROM students WHERE studentId=?";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    pst.setInt(1, searchId);

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        System.out.println("Student ID : "
                                + rs.getInt("studentId"));
                        System.out.println("Name : "
                                + rs.getString("name"));
                        System.out.println("Department : "
                                + rs.getString("department"));
                        System.out.println("Age : "
                                + rs.getInt("age"));
                        System.out.println("Marks : "
                                + rs.getDouble("marks"));

                    } else {

                        System.out.println("Student Not Found!");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 4) {

                try {

                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    double newMarks = sc.nextDouble();

                    String query =
                            "UPDATE students SET name=?, department=?, age=?, marks=? WHERE studentId=?";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    pst.setString(1, newName);
                    pst.setString(2, newDept);
                    pst.setInt(3, newAge);
                    pst.setDouble(4, newMarks);
                    pst.setInt(5, updateId);

                    int rows = pst.executeUpdate();

                    if (rows > 0) {

                        System.out.println("Student Updated Successfully!");

                    } else {

                        System.out.println("Student Not Found!");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 5) {

                try {

                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();

                    String query =
                            "DELETE FROM students WHERE studentId=?";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    pst.setInt(1, deleteId);

                    int rows = pst.executeUpdate();

                    if (rows > 0) {

                        System.out.println("Student Deleted Successfully!");

                    } else {

                        System.out.println("Student Not Found!");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 6) {

                try {

                    String query = "SELECT COUNT(*) FROM students";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        System.out.println(
                                "Total Students = " + rs.getInt(1));
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 7) {

                try {

                    String query = "SELECT AVG(marks) FROM students";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        System.out.println(
                                "Average Marks = " + rs.getDouble(1));
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

             

            } else if (choice == 8) {

                try {

                    String query =
                            "SELECT * FROM students ORDER BY marks DESC LIMIT 1";

                    PreparedStatement pst =
                            con.prepareStatement(query);

                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {

                        System.out.println("\n===== Top Student =====");

                        System.out.println("Student ID : "
                                + rs.getInt("studentId"));
                        System.out.println("Name : "
                                + rs.getString("name"));
                        System.out.println("Department : "
                                + rs.getString("department"));
                        System.out.println("Age : "
                                + rs.getInt("age"));
                        System.out.println("Marks : "
                                + rs.getDouble("marks"));

                    } else {

                        System.out.println("No Students Found!");
                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }

            } else if (choice == 9) {

                System.out.println("Thank You!");
                running = false;

            } else {

                System.out.println("Invalid Choice");
            }        

           
        }

        sc.close();
    }
}