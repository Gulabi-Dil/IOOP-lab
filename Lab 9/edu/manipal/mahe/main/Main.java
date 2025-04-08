package edu.manipal.mahe.main;
import edu.manipal.mahe.employee.*;
import edu.manipal.mahe.department.*;
import edu.manipal.mahe.payroll.*;
public class Main
{
 public static void main(String args[])
 {
   Employee e= new Employee(101,"Arun",20,50000);
   Department d=new Department("IT","Sukhdev Singh","Manipal");
   Payroll p=new Payroll(e,d);
   p.generatePaySlip();
 }
}
