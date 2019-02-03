# Chapter 1

## Understanding the Java Class Structure (page 2)

---

### Fields and Methods 

- fields = variables
- methods = functions
- Both are _members_ of a class 

### Classes vs. Files
Multiple classes can be in the same file. However, only one class can be declared as `public`. The `public` class must match the file name. 

---

## Writing a _main()_ method (page 6)

---

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

---

## Understanding Package Declarations

---

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

---

## Creating Objects

---

### Constructors
```java
// to initialize an object
Random r = new Random(); //Random() calls the Random class' constructor 
```
Two key points about a constructor: 

1. The name of the constructor must match the name of the class
2. There is no return type


> _**TRICK:** when there is a method name that has the same name as the class **but** has a **return type**, it is **not** a constructor. It is a regular method._

Constructors are meant to initialize fields in the class. You can also initialize fields directly on the line they are declared: 
```java
public class Turkey { 
    int eggs = 0; // initialize on line
    String name;
    public Turkey() { 
        name = "Henry"; // initialize in constructor
    } }
```
If no constructor is declared, java will supply a "do nothing" constructor. 

### Reading and Writing Object Fields
Reading a variable is known as _getting_, and writing a variable is known as _setting_. 
```java
public class Swan { 
	int numberEggs; // instance variable
	public static void main(String[] args) { 
		Swan swan = new Swan();
		swan.numberEggs = 1; // setting
		System.out.println(swan.numberEggs); // getting
	}
}
// Another way to get and set inline
public class Name {
    String first = "David";
    String last = "House";
    String full = first + " " + last; // get and set at the same time
}
```

### Instance Initializer Blocks

Anything inside braces (`{}`) is a _code block_. Most of the time you will find code inside methods which are contained in _code blocks_. _Instance initializers_ are code blocks that are not in a method call. 
```java
public class InstanceInitializer { 
	public static void main(String[] args) { 
		// regular code block
	}

	{
		// instance initializer
		System.out.println("Code block that is an instance initializer");
	}
}
```

### Order of Initialization
1. Fields and instance initializer blocks are run in the order in which they appear in the file. 
2. The constructor runs after all fields and instance initializer blocks have run. 

```java
// example
public class Chick { 
	private String name = "Fluffy";
	
	{ System.out.println("setting field"); }
	
	public Chick() { 
		name = "Tiny";
		System.out.println("setting constructor");
	}
	
	public static void main(String[] args) { 
		Chick chick = new Chick();
		System.out.println(chick.name);
	}
}
/* Running this class results in this output
 setting field
 setting constructor
 Tiny
 */
```
It won't run non-static instance initializers until the class is constructed. Order matters. You cannot refer to a variable before it has been initialized. 
```java
{ System.out.println(name); } // DOES NOT COMPILE
private String name = "Fluffy"; 
```

---

## Distinguishing Between Object References and Primitives

---

Java contains two types of data: _primative_ and _reference_ types. 

### Primitive Types
Java has 8 _primative_ types. **YOU MUST KNOW THESE FOR THE EXAM**. 

| Keyword | Type | Example |
| - | - | - |
| `boolean` | true or false | true |
| `byte` | 8-bit integral value | `123` |
| `short` | 16-bit integral value | `123` |
| `int` | 32-bit integral value | `123` |
| `long` | 64-bit integral value | `123` |
| `float` | 32-bit floating-point value | `123.45f` |
| `double` | 64-	bit floating-point value | `123.456` |
| `char` | 16-bit Unicode value | `'a'`

- `float` and `double` are used for floatin-point (decimal) values
- a `float` requires the letter `f` following the number so Java knows it is a float
- `byte, short, int, and long` are used for numbers without decimal points
- Each numeric type uses twice as many bits as the smaller similar type. (ie. `short` is twice the bits as a `byte`)

> _**KNOW**: you should know that a `byte` can hold a value from -128 to 127_ 

A `byte` is 8 `bits`. A bit has two possible values (0 or 1). So, you do 2<sup>8</sup> = 256. Java splits that in half to account for negative numbers and takes the 0 from the positive side. Leaving -128 to 127. Java uses these `byte` sizes when allocating space for variables. 

> Pro tip: To find the max number a integral value can hold, just raise it to the power of `bytes`, divide by 2, and subtract 1 to account for 0. So an int (32-bytes) is: 2<sup>32</sup> = 4,294,967,296 / 2 = 2,147,483,648 - 1 = 2,147,483,647. 

When a number is present in code, it is called a _literal_. 
```java
 long max = 1234567; // DOES NOT COMPILE

 // TO DEFINE A long, you must use an 'L' (preferrably a capital)
 long max = 1234567L; // COMPILES
```

Java allows you to specify digits in several formats: 
>_**TIP**: You need to memorize these_
- base 10 (digits 0-9) is the method we are use to using (and used above)
- octal (digits 0-7), which uses the number 0 as a prefix - for example, `017`
- hexadecimal (digits 0-9 and letters A-F), which uses the number 0 followed by `x` or `X` as a prefix - for example, `0xFF`
- binary (digits 0 & 1), which uses the number 0 followed by a `b` or `B` as a prefix - for example, `0b10`

Something added in Java 7 is the ability to use _underscores_ in literals. 
```java
double legal = 1_00_0.0_0;   // this is legal
double notAtStart = _100.00; // DOES NOT COMPILE
double notAtEnd = 1000.00_;  // DOES NOT COMPILE
double notByDecimal 100_.00; // DOES NOT COMPILE
```

### Reference Types

>_**KNOW**: a reference type refers to an object. Reference typs do not hold their value in memory but they "point" to the object in memory._

A value is assigned to a referene in one of two ways: 
1. A reference can be assigned to another object of the same type.
2. A reference can be assigned to a new object using the `new` keyword. 

```java
// example
today = new java.util.Date();
greeting = "How are you doing?";
```

Objects in memory can only be referenced via a reference to the object. 

### Key Differences (between Primitive and Reference types)
1. Reference types can be assigned `null`, which means they do not currently refer to an object. Primitive types will give you a compiler error if you attempt to assign them `null`. 
```java
int value = null; // DOES NOT COMPILE
String s = null;  // this is valid 
```
2. Reference types can be used to call methods when they do not point to `null`. Primitives do not have methods declared on them. 
```java
String ref = "hello";
int len = ref.length();
int bad = len.length(); // DOOES NOT COMPILE
```
3. All primitive types have lowercase type names. 

---

## Declaring and Initializing Variables 

A _variable_ is a name for a piece of memory that stores data. 

---

## Declaring Multiple Variables

```java
// both are valid
String s1, s2;
String s3 = "yes", s4 = "yes";
```

>_**TRICK**: sometimes the exam will attempt to confuse with the question. PAY ATTENTION! Take the following example:_

```java
// how many variables do you think are declared and initialized in this code
int i1, i2, i3 = 0;
// only 1 (i3). i1 and i2 are declared but not intialized
```

>_**TRICK**: another trick on the exam is putting different types in the same muliple variable declaration line. Take the following example:_
```java
int num, String str; // DOES NOT COMPILE
```
>_**TRICK**: watch for other invalid multi-variable declarations. For example:_
```java
// valid
boolean b1, b2;
String s1 = "str", s2;
int i1; int i2;

// invalid
double d1, double d2; // DOES NOT COMPILE
int i3; i4; // DOES NOT COMPILE
```
>_**TIP**: When you see an oddly placed semicolon on the exam, pretend the code is on separate lines and think about whether the code compiles that way._

### Identifiers

_Identifier_ names have a few naming rules: 
1. The name must begin with a letter or the symbol `$` or `_`.
2. Subsequent characters may also be numbers. 
3. You cannot use the same name as a Java _reserved word_. As you might imagine, a reserved word is a keyword that Java has reserved so that you not allowed to use it. Remember that Java is case sensitive, so you can use versions of the keywords that only differ in case (this is a bad idea, though).

>_**TIP**: Memorize these rules and watch for invalid identifier names. When you see an identifier with an abnormal symbol or name, make sure to check the rules._
```
// valid identifiers
okidentifiter
$OK2Identifier
_alsoOK1d3ntifi3r
__SStillOkButKnotsonice$

// not valid identifiers
3DPointClass // starts with number
hollywood@vine // @ is not a letter, digit, $, or _
*$coffee // * is not a letter, digit, $, o r_
public // reserved keyword
```

---

## Understanding Default Initialization of Variables

There are three types of variables (or scope of those variables): _local, instance_, and _class._

### Local Variables
A _local variable_ is a variable defined within a method. Local variables must be initialized before use. The compiler will not let you read an uninitialized value. 
```java
public int notValid() { 
  int y = 10;
  int x;
  return x + y; // DOES NOT COMPILE
}
```
```java
// this version will compile
// the compiler can figure out that you initialize 'x' before you use it
public int notValid() { 
  int y = 10;
  int x;
  x = 3;
  return x + y; 
}
```
Note this is a method. If these were instance variables, they would automatically be initialized (explained in the next section).

The compiler will also check each branch of code inside the method. Each branch must intialize the variables if it is going to compile. 
```java
public void findAnswer(boolean check) { 
  int answer; 
  int onlyOneBranch;
  if (check) { 
	onlyOneBranch = 1;
	answer = 1;
  } else {
	answer = 2;
  }
  System.out.println(answer);
  System.out.println(onlyOneBranch); // DOES NOT COMPILE
  // there is a code path that will not intialize 'onlyOneBranch'
}
```

### Instance and Class Variables

Variables that are not local vairables are instance variables or class variables. Instance variables are also call fields. Class variables are shared across multiple objects. 

- A variable is a class variable if it has the keyword `static` before it. 

Instance and class variables do not require you to initialize them before use. As soon as they are declared, they are given a default value. 

>_**KNOW**: you need to memorize these. Remember the compiler will use the simplest type it can give the value: `null` for an object and `0/false` for primitives._

| Variable type | Default initialization value | 
| - | - | 
| `boolean` | `false` | 
| `byte, short, int, long` | `0` | 
| `float, double` | `0.0` | 
| `char` | `'\u000'` (NUL) | 
| All object references (everything else) | `null` | 

---
## Understanding Variable Scope (page 31)

How many local variables are in the following example: 
```java
public void eat(int piecesOfCheese) { 
  int bitesOfCheese = 1;
}
// there are two
// piecesOfCheese (parameter declaration)
// bitesOfCheese (body declaration)
```

You cannot use local variables outside of the code block where they are defined. Local variables can never have a scope larger than the method they are defined in. However, they can have a smaller scope. See example: 
```java
public void eatIfHungry(boolean hungry) { 
  if (hungry) { 
	int bitesOfCheese = 1; 
  } // bitesOfCheese goes out of scope here
  System.out.println(bitesOfCheese); // DOES NOT COMPILE
}
```
Variables defined in "smaller" blocks can access variables in higher scopes. 
```java
public void eatIfHungry(boolean hungry) { 
  if (hungry) { 
	int bitesOfCheese = 1;
	{
	  boolean teenyBit = true;
	  System.out.println(bitesOfCheese); // this is fine
	}
  }
  System.out.println(teenyBit); // DOES NOT COMPILE
}
```

>_**TIP**: practice and know scope **extremely** well._

>_**KNOW**: memorize these scope rules_
- Local variables: in scope from declaration to end of block
- Instance variables: in scope from declaration until object garbage collected
- Class variables: in scope from delcaration until program ends (because these are static)

---
## Ordering Elements in a Class (p. 34)

>_**KNOW:** memorize this table_

| Element | Example | Required? | Where does it go? | 
| - | - | - | - | 
| Package declaration | `package abc;` | No | First line in the file | 
| Import statements | `import java.util.*;` | No | Immediately after the package | 
| Class declaration | `public class C` | Yes | Immediately after the import | 
| Field declaration | `int value;` | No | Anywhere inside a class | 
| method declaration | `void method()` | No | Anywhere inside a class | 



```java
// good order
package abc; // package must be first if it exists
import java.util.*; // imports must be after package
public class CS { // class comes after package and imports. This is required
	double weight; // field can go anywhere
	public double getWeight() { // method can go anywhere
		return weight;
	}
	double height; // field can go anywhere
}
```

>_**TRICK:** watch out for mixed up ordering on the exam_

```java
import java.util.*; 
package abc; // DOES NOT COMPILE
String name; // DOES NOT COMPILE
public class ABC { }
```

>_**TIP:** remember PIC (picture): `package, import, and class`_

Multiple classes can be in the same file. However: 
- Only one class can be marked as public
- There must be one public class
- The public class' name must match the name of the file

---
## Destroying Objects (p. 36)

All objects are stored in your program memory's _heap._ 

### Garbage Collection 

>_**KNOW:** You need to know that `System.gc()` is not guaranteed to run, and you should be able to recognize when objects become eligible for garbage collection._

`System.gc()` only _suggests_ to java to run garbage collection. Java is free to ignore the request. An object will remain on the heap until it is no longer reachable. An object is no longer reachable when one of two situations occur: 
1. The object no longer has any references pointing to it. 
2. All references to the object have gone out of scope. 

Remember that objects sit on the heap and can only be accessed through reference. A reference may or may not be created on the heap. All references are the same size, no matter what their data type is, and are accessed by their variable name. Objects are always on the heap. They have no name and can only be accessed via a reference. Objects vary in size depending on their class defintion. 

>_**TIP:** When you get asked a question about garbage collection on the exam, trying drawing what is going on._

### _finalize()_

`finalize()` is a method that java calls before collecting the object. If the garbage collector doesn't run, the method doesn't get called. If the garbage collector fails to collect the object and tries to run it again later, the method doesn't get called a second time.

>_**KNOW:** Just remember that `finalize()` might not get called and **definitely** won't be called twice._

```java
public class Finalizer { 
	protected void finalize() { 
		System.out.println("Calling finalize");
	}
	public static void main(String[] args) { 
		Finalizer f = new Finalizer();
	}
	// this program ends before the garbage collector needs to run. 
}
```

>_**KNOW:** you need to know that the above `finalize()` call could run zero or one time._

Java also knows when a finalize object makes the object ineligible for garbage collection. For example: 
```java
public class Finalizer { 
	private static List objects = new ArrayList();
	protected void finalize() { 
		objects.add(this); // really bad idea
	}
}
```

## Benefits of Java (p. 39)

>_**KNOW:** You need to know these for the exam_
> - **Object Oriented**: Java is an object-oriented language, which means all code is defined in classes and most of those classes can be instantiated into objects. Java allows for functional programming within a class, but object oriented is still the main organization of code. 
> - **Encapsulation**: Java supports access modifiers to protect data from unintended access and modification.
> - **Platform Independent**: Java is an interpreted language because it gets compiled to bytecode. Java is a "write once, run anywhere" language because it only gets compiled once. If asked on the exam remember, the same class files run everywhere. (It is slightly different on the OCP exam).
> - **Robust**: One of the majoy advantages of java over C++ is that it prevents memory leaks because java manages its own memory. 
> - **Simple**: Java was intended to be simpler than C++. 
> - **Secure**: Because Java runs inside the JVM, it creates a sandbox that makes it hard for java code to do evil things to the machine it is running on.










