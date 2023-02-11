import java.io.*; // File I/O

/**
 * Answers specific questions regarding the students provided
 *
 * @Anthony Segarra
 * @18 December 2022
 */
public class Tester {

    public static void main(String args[]) throws IOException {

        // creates new students obj
        Students periodOne = new Students();
        // creates an output file
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        // 1) reads the data file into Students
        periodOne.readFile();

        // 2) Prints all Student objects from Students
        pw.println("A List Of All Students");
        pw.println(periodOne.allStudents() + "\n");
        System.out.println("A List Of All Students");
        System.out.println(periodOne.allStudents() + "\n");

        // 3) Prints the Student object with the best GPA
        pw.println("The Student With The Best GPA");
        pw.println(periodOne.bestGPA() + "\n");
        System.out.println("The Student With The Best GPA");
        System.out.println(periodOne.bestGPA() + "\n");

        // 4) Average GPA is:
        pw.println("The average GPA is: " + periodOne.averageGPA() + "\n");
        System.out.println("The average GPA is: " + periodOne.averageGPA() + "\n");

        // 5)
        // print students with above average
        pw.println("Number of Students With Above Average GPA: " + periodOne.numAboveAvg());
        System.out.println("Number of Students With Above Average GPA: " + periodOne.numAboveAvg());

        // print students with above average
        pw.println("Number of Students With Below Average GPA: " + periodOne.numBelowAvg() + "\n");
        System.out.println("Number of Students With Below Average GPA: " + periodOne.numBelowAvg() + "\n");

        // 6) Above Avg student(s)
        pw.println("List of above average students");
        pw.println(periodOne.aboveAverage() + "\n");
        System.out.println("List of above average students");
        System.out.println(periodOne.aboveAverage() + "\n");

        // 7) youngest Student with a below average GPA
        pw.println("Youngest Student with a below average GPA: " + periodOne.youngestBelowAvg() + "\n");
        System.out.println("Youngest Student with a below average GPA: " + periodOne.youngestBelowAvg() + "\n");

        // 8) average age of the students with below average GPA
        pw.println("Average age of the students with below average GPA : " + periodOne.avgAgeBelowAvg() + " years old");
        System.out.println(
                "Average age of the students with below average GPA : " + periodOne.avgAgeBelowAvg() + " years old");

        pw.close();
    }
}
