/*
To the already defined Employee class, add the following string processing methods:
i. formatEmployeeName(): A method that formats the employee's name by capitalizing the first letter of each word and converting the remaining letters to lowercase. 
For example, if the employee's name is "JOHN DOE", this method would transform it to "John Doe".
ii. generateEmail(): A method that generates an email address for the employee based on their name. 
For example, if the employee's name is "John Doe", this method would generate an email address like jdoe@example.com.
Illustrate the above methods upon creating an array of Employee objects. 
The details of each Employee object must be read from the user and initialized using the parameterised constructor.
*/
import java.util.Scanner;
class EMPLOYEE {
    String[] Ename;
    int[] Eid;
    double[] Basic;
    double[] DA;
    double[] Gross_Sal;
    double[] Net_Sal;
    double[] IT;
    int N;
    Department[] departments;
    // Inner class Department
    class Department {
        String departmentName;
        String location;

        Department(String departmentName, String location) {
            this.departmentName = departmentName;
            this.location = location;
        }

        void displayDepartmentDetails() {
            System.out.println("Department: " + departmentName + ", Location: " + location);
        }
    }
    public EMPLOYEE(int N) {
        this.Ename = new String[N];
        this.Eid = new int[N];
        this.Basic = new double[N];
        this.DA = new double[N];
        this.Gross_Sal = new double[N];
        this.Net_Sal = new double[N];
        this.IT = new double[N];
        this.N = N;
        this.departments = new Department[N];
    }

    void addDepartments() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            System.out.print("Enter department name for Employee " + (i + 1) + ": ");
            String deptName = sc.nextLine();
            System.out.print("Enter department location for Employee " + (i + 1) + ": ");
            String location = sc.nextLine();
            departments[i] = new Department(deptName, location);
        }
    }
    void read() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            System.out.print("Enter name of Employee " + (i + 1) + ": ");
            Ename[i] = sc.nextLine();
            System.out.print("Enter ID of Employee " + (i + 1) + ": ");
            Eid[i] = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter basic salary of Employee " + (i + 1) + ": ");
            Basic[i] = sc.nextDouble();
            sc.nextLine();
        }
        addDepartments();
    }
    void compute_net_sal() {
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                DA[i] = 0.52 * Basic[i];
                Gross_Sal[i] = Basic[i] + DA[i];
                IT[i] = 0.3 * Gross_Sal[i];
                Net_Sal[i] = Gross_Sal[i] - IT[i];
            }
        } else if (N == 0) {
            System.out.println("Default constructor. No values assigned.");
        } else {
            System.out.println("Invalid");
        }
    }
    // Method to format the employee name
    String formatEmployeeName(String name) {
        String[] words = name.toLowerCase().split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                formattedName.append(Character.toUpperCase(word.charAt(0)))
                             .append(word.substring(1))
                             .append(" ");
            }
        }
        return formattedName.toString().trim();
    }

    // Method to generate email
    String generateEmail(String name) {
        name = name.toLowerCase().trim();
        String[] parts = name.split("\\s+");
        String email=parts[0].charAt(0)+parts[parts.length-1]+"@example.com";
        return email;
    }

    void display() {
        for (int i = 0; i < N; i++) {
            // Format and update employee name
            Ename[i] = formatEmployeeName(Ename[i]);
            String email = generateEmail(Ename[i]);
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.println("Name: " + Ename[i]);
            System.out.println("Email: " + email);
            System.out.println("Net Salary: " + Net_Sal[i]);
            departments[i].displayDepartmentDetails();
        }
    }
}
class EmpSal3 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int N = scan.nextInt();
        scan.nextLine(); // Consume newline
        EMPLOYEE ob = new EMPLOYEE(N);
        ob.read();
        ob.compute_net_sal();
        ob.display();
    }
}
