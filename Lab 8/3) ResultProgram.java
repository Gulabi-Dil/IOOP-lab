/*
Design a class Student with the methods, getRollNum() and putRollNum() to read and display the Roll No. of each student; and getMarks() and putMarks() to read and display their marks. 
Create an interface called Sports with a method putSportsScore() that will set the score obtained by a student in physical education examination. 
Design a class called Result that will implement this interface to generate the result by considering both the marks and sports score.
*/
interface Sports {
    void putSportsScore(int score);
}

class Student {
    int rollNum;
    double marks;
    
    void getRollNum(int roll) {
        rollNum = roll;
    }
    
    void putRollNum() {
        System.out.println("Roll Number: " + rollNum);
    }
    
    void getMarks(double m) {
        marks = m;
    }
    
    void putMarks() {
        System.out.println("Marks: " + marks);
    }
}

class Result extends Student implements Sports {
    int sportsScore;
    
    public void putSportsScore(int score) {
        sportsScore = score;
    }
    
    void displayResult() {
        putRollNum();
        putMarks();
        System.out.println("Sports Score: " + sportsScore);
    }
}

class ResultDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Result student = new Result();
        
        System.out.print("Enter Roll Number: ");
        student.getRollNum(sc.nextInt());
        System.out.print("Enter Marks: ");
        student.getMarks(sc.nextDouble());
        System.out.print("Enter Sports Score: ");
        student.putSportsScore(sc.nextInt());
        
        student.displayResult();
    }
}
