# SOLID PRINCIPLES
SOLID principles are five essential `guidelines` that enhance software design, making code more maintainable and scalable. They include:

1. Single Responsibility Principle 
2. Open/Closed Principle 
3. Liskov Substitution Principle 
4. Interface Segregation Principle 
5. Dependency Inversion Principle 

# SOLID Principles in detail
## 1. Single Responsibility Principle‍ (SRP)
This principle states that - A class should have only one reason to change which means every class should have a single responsibility or single job or single purpose. In other words, a class should have only one job or purpose within the software system.

### Why it matters:
 - Code maintainability
 - Easy debugging

### Situation: 
Baker managing the baking tasks and handling other tasks like serving customers, managing inventory and making breads etc - Violation of SRP

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
```java
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

## 2. Open/Closed Principle (OCP)
This principle states that Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification which means you should be able to extend a class behavior, without modifying it.

### Why it matters:
- Prevents breaking existing code.
- Encourages reusable components.

### Situation: 
Suppose we have a Shape class that calculates the area of different shapes. Initially, it supports only circles and rectangles. Adding a new shape, like a triangle, would require modifying the existing code.

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

## 3. Liskov Substitution Principle (LSP)
The principle was introduced by Barbara Liskov in 1987 and according to this principle - `Derived or child classes` `must be substitutable` for their `base or parent classes`. This principle ensures that any class that is the child of a parent class should be usable in place of its parent without any unexpected behavior.

### Why it matters:
- Ensures `reliability` when `using polymorphism`.
- `Avoids unexpected behaviors in subclass implementations`.

### Situation: 
Vehicle class having some methods whose implementation in the child class like bicycle is not able to provide - i.e. child not usable in place of parent

- `BAD CODE`
```java
// Problematic approach that violates LSP
class Vehicle {
    public void startEngine() { /* code */ }
}

class Car extends Vehicle {
    @Override public void startEngine() {/*code*/}
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
    public void move() {
        // Movement logic
    }
}

abstract class EngineVehicle extends Vehicle {
    public void startEngine() {/* code */}
}

abstract class NonEngineVehicle extends Vehicle {
    // No engine-related methods
}

class Car extends EngineVehicle {
    @Override public void startEngine() {/*code*/ }
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

## 4. Interface Segregation Principle
- Applies to `Interfaces` instead of classes in SOLID and it is similar to the `Single Responsibility principle`. 
- It states that `do not force any client` to `implement an interface` which is `irrelevant to them`. 
- You should prefer `many client interfaces` rather than one general interface and each interface should have a `specific responsibility`.

### Why it matters:
- Reduces unnecessary dependencies.
- Simplifies implementation for specific use cases.

### Situation
All in one machine: printing, scanning, and faxing. This design presents a violation of the Interface Segregation Principle when implementing a basic printer device.

- `BAD CODE`: fat interfaces
```java
interface Machine {
    void print();
    void scan();
    void fax();
}

// the interface works for this AllInOnePrinter
class AllInOnePrinter implements Machine {
    @Override public void print(){/* code */}
    @Override public void scan(){/* code */}
    @Override public void fax(){/* code */}
}

// here problem occurs
class BasicPrinter implements Machine {
    @Override public void print() {/* code */}

    // Problem: Basic printer can't scan!
    @Override public void scan() {
        throw new UnsupportedOperationException("Cannot scan");
    }
    // Problem: Basic printer can't fax!
    @Override public void fax() {
        throw new UnsupportedOperationException("Cannot fax");
    }
}
```

- `GOOD CODE`: specific interfaces
```java
// separate out the interfaces based on their responsibilites
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface FaxMachine {
    void fax();
}

class BasicPrinter implements Printer {
    @Override
    public void print() { /* code */ }
}

class AllInOnePrinter implements Printer, Scanner, FaxMachine {
    @Override
    public void print() {/* code */}

    @Override
    public void scan() {/* code */}

    @Override
    public void fax() {/* code */}
}
```

## 5. Dependency Inversion Principle
The Dependency Inversion Principle (DIP) is a principle in object-oriented design that states that High-level modules should not depend on low-level modules. Both should depend on abstractions. Additionally, abstractions should not depend on details. Details should depend on abstractions.
In simpler terms, the DIP suggests that classes should rely on abstractions (e.g., interfaces or abstract classes) rather than concrete implementations. This allows for more flexible and decoupled code, making it easier to change implementations without affecting other parts of the codebase.

🌟Why it matters:
• Promotes decoupled architecture.

• Facilitates testing and maintainability.

‍

💭Example : 
Consider an enterprise e-commerce system where order processing requires various types of notifications to be sent to customers, administrators, and inventory systems

- `BAD CODE`: Direct dependency on the concrete classes
```java
class EmailNotifier {
    public void sendEmail(String message) { /* code */ }
}

class OrderService {
    private EmailNotifier emailNotifier;
    private DatabaseLogger logger;
    private InventorySystem inventory;

    public OrderService() {
        // Direct dependencies on concrete implementations:  Problematic code
        this.emailNotifier = new EmailNotifier();
        this.logger = new DatabaseLogger();
        this.inventory = new InventorySystem();
    }
  
    public void placeOrder(Order order) {
        inventory.updateStock(order);
        emailNotifier.sendEmail("Order #" + order.getId() + " placed successfully");
        logger.logTransaction("Order placed: " + order.getId());
    }
}
```

- `GOOD CODE`: 
```java
// separate the logic as 3 interfaces
interface NotificationService {
  void sendNotification(String message);
}

interface LoggingService {
  void logMessage(String message);
  void logError(String error);
}

interface InventoryService {
  void updateStock(Order order);
  boolean checkAvailability(Product product);
}

class EmailNotifier implements NotificationService {
  @Override
  public void sendNotification(String message) {}
}
// similary do sms, whtsapp notifier using the same boiler plate


class DatabaseLogger implements LoggingService {
  @Override
  public void logMessage(String message) { /* code */ }
  
  @Override
  public void logError(String error) { /* code */ }
}

class OrderService {
    private final NotificationService notificationService;
    private final LoggingService loggingService;
    private final InventoryService inventoryService;
  
  // Constructor injection of dependencies
    public OrderService(NotificationService notificationService, LoggingService loggingService, InventoryService inventoryService) {
        this.notificationService = notificationService;
        this.loggingService = loggingService;
        this.inventoryService = inventoryService;
    }

    public void placeOrder(Order order) {
        try {
            // Check inventory
            if (inventoryService.checkAvailability(order.getProduct())) { 
                inventoryService.updateStock(order); // Process order
                notificationService.sendNotification("Order #" + order.getId() + " placed successfully"); // Send notification
                loggingService.logMessage("Order processed successfully: " + order.getId()); // Log success
            }
        } catch (Exception e) {
            loggingService.logError("Error processing order: " + order.getId() + " - " + e.getMessage());
            throw e;
        }
    }
}

// Usage with dependency injection
NotificationService emailNotifier = new EmailNotifier();
LoggingService logger = new DatabaseLogger();
InventoryService inventory = new WarehouseInventoryService();
OrderService orderService = new OrderService(emailNotifier, logger, inventory);
```