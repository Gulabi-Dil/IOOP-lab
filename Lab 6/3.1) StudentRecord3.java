/*
To the already defined Student class, add the following methods:
i. extractInitials(): A method that extracts the initials from the student's name. 
   For example, if the student's name is "John Doe", this method would return "JD".
ii. removeWhitespace(): A method that removes any whitespace characters from the student's name. 
    For example, if the student's name is "John Doe", this method would transform it to "JohnDoe".
iii. List all the student names containing a particular substring.
iv. Sort the students alphabetically
In a separate class that contains main(), read the students details from console input. 
After displaying the details of all the students, illustrate the use of the above methods.
*/

// INPUT TAKEN IN THE STUEDNT CLASS.
import java.util.*;
class STUDENT {
    String[] sname;
    int[] numSubjects;
    Subject[][] subjects;
    double[] total;
    double[] avg;
    int N;

    // Inner class Subject
    class Subject {
        String subjectName;
        double marks;

        Subject(String subjectName, double marks) {
            this.subjectName = subjectName;
            this.marks = marks;
        }
    }

    public STUDENT(int N) {
        this.N = N;
        this.sname = new String[N];
        this.numSubjects = new int[N];
        this.subjects = new Subject[N][];
        this.total = new double[N];
        this.avg = new double[N];
    }

    void read() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            sname[i] = sc.nextLine();
            System.out.print("Enter number of subjects for student " + (i + 1) + ": ");
            numSubjects[i] = sc.nextInt();
            sc.nextLine();
            subjects[i] = new Subject[numSubjects[i]];
            for (int j = 0; j < numSubjects[i]; j++) {
                System.out.print("Enter subject " + (j + 1) + " name: ");
                String subjectName = sc.nextLine();
                System.out.print("Enter marks for " + subjectName + ": ");
                double marks = sc.nextDouble();
                sc.nextLine(); // Consume newline
                subjects[i][j] = new Subject(subjectName, marks);
            }
        }
    }

    void compute() {
        for (int i = 0; i < N; i++) {
            total[i] = 0;
            for (int j = 0; j < numSubjects[i]; j++) {
                total[i] += subjects[i][j].marks;
            }
            avg[i] = (numSubjects[i] > 0) ? (total[i] / numSubjects[i]) : 0;
        }
    }

    void sortStudents() {
        Arrays.sort(sname);
    }

    void searchBySubstring(String substring) {
        System.out.println("Students containing \"" + substring + "\":");
        for (String name : sname) {
            if (name.contains(substring)) {
                System.out.println(name);
            }
        }
    }

    void display() {
        for (int i = 0; i < N; i++) {
            System.out.println("\nDisplaying Student record...");
            System.out.println("Student's name: " + sname[i]);
            if (numSubjects[i] > 0) {
                System.out.println("Subjects and marks:");
                for (int j = 0; j < numSubjects[i]; j++) {
                    System.out.println(subjects[i][j].subjectName + ": " + subjects[i][j].marks);
                }
                System.out.println("Total marks: " + total[i]);
                System.out.println("Average marks: " + avg[i]);
            } else {
                System.out.println("No subjects available.");
            }
            System.out.println("Initials: " + extractInitials(sname[i]));
            System.out.println("Name without whitespace: " + removeWhitespace(sname[i]));
        }
    }

    String extractInitials(String name) {
        StringBuilder initials = new StringBuilder();
        for (String part : name.split(" ")) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }
        return initials.toString().toUpperCase();
    }

    String removeWhitespace(String name) {
        return name.replaceAll("\\s", "");
    }
}

class StudentRecord3 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int N = scan.nextInt();
        scan.nextLine(); // Consume newline
        STUDENT ob = new STUDENT(N);
        ob.read();
        ob.compute();
        ob.sortStudents();
        ob.display();
        System.out.print("Enter substring to search for in student names: ");
        String substring = scan.nextLine();
        ob.searchBySubstring(substring);
    }
}
