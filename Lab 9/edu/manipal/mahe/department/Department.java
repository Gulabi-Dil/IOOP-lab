package edu.manipal.mahe.department;
public class Department
{
 private String departmentName; protected String manager;
 public String location;
 public Department(String departmentName,String manager,String location)
 {
  this.departmentName=departmentName; this.manager=manager;
  this.location=location;
 }
 public String getDept()
 {return departmentName;}
 public String getMan()
 {return manager;}
 public String getLoc()
 {return location;}
 public void displayDepts()
 {System.out.println("Employee department name: "+departmentName+" Department");}
}
