// Write a Java program to find largest and smallest among 3 numbers using ternary operator.
import java.util.Scanner;
class Ternary
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter first number: ");
    int a=sc.nextInt();
    System.out.print("Enter a second number: ");
    int b=sc.nextInt();
    System.out.print("Enter third number: ");
    int c =sc.nextInt();
    int largest=(a>b)?((a>c)?a:c):((b>c)?b:c);
    int smallest=(a<b)?((a<c)?a:c):((b<c)?b:c);
    System.out.print("Largest = "+largest+"\nSmallest = "+smallest);
  }
}
