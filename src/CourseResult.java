import java.util.Scanner;

public class CourseResult {
    Scanner scanner = new Scanner(System.in);
    // Data members
    private int marks;
    private String courseName;
    private double gpa;
    private String grade;

    // Constructor
    public CourseResult() {
        this.courseName = courseNameInput();
        this.marks = marksInput();
        this.gpa = calculateGPA();
        this.grade = calculateGrade();
    }

    // Getter methods
    public double getGpa() {
        return gpa;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getGrade() {
        return grade;
    }

    public int getMarks() {
        return marks;
    }

    // Methods for user input
    public String courseNameInput() {
        System.out.print("Enter course Name: ");
        return scanner.nextLine();
    }

    public int marksInput() {
        System.out.print("Enter Marks: ");
        return scanner.nextInt();
    }

    private double calculateGPA() {
        if (marks >= 85) return 4.00;
        else if (marks >= 80) return 3.70;
        else if (marks >= 75) return 3.30;
        else if (marks >= 70) return 3.00;
        else if (marks >= 65) return 2.70;
        else if (marks >= 61) return 2.30;
        else if (marks >= 58) return 2.00;
        else if (marks >= 55) return 1.70;
        else if (marks >= 50) return 1.00;
        else return 0.00; // Below 50
    }

    private String calculateGrade() {
        if (marks >= 85) return "A";
        else if (marks >= 80) return "A-";
        else if (marks >= 75) return "B+";
        else if (marks >= 70) return "B";
        else if (marks >= 65) return "B-";
        else if (marks >= 61) return "C+";
        else if (marks >= 58) return "C";
        else if (marks >= 55) return "C-";
        else if (marks >= 50) return "D";
        else return "F"; // Below 50
    }
}
