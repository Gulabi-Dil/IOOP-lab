/*
Create a Die class with one integer instance variable called sideUp. Give it a getSideUp() method that returns the values of sideUp and a void roll() method that changes sideUpto a random value from 1 to 6.
Then create a DieDemo class with a method that creates two Die objects, rolls them, and prints the sum of the two sides up.
*/
import java.util.Random;
class Die
{
  int sideUp;
  int getSideUp()
  {
    return sideUp;
  }
  void roll()
  {
    Random dice=new Random();
    sideUp=dice.nextInt(7);
  }
}
class DieDemo
{
  public static void main(String args[])
  {
    Die ob1=new Die();
    Die ob2=new Die();
    System.out.println("Rolling dice 1: ");
    ob1.roll();
    System.out.println("Side up: "+ob1.getSideUp());
    System.out.println("Rolling dice 2: ");
    ob2.roll();
    System.out.println("Side up: "+ob2.getSideUp());
    int sum=ob1.getSideUp() + ob2.getSideUp();
    System.out.println("Sum of the two sides up = "+ sum);
  }
}
