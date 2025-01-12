// Write a Java program to read an int number, double number, and a char from the keyboard and perform the following conversion: int to byte, char to int, double to byte, double to int.
import java.util.Scanner;
class TypeConversions
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int num=sc.nextInt();
    System.out.print("Enter a double data type number: ");
    double d=sc.nextDouble();
    System.out.print("Enter a character: ");
    char ch=sc.next().charAt(0);
    byte b=(byte)num;
    int c=(int)ch;
    byte dou=(byte)d;
    int ok=(int)d;
    System.out.println("int to byte: "+b+"\nchar to int: "+c+"\ndouble to byte: "+dou+"\ndouble to int: "+ok);
  }
}
