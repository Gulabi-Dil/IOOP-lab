/* Write a Java program to find the result of the following expressions for various values of a & b:
a. (a << 2) + (b >> 2)
b. (b > 0)
c. (a + b * 100) / 10
d. a & b
*/
import java.util.Scanner;
class Employee
{
  public static void main(String args[])
  {
   Scanner sc =new Scanner(System.in);
   System.out.println("Enter number a: ");
   int a=sc.nextInt();
   System.out.println("Enter number b: ");
   int b=sc.nextInt();
   System.out.println("a. (a<<2) + (b>>2) = "+ (a<<2+b>>2));
   System.out.println("b. (b>0) = " + (b>0));
   System.out.println("c. (a+b*100)/10 = "+ ((a+b*100)/10));
   System.out.println("d. a&b = " + (a&b));
  }
}
