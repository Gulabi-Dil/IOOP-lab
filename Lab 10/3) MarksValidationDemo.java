/*
Write a program to calculate the average marks of a student. 
If the total marks are zero or the number of subjects is zero, throw an ArithmeticException to avoid division by zero. 
Create a Student class , add a method calculateAverage(int totalMarks, int numberOfSubjects) that throws ArithmeticException if numberOfSubjects is zero. 
Write a MarksValidationDemo class to invoke the calculateAverage method with valid and invalid data. Handle the exception and display an appropriate error message.
*/

import java.util.*;
class Student3
{
 double totalMarks; int numberOfSubjects; double avg;
 public Student3(double totalMarks, int numberOfSubjects)
 {
  this.totalMarks=totalMarks; this.numberOfSubjects=numberOfSubjects; avg=0;
 }
 public void calculateAverage(double m,int n) throws ArithmeticException
 {
  if(n<=0) throw new ArithmeticException();
  avg=m/n;
  System.out.println("Average marks: "+avg);
 }
}

public class MarksValidationDemo
{
 public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter number of subjects: "); int n=sc.nextInt();
  System.out.print("Enter total marks: "); double m=sc.nextDouble();
  Student3 s=new Student3(m,n);
  try{s.calculateAverage(m,n);}
  catch(ArithmeticException x)
  {
    System.out.println("Invalid input for number of subjects. Division by 0 or negative number of subjects is undefined.");
    System.exit(0);
  }
 }
}
