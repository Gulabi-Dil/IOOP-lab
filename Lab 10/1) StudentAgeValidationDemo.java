/*
Write a program to validate the age of a student during their registration. 
If the age is not between 18 and 60, throw an IllegalArgumentException. Create Student class with Private attributes name and age. 
Add method registerStudent(String name, int age) that throws an IllegalArgumentException if the age is invalid (that is, not between 18 and 60).
Write StudentAgeValidationDemo class to create instance of student class and invoke registerStudent method with valid and invalid data.
Catch the exception and display an error message for invalid input.
*/

import java.util.*;
class Student
{
 private String name; private int age;
 public Student(String name, int age)
 {this.name=name; this.age=age;}

 public void registerStudent(String name, int age)
 {
   if(!(age>18 && age<60)) throw new IllegalArgumentException();
 }
}

public class StudentAgeValidationDemo
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter student name: "); String n=sc.nextLine();
   System.out.print("\nEnter student age: "); int a=sc.nextInt();
   Student s=new Student(n,a);
   try{s.registerStudent(n,a);}
   catch(IllegalArgumentException A)
  {
    System.out.println("Invalid age input! Must be between 18 and 60.\nRegistration failed.");
    System.exit(0);
  }
  System.out.println("Registration successful.");
 }
}
