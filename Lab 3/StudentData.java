/* 
Define a Class STUDENT having following
Members: sname, marks_array, total, avg and provide the following methods:
a. assign(): to assign initial values to the STUDENT object
b. display(): to display the STUDENT object
c. compute(): to Compute Total, Average marks
Write a Java program Illustrating Class Declarations, Definition, and Accessing Class Members to test the class defined.
*/
import java.util.Scanner;
class STUDENT
{
  String sname;
  double[] marks_array;
  double total;
  double avg;
  int n;
  void assign()
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter name of student: ");
    sname=sc.nextLine();
    System.out.print("Enter number of subjects: ");
    n=sc.nextInt();
    System.out.println("Enter marks in:");
    marks_array=new double[n];
    for(int i=0;i<n;i++)
    {
      System.out.print("subject 1: ");
      marks_array[i]=sc.nextDouble();
    }
  }
  void compute()
  {
    total=0;
    for(int i=0;i<n;i++) total+=marks_array[i];
    avg=total/n;
  }
  void display()
  {
    System.out.println("Student's name: "+sname);
    System.out.println("Student's marks in:");
    for(int i=0;i<n;i++)
    {
      System.out.println("subject 1: "+marks_array[i]);
    }
    System.out.println("Student's total marks: "+total);
    System.out.println("Student's average marks: "+avg);
  }
}
class StudentData
{
  public static void main(String args[])
  {
    STUDENT ob=new STUDENT();
    ob.assign();
    ob.compute();
    ob.display();
  }
}
