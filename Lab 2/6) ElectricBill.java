/*Write a Java program to compute the electricity bill for an industry using a switch-case statement. The program should take the daily consumption in units for 7 days as input. 
Based on the total consumption, the program should calculate and display the total electricity bill according to the following pricing table:
Units Price per Unit (INR)
0 - 100     7.00
101 - 200   8.00
>= 201     10.00*/
import java.util.Scanner;
class ElectricBill
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter daily consumption for 7 days in units: ");
    int units[]=new int[7];
    for(int i =0;i<7;i++) units[i]=sc.nextInt();
    double bill=0;
    int k;
    for(int i =0;i<7;i++)
    {
    if(units[i]>0 && units[i]<=100) k=1;
    else if(units[i]>100 && units[i]<=200) k=2;
    else if(units[i]>200) k=3;
    else k=4;
    switch(k)
    {
      case 1: bill+=7*units[i];
      break;
      case 2: bill+=8*units[i];
      break;
      case 3: bill+=10*units[i];
      break;
      case 4: System.out.println("Invalid input");
      break;
    }
    }
    System.out.println("Total bill = " + bill);
}
}
