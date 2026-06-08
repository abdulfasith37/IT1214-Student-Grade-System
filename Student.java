public class Student {
    private String studentId;
    private String studentName;
    private double marks;

    // Constructor
    public Student(String studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Overriding toString to format console output nicely
    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + studentName + " | Marks: " + marks;
    }
}
