// Write a Java program to display non diagonal elements and find their sum. 
// [Hint: Non Principal diagonal: The diagonal of a diagonal matrix from the top right to the bottom left corner is called non principal diagonal.]
import java.util.Scanner;
class Matrix
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter dimensions of matrix: ");
    int dim[]=new int[2];
    for(int i=0;i<2;i++) dim[i]=sc.nextInt();
    if(dim[0]==dim[1])
    {
      int m=dim[0];
      int n=dim[1];
      System.out.println("Enter integer elements of the matrix:");
      int mat[][]=new int[m][n];
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++) mat[i][j]=sc.nextInt();
      }
      System.out.println("Matrix = ");
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++) System.out.print(mat[i][j]+"\t");
        System.out.print("\n");
      }
      int sum=0;
      System.out.println("All non diagonal elements of the matrix:");
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
          if((i!=j) && (i+j)!=n-1)
          {
             System.out.print(mat[i][j]+" ");
             sum+=mat[i][j];
          }
          else continue;
        }
      }
      System.out.println("\nSum of all non diagonal elements = "+sum);
    }
    else System.out.println("Invalid dimensions input.");
  }
}
