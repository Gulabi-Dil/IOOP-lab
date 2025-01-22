/*
Create a class with integer array of size 10 and write methods to perform following. Use Switch case to accept choice from the user.
a. Input values into an array
b. Display the values
c. Display the largest value
d. Display the average
e. Sort the array in ascending order
*/
import java.util.Scanner;
class ArrayOps
{
  int a[]=new int[10];
  void Input()
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter 10 integer values in the array:");
    for(int i=0;i<10;i++) a[i]=sc.nextInt();
    System.out.println();
  }
  void Display()
  {
    System.out.println("Displaying array:");
    for(int i=0;i<10;i++) System.out.print(a[i]+" ");
    System.out.println();
  }
  void Largest()
  {
    int max=a[0];
    for(int i=1;i<10;i++)
    {
      if(max<a[i]) max=a[i];
    }
    System.out.println("Largest number in the array : "+max+"\n");
  }
  void Average()
  {
    int sum=0;
    for(int i=0;i<10;i++) sum+=a[i];
    double avg=sum/10.0;
    System.out.println("Average of all numbers in the array = "+avg+"\n");
  }
  void AscSort()
  {
    for(int i = 0; i < 10-1; i++)
    {
      for(int j = 0; j < 10 - i - 1; j++)
      {
        if(a[j] > a[j + 1])
        {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
    System.out.println("Array in ascending order:");
    for(int i=0;i<10;i++) System.out.print(a[i]+" ");
    System.out.println();
  }
}
class UserArray
{
  public static void main(String args[])
  {
    Scanner scan=new Scanner(System.in);
    ArrayOps ob=new ArrayOps();
    //boolean start=true;
    while(true)
    {
      System.out.println("Enter choice:\n1.Input values into an array.\n2. Display the values.\n3. Display the largest value.\n4. Display the average.\n5. Sort the array in ascending order.\n6. Exit.");
      int k=scan.nextInt();
      switch(k)
      {
        case 1: ob.Input();
        break;
        case 2: ob.Display();
        break;
        case 3: ob.Largest();
        break;
        case 4: ob.Average();
        break;
        case 5: ob.AscSort();
        break;
        case 6: System.exit(0);
        break;
        default: System.out.println("Invalid input.");
      }
    }
  }
}
