# Java Certification Study Guide and Notes
## OCA (Programmer I - 1Z0-808) 
The `OCA/` directory will contain all notes for the 1st Java certifcation. 

## OCP (Programmer II - 1Z0-809)
After the first test, a folder will be created for this test. 

## System Requirements
This exam is for the latest release version of `Java 8`. Please be sure all code is written, compiled, and run in `Java 8`. You will need to install the `jdk_1_8` to develop java files. The jdk will include the `jre` which you need to run java files. Make sure that the commands `javac` and `java` are part of your system's environment variables. 

Run this command in a terminal to see what version of java you are using. 
```
java -version
```
The output should look something like this: 
```
java version "1.8.0_172"
Java(TM) SE Runtime Environment (build 1.8.0_172-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.172-b11, mixed mode)
```
_Make sure the `java version` is "1.8.^"_

## Writing and Testing code
An IDE should not be used during exam preparation. Most questions are trick questions and will most likely contain an option for `code does not compile`. By using a plain text editor (like wordpad or gedit), it will force you to know whether or not the code will compile. 

#### How to run Java code (latest version of Java 8)
All the following commands are for linux. Make the desired amount of Java files
```
# single file
/directory/Class1.java

# single file inside a package
/directory/package/Class2.java

# or multiple files with packages
/directory/packagea/ClassA.java
/directory/packageb/ClassB.java
```
Once you have created the files and placed the desired code inside the individual java files, you need to compile it. 
```
# first, cd into the working directory
cd /directory

# for single file
javac Class1.java

# for single file inside a package
javac package/Class2.java

# for multiple files with packages
javac packagea/ClassA.java packageb/ClassB.java
```
Once you have compiled your code, java should have created `.class` files for each `.java` file you created. This is the file that java will actually run. Note, you do not need to include the `.class` extension when running the file. Java is already looking for `.class` files. 
```
# make sure you are still in the working directory. If not, cd into it
cd /directory

# for single class file
java Class1

# for single file inside a package
java package.Class2

# for multiple files with packages
# you will want to run the file that has the "public static void main" method. 
# for our example, let's say that ClassA has the main method and uses ClassB 
# so, we will only need to run ClassA
java packagea.ClassA
```