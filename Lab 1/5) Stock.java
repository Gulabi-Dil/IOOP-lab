/* Write a Java program to manage stock information for multiple products. 
The program should store the product name, product price, and quantity in separate one-dimensional arrays for n items. 
The user should be able to specify which products they want to purchase and the desired quantity for each. 
Based on the user’s input, the program should generate and display the total bill. */
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
   double bill=0;
   System.out.println("Enter product names in separate lines:");
   for(int i=0;i<n;i++) name[i]=sc.nextLine();
   System.out.println("Enter respective product prices in separate lines");
   for(int i=0;i<n;i++) price[i]=sc.nextDouble();
   System.out.print("Enter the number of specific distinct items you want to buy: ");
   int choice=sc.nextInt();
   String cart[]=new String[choice];
   double total[]=new double[choice];
   int quant[]=new int[choice];
   sc.nextLine();
   System.out.println("Enter the product names which you want to buy: ");
   boolean check[]=new boolean[choice];
   for(int i=0;i<choice;i++)
   {
     cart[i]=sc.nextLine();
   }
   for(int i=0;i<choice;i++)
   {
     boolean search=false;
     for(int j=0;j<n;j++)
     {
       if(cart[i].equals(name[j]))
       {
         check[i]=true;
         search=true;
         break;
       }
     }
       if(search==false) System.out.println(cart[i]+" is not in stock.");
   }
   for(int i=0;i<choice;i++)
   {
       if(check[i])
       {
         System.out.println("Enter quantity of "+cart[i]+ ":");
         quant[i]=sc.nextInt();
         for(int j=0;j<n;j++)
         {
           if(cart[i].equals(name[j]))
           {
             bill+=quant[i]*price[j];
             break;
           }
         }
       }
   }
   System.out.println("Total bill is "+ bill);
  }
}
