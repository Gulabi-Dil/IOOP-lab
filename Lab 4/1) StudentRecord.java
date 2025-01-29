/*
Consider the already defined STUDENT class. Provide a default constructor and parameterized constructor to this class. Also provide a display method. 
Illustrate all the constructors as well as the display method by defining STUDENT objects.
*/
import java.util.Scanner;
class STUDENT
{
  String sname;
  double[] marks_array;
  double total;
  double avg;
  int n;
  public STUDENT()
  {
    this.sname="Unknown";
    this.marks_array=new double[0];
    this.total=0;
    this.avg=0;
    this.n=0;
  }
  public STUDENT(String sname, double marks_array[])
  {
    this.sname=sname;
    this.marks_array=marks_array;
    this.n=marks_array.length;
    this.total=0;
    this.avg=0;
  }
  void compute()
  {
    total=0;
    for(int i=0;i<n;i++) total+=marks_array[i];
    avg=(n>0)?(total/n):0;
  }
  void display()
  {
    System.out.println("\nDisplaying Student record...\nStudent's name: "+sname);
    if(n>0)
    {
      System.out.println("Student's marks in:");
      for(int i=0;i<n;i++)
      {
        System.out.println("subject "+(i+1)+": "+marks_array[i]);
      }
      System.out.println("Student's total marks: "+total);
      System.out.println("Student's average marks: "+avg+"\n");
    }
    else if(n==0)
    {
      total=0;
      avg=0;
      System.out.println("Student's marks: 0\nStudent's total marks: "+total+"\nStudent's avergage marks: "+avg+"\n");
    }
    else System.out.println("Invalid");
  }
}
class StudentRecord
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    STUDENT ob=new STUDENT();
    System.out.println("Student 1: (Default constructor)");
    ob.compute();
    ob.display();
    System.out.println("Enter name of Student 2: ");
    String sname=sc.nextLine();
    System.out.println("Enter number of subjects: ");
    int n=sc.nextInt();
    double marks_array[]=new double[n];
    System.out.println("Enter marks in:");
    for(int i=0;i<n;i++)
    {
      System.out.println("Subject "+(i+1)+": ");
      marks_array[i]=sc.nextDouble();
    }
    STUDENT ob1=new STUDENT(sname,marks_array);
    ob1.compute();
    ob1.display();
  }
}
