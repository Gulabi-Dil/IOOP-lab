/*
Define a class to represent a Bank account. Include the following members. Data members:
a. Name of the depositor
b. Account number.
c. Type of account.
d. Balance amount in the account.
e. Rate of interest (static data)
Provide a default constructor and parameterized constructor to this class. Also provide Methods:
a. To deposit amount.
b. To withdraw amount after checking for minimum balance.
c. To display all the details of an account holder.
d. Display rate of interest (a static method)
Illustrate all the constructors as well as all the methods by defining objects.
*/
import java.util.Scanner;
class Savings
{
  String name;
  String accnum;
  String type;
  double balance;
  static double min=10000;
  static double rate;
  public Savings()
  {
    name="Unknown";
    accnum="0000000000";
    type="Unknown";
    balance=0;
  }
  public Savings(String name,String accnum,String type, double balance)
  {
    this.name=name;
    this.accnum=accnum;
    this.type=type;
    this.balance=balance;
  }
  void Deposit1(double P)
  {
    if(P>0) balance+=P;
    else System.out.println("Deposit amount must be greater than 0.");
  }
  void Withdraw1(double P)
  {
    if(balance>10000) balance-=P;
    else System.out.println("Minimum account balance requirement was not met. Withdrawal disapproved.");
  }
  public static void RateInput(double r)
  {
    rate=r;
  }
  void Display()
  {
    System.out.println("Displaying bank account details...");
    System.out.println("Name of account holder: "+name);
    System.out.println("Account number: "+accnum);
    System.out.println("Account type: "+type);
    System.out.println("Balance in account: "+balance);
    System.out.println("Rate of interest: "+rate);
  }
}
class Current extends Savings
{
  public Current(String name, String accnum, String type, double balance) {
        super(name, accnum, type, balance); }
}
class Bank
{
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter 1 to choose Savings account(S). Enter 2 to choose Current account(C): ");
    int k=sc.nextInt();
    sc.nextLine();
    switch(k)
    {
      case 1:
      System.out.println("Enter name of account holder: ");
      String name=sc.nextLine();
      System.out.println("Enter account number: ");
      String n=sc.nextLine();
      System.out.println("Enter current balance in account: ");
      double bal=sc.nextDouble();
      System.out.println("Enter rate of interest: ");
      double R=sc.nextDouble();
      String type="Savings";
      Savings ob=new Savings(name,n,type,bal);
      Savings.RateInput(R);
      System.out.println("Enter 1 to deposit or 2 to withdraw. ");
      int c=sc.nextInt();
      switch(c)
      {
        case 1: System.out.println("Enter amount to deposit: ");
        double amt=sc.nextDouble();
        ob.Deposit1(amt);
        ob.Display();
        break;
        case 2: System.out.println("Enter amount to withdraw: ");
        double amt1=sc.nextDouble();
        ob.Withdraw1(amt1);
        ob.Display();
        break;
        default: System.out.println("Invalid.");
      }
      break;
      case 2:
      System.out.println("Enter name of account holder: ");
      String nam=sc.nextLine();
      System.out.println("Enter account number: ");
      String N=sc.nextLine();
      System.out.println("Enter current balance in account: ");
      double b=sc.nextDouble();
      System.out.println("Enter rate of interest: ");
      double r=sc.nextDouble();
      String t="Current";
      Current obj=new Current(nam,N,t,b);
      Savings.RateInput(r);
      System.out.println("Enter 1 to deposit or 2 to withdraw. ");
      int d=sc.nextInt();
      switch(d)
      {
        case 1: System.out.println("Enter amount to deposit: ");
        double amt=sc.nextDouble();
        obj.Deposit1(amt);
        obj.Display();
        break;
        case 2: System.out.println("Enter amount to withdraw: ");
        double amt1=sc.nextDouble();
        obj.Withdraw1(amt1);
        obj.Display();
        break;
        default: System.out.println("Invalid.");
      }
    }
  }
}


