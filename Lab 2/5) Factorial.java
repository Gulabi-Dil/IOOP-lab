// Write a Java programs to print factorial of a given no recursively.
import java.util.Scanner;
class Factorial
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number to calculate its factorial: ");
    int n=sc.nextInt();
    int prod=1;
    int i=n;
    while(i>0)
    {
      prod*=i;
      i--;
    }
    System.out.println("Factorial of "+n+" = "+prod);
  }
}
