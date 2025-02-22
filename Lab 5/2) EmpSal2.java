/*
Implement an EMPLOYEE class with an inner class named Department that handles department-related details. The inner class Department should:
a. Contain fields for departmentName and location.
b. Provide methods to set and display department details.
The EMPLOYEE class should:
Contain fields for eName (employee name), salary, and an array of Department objects. Provide methods to:
c) Add departments.
d) Display employee details along with department information.
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

    void display() {
        for (int i = 0; i < N; i++) {
            System.out.println("\nEmployee " + (i + 1) + ":");
            System.out.println("Name: " + Ename[i] + "\nNet Salary = " + Net_Sal[i]);
            departments[i].displayDepartmentDetails();
        }
    }
}

class EmpSal2 {
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
