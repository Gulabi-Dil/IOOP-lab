/*
Define a class EMPLOYEE having following members: Ename, Eid, Basic, DA, Gross_Sal, Net_Sal and following methods:
a. read(): to read N employee details
b. display(): to display employee details
c. compute_net_sal(): to compute net salary
Write a Java program to read data of N employee and compute and display net salary of each employee Note: (DA = 52% of Basic, gross_Sal = Basic + DA; IT = 30% of the gross salary)
Net salary=Gross salary-IT
*/
import java.util.Scanner;
class EMPLOYEE
{
  String[] Ename;
  int[] Eid;
  double[] Basic;
  double[] DA;
  double[] Gross_Sal;
  double[] Net_Sal;
  int N;
  double[] IT;
  void read()
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter number of Employees: ");
    N=sc.nextInt();
    Ename=new String[N];
    Eid=new int[N];
    Basic=new double[N];
    DA=new double[N];
    Gross_Sal=new double[N];
    Net_Sal=new double[N];
    IT=new double[N];
    for(int i=0;i<N;i++)
    {
      sc.nextLine();
      System.out.print("Enter name of Employee "+(i+1)+": ");
      Ename[i]=sc.nextLine();
      System.out.print("Enter ID of Employee "+(i+1)+": ");
      Eid[i]=sc.nextInt();
      System.out.print("Enter basic salary of Employee "+(i+1)+": ");
      Basic[i]=sc.nextDouble();
    }
  }
  void compute_net_sal()
  {
    for(int i=0;i<N;i++)
    {
      DA[i]=0.52*Basic[i];
      Gross_Sal[i]=Basic[i]+DA[i];
      IT[i]=0.3*Gross_Sal[i];
      Net_Sal[i]=Gross_Sal[i]-IT[i];
    }
  }
  void display()
  {
    for(int i=0;i<N;i++)
    {
      System.out.println("Employee "+(i+1)+":");
      System.out.println("Name: "+Ename[i]+"\nNet Salary = "+Net_Sal[i]);
    }
  }
}
class EmpSal
{
  public static void main(String args[])
  {
    EMPLOYEE ob=new EMPLOYEE();
    ob.read();
    ob.compute_net_sal();
    ob.display();
  }
}
