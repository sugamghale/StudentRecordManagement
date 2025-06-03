import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

public class StudentManagement {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        studentList.add(new Student(id, name, age));
        System.out.println("Student added successfully.");
    }

    static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();

        for (Student s : studentList) {
            if (s.id == id) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();

        for (Student s : studentList) {
            if (s.id == id) {
                studentList.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
