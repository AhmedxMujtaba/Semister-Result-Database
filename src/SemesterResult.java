import java.util.Scanner;

public class SemesterResult {
    Scanner scanner = new Scanner(System.in);
    private String studentName;
    private String studentRollNumber;
    private String studentSemester;
    private double studentCGPA;
    private int numberOfCourses;
    private CourseResult[] courseResultsArray;

    public SemesterResult() {
        this.studentName = userNameInput();
        this.studentRollNumber = rollNumberInput();
        this.studentSemester = semesterInput();
        this.numberOfCourses = numberOfCoursesInput();
        this.courseResultsArray = new CourseResult[numberOfCourses];
        courseAdder();
        this.studentCGPA = cgpaCalculator();
    }

    // Methods to get the data according to user input
    public String userNameInput() {
        System.out.print("Enter Student Name: ");
        return scanner.nextLine();
    }

    public String rollNumberInput() {
        System.out.print("Enter Student Roll Number: ");
        return scanner.nextLine();
    }

    public String semesterInput() {
        System.out.print("Enter Student Semester: ");
        return scanner.nextLine();
    }

    public int numberOfCoursesInput() {
        System.out.print("Enter Number of Courses: ");
        return scanner.nextInt();
    }

    // getter methods
    public String getStudentName() {
        return studentName;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public String getStudentSemester() {
        return studentSemester;
    }

    public double getStudentCGPA() {
        return studentCGPA;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }


    public CourseResult[] getCourseResultsArray() {
        return courseResultsArray;
    }

    //setter methods
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public void setStudentRollNumber(String studentRollNumber) {
        this.studentRollNumber = studentRollNumber;
    }

    public void setStudentSemester(String studentSemester) {
        this.studentSemester = studentSemester;
    }

    public void setStudentCGPA(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    // Courses adder
    private void courseAdder() {
        for (int i = 0; i < courseResultsArray.length; i++) {
            CourseResult subjectResult = new CourseResult();
            courseResultsArray[i] = subjectResult;
        }
    }

    public double cgpaCalculator() {
        double totalCGPA = 0;
        int validCourses = 0;
        for (int i = 0; i < courseResultsArray.length; i++) {
            double gpa = courseResultsArray[i].getGpa();
            if (gpa >= 0) { // Assuming valid GPA is non-negative
                totalCGPA += gpa;
                validCourses++;
            }
        }
        double cgpa = validCourses > 0 ? totalCGPA / validCourses : 0;
        return Math.round(cgpa * 100.0) / 100.0; // Round to two decimal places
    }
}
