import java.util.*;
class strProg
{
  static String rev="";
  static void CheckPalindrome(String s)
  {
    for(int i=0;i<s.length()/2;i++)
    {
      if(s.charAt(s.length()-i-1)!=s.charAt(i))
      {
        System.out.printf("%s is not a palindrome string",s); return;
      }
    }
    System.out.printf("%s is a palindrome string",s);
  }
  static void AlphaOrder(String s)
  {
    String sarr[]=new String[s.length()];
    String ss="";
    for(int x=0;x<s.length();x++)
    {
      sarr[x]=String.valueOf(s.charAt(x));
    }
    Arrays.sort(sarr,String.CASE_INSENSITIVE_ORDER);
    for(int i=0;i<s.length();i++) ss+=sarr[i];
    System.out.printf("\nString in alphabetical order: %s\n",ss);
  }
  static void RevStr(String s)
  {
    String ss="";
    for(int i=s.length()-1;i>=0;i--)
    {
      ss+=s.charAt(i);
    }
    System.out.printf("String in reverse: %s\n",ss);
    rev=ss;
  }
  static void Joining(String s)
  {
    String j=s+rev;
    System.out.printf("Concatenation of original and reversed strings: %s\n",j);
  }
  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s=sc.nextLine().trim();
    while(true)
    {
    System.out.println("\nEnter your choice:\n1. Check if a string is palindrome.\n2. Write string in alphabetical order.\n3. Reverse the string.\n4. Concatente original and reversed strings.\n5. Exit.");
    int k=sc.nextInt();
    switch(k)
    {
      case 1: CheckPalindrome(s); break;
      case 2: AlphaOrder(s); break;
      case 3: RevStr(s); break;
      case 4: Joining(s); break;
      case 5: System.exit(0);
      default: System.out.println("Invalid choice!");
    }
    }
  }
}
