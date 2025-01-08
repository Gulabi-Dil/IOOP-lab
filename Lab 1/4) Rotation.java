// Write a Java program to rotate the elements of an array to the right/left by a given number of steps. The program should handle arrays of different sizes and should be able to rotate the array in both directions (left and right).
import java.util.Scanner;
class Rotation
{
  public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter size of array: ");
     int n=sc.nextInt();
     String a[]=new String[n];
     String b[]=new String[n];
     System.out.println("\nEnter elements in the array:");
     for(int i=0;i<n;i++) a[i]=sc.next();
     System.out.println("The array is: ");
     for(int i=0;i<n;i++) System.out.print(a[i]+" ");
     System.out.print("\nEnter the number of shifts you want to perform: ");     int num=sc.nextInt();
     System.out.print("Enter 1 to shift towards right and 2 to shift toward>     int choice=sc.nextInt();
     if(choice==1)
     {
     for(int i=0;i<n;i++)
     {
        if((i+num)<n) b[(i+num)%n]=a[i];
        else b[(i+num)%n]=a[i];
     }
     }
     else if(choice==2)
     for(int i=0;i<n;i++){
     {
        if((i+num)<n) b[i]=a[i+num];
        else b[i]=a[(i+num)%n];
     }}
     else {System.out.println("Invalid choice");
     System.exit(0);}
     System.out.println("\nArray after shifting elements: ");
     for(int i=0;i<n;i++) System.out.print(b[i]+" ");
     System.out.println("");
  }
}
