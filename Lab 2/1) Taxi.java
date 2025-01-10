// A Taxi service offers a new service based on travel distance. Write a Java program to calculate the total distance traveled by considering the following charges. First 5 km = INR 10/km, Next 15 km = INR 8/km, Next 25 km = INR 5/km.
import java.util.Scanner;
class Taxi
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter distance travelled in kilometeres: ");
    int d=sc.nextInt();
    double fare=0;
    if(d<=5) fare=d*10;
    else if(d>5 && d<=20) fare=50+(d-5)*8;
    else if(d>20 && d<=45) fare=50+15*8+(d-20)*5;
    else System.out.println("Fare not specified for more than 45 km.");
    System.out.println("Total fare is: " + fare);
  }
}
