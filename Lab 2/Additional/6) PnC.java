/* Write a program to print all combinations of four digit number. A four digit number is generated using only four digits {1, 2, 3, 4}.
• Case 1: Duplication of digit is allowed.
• Case 2: Duplication of digit is not allowed.
*/
import java.util.Scanner;
class PnC
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    char a[]={'1','2','3','4'};
    System.out.println("All combinations of 4 digit number:\nCase 1: Duplication of digit is allowed.>    for(int i=0;i<4;i++)
    {
      for(int j=0;j<4;j++)
      {
        for(int k=0;k<4;k++)
        {
          for(int l=0;l<4;l++) System.out.println(""+a[i]+a[j]+a[k]+a[l]);
        }
      }
    }
    System.out.println("Case 2: Duplication of digit is not allowed:");
    for(int i=0;i<4;i++)
    {
      for(int j=0;j<4;j++)
      {
        if(i==j) continue;
        for(int k=0;k<4;k++)
        {
          if(i==k || j==k) continue;
          for(int l=0;l<4;l++)
          {
            if(i==l || j==l || k==l) continue;
            System.out.println(""+a[i]+a[j]+a[k]+a[l]);
          }
        }

      }
    }
  }
}
