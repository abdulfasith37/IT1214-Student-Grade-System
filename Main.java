import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add a Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search for a Student by ID");
            System.out.println("4. Calculate and Display Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting system. Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose between 1 and 5.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid marks. Please enter a valid decimal number: ");
            scanner.next();
        }
        double marks = scanner.nextDouble();
        
        studentList.add(new Student(id, name, marks));
        System.out.println("Student record added successfully!");
    }

    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found in the database.");
            return;
        }
        System.out.println("\n--- All Registered Students ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        if (studentList.isEmpty()) {
            System.out.println("The system is currently empty. No records to search.");
            return;
        }
        System.out.print("Enter Student ID to search: ");
        String searchId = scanner.nextLine().trim();
        boolean matchFound = false;

        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(searchId)) {
                System.out.println("\n[Record Found]: " + student);
                matchFound = true;
                break;
            }
        }
        if (!matchFound) {
            System.out.println("Error: Student with ID '" + searchId + "' does not exist.");
        }
    }

    private static void calculateAverage() {
        if (studentList.isEmpty()) {
            System.out.println("No student data available to calculate metrics.");
            return;
        }
        double sum = 0;
        for (Student student : studentList) {
            sum += student.getMarks();
        }
        double average = sum / studentList.size();
        System.out.printf("\n--- Performance Analytics ---\n");
        System.out.printf("Total Enrolled Students: %d\n", studentList.size());
        System.out.printf("Class Average Mark: %.2f\n", average);
    }
}
