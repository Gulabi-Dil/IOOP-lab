package edu.manipal.mit.student;
public class Student
{
  private String name; private int rollNumber;
  protected String department; public double gpa;
  public Student(String name, int rollNumber, String department, double gpa)
  {
    this.name=name; this.rollNumber=rollNumber;
    this. department=department; this.gpa=gpa;
  }
  public String getName()
  {return name;}
  public int getRoll()
  {return rollNumber;}
  public String getDept()
  {return department;}
  public double getGpa()
  {return gpa;}
  public void displayStudent()
  {System.out.println("Student: "+name+"\nRoll Number: "+rollNumber+"\nDepartment: "+department+"\nGPA: "+gpa);}
}
