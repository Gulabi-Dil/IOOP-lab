package edu.manipal.mit.main;
import edu.manipal.mit.student.Student;
import edu.manipal.mit.course.Course;
import edu.manipal.mit.registration.Registration;
public class Main
{
  public static void main(String args[])
  {
   Student s1 = new Student("Alice", 101, "CSE", 9.1);
   Course c1 = new Course("Data Structures", "Dr. Smith", 4);
   Registration reg1 = new Registration(s1, c1);
   reg1.registerStudent();
  }
}
