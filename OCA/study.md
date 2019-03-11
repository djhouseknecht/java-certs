# Assessment Test

### Question: 
4. switch statement
	> the `default` clause can be anywhere in the list of options. The last option does not need a `break;` because the code stops there. 
8. hidding a private method
	> parent class has a private method `methodA` that returns `true`. A subclass extends the parent and implements a public method `methodA` that returns `false`. _If_ `methodA()` is called from within the parent class, it returns `true`. If it is called in the subclass (or any other class), it returns `false`. This is called `hidding`a method because it isn't overriding it. 
	- > If a method is not `overridden`, then it is only `hidden` which means it can still be called. It can only be hidden if it is `private` or possibly `default package private` and the extending class is not in the same package. `protected` and `public` can be overridden. 