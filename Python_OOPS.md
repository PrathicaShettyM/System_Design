# **Basic Python OOPS**
Object-Oriented Programming (OOP) is a programming paradigm that organizes code into objects, which represent real-world entities.

## **1. Classes**
- A class is a blueprint for creating objects, defining properties (attributes) and behaviors (methods). 
- Ex: class vehicle

## **2. Objects**
- An object is an instance of a class—think of it as a real-world entity based on the blueprint.
- Ex: objects - car, bike 

```python
class Vehicle:
    # attributes (all passed directly in constructor)
    def __init__(self, brand, model):
        self.brand = brand
        self.model = model
    
    # functions
    def display_details(self):
        print(f"Brand: {self.brand}, Model: {self.model}")

# Creating objects
car = Vehicle("Hyundai", "Creta")
bike = Vehicle("Royal Enfield", "Hunter 350")

car.display_details()   # Output: Brand: Hyundai, Model: Creta
bike.display_details()  # Output: Brand: Royal Enfield, Model: Hunter 350
```

## **3. Constructors**
- A constructor in Python is the `__init__` method. 
- It is automatically called when a new object is created, and is used to initialize the object’s state.

Types of Constructors
1. Default Constructors
2. Parameterised Constructors


**1. Default Constructor**: Takes only the self parameter and no additional args.

```python
class Employee:
    def __init__(self):
        print("Default constructor called")

emp1 = Employee()  # Output: Default constructor called
```

**2. Parameterized Constructor**: Accepts parameters to initialize attributes.
```python
class Employee:
    def __init__(self, name, salary):
        self.name = name
        self.salary = salary

    def show(self):
        print(f"Employee: {self.name}, Salary: {self.salary}")

emp2 = Employee("Smith", 60000)
emp2.show()    # Output: Employee: Smith, Salary: 60000
```

**Constructor Overloading (Not Directly Supported):**

- Python does not support multiple constructors directly. 
- You can work around this by using default parameters or variable arguments.

```python
class Employee:
    def __init__(self, name=None, salary=None):
        self.name = name if name else "Unknown"
        self.salary = salary if salary else 0

emp3 = Employee()
emp4 = Employee("Neha", 70000)
```

**Attributes and Methods**
- Attributes are variables bound to an object.
- Methods are functions defined within a class.

Example: Shapes
```python
class Shape:
    def __init__(self, color="Red"):
        self.color = color

    def display_color(self):
        print(f"Shape color is {self.color}")

shape1 = Shape()
shape2 = Shape("Blue")
shape1.display_color()  # Output: Shape color is Red
shape2.display_color()  # Output: Shape color is Blue
```

## **4 Pillars of OOPS**
1. [Inheritence](#1-inheritence)
2. [Polymorphism](#2-polymorphism)
3. [Abstraction](#3-abstraction)
4. [Encapsulation](#4-encapsulation)

## **1. Inheritence**
Inheritance is an OOP concept where a class (child/derived) inherits attributes and methods from another class (parent/base), promoting code reuse and extensibility. 

Python supports several types of inheritance: 
1. single inheritence
2. multiple inheritence 
3. multilevel inheritence
4. hierarchical inheritence

### **1.Single Inheritance**
One child class inherits from one parent class.
```python
class Vehicle:
    def show_type(self):
        print("This is a Vehicle.")

# single inheritence
class Car(Vehicle):
    def show_car(self):
        print("This is a Car.")

c = Car()
c.show_type()   # Output: This is a Vehicle.
c.show_car()    # Output: This is a Car.
```

### **3. Multiple Inheritance**
A child class inherits from more than one parent class.
```python
class Electric:
    def show_power(self):
        print("Powered by electricity.")

class Wheel:
    def show_wheels(self):
        print("Has wheels.")

# multiple inheritence
class ElectricCar(Electric, Wheel):
    def show_type(self):
        print("Electric Car.")

ec = ElectricCar()
ec.show_power()   # Output: Powered by electricity.
ec.show_wheels()  # Output: Has wheels.
ec.show_type()    # Output: Electric Car.
```

### **4. Multilevel Inheritance**
A chain where a class inherits from a derived class, which itself inherits from a parent class.
```python
# multi-level inheritence
class Shape:
    def show_shape(self):
        print("This is a Shape.")

class Polygon(Shape):
    def show_polygon(self):
        print("This is a Polygon.")

class Triangle(Polygon):
    def show_triangle(self):
        print("This is a Triangle.")

t = Triangle()
t.show_shape()      # Output: This is a Shape.
t.show_polygon()    # Output: This is a Polygon.
t.show_triangle()   # Output: This is a Triangle.
```

### **5. Hierarchical Inheritance**
Multiple child classes inherit from the same parent class.
```python
class Employee:
    def role(self):
        print("General Employee.")

# hierarchiacal inheritence
class Manager(Employee):
    def role(self):
        print("Manager.")

class Developer(Employee):
    def role(self):
        print("Developer.")

m = Manager()
d = Developer()
m.role()   # Output: Manager.
d.role()   # Output: Developer.
```

## **2. Polymorphism:**
Polymorphism allows different classes to be treated through a common interface, letting functions and operators process objects of various types in flexible ways. 

There are several types of polymorphism: 
1. method overloading (mimicking compile-time), 
2. method overriding (runtime)
3. operator overloading
4. duck typing

**1. Method Overloading (Compile-Time Polymorphism)**
Python does not support true method overloading, but similar behavior can be achieved using default or variable-length arguments.

```python
class Calculator:
    def multiply(self, a=1, b=1, *args):
        result = a * b
        for num in args:
            result *= num
        return result

calc = Calculator()
print(calc.multiply())           # Output: 1
print(calc.multiply(4))          # Output: 4
print(calc.multiply(2, 3))       # Output: 6
print(calc.multiply(2, 3, 4))    # Output: 24
```


**2. Method Overriding (Runtime Polymorphism)**

A derived class provides a specific implementation of a method already defined in its base class.

```python
class Animal:
    def sound(self):
        return "Some generic sound"

class Dog(Animal):
    def sound(self):
        return "Bark"

class Cat(Animal):
    def sound(self):
        return "Meow"

# Polymorphic behavior
animals = [Dog(), Cat(), Animal()]
for animal in animals:
    print(animal.sound())
# Output: Bark, Meow, Some generic sound
```

**3. Operator Overloading**

Operators can work with user-defined objects by defining special “magic” methods.

```python
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def __add__(self, other):
        return Point(self.x + other.x, self.y + other.y)
    def __str__(self):
        return f"({self.x}, {self.y})"

p1 = Point(1, 2)
p2 = Point(3, 4)
result = p1 + p2
print(result)          # Output: (4, 6)

```

**4. Duck Typing (Polymorphism by Interface)**

Python’s duck typing lets objects be treated according to whether they implement certain methods, not their specific class.


```python
class Car:
    def start(self):
        print("Car started")

class Boat:
    def start(self):
        print("Boat started")

def start_engine(vehicle):
    vehicle.start()

start_engine(Car())    # Output: Car started
start_engine(Boat())   # Output: Boat started

```

## 3. **Abstraction:**
Abstraction exposes only the essential features of an object, hiding complex implementation details. 

Types of Abstraction in Python:

**1. Data Abstraction:** Hides internal data details.

**2. Process Abstraction:** Hides process implementation (method logic).

**3. Abstract Classes and Methods:** Uses ABC (Abstract Base Classes) for enforcement.


### **Abstract Base Class (ABC) and Abstract Methods**
- Abstract classes cannot be instantiated directly and must inherit from the ABC class and use the `@abstractmethod` decorator. 
- Subclasses must implement abstract methods defined in parent classes.

Example: Abstract Class with Abstract Method
```python
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def area(self):
        pass    # No implementation here

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius
    def area(self):
        return 3.14 * self.radius * self.radius

class Rectangle(Shape):
    def __init__(self, length, width):
        self.length = length
        self.width = width
    def area(self):
        return self.length * self.width

c = Circle(5)
r = Rectangle(4, 6)
print(c.area())   # Output: 78.5
print(r.area())   # Output: 24
```
Explanation: Shape is abstract and provides a template for area() method.

Subclasses implement their own logic for area().

### **Concrete Methods in Abstract Class**
- Abstract classes can also have `concrete (fully defined) methods`.

```python
from abc import ABC, abstractmethod

class Employee(ABC):
    @abstractmethod
    def work(self):
        pass
    def company(self):
        return "ABC Corp"

class Developer(Employee):
    def work(self):
        return "Writes code"

dev = Developer()
print(dev.work())      # Output: Writes code
print(dev.company())   # Output: ABC Corp

```

Explanation: company() is a concrete method and does not need to be overridden by subclasses.

### Data vs Process Abstraction
**1. Data Abstraction Example**

```python
class Account:
    def __init__(self, balance):
        self.__balance = balance   # Hidden via name mangling
    def get_balance(self):
        return self.__balance

acc = Account(1000)
print(acc.get_balance())  # Output: 1000

```
`__balance` is private; accessible only through public methods.

**2. Process Abstraction Example**
```python
from abc import ABC, abstractmethod
class Greet(ABC):
    @abstractmethod
    def say_hello(self):
        pass

class English(Greet):
    def say_hello(self):
        return "Hello!"

```
Only necessary details (interface) exposed, not implementation.

## **4. Encapsulation:**
- Encapsulation is bundling data (attributes) and methods that operate on the data within a single class, restricting direct access to some of an object's components to protect integrity and hide complexity. 
- It enhances security by preventing unauthorized access and modification, allows controlled access via getter/setter methods, and makes code easier to maintain.

**Types of Encapsulation in Python**

**1. Public Members**: Accessible anywhere (default).

**2. Protected Members**: Accessible within the class and subclasses (conventionally prefixed with a single underscore _).

**3. Private Members**: Accessible only within the class (name-mangled by prefixing double underscores __).


### **1. Public Members**
Attributes and methods are accessible from anywhere.

```python
class Employee:
    def __init__(self, name, salary):
        self.name = name      # Public attribute
        self.salary = salary  # Public attribute

emp = Employee("John", 50000)
print(emp.name)    # Output: John
print(emp.salary)  # Output: 50000

```

### **2. Protected Members**
- By convention, members with a `single underscore` are treated as protected. 
- They can still be accessed in the same class or the subclasses which inherit it.

```python
class Employee:
    def __init__(self, name, salary):
        self._name = name        # Protected attribute
        self._salary = salary    # Protected attribute

emp = Employee("John", 50000)
print(emp._name)      # Output: John (accessible but discouraged)

```

### **3. Private Members**
- Private members use `double underscores`. 
- They are accessible only inside that class and to use it outside the class we need to make use of getter and setter functions.

ex 1: Employee class
```python
class Employee:
    def __init__(self, name, salary):
        self.__name = name        # Private attribute
        self.__salary = salary    # Private attribute

    def get_name(self):
        return self.__name

    def set_name(self, name):
        if name:
            self.__name = name

emp = Employee("John", 50000)
print(emp.get_name())  # Output: John
print(emp.__name)      # Error: AttributeError

emp.set_name("Jane")
print(emp.get_name())  # Output: Jane

```

ex 2: Banking application

```python
class BankAccount:
    def __init__(self, balance=0):
        self.__balance = balance  # Private attribute

    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount

    def withdraw(self, amount):
        if 0 < amount <= self.__balance:
            self.__balance -= amount
        else:
            print("Insufficient balance or invalid amount")

    def get_balance(self):
        return self.__balance

account = BankAccount(1000)
account.deposit(500)
account.withdraw(200)
print(account.get_balance())  # Output: 1300

```



```python

```




```python

```



```python

```




```python

```



```python

```




```python

```



```python

```




```python

```