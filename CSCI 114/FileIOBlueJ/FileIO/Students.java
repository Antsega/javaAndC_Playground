import java.util.ArrayList; // Array List
import java.io.*; // File I/O
import java.util.*; // Import Scanner in Java

/**
 * Creates an Array List of Students
 * Uses Students.txt to create students
 * Contains methods to pull specific information regarding the students in the new AL
 *
 * @Anthony Segarra
 * @18 December 2022
 */
public class Students {
    private ArrayList<Student> students;

    /*
     * @return number of lines from a file
     */
    public int lineCounter() throws IOException {
        // read input file
        Scanner sc1 = new Scanner(new File("Students.txt"));
        // line counter
        int lineCount = 0;
        while (sc1.hasNextLine()) {
            // Read the next line
            sc1.nextLine();
            // increment the line count
            lineCount++;
        }
        sc1.close();
        return lineCount;
    }

    /*
     * Opens data file
     * Reads data
     * Creates Student Object(s)
     * Adds student to the students AL
     * 
     * @returns AL
     */
    public void readFile() throws IOException {

        // student format
        String name;
        int age;
        double gpa;

        // initializing
        String line;

        // read text file
        // creates a new student with the text file
        try (Scanner sc2 = new Scanner(new File("Students.txt"))) {
            students = new ArrayList<>();
            while (sc2.hasNextLine()) {
                // each student requires three lines of code
                for (int i = 0; i < (lineCounter() / 3); i++) {

                    name = sc2.nextLine();

                    // convert next line from file from string to int
                    line = sc2.nextLine();
                    age = Integer.parseInt(line);

                    // convert next line from file from string to gpa
                    line = sc2.nextLine();
                    gpa = Double.parseDouble(line);

                    // Creates a student object
                    this.students.add(i, new Student(name, age, gpa));
                }
            }
            sc2.close();
        }
    }

    /*
     * @return a String containing all the students in the AL and format.toString()
     */
    public String allStudents() {
        String output = getClass().getName() + "[ ";
        for (int i = 0; i < this.students.size(); i++) {
            output += this.students.get(i).toString() + ", ";
            if (i == this.students.size() - 1) {
                output += this.students.get(i).toString() + "]";
            }
        }
        return output;
    }

    /*
     * grabs the highest gpa
     * 
     * @returns toString() of the student containing the highest GPA
     */
    public String bestGPA() {
        double startingGPA = 0.0;
        String output = "student not found";
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getGPA() > startingGPA) {
                startingGPA = this.students.get(i).getGPA();
                output = this.students.get(i).toString();
            }
        }
        return output;
    }

    /*
     * adds the GPA of all students
     * divides by number of lines in txt file by three, since each student contains
     * three lines of information
     * 
     * @returns double average rounded to two decimal places
     */
    public double averageGPA() throws IOException {
        double average = 0;
        for (int i = 0; i < this.students.size(); i++) {
            average += this.students.get(i).getGPA();
        }
        average = average / (lineCounter() / 3);
        average = Math.round(average * 100.0) / 100.0;
        return average;
    }

    /*
     * creates default string
     * if their GPA is greater than the average, adds a student to output
     * if statement(s); for formating output string
     * 
     * @return String containing student(s).toString() formatted
     */
    public String aboveAverage() throws IOException {
        String output = "error in calculation(s)";
        int count = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getGPA() > averageGPA()) {
                // if multiple students, first student formatted
                if (count == 0 && this.students.size() > 1) {
                    count++;
                    output = this.students.get(i).toString() + ", ";
                    // if last student, formatted
                } else if (count > 1 && i < this.students.size() - 1) {
                    output += this.students.get(i).toString();
                    // if only student
                } else if (this.students.size() == 1)
                    output = this.students.get(i).toString();
                // additional students
                else
                    output += this.students.get(i).toString() + ", ";
            }
        }
        return output;
    }

    /*
     * if a student's GPA is above average
     * increment count
     * 
     * @return count
     */
    public Integer numAboveAvg() throws IOException {
        int count = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getGPA() > averageGPA())
                count++;
        }
        return count;
    }

    /*
     * if a student's GPA is below average
     * increment count
     * 
     * @return count
     */
    public Integer numBelowAvg() throws IOException {
        int count = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getGPA() < averageGPA())
                count++;
        }
        return count;
    }

    /*
     * creates default string
     * if their GPA is less than the average, adds a student to output
     * if statement(s); for formating output string
     * 
     * @return String containing student(s).toString() formatted
     */
    public String belowAverage() throws IOException {
        String output = "error in calculation(s)";
        int count = 0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getGPA() < averageGPA()) {
                // if multiple students, first student formatted
                if (count == 0 && this.students.size() > 1) {
                    count++;
                    output = this.students.get(i).toString() + ", ";
                    // if last student, formatted
                } else if (count > 1 && i < this.students.size() - 1) {
                    output += this.students.get(i).toString();
                    // if only student
                } else if (this.students.size() == 1)
                    output = this.students.get(i).toString();
                // additional students
                else
                    output += this.students.get(i).toString() + ", ";
            }
        }
        return output;
    }

    /*
     * Loops through students AL
     * grabs lowest age and if student is below average GPA
     * 
     * @return output of student.toString() that meets conditions
     */
    public String youngestBelowAvg() throws IOException {
        Integer age = 100;
        String output = "error in calculation(s)";
        for (int i = 0; i < this.students.size(); i++) {
            if ((this.students.get(i).getAge() < age) && (this.students.get(i).getGPA() < averageGPA())) {
                age = this.students.get(i).getAge();
                output = this.students.get(i).toString();
            }
        }
        return output;
    }

    /*
     * Adds the students age who are below average GPA
     * 
     * @return avgAge by number of students below average
     */
    public double avgAgeBelowAvg() throws IOException {
        double avgAge = 0.0;
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getGPA() < averageGPA())
                avgAge += this.students.get(i).getAge();
        }
        avgAge /= numBelowAvg();
        // round avg age to two decimal places
        avgAge = Math.round(avgAge * 100.00) / 100;
        return avgAge;
    }
}