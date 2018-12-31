# Chapter 1

## Understanding the Java Class Structure (page 2)
### Fields and Methods 

- fields = variables
- methods = functions
- Both are _members_ of a class 

### Classes vs. Files
Multiple classes can be in the same file. However, only one class can be declared as `public`. The `public` class must match the file name. 

## Writing a _main()_ method (page 6)

The main method must match the following syntax: 
```java
public class MainMethod { 
    public static void main(String[] args) { 
        //code goes here
    }
}
```
> _**TRICK:** watch for questions that mix up the order of the `public static void` syntax._

There are three ways to define the array of arguments that are passed into. 
```java
// Option 1: 
main(String[] args) { }
// Option 2: 
main(String args[]) { }
// Option 3: 
main(String args...) { }
```
> _**TRICK:**  watch to make sure that the parameter for the `main()` method is defined correctly._

## Understanding Package Declarations
> _**TRICK:** watch for imports to make sure they are correct._

### Wildcards (page 9)
Wildcard imports will import all the classes in the package. 

```java
import java.util.*; // imports all classes in java.util
```
- Wildcard imports do not import child packages, fields, or methods.

### Redundant Imports
- java automatically imports the `java.lang` package
- Redundant imports are ok and will not cause an error 

You CANNOT do any of the following imports if we wanted to import `java.nio.file.Files`
```java
import java.nio.*; // can only import classes in the package. Cannot deep import java.nio.file.Files;
import java.nio.*.*; // can only have one wildcard and it MUST be at the end 
import java.nio.files.Paths.*; // cannot import methods/variables from a class
```

### Naming Conflicts
There are a few cases where naming conflicts arise for imports. Take this example for `Date` classes found in `java.util.Date` and `java.sql.Date`. 
```java
import java.util.*;
import java.sql.*;
// DOES NOT COMPILE 
// java throws: The type Date is ambiguous
```
We can either remove one of the imports (if it isn't needed). But if we need alot of imports from `java.sql`, then we can explicitly import one of those `Date` classes.
```java
import java.util.Date;
import java.sql.*;
// java will use the java.util.Date for Date types
```
However, if we need both Date types then we have to do something else: 
```java
import java.util.Date;
import java.sql.Date;
// DOES NOT COMPILE
// java throws a: The import java.sql.Date collides with another import statement
```
If we need both `Date` classes then we need to explicitly declare which type we want to define in our class. Here is a couple ways to accomplish this: 
```java
// Option 1
import java.util.Date;

public class ConflictClass { 
    Date date; // this will be the java.util.Date type
    java.sql.Date sqlDate; // this will be the java.sql.Date type
}

// Option 2
public class ConflictClass { 
    java.util.Date date;
    java.sql.Date sqlDate;
}
```

### Creating a New Package
This section just talks about compiling java classes via the command line. 

### Code Formatting on the Exam
It is important to watch the imports on every question on the exam. 
- If a question begins with a line number other than `1`, then you can assume the imports are correct. 
```java
3: public void method(ArrayList list) { 
4:     //some code 
5:     // Assume the ArrayList import is included and correct
6: }
```

- If a question starts with line `1` _OR_ no line at all, then you **HAVE** to check the imports. 
```java
1: public class Something { 
2:   public void method(ArrayList list) { 
3:     //some code 
4:     // this will NOT COMPILE because there is no import for ArrayList
5:   } }
```
> _**TIP:** the exam will let you know what package classes are in unless ther're covered in the objectives_

## Creating Objects

### Constructors
```java
// to initialize an object
Random r = new Random(); //Random() calls the Random class' constructor 
```
Two key points about a constructor: 

1. The name of the constructor must match the name of the class
2. There is no return type


> _**TRICK:** when there is a method name that has the same name as the class **but** has a **return type**, it is **not** a constructor. It is a regular method._





---
## End of Chapter Questions
### Practice Question - 1st attempt 78% 
- **6** - Importing needed packages. `java.lang.*` is always imported
- **16** - prefix `0x` is hexidecimal and can be assigned to many types of primative types including `int` and `double`
- **17** - `public static void main()` is a function and _NOT_ a reference to an object. 
- **22** - Java is _NOT_ a functional programming language. It does support functional programming but it is done in objects. Making Java Object Oriented by nature. 
- **23** - Java does _NOT_ take the `.class` name of a file as a parameter when running a java file. 