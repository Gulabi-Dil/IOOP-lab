// Write a Java program to manage stock information for multiple products. The program should store the product name, product price, and quantity in separate one-dimensional arrays for n items. The user should be able to specify which products they want to purchase and the desired quantity for each. Based on the user’s input, the program should generate and display the total bill.
import java.util.Scanner;
class Stock
{
  public static void main(String args[])
  {
   Scanner sc =new Scanner(System.in);
   System.out.print("Enter number of items: ");
   int n=sc.nextInt();
   sc.nextLine();
   String name[]=new String[n];
   double price[]=new double[n];
   int quant[]=new int[n];
   double bill=0;
   System.out.println("Enter product names in separate lines:");
   for(int i=0;i<n;i++) name[i]=sc.nextLine();
   System.out.println("Enter respective product prices in separate lines");
   for(int i=0;i<n;i++) price[i]=sc.nextDouble();
   System.out.print("Enter the number of specific distinct items you want to buy: ");
   int choice=sc.nextInt();
   String cart[]=new String[choice];
   double total[]=new double[choice];
   sc.nextLine();
   System.out.println("Enter the product names which you want to buy: ");
   for(int i=0;i<choice;i++) cart[i]=sc.nextLine();
   int c=0;
   for(int i=0;i<choice;i++)
   {
     for(int j=0;j<n;j++)
     {
       if(name[j].equals(cart[i])) c++;
     }
   }
   if(c<choice)
   {
     System.out.println("Invalid input. Some items you mentioned are not in stock.");
     System.exit(0);
   }
   else
   {
   for(int i=0;i<choice;i++)
   {
      for(int j=0;j<n;j++)
      {
         if(cart[i].equals(name[j])) total[i]=price[j];
         else continue;
      }
   }}
   System.out.println("Enter respective product quantities: ");
   for(int i=0;i<choice;i++) quant[i]=sc.nextInt();
   for(int i=0;i<choice;i++) bill+=quant[i]*total[i];
   System.out.println("Total bill is: "+ bill);
  }
}
