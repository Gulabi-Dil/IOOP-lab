// Write a program to check whether a number is palindrome or not.
import java.util.Scanner;
class Palindrome
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int n=sc.nextInt();
    int rem;
    int num=n;
    int rev=0;
    while(n!=0)
    {
      rem=n%10;
      rev=rev*10+rem;
      n=n/10;
    }
    if(num==rev) System.out.println("Number is palindrome.");
    else System.out.println("Number is not palindrome.");
  }
}
