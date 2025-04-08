package edu.manipal.mahe.employee;
public class Employee
{
 private int employeeId; private String name;
 protected int age; public double basicSalary;
 public Employee(int employeeId,String name,int age,double basicSalary)
 {
   this.employeeId=employeeId; this.age=age;
   this.name=name; this.basicSalary=basicSalary;
 }
 public int getID()
 {return employeeId;}
 public String getEmpName()
 {return name;}
 public int getAge()
 {return age;}
 public double getSal()
 {return basicSalary;}
 public void displayEmployee()
 {System.out.println("Employee name: "+name+"\nEmployee age: "+age);}
}
