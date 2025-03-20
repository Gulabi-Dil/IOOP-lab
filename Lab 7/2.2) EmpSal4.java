/*
To the already defined EMPLOYEE class, add two subclasses FullTimeEmp and PartTimeEmp and implement the following:
i) Include the following data members to the PartTimeEmp class-hoursWorked (int) that represents the number of hours worked by the part-time employee 
and hourlyRate (double, static and final) that represents the hourly rate at which the part-time employee is paid. 
Also, override calculateSalary() and displayEmployeeDetails() splayEmployeeDetails() method of the base class to display the part-time employee's details, 
including the hours worked and hourly rate.

ii) The FullTimeEmployee subclass includes the data members bonus and deductions as additional data members and are of type double and overrides the calculateSalary() and
displayEmployeeDetails() methods to incorporate these factors.
In main(), create various objects to illustrate the functionality of all the classes.
*/
// INPUT IS HARDCODED.
class EMPLOYEE {
    String Ename;
    int Eid;
    double Basic;
    double DA;
    double Gross_Sal;
    double Net_Sal;
    double IT;
    Department department;

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

    public EMPLOYEE(String Ename, int Eid, double Basic, String deptName, String location) {
        this.Ename = Ename;
        this.Eid = Eid;
        this.Basic = Basic;
        this.department = new Department(deptName, location);
    }

    void compute_net_sal() {
        DA = 0.52 * Basic;
        Gross_Sal = Basic + DA;
        IT = 0.3 * Gross_Sal;
        Net_Sal = Gross_Sal - IT;
    }

    void display() {
        System.out.println("\nEmployee:");
        System.out.println("Name: " + Ename);
        System.out.println("ID: " + Eid);
        System.out.println("Net Salary: " + Net_Sal);
        department.displayDepartmentDetails();
    }
}

class PartTimeEmp extends EMPLOYEE {
    int hoursWorked;
    static final double hourlyRate = 20.0;

    public PartTimeEmp(String Ename, int Eid, int hoursWorked, String deptName, String location) {
        super(Ename, Eid, 0, deptName, location);
        this.hoursWorked = hoursWorked;
    }

    void compute_net_sal() {
        Net_Sal = hoursWorked * hourlyRate;
    }

    void display() {
        super.display();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: " + hourlyRate);
    }
}

class FullTimeEmp extends EMPLOYEE {
    double bonus;
    double deductions;

    public FullTimeEmp(String Ename, int Eid, double Basic, double bonus, double deductions, String deptName, String location) {
        super(Ename, Eid, Basic, deptName, location);
        this.bonus = bonus;
        this.deductions = deductions;
    }

    void compute_net_sal() {
        super.compute_net_sal();
        Net_Sal += bonus - deductions;
    }

    void display() {
        super.display();
        System.out.println("Bonus: " + bonus);
        System.out.println("Deductions: " + deductions);
    }
}

class EmpSal4 {
    public static void main(String args[]) {
        FullTimeEmp[] fullTimeEmployees = {
            new FullTimeEmp("Alice Johnson", 101, 50000, 5000, 2000, "HR", "New York"),
            new FullTimeEmp("Bob Smith", 102, 60000, 7000, 3000, "Finance", "Chicago")
        };

        PartTimeEmp[] partTimeEmployees = {
            new PartTimeEmp("Charlie Brown", 201, 25, "IT", "San Francisco"),
            new PartTimeEmp("David White", 202, 30, "Marketing", "Los Angeles")
        };

        for (FullTimeEmp emp : fullTimeEmployees) {
            emp.compute_net_sal();
        }

        for (PartTimeEmp emp : partTimeEmployees) {
            emp.compute_net_sal();
        }

        System.out.println("\nFull-Time Employees:");
        for (FullTimeEmp emp : fullTimeEmployees) {
            emp.display();
        }

        System.out.println("\nPart-Time Employees:");
        for (PartTimeEmp emp : partTimeEmployees) {
            emp.display();
        }

        EMPLOYEE ref = fullTimeEmployees[0];
        ref.display();  // Demonstrates dynamic polymorphism
    }
}
