import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<SemesterResult> studentsSemesterResultArrayList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1- Create a Result");
            System.out.println("2- Display a Students Result");
            System.out.println("3- Display All Results");
            System.out.println("4- Display All Students Names");
            System.out.println("5- Delete a Result");
            System.out.println("6- Change Name");
            System.out.println("7- Change Marks");
            System.out.println("8- Change Course Name");
            System.out.println("0- Exit");
            System.out.print("Enter Option Number: ");

            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    semesterResultCreator();
                    break;
                case 2:
                    displayStudentResult();
                    break;
                case 3:
                    displayAllStudentsResults();
                    break;
                case 4:
                    displayAlLStudentsName();
                    break;
                case 5:
                    deleteResult();
                    break;
                case 6:
                    changeName();
                    break;
                case 7:
                    changeCourseMarks();
                    break;
                case 8:
                    changeCourseName();
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

    public static void displayAllStudentsResults() {
        System.out.println("--------------------------------------------");
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
            System.out.println();
        }
    }
    public static void displayStudentResult() {

        if (studentsSemesterResultArrayList.isEmpty()) {
            System.out.println("No results available to Display!");
            return;
        }
        System.out.println("Enter the Roll Number of the Student:");
        scanner.nextLine();
        String rollNumber = scanner.nextLine();
        int index = indexFinderFromRollNumber(rollNumber);
        if (index == -1) {
            return;
        }

        System.out.println("--------------------------------------------");

        SemesterResult semesterResult = studentsSemesterResultArrayList.get(index);

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
            System.out.println();

    }
    public static void displayStudentResult(int index) {

        System.out.println("--------------------------------------------");
        SemesterResult semesterResult = studentsSemesterResultArrayList.get(index);
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
            System.out.println();
    }

    public static void deleteResult() {
        if (studentsSemesterResultArrayList.isEmpty()) {
            System.out.println("No results available to change name!");
            return;
        }
        scanner.nextLine();
        System.out.println("Enter the Roll Number of the Result to delete:");
        String rollNumber = scanner.nextLine();
        int index = indexFinderFromRollNumber(rollNumber);
        if (index == -1) {
            return;
        }
        if (index >= 0 && index < studentsSemesterResultArrayList.size()) {
            studentsSemesterResultArrayList.remove(index);
            System.out.println("Result deleted successfully!");
        }
    }

    public static void changeName() {
        if (studentsSemesterResultArrayList.isEmpty()) {
            System.out.println("No results available to change name!");
            return;
        }
        scanner.nextLine();
        System.out.println("Enter the Roll Number of the Student to change name:");
        String rollNumber = scanner.nextLine();
        int index = indexFinderFromRollNumber(rollNumber);
        if (index == -1) {
            return;
        }
        if (index >= 0 && index < studentsSemesterResultArrayList.size()) {
            scanner.nextLine();
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            studentsSemesterResultArrayList.get(index).setStudentName(newName);
            System.out.println("Name changed successfully!");
        }
    }
    //helper function to return index of the person when roll number is provided:
    public static int indexFinderFromRollNumber(String rollNumber){
        for (int i = 0; i < studentsSemesterResultArrayList.size(); i++) {
            if (rollNumber.equals(studentsSemesterResultArrayList.get(i).getStudentRollNumber())) {
                return i;
            }
        }
        System.out.println("No such roll number was found");
        return -1;
    }

    // Implement changeCourseName() and changeMarks() similarly
    public static void changeCourseName(){
        if (studentsSemesterResultArrayList.isEmpty()) {
            System.out.println("No results available to change name!");
            return;
        }
        System.out.println("Enter the Roll Number of the Student to change Course:");
        scanner.nextLine();
        String rollNumber = scanner.nextLine();
        int index = indexFinderFromRollNumber(rollNumber);
        if (index == -1 || index > studentsSemesterResultArrayList.size()) {
            return;
        }
        //Now displaying the students information
        displayStudentResult(index);
        System.out.println("Enter Previous Course Name to change: ");
        String previousCourseName = scanner.nextLine();
        int noOfCourses = studentsSemesterResultArrayList.get(index).getNumberOfCourses();
        CourseResult[] courseResultArray = studentsSemesterResultArrayList.get(index).getCourseResultsArray();
        for (int i = 0; i < noOfCourses; i++) {
            if (previousCourseName.equals(courseResultArray[i].getCourseName())){
                System.out.println("Enter new Course Name:");
                String newName = scanner.nextLine();
                studentsSemesterResultArrayList.get(index).getCourseResultsArray()[i].setCourseName(newName);
                System.out.println("Name changed successfully!");
                return;
            }
        }
        System.out.println("No Such Course Name Exist");
    }

    public static void changeCourseMarks(){
        if (studentsSemesterResultArrayList.isEmpty()) {
            System.out.println("No results available to change name!");
            return;
        }
        System.out.println("Enter the Roll Number of the Student to Change Course Marks:");
        scanner.nextLine();
        String rollNumber = scanner.nextLine();
        int index = indexFinderFromRollNumber(rollNumber);
        if (index == -1 || index > studentsSemesterResultArrayList.size()) {
            return;
        }
        //Now displaying the students information
        System.out.println("Enter Name of the Course: ");
        String previousCourseName = scanner.nextLine();
        int noOfCourses = studentsSemesterResultArrayList.get(index).getNumberOfCourses();
        CourseResult[] courseResultArray = studentsSemesterResultArrayList.get(index).getCourseResultsArray();
        for (int i = 0; i < noOfCourses; i++) {
            if (previousCourseName.equals(courseResultArray[i].getCourseName())){
                System.out.println("Enter new Marks:");
                int newMarks = scanner.nextInt();
                studentsSemesterResultArrayList.get(index).getCourseResultsArray()[i].setMarks(newMarks);
                double cgpa = studentsSemesterResultArrayList.get(index).cgpaCalculator();
                studentsSemesterResultArrayList.get(index).setStudentCGPA(cgpa);
                System.out.println("Marks Updated successfully!");
                System.out.println();
                displayStudentResult(index);

                return;
            }
        }
        System.out.println("No Such Course Name Exist");
    }

    public static void displayAlLStudentsName()
    {
        for (int i = 0; i < studentsSemesterResultArrayList.size(); i++) {
            String name = studentsSemesterResultArrayList.get(i).getStudentName();
            String rollNumber = studentsSemesterResultArrayList.get(i).getStudentRollNumber();
            System.out.println(i + 1 + "- " + rollNumber + "  " + name);
        }
        System.out.println();
    }
}
