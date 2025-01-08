import java.util.Scanner;
class Employee
{
  public static void main(String args[])
  {
   Scanner sc =new Scanner(System.in);
   System.out.print("Enter the number of hours worked: ");
   int hours=sc.nextInt();
   System.out.print("\nEnter the hourly salary rate: ");
   double rate=sc.nextDouble();
   double salary;
   if(hours<=40) salary=hours*rate;
   else salary=rate*40+1.5*(hours-40)*rate;
   System.out.println("The final salary of employee is: "+salary);
  }
}
