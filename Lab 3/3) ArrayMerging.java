/*
Define a class Mixer to merge two sorted integer arrays in ascending order with the following instance variables and methods:
instance variables:
int arr[] //to store the elements of an array
Methods:
void accept() // to accept the elements of the array in ascending order without any duplicates
Mixer mix(Mixer A) // to merge the current object array elements with the parameterized array elements and return the resultant object
void display() // to display the elements of the array Define the main() method to test the class.
*/
import java.util.Scanner;
class Mixer
{
  int arr[];
  void accept()
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter size of array: ");
    int n=sc.nextInt();
    arr=new int[n];
    System.out.println("Enter elements of array in ascending order without any duplicates:");
    for(int i=0;i<n;i++) arr[i]=sc.nextInt();
    for(int i = 0; i < n - 1; i++)
    {
      for(int j = 0; j < n - i - 1; j++)
      {
        if(arr[j] > arr[j + 1])
        {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        if((i!=j) && (arr[j]==arr[i]))
        {
          System.out.println("Invalid! Duplicate element found. Exiting program...");
          System.exit(0);
        }
      }
    }
    System.out.println("Array in ascending order (got sorted if not entered in ascending order)");
  }
  Mixer mix(Mixer A)
  {
    int k=0;
    int size=A.arr.length+this.arr.length;
    int merged[]=new int[size];
    for (int i = 0; i < this.arr.length; i++) merged[k++] = this.arr[i];
    for (int i = 0; i < A.arr.length; i++)
    {
       int s = 0;
       for (int j = 0; j < this.arr.length; j++)
       {
          if (this.arr[j] == A.arr[i]) s++;
       }
       if (s == 0) merged[k++] = A.arr[i];
    }
    for(int i=0;i<k-1;i++)
    {
      for(int j=0;j<k-i-1;j++)
      {
        if(merged[j]>merged[j+1])
        {
         int tempo=merged[j];
         merged[j]=merged[j+1];
         merged[j+1]=tempo;
        }
      }
    }
    Mixer answer=new Mixer();
    answer.arr=new int[k];
    for(int i=0;i<k;i++) answer.arr[i]=merged[i];
    return answer;
  }
  void display()
  {
    for (int num : arr) System.out.print(num + " ");
    System.out.println();
  }
}
class ArrayMerging
{
  public static void main(String args[])
  {
    Mixer ob1=new Mixer();
    Mixer ob2=new Mixer();
    System.out.println("First array:");
    ob1.accept();
    System.out.println("Second array:");
    ob2.accept();
    System.out.println("Displaying first array:");
    ob1.display();
    System.out.println("Displaying second array:");
    ob2.display();
    Mixer merge=ob1.mix(ob2);
    System.out.println("Array after merging without any duplicate elements if any:");
    merge.display();
  }
}
