# Pointer like Behavior in Java:
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

---

## **Explanation:**

Arrays, like other objects in Java, are stored as references. When the `Check()` method is called, it **returns a reference** to the array, not its actual contents.

---

## **Pointers vs. References in Java**

Unlike C or C++, **Java does not have pointers**. Instead, Java uses **references**, which behave like pointers but with safety restrictions.

- In C++, you can manipulate memory directly with pointers.
- In Java, you cannot access memory directly, but references **point to objects stored in memory**.

# **Understanding `toString()` in Java**

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

---

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

---

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

---

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

---

## **5. Summary**
| Scenario | `toString()` Output |
|----------|----------------------|
| **Default `Object` behavior** | `ClassName@hashcode` |
| **Overridden in custom class** | Returns a meaningful string (e.g., `"Person{name='Alice', age=25}"`) |
| **Called on arrays** | `"[I@hashcode"` (use `Arrays.toString()`) |
| **Called on `ArrayList`, `HashMap`, etc.** | Prints contents directly (e.g., `[1, 2, 3, 4]`) |

---

## **Final Thoughts**
- `toString()` **helps represent an object as a string**.
- **Override it** in custom classes for better readability.
- **Use `Arrays.toString()`** to print arrays properly.
- **Collections already override `toString()`**, so they print correctly.

