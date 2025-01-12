/* Write a Java program to generate prime numbers between n and m.
(Hint: A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself. Eg: 2, 3, 5,7,11 etc.)*/
import java.util.Scanner;
class PrimeGenerator
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter lower limit: ");
    int n=sc.nextInt();
    System.out.print("Enter upper limit: ");
    int m=sc.nextInt();
    System.out.println("Prime numbers between "+n+" and "+m+":");
    for(int i=n;i<=m;i++)
    { if(i==1) continue;
      else
      {
        int c=0;
        for(int j=2;j*j<=i;j++)
        {
          if(i%j==0)
          {
            c++;
            break;
          }
        }
        if(c==0) System.out.print(i+" ");
        else continue;
      }
    }
  }
}
