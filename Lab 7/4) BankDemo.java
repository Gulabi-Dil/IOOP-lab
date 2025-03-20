/*
Create an Account class that stores customers name, acc-no and type of account. From this derive class current account and savings bank account. Include necessary methods to achieve following tasks
i) Accept the deposit from a customer and update the balance
ii) Display the balance
iii) Compute and deposit interest
iv) Permit withdraw and update the balance
v) Check for minimum balance impose penalty if necessary and update the balance
For savings bank account, the facilities provided include computing interest and withdrawal.
No interest can be computed on current bank account and a minimum balance must always be maintained. In any instance when it goes below this level, service tax must be imposed.
*/
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    public Account(String customerName, int accountNumber, String accountType, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate = 0.04; // 4% annual interest

    public SavingsAccount(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Savings", balance);
    }

    void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest Deposited: " + interest);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurrentAccount extends Account {
    static final double MIN_BALANCE = 500.0;
    static final double PENALTY = 50.0;

    public CurrentAccount(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, "Current", balance);
    }

    void withdraw(double amount) {
        if (balance - amount < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Minimum balance not maintained. Penalty imposed: " + PENALTY);
        } else {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        }
    }
}

class BankDemo {
    public static void main(String args[]) {
        SavingsAccount savings = new SavingsAccount("Alice", 101, 2000);
        CurrentAccount current = new CurrentAccount("Bob", 102, 1000);

        System.out.println("\nSavings Account Transactions:");
        savings.deposit(500);
        savings.computeInterest();
        savings.withdraw(700);
        savings.displayBalance();

        System.out.println("\nCurrent Account Transactions:");
        current.deposit(1000);
        current.withdraw(1600);
        current.displayBalance();
    }
}
