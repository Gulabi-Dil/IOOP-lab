/* Write a java program to search for a value in a 1 dimensional array using for each loop construct. 
Assume that the array is initialized at the time of declaration and user enters the value to be searched on request.(1 mark)
Input: a[]={1,2,3,1,2,1,5,6,7} searchValue= 1
Expected Output : The value is found at locations: a[0] ,a[3],a[5]. */
import java.util.Scanner;
class Search
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int a[]={1,2,3,1,2,1,5,6,7};
    System.out.print("Enter value to be searched in array: ");
    int n=sc.nextInt();
    boolean flag=false;
    System.out.print("The value is found at locations: ");
    int x=0;
    for(int i:a)
    {
      if(i==n)
      {
        System.out.print("a["+x+"] ");
        flag=true;
      }
      x++;
    }
    if(flag==false) System.out.print("Value not found.");
  }
}
