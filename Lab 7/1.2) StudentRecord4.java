/*
To the already defined STUDENT class, add two subclasses ScienceStudent and ArtsStudent and implement the following:
i) Add a data member practicalMarks (int) to the ScienceStudent class that represents the marks obtained by the student in the laboratory subject. 
The ScienceStudent class should override the compute() method to include the practical marks in the total marks and average marks calculation. 
Additionally, the ScienceStudent class should provide a method displayPracticalMarks() to display the practical marks obtained by the science student.

ii) Add a data member electiveSubject (String): to the ArtsStudent class that represents the elective subject chosen by the arts student. 
Also, add appropriate constructors to the subclasses.

In main(), create objects of STUDENT, ScienceStudent, and ArtsStudent, and demonstrate the keyword ‘super’ and other functionalities of the classes 
by assigning values, computing marks, and displaying the information of the students. Also, demonstrate dynamic polymorphism.
*/

// INPUT IS TAKEN FROM USER.
import java.util.*;

class STUDENT {
    String sname;
    Subject[] subjects;
    int n;
    double total;
    double avg;

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

    public STUDENT(String sname, int n) {
        this.sname = sname;
        this.n = n;
        this.subjects = new Subject[n];
        this.total = 0;
        this.avg = 0;
    }

    void addSubject(int x, String subjectName, double marks) {
        if (x >= 0 && x < n) {
            subjects[x] = new Subject(subjectName, marks);
        }
    }

    void compute() {
        total = 0;
        for (int i = 0; i < n; i++) {
            total += subjects[i].marks;
        }
        avg = (n > 0) ? (total / n) : 0;
    }

    void display() {
        System.out.println("\nDisplaying Student record...");
        System.out.println("Student's name: " + sname);
        System.out.println("Subjects and marks:");
        for (int i = 0; i < n; i++) {
            subjects[i].displaySubjectDetails();
        }
        System.out.println("Total marks: " + total);
        System.out.println("Average marks: " + avg);
    }
}

class ScienceStudent extends STUDENT {
    int practicalMarks;

    public ScienceStudent(String sname, int n, int practicalMarks) {
        super(sname, n);
        this.practicalMarks = practicalMarks;
    }

    @Override
    void compute() {
        super.compute();
        total += practicalMarks;
        avg = (n > 0) ? (total / (n + 1)) : 0;
    }

    void displayPracticalMarks() {
        System.out.println("Practical Marks: " + practicalMarks);
    }
}

class ArtsStudent extends STUDENT {
    String electiveSubject;

    public ArtsStudent(String sname, int n, String electiveSubject) {
        super(sname, n);
        this.electiveSubject = electiveSubject;
    }

    void displayElectiveSubject() {
        System.out.println("Elective Subject: " + electiveSubject);
    }
}

class StudentRecord4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name of student: ");
        String name = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();
        sc.nextLine();
        
        STUDENT s1 = new STUDENT(name, numSubjects);
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            String subjectName = sc.nextLine();
            System.out.print("Enter marks for " + subjectName + ": ");
            double marks = sc.nextDouble();
            sc.nextLine();
            s1.addSubject(i, subjectName, marks);
        }
        s1.compute();
        s1.display();

        System.out.print("Enter name of science student: ");
        String sciName = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int sciSubjects = sc.nextInt();
        System.out.print("Enter practical marks: ");
        int practicalMarks = sc.nextInt();
        sc.nextLine();
        
        ScienceStudent s2 = new ScienceStudent(sciName, sciSubjects, practicalMarks);
        for (int i = 0; i < sciSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            String subjectName = sc.nextLine();
            System.out.print("Enter marks for " + subjectName + ": ");
            double marks = sc.nextDouble();
            sc.nextLine();
            s2.addSubject(i, subjectName, marks);
        }
        s2.compute();
        s2.display();
        s2.displayPracticalMarks();

        System.out.print("Enter name of arts student: ");
        String artsName = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int artsSubjects = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter elective subject: ");
        String electiveSubject = sc.nextLine();

        ArtsStudent s3 = new ArtsStudent(artsName, artsSubjects, electiveSubject);
        for (int i = 0; i < artsSubjects; i++) {
            System.out.print("Enter subject " + (i + 1) + " name: ");
            String subjectName = sc.nextLine();
            System.out.print("Enter marks for " + subjectName + ": ");
            double marks = sc.nextDouble();
            sc.nextLine();
            s3.addSubject(i, subjectName, marks);
        }
        s3.compute();
        s3.display();
        s3.displayElectiveSubject();

        STUDENT ref;
        ref = s2;  // Dynamic polymorphism
        ref.display();
    }
}
