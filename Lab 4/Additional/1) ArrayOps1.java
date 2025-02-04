/*
Define a class IntArr which hosts an array of integers. Provide the following methods:
1. A default constructor.
2. A parameterized constructor which initializes the array of the object.
3. A method called display to display the array contents.
4. A method called search to search for an element in the array.
5. A method called compare which compares 2 IntArr objects for equality
*/
import java.util.Scanner;
class IntArr
{
  int arr[];
  public IntArr()
  {
    arr=new int[0];
  }
  public IntArr(int[] a)
  {
    arr=a;
  }
  void display()
  {
    System.out.println("Displaying elements of the array..");
    for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    System.out.println();
  }
  void Searching(int s)
  {
    boolean flag=false;
    for(int n:arr)
    {
      if(n==s)
      {
        flag=true;
        break;
      }
    }
    if(flag) System.out.println("Element found in array.");
    else System.out.println("Element not found in array.");
  }
  void Comparing(int[] x,int[] y)
  {
    boolean check=true;
    if(x.length!=y.length) check=false;
    else
    {
      for(int i=0;i<x.length;i++)
      {
        if(x[i]!=y[i])
        {
          check=false;
          break;
        }
      }
    }
    if(check) System.out.println("Both arrays are equal.");
    else System.out.println("Arrays are unequal.");
  }
}
class ArrayOps1
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter size of 1st array: ");
    int m=sc.nextInt();
    int a[]=new int[m];
    System.out.println("Enter integer elements in this array: ");
    for(int i=0;i<m;i++) a[i]=sc.nextInt();
    IntArr ob1=new IntArr(a);
    ob1.display();
    System.out.println("Enter a number to search in this array: ");
    int x=sc.nextInt();
    ob1.Searching(x);
    System.out.println("Enter size of 2nd array: ");
    int n=sc.nextInt();
    int b[]=new int[n];
    System.out.println("Enter integer elements in this array: ");
    for(int i=0;i<n;i++) b[i]=sc.nextInt();
    IntArr ob2=new IntArr(b);
    ob2.display();
    System.out.println("Enter a number to search in this array: ");
    int y=sc.nextInt();
    ob1.Searching(y);
    System.out.println("\nComparing both arrays..");
    ob1.Comparing(a,b);
  }
}
