# **INDEX**
- [Pointer like Behavior in Java (Referenicng)](https://github.com/Gulabi-Dil/IOOP-lab/blob/main/Notes.md#pointer-like-behavior-in-java)
- [toString function](https://github.com/Gulabi-Dil/IOOP-lab/blob/main/Notes.md#understanding-tostring-in-java)
- [Abstract Classes](https://github.com/Gulabi-Dil/IOOP-lab/blob/main/Notes.md#abstract-classes-and-static-usage-in-java)
- [Accessing private variable in a different class]()
---
# **(1) Pointer like Behavior in Java (Referenicng)**:
## Case 1:
```java
import java.util.*;
class IOOP
{
  static int[] Check()
  {
    int a[]={1,2,3,4,5};
    return a;
  }
  public static void main(String args[])
  {
    System.out.println(Check());
  }
}
```
Output: `[I@7ad041f3`
## Case 2:
```java
import java.util.*;
class IOOP
{
  static int[] Check()
  {
    int a[]={1,2,3,4,5};
    return a;
  }
  public static void main(String args[])
  {
    System.out.println(Arrays.toString(Check()));
  }
}
```
Output: `[1, 2, 3, 4, 5]`
## Explanation:
Arrays like other entities are objects in java. When the Chech() method is just called directly, Java does not return the memory address directly but a hash code representing the reference.
In `[I@7ad041f3`, "[I" tells that its an array of int data type. "@" separates the type from the hash code. "7ad041f3" is the hash code of the memory address. 
But the contents of array can be printed in its string representation (i.e. `[1, 2, 3, 4, 5]`) by using **Arrays.toString()**, which converts the array into a readable string format.

Unlike C or C++, Java does not have explicit pointers, but it uses references.

- Reference variables store memory addresses indirectly (like pointers).
- No pointer arithmetic is allowed in Java.
- Garbage collection automatically manages memory, so we don’t need to free() or delete objects manually.
```java
import java.util.*;
class Example
{
  public static void main(String args[])
  {
    int[] arr1 = {1,2,3};
    int[] arr2 = arr1; // Both arr1 and arr2 point to the same array
    
    arr2[0] = 99; // Changing arr2 also affects arr1
    
    System.out.println(Arrays.toString(arr1)); // Output: [99, 2, 3]
  }
}
```
Both arr1 and arr2 point to the same memory. Changing arr2[0] also changes arr1[0] because they reference the same array.

### Pointer-like Behavior in Java:

## **Case 1:**

```java
import java.util.*;
class IOOP
{
  static int[] Check()
  {
    int a[]={1,2,3,4,5};
    return a;
  }
  public static void main(String args[])
  {
    System.out.println(Check());
  }
}
```

**Output:** `[I@7ad041f3`

## **Case 2:**

```java
import java.util.*;
class IOOP
{
  static int[] Check()
  {
    int a[]={1,2,3,4,5};
    return a;
  }
  public static void main(String args[])
  {
    System.out.println(Arrays.toString(Check()));
  }
}
```

**Output:** `[1, 2, 3, 4, 5]`

## **Explanation:**

Arrays, like other objects in Java, are stored as references. When the `Check()` method is called, it **returns a reference** to the array, not its actual contents.

## **Pointers vs. References in Java**

Unlike C or C++, **Java does not have pointers**. Instead, Java uses **references**, which behave like pointers but with safety restrictions.

- In C++, you can manipulate memory directly with pointers.
- In Java, you cannot access memory directly, but references **point to objects stored in memory**.
---

# **(2) Understanding `toString()` in Java**

The `toString()` method in Java is used to **return a string representation of an object**. It is defined in the `Object` class, which means every Java class **inherits** it by default.


## **1. Default Behavior of `toString()`**
By default, if you call `toString()` on an object **without overriding it**, it prints:
```
ClassName@HashCode
```
where:
- `ClassName` → Name of the object's class.
- `@` → Separator.
- `HashCode` → Hexadecimal representation of the memory reference.

### **Example: Default `toString()` Behavior**
```java
class Demo {}
public class Main {
    public static void main(String[] args) {
        Demo obj = new Demo();
        System.out.println(obj.toString()); // Output: Demo@7ad041f3
        System.out.println(obj);            // Also prints: Demo@7ad041f3
    }
}
```
💡 **Calling `System.out.println(obj);` is the same as `System.out.println(obj.toString());` because `println` automatically calls `toString()`.**


## **2. Overriding `toString()` for Custom Output**
Since the default `toString()` is not very useful, we **override it** in custom classes to return meaningful information.

### **Example: Overriding `toString()`**
```java
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding toString() to return a meaningful string
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alice", 25);
        System.out.println(p); // Output: Person{name='Alice', age=25}
    }
}
```
💡 **Without overriding `toString()`, the output would be** `Person@hashcode`.  
💡 **With overriding, we get a useful string representation** instead.


## **3. `toString()` in Arrays**
In Java, **arrays do not override `toString()`**, so calling `toString()` on an array gives the default behavior:

### **Example: `toString()` with Arrays**
```java
int[] arr = {1, 2, 3, 4};
System.out.println(arr.toString());  // Output: [I@7ad041f3
```
💡 **Solution:** Use `Arrays.toString()` to print arrays properly:
```java
System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4]
```

## **4. `toString()` in Collections (Like `ArrayList`)**
Unlike arrays, Java Collections (like `ArrayList`, `HashMap`, etc.) **override `toString()`**, so calling `toString()` on them **prints their contents properly**.

### **Example: `toString()` in `ArrayList`**
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(list.toString()); // Output: [1, 2, 3, 4]
        System.out.println(list);            // Same output: [1, 2, 3, 4]
    }
}
```

## **5. Summary**
| Scenario | `toString()` Output |
|----------|----------------------|
| **Default `Object` behavior** | `ClassName@hashcode` |
| **Overridden in custom class** | Returns a meaningful string (e.g., `"Person{name='Alice', age=25}"`) |
| **Called on arrays** | `"[I@hashcode"` (use `Arrays.toString()`) |
| **Called on `ArrayList`, `HashMap`, etc.** | Prints contents directly (e.g., `[1, 2, 3, 4]`) |


## **Final Thoughts**
- `toString()` **helps represent an object as a string**.
- **Override it** in custom classes for better readability.
- **Use `Arrays.toString()`** to print arrays properly.
- **Collections already override `toString()`**, so they print correctly.

# Example of Array of Objects and overriding toString function to print the objects diirectly:
```java
import java.util.*;
class Student
{
  int roll;
  String name;
  double marks;
  public String toString()
  {  return "Roll: "+roll+"\tName: "+name+"\tMarks: "+marks;}
}
public class byeworld
{
  public static void main(String args[])
  {
    Student s1=new Student();
    s1.roll=1;
    s1.name="Yahoo";
    s1.marks=90;

    Student s2=new Student();
    s2.roll=2;
    s2.name="Tanay";
    s2.marks=80;

    Student s3=new Student();
    s3.roll=3;
    s3.name="Krisha";
    s3.marks=87;
    Student students[]=new Student[3];
    students[0]=s1;
    students[1]=s2;
    students[2]=s3;
    for(int i=0;i<3;i++) System.out.println(students[i]);
  }
}
```
Output: 
```
Roll: 1 Name: Yahoo     Marks: 90.0
Roll: 2 Name: Tanay     Marks: 80.0
Roll: 3 Name: Krisha    Marks: 87.0
```
---
# **(3) Abstract Classes and `static` Usage in Java**

## **1. Abstract Classes and Methods**
- An **abstract class** is a class that **cannot be instantiated** (objects cannot be created from it).
- It is **meant to be inherited** by subclasses.
- It can have both **abstract methods (without a body)** and **concrete methods (with a body)**.

### **Example of an Abstract Class with an Abstract Method**
```java
// Abstract class
abstract class Main {
  public String fname = "John";
  public int age = 24;
  public abstract void study(); // Abstract method (must be implemented in subclass)
}

// Subclass (inherits from Main)
class Student extends Main {
  public int graduationYear = 2018;

  public void study() { // Abstract method implemented
    System.out.println("Studying all day long");
  }
}

// Another class to run the program
class Second {
  public static void main(String[] args) {
    Student myObj = new Student();
    System.out.println("Name: " + myObj.fname);
    System.out.println("Age: " + myObj.age);
    System.out.println("Graduation Year: " + myObj.graduationYear);
    myObj.study(); // Calls the implemented method
  }
}
```

### **Key Points About Abstract Classes**
- ✅ **Can contain instance variables**.
- ✅ **Can have constructors**.
- ✅ **Can contain both abstract and concrete methods**.
- ❌ **Cannot be instantiated directly**.
- ✅ **A subclass must implement all abstract methods**, otherwise it must be declared abstract.


## **2. What Happens If a Subclass Doesn't Implement Abstract Methods?**
- If a subclass **does not** implement all abstract methods from the parent class, it must also be declared `abstract`.
  
### **Example**
```java
abstract class Animal {
    abstract void makeSound();
}

// Dog class does not implement makeSound(), so it must be abstract too
abstract class Dog extends Animal {
}
```


## **3. Abstract Class Without Abstract Methods (Allowed)**
- An abstract class **can exist without** abstract methods.
- It is used to **prevent object creation** and **provide common behavior to subclasses**.

### **Why Use an Abstract Class Without Abstract Methods?**
- ✅ **To prevent direct object creation**.
- ✅ **To provide common functionality** to subclasses (e.g., `showSalary()`).
- ✅ **To support polymorphism** (abstract class reference can be used for different subclasses).


## **4. `static` and Abstract Classes**
### **(a) `static` Abstract Methods (❌ Not Allowed)**
- ❌ **Abstract methods must be overridden** in subclasses.
- ❌ **Static methods belong to the class itself** and **cannot** be overridden.

### **(b) `static` Methods in Abstract Classes (✅ Allowed)**
- Static methods **do not** need an object and **can be called directly**.


### **(c) `static` Variables in Abstract Classes (✅ Allowed)**
- Shared among **all instances of subclasses**.


### **(d) `static` Blocks in Abstract Classes (✅ Allowed)**
- Runs **once** when the class is **first loaded**.


## **5. Summary Table**

| Feature                         | Allowed? | Why? |
|----------------------------------|---------|------|
| **Abstract method as `static`**  | ❌ No  | Abstract methods must be **overridden**, but static methods **cannot be overridden**. |
| **Static methods in an abstract class** | ✅ Yes | Can be used **without an instance** (e.g., utility methods). |
| **Static variables in an abstract class** | ✅ Yes | Shared among **all instances** of subclasses. |
| **Static blocks in an abstract class** | ✅ Yes | Executes **once** when the class is loaded. |


## **Final Takeaways**
✔ **Abstract classes** provide a common blueprint for related classes.  
✔ **Abstract methods must be implemented by subclasses**.  
✔ **Static methods & variables work normally** inside an abstract class.  
✔ **You cannot make an abstract method static**, as it contradicts its purpose.  
✔ **Abstract classes without abstract methods** can still be useful for **polymorphism and code reusability**.
---

# (4) **Accessing private variable in a different class**
two methods are available which can be used for this.
1. setVar() which assigns the value to the private variable.
2. getVar() which returns the value of the private variable.
Syntax: The first letter of the variable must be written in uppercase.
Example:
```java
import java.util.*;
class Student
{
  private int age;
  public void setAge(int x)
  {
    age=x;
  }
  public int getAge()
  {
   return age;
  }
}
class byeworld
{
  public static void main(String args[])
  {
    Student ob=new Student();
    int myage=18;
    ob.setAge(myage);
    System.out.print(ob.getAge());
  }
}
```
