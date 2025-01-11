// Write a Java program to print table of number entered by user.
import java.util.Scanner;
class Table
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number whose table you want: ");
    int n=sc.nextInt();
    System.out.print("Enter how many multiples you want in the table: ");
    int x=sc.nextInt();
    for(int i=1;i<x+1;i++) System.out.println(n+" times "+i+" = " +(i*n));
  }
}
