/*
Consider the already defined EMPLOYEE class. Provide a default constructor, and parameterized constructor. 
Also provide a display method. Illustrate all the constructors as well as the display method by defining EMPLOYEE objects.
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
  public EMPLOYEE()
  {
    this.Ename=new String[0];
    this.Eid=new int[0];
    this.Basic=new double[0];
    this.DA=new double[0];
    this.Gross_Sal=new double[0];
    this.Net_Sal=new double[0];
    this.IT=new double[0];
    this.N=0;
  }
  public EMPLOYEE(int N)
  {
    this.Ename=new String[N];
    this.Eid=new int[N];
    this.Basic=new double[N];
    this.DA=new double[N];
    this.Gross_Sal=new double[N];
    this.Net_Sal=new double[N];
    this.IT=new double[N];
    this.N=N;
  }
  void read()
  {
    Scanner sc=new Scanner(System.in);
    for(int i=0;i<N;i++)
    {
      System.out.print("Enter name of Employee "+(i+1)+": ");
      Ename[i]=sc.nextLine();
      System.out.print("Enter ID of Employee "+(i+1)+": ");
      Eid[i]=sc.nextInt();
      sc.nextLine();
      System.out.print("Enter basic salary of Employee "+(i+1)+": ");
      Basic[i]=sc.nextDouble();
      sc.nextLine();
    }
  }
  void compute_net_sal()
  {
   if(N>0)
   {
    for(int i=0;i<N;i++)
    {
      DA[i]=0.52*Basic[i];
      Gross_Sal[i]=Basic[i]+DA[i];
      IT[i]=0.3*Gross_Sal[i];
      Net_Sal[i]=Gross_Sal[i]-IT[i];
    }
   }
   else if(N==0)
   {
    System.out.println("Default constructor. No values assigned.");
   }
   else System.out.println("Invalid");
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
    Scanner scan=new Scanner(System.in);
    EMPLOYEE ob1=new EMPLOYEE();
    ob1.read();
    ob1.compute_net_sal();
    ob1.display();
    System.out.print("Enter number of employees: ");
    int N=scan.nextInt();
    EMPLOYEE ob2=new EMPLOYEE(N);
    ob2.read();
    ob2.compute_net_sal();
    ob2.display();
  }
}

