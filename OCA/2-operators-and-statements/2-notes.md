# Chapter 2

## Operatores and Statements (page 52)

---

### Understanding Java Operators

>_**KNOW:** You need to know the following table_


| Operator | Symbol and examples |
| - | - | 
| Post-unary operators | `expression++, expression--` |
| Pre-unary operators | `++expression, --expression` |
| Other unary operators | `+, -, !` |
| Multiplication/Division/Modulus | `*, /, %` |
| Addition/Subtraction | `+, -` |
| Shift operators | `<<, >>, >>>` |
| Ralational operators | `<, >, <=, >=, instanceof` |
| Equal to/not equal to | `==, !=` |
| Logical operators | `&, ^, |` |
| Short-circuit logical operators | `&&, ||` |
| Ternary operators | `boolean expression ? expression1 : expresion2` |
| Assignment operators | `=, +=, -=, *=, /=, %=, ^=, !=, <<=, >>=, >>>=` |


>_**KNOW:** Make sure you know the order of operations_

>_**TIP:** Division truncates (ie. `10 / 3 = 3`)_

#### Numeric Promotion (page 55)

>_**KNOW:** These numeric promo rules. Also, you should know which types are bigger than others._

*Numeric Promotion Rules* 
1. If two values have different data types, Java will automatically promote one of the values to the larger of the two data types. 
2. If one of the values is integral and the other is floating-point, Java will automatically promote the integral value to the floating-point value's data type. 
3. Smaller data types, namely `byte, short, and char`, are first promoted to `int` any time they're used with a Java binary arithmetic operator, even if neither of the operands is `int`. (Except for unary operators `--, ++`). 
4. After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands. 

The last two are tricky. 

### Working with Unary Operators (page 57)

By defintion, an unary operator is one that requires exactly one operand, or variable, to function. 

| Unary operator | Description | 
| - | - | 
| `+` | Indicates a number is positive (this is assumed in Java unless declared negative) | 
| `-` | Indicates a literal number is negative or negates an expression | 
| `++` | Increments a value by 1 |
| `--` | Decrements a value by 1 |
| `!` | Inverts a Boolean's logical value |


#### Logical Complement and Negation Operators
The _logical  complement operator_ (`!`) flips the value of a `boolean` expression. 

The _negation operator_ (`-`) reverses the sign of a numeric expression. 

>_**TRICK:** Watch out for logical operators being used on numeric values and negation operators being used on boolean expressions_

```java
// these don't compile
int x = !5; 
boolean y = -true;
boolean z = !0;
```

#### Increment and Decrement Operators

**Pre-increment and Pre-decrement** are calculated before a value is returned. **Post-increment and Post-decrement** are calculated after a value is returned. 

>_**TRICK:** The exam will throw complicated examples at you. Like this one:_

```java
int x = 3; 
int y = ++x * 5 / x-- + --x;
System.out.println("x is " + x); // x = 2
System.out.println("y is " + y); // y = 7
```
Explanation: 
```java
// step one, increment x before returning the 1st time
int y = 4 + 5 / x-- + --x; // x = 4
// step one, decrement x after returning the 2nd time
int y = 4 + 5 / 4 + --x; // x = 3
// step one, increment x before returning the 3rd time
int y = 4 + 5 / 4 + 2; // x = 2
```

### Using Additional Binary Operators (page 60)

#### Assignemtn Operators
An **assignment operator** is a binary operator that modifies, or assigns, the variable on the left-hand side of the operator, with the result of the value on the right=hand side of the equation. 

```java
int x = 1; // simple example
```
Java will automatically promote frm smaller to larger data types. But it will throw a compiler exception if it detects we are tring to convert from larger to smaller data types. 
```java
int x = 1.0; // DOES NOT COMPILE
short y = 1921222; // DOES NOT COMPILE
int z = 9f; // DOES NOT COMPILE
long t = 12312141021940; // DOES NOT COMPILE (postfix with 'L' because Java thinks this is an int)
```

#### Casting Primitive Values 

Casting primitives is required any time you are going from a larger numerical data type to a smaller numerical data type, or converting from a floating-point number to an integral value. 












































