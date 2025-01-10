// For given a 9-digit registration number of a CSE student, identify the year of joining. Assuming the first two digits specify the year of joining.
import java.util.Scanner;
class RegNum
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter student registration number of a CSE student: ");
    int reg=sc.nextInt();
    if((String.valueOf(reg).length())==9)
    {
      String s= String.valueOf(reg);
      if(Integer.parseInt(s.substring(0,2)) >25) System.out.println("Year of joining: 19" + Integer.parseInt(s.substring(0,2)));
      else System.out.println("Year of joining: 20" + Integer.parseInt(s.substring(0,2)));
    }
    else System.out.println("Invalid input. Number is not of 9 digits.");
  }
}
