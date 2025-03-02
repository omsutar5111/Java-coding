# Java Exceptions and Errors

## Exception and Error Hierarchy
In Java, both **Exceptions** and **Errors** are subclasses of the `Throwable` class, which is a direct subclass of `Object`. Below is the hierarchy:

```
            Object
              |
          Throwable
         /         \
  Exception        Error
  /        \        /    \
Checked  Unchecked  VirtualMachineError  OutOfMemoryError
Exception Exception AssertionError  StackOverflowError
```

### **1. Checked and Unchecked Exceptions**

#### **Checked Exceptions**
Checked exceptions are exceptions that are checked at compile-time. If a method throws a checked exception, it must handle it using a `try-catch` block or declare it using `throws`.

Examples:
- `IOException`
- `SQLException`
- `FileNotFoundException`
- `InterruptedException`

#### **Unchecked Exceptions**
Unchecked exceptions (Runtime Exceptions) occur at runtime and are not checked at compile-time. These exceptions usually result from programming errors like dividing by zero or accessing an invalid index in an array.

Examples:
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ArithmeticException`
- `IllegalArgumentException`

### **2. Types of Errors in Java**
Errors represent serious issues that a program cannot typically handle. These are not checked by the compiler and usually indicate problems with the system or environment.

#### **Types of Errors**
1. **VirtualMachineError**
    - `OutOfMemoryError`
    - `StackOverflowError`
    - `InternalError`

2. **AssertionError** (Occurs when an assertion fails)

3. **LinkageError** (Occurs when there is a problem with loading classes)

### **3. Types of Checked and Unchecked Exceptions**
#### **Types of Checked Exceptions**
- `ClassNotFoundException`
- `NoSuchMethodException`
- `InstantiationException`
- `InterruptedException`
- `IOException`

#### **Types of Unchecked Exceptions**
- `ArithmeticException`
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `IllegalArgumentException`

### **4. Built-in Exceptions in Java**
Java provides several built-in exceptions categorized as follows:

#### **1. Java.Lang Package Exceptions**
- `ArithmeticException` (e.g., Division by zero)
- `NullPointerException` (e.g., Accessing an object with a `null` reference)
- `ArrayIndexOutOfBoundsException` (e.g., Accessing an array with an invalid index)
- `ClassCastException` (e.g., Invalid casting of objects)

#### **2. Java.IO Package Exceptions**
- `FileNotFoundException`
- `EOFException`
- `IOException`

#### **3. Java.SQL Package Exceptions**
- `SQLException`
- `SQLTimeoutException`

### **5. User-Defined Exceptions**
User-defined exceptions are custom exceptions created by extending the `Exception` or `RuntimeException` class.

#### **Example of a Custom Checked Exception**
```java
class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

public class Main {
    public static void validateAge(int age) throws CustomCheckedException {
        if (age < 18) {
            throw new CustomCheckedException("Age must be 18 or above.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16);
        } catch (CustomCheckedException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
```

#### **Example of a Custom Unchecked Exception**
```java
class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        throw new CustomUncheckedException("This is a custom unchecked exception.");
    }
}
```

### **Conclusion**
- **Errors** are serious and usually cannot be handled.
- **Exceptions** are categorized as Checked (compile-time) and Unchecked (runtime).
- Java provides built-in exceptions, and we can create our own custom exceptions.
- Proper exception handling improves program robustness and prevents crashes.

