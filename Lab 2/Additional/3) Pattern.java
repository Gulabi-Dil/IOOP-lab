/* Write a Java program to display the numbers in the following format
• using nested for loop.
• using for-each loop.
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
*/
import java.util.Scanner;
class Pattern
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of rows: ");
    int n=sc.nextInt();
    System.out.println("Pattern using nested for loop:");
    for(int i=0;i<=n;i++)
    {
      for(int j=0;j<i;j++) System.out.print(i);
      System.out.print("\n");
    }
    System.out.print("Pattern using for-each loop:\n");
    for(int i=0;i<=n;i++)
    {
      int arr[]=new int[i];
      for(int j=0;j<i;j++) arr[j]=i;
      for(int x:arr) System.out.print(x);
      System.out.print("\n");
    }
  }
}
