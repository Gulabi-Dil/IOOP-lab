// For a given date of birth of a person, calculate the date of retirement by taking years of service as input. (assume service periods as 60 years).
import java.util.Scanner;
class Retirement
{
public static void main(String[] args)
{
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter date of birth in the format of DD MM YYYY separated by space: ");
  String d = sc.nextLine();
     if(d.length()==10)
     {

       int date = Integer.parseInt(d.substring(0, 2));
       int month = Integer.parseInt(d.substring(3, 5));
       int year = Integer.parseInt(d.substring(6, 10));
       d = d.replace(" ", "/");
       if(month==2)
       {
       if(date > 28)
       {
         if(date==29)
         {
           if((year%4==0 && year%100!=0) || (year%400==0))
           {
             int x=year+60;
             System.out.println("Retirement date is: " + d.substring(0,6)+x);
           }
           else System.out.println("Invalid date input.");
         }
         else System.out.println("Invalid date input.");
       }
       else
       {
         int x=year+60;
         System.out.println("Retirement date is: " + d.substring(0,6)+x);
       }
       }
       else if((month==9 || month==4 || month==6 || month==11) && month<13)
       {
         if(date>0 && date<=30)
         {
           int x=year+60;
           System.out.println("Retirement date is: " + d.substring(0,6)+x);
         }
         else System.out.println("Invalid date input.");
       }
       else if((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && month <13)
       {
         if(date>0 && date<=31)
         {
           int x=year+60;
           System.out.println("Retirement date is: " + d.substring(0,6)+x);
         }
         else System.out.println("Invalid date input.");
       }
       else System.out.println("Invalid date input.");
     }

     else System.out.println("Invalid date input.");
 }
}
