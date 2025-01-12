/* Write a Java program to find whether a given year is leap or not using boolean data type. [Hint: leap year has 366 days;]
Algorithm:
if (year is not exactly divisible by 4) then (it is a common year)
else if (year is not exactly divisible by 100) then (it is a leap year)
else if (year is not exactly divisible by 400) then (it is a common year)
else (it is a leap year)
*/
import java.util.Scanner;
class Leap
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter year: ");
    int year=sc.nextInt();
    boolean flag=false;
    if((year%4==0 && year%100!=0) || year%400==0) flag=true;
    else flag=false;
    if(flag==true) System.out.println(year+" is a leap year.");
    else System.out.println(year+" is not a leap year.");
  }
}
