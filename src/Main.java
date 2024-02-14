import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<CourseResult> resultArrayList = new ArrayList<>();
    static ArrayList<SemesterResult> studentsSemesterResultArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1- Create a Result");
            System.out.println("2- Display Results");
            System.out.println("3- Delete a Result");
            System.out.println("4- Change Name");
            System.out.println("5- Change Grade");
            System.out.println("6- Change Marks");
            System.out.println("0- Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    semesterResultCreator();
                    break;
                case 2:
                    displayResults();
                    break;
                case 3:
                    deleteResult();
                    break;
                case 4:
                    //changeName();
                    break;
                case 5:
                    //changeGrade();
                    break;
                case 6:
                    //changeMarks();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void semesterResultCreator() {
        SemesterResult mySemesterResult = new SemesterResult();
        studentsSemesterResultArrayList.add(mySemesterResult);
    }

    public static void displayResults() {
        for (SemesterResult semesterResult : studentsSemesterResultArrayList) {
            System.out.println("Student Name: " + semesterResult.getStudentName());
            System.out.println("Roll Number: " + semesterResult.getStudentRollNumber());
            System.out.println("Semester: " + semesterResult.getStudentSemester());
            System.out.println("CGPA: " + semesterResult.getStudentCGPA());
            System.out.println("Number of Courses: " + semesterResult.getNumberOfCourses());
            for (CourseResult courseResult : semesterResult.getCourseResultsArray()) {
                System.out.println("Course Name: " + courseResult.getCourseName());
                System.out.println("Marks: " + courseResult.getMarks());
                System.out.println("GPA: " + courseResult.getGpa());
                System.out.println("Grade: " + courseResult.getGrade());
            }
            System.out.println("--------------------------------------------");
        }
    }

    public static void deleteResult() {
        if (studentsSemesterResultArrayList.isEmpty()) {
            System.out.println("No results to delete!");
            return;
        }
        System.out.println("Enter the index of the result to delete:");
        int index = scanner.nextInt();
        if (index >= 0 && index < studentsSemesterResultArrayList.size()) {
            studentsSemesterResultArrayList.remove(index);
            System.out.println("Result deleted successfully!");
        } else {
            System.out.println("Invalid index!");
        }
    }

//    public static void changeName() {
//        if (studentsSemesterResultArrayList.isEmpty()) {
//            System.out.println("No results available to change name!");
//            return;
//        }
//        System.out.println("Enter the index of the result to change name:");
//        int index = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//        if (index >= 0 && index < studentsSemesterResultArrayList.size()) {
//            System.out.println("Enter new name:");
//            String newName = scanner.nextLine();
//            studentsSemesterResultArrayList.get(index).setStudentName(newName);
//            System.out.println("Name changed successfully!");
//        } else {
//            System.out.println("Invalid index!");
//        }
//    }

    // Implement changeGrade() and changeMarks() similarly

}
