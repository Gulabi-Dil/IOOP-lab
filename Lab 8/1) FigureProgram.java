/*
Create an abstract class Figure with an abstract method area and two integer variables that represent x and y dimensions. 
Create three more classes Rectangle, Triangle and Square that extend Figure and implement the area method appropriately. 
Illustrate how the method area can be computed at run time for Rectangle, Square and Triangle to achieve dynamic polymorphism.
*/
import java.util.*;
abstract class Figure {
    int x, y;
    
    Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    abstract double area();
}

class Rectangle extends Figure {
    Rectangle(int x, int y) {
        super(x, y);
    }
    
    double area() {
        return x * y;
    }
}

class Triangle extends Figure {
    Triangle(int x, int y) {
        super(x, y);
    }
    
    double area() {
        return 0.5 * x * y;
    }
}

class Square extends Figure {
    Square(int x) {
        super(x, x);
    }
    
    double area() {
        return x * x;
    }
}

class FigureDemo {
    public static void main(String[] args) {
        Figure f1 = new Rectangle(5, 10);
        Figure f2 = new Triangle(4, 8);
        Figure f3 = new Square(6);
        
        System.out.println("Rectangle Area: " + f1.area());
        System.out.println("Triangle Area: " + f2.area());
        System.out.println("Square Area: " + f3.area());
    }
}
