# System Design
- System design is the `process of defining the architecture`, `components`, `modules`, `interfaces`, and `data` for a system to satisfy specified requirements. 
- It involves creating a` blueprint` for how a software system will be built, focusing on `scalability`, `performance`, `reliability`, and `maintainability`. 
- System design can be broadly categorized into:
    - High-Level Design (HLD) and
    - Low-Level Design (LLD).

# High Level Design HLD
- HLD provides a broad overview of the `system architecture`. It focuses on the system's major components, their interactions, and how they align with business requirements. 

Key Aspects of HLD:
- System architecture (e.g., microservices, monolithic, serverless).
- Major components (e.g., databases, servers, APIs, load balancers).
- Data flow and communication protocols between components.
- Scalability, fault tolerance, and deployment strategies.
- Technology stack selection (e.g., programming languages, frameworks).

- Example: For a ride-sharing app, HLD would outline the user app, driver app, backend services, database, and load balancer, along with how they interact (e.g., API calls, message queues).


# Low Level Design
LLD focuses on the `detailed design of individual components` identified in the HLD. It provides a granular view, specifying how each module or component will be implemented, including `algorithms`, `data structures`, and `code-level details`.

Key Aspects of LLD:
- Detailed class diagrams, including methods, attributes, and relationships.
- Algorithms and data structures for specific functionalities.
- Database schema design (e.g., tables, relationships, indexes).
- API endpoints with input/output specifications.
- Error handling and logging mechanisms.

- Example: For the ride-sharing app, LLD would define the database schema for user data, the algorithm for matching drivers to riders, and the implementation details of a specific API endpoint.

# SOLID PRINCIPLES
SOLID principles are five essential `guidelines` that enhance software design, making code more maintainable and scalable. They include:

1. Single Responsibility Principle 
2. Open/Closed Principle 
3. Liskov Substitution Principle 
4. Interface Segregation Principle 
5. Dependency Inversion Principle 

1. `Single Responsibility Principle‍ (SRP)`
This principle states that - A class should have only one reason to change which means every class should have a single responsibility or single job or single purpose. In other words, a class should have only one job or purpose within the software system.

🌟Why it matters:
- Code maintainability
- Easy debugging

- Situation: Baker managing the baking tasks and handling other tasks like serving customers, managing inventory and making breads etc - Violation of SRP

- `BAD CODE`: one class with multiple responsibilities
```java
class BreadBaker {
    public void bakeBread() { System.out.println("Baking high-quality bread..."); }

    public void manageInventory() { System.out.println("Managing inventory..."); }

    public void orderSupplies() { System.out.println("Ordering supplies..."); }

    public void serveCustomer() { System.out.println("Serving customers..."); }

    public void cleanBakery() { System.out.println("Cleaning the bakery..."); }

    public static void main(String[] args) {
        BreadBaker baker = new BreadBaker();
        baker.bakeBread();
        baker.manageInventory();
        baker.orderSupplies();
        baker.serveCustomer();
        baker.cleanBakery();
  }
}
```

- `GOOD CODE`: One class - one job or one responsibility
```
// Class for baking bread
class BreadBaker {
    public void bakeBread() { System.out.println("Baking high-quality bread..."); }
}

// Class for managing inventory
class InventoryManager {
    public void manageInventory() { System.out.println("Managing inventory..."); }
}

// Class for ordering supplies
class SupplyOrder {
    public void orderSupplies() { System.out.println("Ordering supplies..."); }
}

// Class for serving customers
class CustomerService {
    public void serveCustomer() { System.out.println("Serving customers..."); }
}

// Class for cleaning the bakery
class BakeryCleaner {
    public void cleanBakery() { System.out.println("Cleaning the bakery..."); }
}

class Bakery {
    public static void main(String[] args) {
        BreadBaker baker = new BreadBaker();
        InventoryManager inventoryManager = new InventoryManager();
        SupplyOrder supplyOrder = new SupplyOrder();
        CustomerService customerService = new CustomerService();
        BakeryCleaner cleaner = new BakeryCleaner();
        // Each class focuses on its specific responsibility
        baker.bakeBread();
        inventoryManager.manageInventory();
        supplyOrder.orderSupplies();
        customerService.serveCustomer();
        cleaner.cleanBakery();
  }
}
```

2. `Open/Closed Principle (OCP)`
This principle states that Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification which means you should be able to extend a class behavior, without modifying it.

🌟Why it matters:
- Prevents breaking existing code.
- Encourages reusable components.

Situation: Suppose we have a Shape class that calculates the area of different shapes. Initially, it supports only circles and rectangles. Adding a new shape, like a triangle, would require modifying the existing code.

- `BAD CODE`: this function is not closed for modifications - everytime we want to add features, the function is modified violating the OCP.
```java
class Shape {
 private String type;
 
 public double calculateArea() {
    if (type.equals("circle")) {
      // Circle area calculation
    } else if (type.equals("rectangle")) {
      // Rectangle area calculation
    }
    // Adding a triangle requires modifying this method
  }
}
```

`GOOD CODE`: use abstract class to make the "class Shape" closed to modifications and let the child classes give their own implemenation of the function in the abstract class
```java
abstract class Shape {
  abstract double calculateArea();
  // We can also use an interface instead of an abstract class
}

class Circle extends Shape {
    private double radius;
    
    @Override 
    public double calculateArea() {
    return Math.PI * radius * radius;
  }
}

class Rectangle extends Shape {
    private double width;
    private double height;
  
    @Override 
    public double calculateArea() {
        return width * height;
    }
}

// Adding a new shape without modifying existing code
class Triangle extends Shape {
    private double base;
    private double height;
    
    @Override 
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
```

3. `Liskov Substitution Principle (LSP)`
The principle was introduced by Barbara Liskov in 1987 and according to this principle - `Derived or child classes` `must be substitutable` for their `base or parent classes`. This principle ensures that any class that is the child of a parent class should be usable in place of its parent without any unexpected behavior.

🌟 Why it matters:
- Ensures `reliability` when `using polymorphism`.
- `Avoids unexpected behaviors in subclass implementations`.

Situation: Vehicle class having some methods whose implementation in the child class like bicycle is not able to provide - i.e. child not usable in place of parent

- `BAD CODE`
```java
// Problematic approach that violates LSP
class Vehicle {
    public void startEngine() {
        // Engine starting logic
    }
}

class Car extends Vehicle {
    @Override public void startEngine() {
        // Car-specific engine starting logic
    }
}

class Bicycle extends Vehicle {
    // Problem: Bicycles don't have engines!
    @Override public void startEngine() {
        throw new UnsupportedOperationException("Bicycles don't have engines");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating objects of different subclasses
        Vehicle car = new Car();
        Vehicle bicycle = new Bicycle();
        // Using polymorphism
        System.out.println("Car:");
        car.startEngine();  // Output: Car engine started.
        
        System.out.println("nBicycle:");
        try {
            bicycle.startEngine();  // Throws UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

- `GOOD CODE`: child usable in place of its parent
```java
abstract class Vehicle {
    // Common vehicle behaviors
    public void move() {
        // Movement logic
    }
}

abstract class EngineVehicle extends Vehicle {
    public void startEngine() {
        // Engine starting logic
    }
}

abstract class NonEngineVehicle extends Vehicle {
    // No engine-related methods
}

class Car extends EngineVehicle {
    @Override public void startEngine() {
        // Car-specific engine starting logic
    }
}

class Bicycle extends NonEngineVehicle {
    // Bicycle-specific methods
    // No need to implement engine-related methods
}

public class Main {
    public static void main(String[] args) {
        // Using EngineVehicle
        EngineVehicle car = new Car();
        car.startEngine();  // Output: Car-specific engine starting logic
        car.move();         // Output: Movement logic

        // Using NonEngineVehicle
        NonEngineVehicle bicycle = new Bicycle();
        bicycle.move();  // Output: Movement logic
  }
}
```