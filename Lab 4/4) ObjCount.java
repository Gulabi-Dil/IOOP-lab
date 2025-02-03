/*
Create a class called Counter that contains a static data member to count the number of Counter objects being created. 
Also define a static member function called showCount() which displays the number of objects created at any given point of time. Illustrate this.
*/
import java.util.Scanner;
class Counter
{
  static int count=0;
  public Counter()
  {
    count++;
  }
  static void showCount()
  {
    System.out.println("Number of objects of this class created: "+count);
  }
}
class ObjCount
{
  public static void main(String args[])
  {
    Counter ob1=new Counter();
    Counter ob2=new Counter();
    Counter ob3=new Counter();
    Counter.showCount();
  }
}
