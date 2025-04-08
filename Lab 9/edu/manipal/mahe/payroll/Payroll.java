package edu.manipal.mahe.payroll;
import edu.manipal.mahe.employee.*;
import edu.manipal.mahe.department.*;
public class Payroll
{
 private Employee employee; private Department department;
 double DA=0; double gross=0; double IT=0; double net=0;
 public Payroll(Employee employee,Department department)
 {this.employee=employee; this.department=department;}
 private double calculateNetSalary()
 {
  DA=0.52*employee.basicSalary; gross=employee.basicSalary+DA;
  IT=0.3*gross; net=gross-IT;
  return net;
 }
 public void generatePaySlip()
 {
   System.out.println("Payslip for January 2025");
   employee.displayEmployee(); department.displayDepts();
   System.out.println("Employee Net Salary: "+ (calculateNetSalary()));
 }
}
