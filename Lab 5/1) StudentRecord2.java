/*
Enhance the STUDENT class by adding an inner class named Subject that handles details of individual subjects. Where
a) The inner class Subject should:
  a. Contain fields for subjectName and marks.
  b. Provide methods to assign marks and display subject details.
b) The STUDENT class should maintain an array of Subject objects.
c) The STUDENT class should:
 a. Provide methods to add subjects.
d) Calculate total and average marks by iterating over the Subject objects.
*/
import java.util.*;
class STUDENT {
    String sname;
    Subject[] subjects;
    int n;
    double total;
    double avg;

    // Inner class Subject
    class Subject {
        String subjectName;
        double marks;

        Subject(String subjectName, double marks) {
            this.subjectName = subjectName;
            this.marks = marks;
        }

        void displaySubjectDetails() {
            System.out.println(subjectName + ": " + marks);
        }
    }

    // Parameterized constructor
    public STUDENT(String sname, int n) {
        this.sname = sname;
        this.n = n;
        this.subjects = new Subject[n];
        this.total = 0;
        this.avg = 0;
    }

    // Method to add subjects
    void addSubject(int x, String subjectName, double marks) {
        if (x >= 0 && x < n) {
            subjects[x] = new Subject(subjectName, marks);
        }
    }

    // Compute total and average marks
    void compute() {
        total = 0;
        for (int i = 0; i < n; i++) {
            total += subjects[i].marks;
        }
        avg = (n > 0) ? (total / n) : 0;
    }

    // Display student details
    void display() {
        System.out.println("\nDisplaying Student record...");
        System.out.println("Student's name: " + sname);
        if (n > 0) {
            System.out.println("Subjects and marks:");
            for (int i = 0; i < n; i++) {
                subjects[i].displaySubjectDetails();
            }
            System.out.println("Total marks: " + total);
            System.out.println("Average marks: " + avg);
        } else {
            System.out.println("No subjects available.");
        }
    }
}

class StudentRecord2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num=sc.nextInt();
        sc.nextLine();
        STUDENT[] students = new STUDENT[num];

        for (int j = 0; j < num; j++) {
            System.out.print("Enter name of student "+(j+1)+": ");
            String name=sc.nextLine();
            System.out.print("Enter number of subjects: ");
            int n=sc.nextInt();
            sc.nextLine();
            students[j]=new STUDENT(name,n);
            for(int i=0;i<n;i++)
            {
              System.out.print("Enter subject " + (i + 1) + " name: ");
              String subjectName = sc.nextLine();
              System.out.println("Enter marks for " + subjectName + ": ");
              double marks = sc.nextDouble();
              sc.nextLine(); // Consume newline
              students[j].addSubject(i, subjectName, marks);
            }
          students[j].compute();
        }
        for(STUDENT student: students)
        {
          student.display();
        }
    }
}
