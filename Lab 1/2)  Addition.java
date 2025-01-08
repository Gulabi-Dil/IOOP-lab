// Write a java program to add two numbers using the bitwise operator and check if the output is an even or odd number. [Hint: use left shift and right shift bitwise operators].
import java.util.Scanner;
class Addition
{
  public static void main(String args[])
  {
   Scanner sc =new Scanner(System.in);
   System.out.print("Enter first number: ");
   int a=sc.nextInt();
   System.out.print("\nEnter second number: ");
   int b=sc.nextInt();
   int c=(a&b)<<1;
   int sum=(a^b)+c;
   System.out.println("\nSum= "+sum);
  }
}
