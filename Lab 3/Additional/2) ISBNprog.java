/*
The International Standard Book Number (ISBN) is a unique numeric book identifier which is printed on every book. The ISBN is based upon a 10-digit code. 
The ISBN is legal if: 1xdigit1 + 2xdigit2 + 3xdigit3 + 4xdigit4 + 5xdigit5 + 6xdigit6 + 7xdigit7 + 8xdigit8 + 9xdigit9 + 10xdigit10 is divisible by 11.
example: For an ISBN 1401601499:
Sum=1×1 + 2×4 + 3×0 + 4×1 + 5×6 + 6×0 + 7×1 + 8×4 + 9×9 + 10×9 = 253 which is divisible by 11.
Write a program to implement the following methods:
inputISBN( ) to read the ISBN code as a 10-digit integer. checkISBN() to perform the following check operations:
a. If the ISBN is not a 10-digit integer, output the message “ISBN should be a 10 digit number” and terminate the program.
b. If the number is 10-digit, extract the digits of the number and compute the sum as explained above. 
   If the sum is divisible by 11, output the message, “Legal ISBN”; otherwise output the message, “Illegal ISBN”
*/
import java.util.Scanner;
class ISBNValidity
{
   long isbn;
   void inputISBN()
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter a ten digit ISBN: ");
     isbn=sc.nextLong();
   }
   void checkISBN()
   {
     String str=String.valueOf(isbn);
     if(str.length()!=10)
     {
       System.out.println("ISBN should be a 10 digit number.");
       System.exit(0);
     }
     else
     {
       long rem;
       long sum=0;
       int i=10;
       while(isbn>0)
       {
         rem=isbn%10;
         sum+=rem*(i--);
         isbn/=10;
       }
       if(sum%11==0) System.out.println("Legal ISBN.");
       else System.out.println("Illegal ISBN.");
     }
   }
}
class ISBNprog
{
  public static void main(String args[])
  {
    ISBNValidity ob=new ISBNValidity();
    ob.inputISBN();
    System.out.println("Checking if its a valid ISBN or not...");
    ob.checkISBN();
  }
}
