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

// INPUT IS HARDCODED.
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
        STUDENT s1 = new STUDENT("Alice", 2);
        s1.addSubject(0, "Math", 85);
        s1.addSubject(1, "English", 90);
        s1.compute();
        s1.display();

        ScienceStudent s2 = new ScienceStudent("Bob", 3, 20);
        s2.addSubject(0, "Physics", 80);
        s2.addSubject(1, "Chemistry", 75);
        s2.addSubject(2, "Biology", 85);
        s2.compute();
        s2.display();
        s2.displayPracticalMarks();

        ArtsStudent s3 = new ArtsStudent("Charlie", 2, "History");
        s3.addSubject(0, "History", 88);
        s3.addSubject(1, "Literature", 92);
        s3.compute();
        s3.display();
        s3.displayElectiveSubject();

        STUDENT ref;
        ref = s2;  // Dynamic polymorphism
        ref.display();
    }
}
