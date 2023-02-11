/**
 * Creates an object for a Student
 *
 * @Anthony Segarra
 * @18 December 2022
 */
public class Student {
    // instance variables
    private String name;
    private int age;
    private double gpa;

    /*
     * Creates a student with a name, age and gpa
     */
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // @return student name
    public String getName() {
        return name;
    }

    // @return student age
    public int getAge() {
        return age;
    }

    // @return student gpa
    public double getGPA() {
        return gpa;
    }

    /*
     * @return formated student
     */
    public String toString() {
        String output = getClass().getName() + "[name = " + this.name + ", age = " + this.age + " gpa = " + this.gpa
                + "]";
        return output;
    }
}