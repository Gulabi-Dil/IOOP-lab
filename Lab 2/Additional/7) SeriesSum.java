/* Write a Java programs to evaluate the following series
• Sin(x) =x - (x3/3!) + (x5/5!)-…
• Sum=1 + (1/2)2 + (1/3)3 +… 
*/
import java.lang.Math;
import java.util.Scanner;
class SeriesSum
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Computing sine series sum...\nEnter value of x: ");
    double x=sc.nextDouble();
    System.out.print("Enter number of terms in the sine series: ");
    int n=sc.nextInt();
    double s=0;
    int fact=1;
    for(int i=1;i<=n;i++)
    {
      int j=2*i-1;
      fact=1;
      for(int k=1;k<=j;k++) fact*=k;
      if(i%2==1)
      {
        s+=(Math.pow(x,j))/(fact);
      }
      else s-=(Math.pow(x,j))/(fact);
    }
    System.out.println("sin(x) = "+s);
    System.out.print("Computing 1 + (1/2)2 + (1/3)3 +… now.\nEnter number of terms in the series: ");
    int m=sc.nextInt();
    double sum=0;
    for(int i=1;i<=m;i++) sum+=Math.pow((1.0/i),i);
    System.out.print("1 + (1/2)2 + (1/3)3 +… = "+sum);
  }
}
