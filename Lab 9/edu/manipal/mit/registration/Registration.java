package edu.manipal.mit.registration;
import edu.manipal.mit.course.Course;
import edu.manipal.mit.student.Student;
public class Registration
{
 private Student student;
 private Course course;
 public Registration(Student student, Course course)
 {this.student=student; this.course=course;}
 public void registerStudent()
 {
  System.out.println("Registration successful!");
  student.displayStudent();
  course.displayCourse();
 }
}
