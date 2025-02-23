/*
To the already defined Student class, add the following methods:
i. extractInitials(): A method that extracts the initials from the student's name. 
   For example, if the student's name is "John Doe", this method would return "JD".
ii. removeWhitespace(): A method that removes any whitespace characters from the student's name. 
    For example, if the student's name is "John Doe", this method would transform it to "JohnDoe".
iii. List all the student names containing a particular substring.
iv. Sort the students alphabetically
In a separate class that contains main(), read the students details from console input. After displaying the details of all the students, illustrate the use of the above methods.
*/

// INPUT TAKEN FROM THE MAIN METHOD. 

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

    String extractInitials(String name) {
        String words[] = name.trim().toUpperCase().split("\\s+");
        String initial = "";
        for (String x : words) {
            initial += x.charAt(0);
        }
        return initial;
    }

    String removeWhitespace(String name) {
        return name.replaceAll("\\s+", "");
    }

    static void sortStudents(STUDENT[] students) {
        Arrays.sort(students, Comparator.comparing(student -> student.sname,String.CASE_INSENSITIVE_ORDER));
    }

    static void search(STUDENT[] students, String sub) {
        System.out.printf("Students with their names containing '%s':\n", sub);
        for (STUDENT student : students) {
            if (student.sname.contains(sub)) {
                System.out.println(student.sname);
            }
        }
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
        System.out.println("Initials: " + extractInitials(sname));
        System.out.println("Name without whitespace: " + removeWhitespace(sname)+"\n");
    }
}

class StudentRecord3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int num = sc.nextInt();
        sc.nextLine();
        STUDENT[] students = new STUDENT[num];

        for (int j = 0; j < num; j++) {
            System.out.print("Enter name of student " + (j + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter number of subjects: ");
            int n = sc.nextInt();
            sc.nextLine();
            students[j] = new STUDENT(name, n);
            for (int i = 0; i < n; i++) {
                System.out.print("Enter subject " + (i + 1) + " name: ");
                String subjectName = sc.nextLine();
                System.out.print("Enter marks for " + subjectName + ": ");
                double marks = sc.nextDouble();
                sc.nextLine(); // Consume newline
                students[j].addSubject(i, subjectName, marks);
            }
            students[j].compute();
        }
        STUDENT.sortStudents(students);
        for (STUDENT student : students) {
            student.display();
        }

        System.out.print("Enter substring to search in students' names: ");
        String search = sc.nextLine();
        STUDENT.search(students, search);
    }
}
