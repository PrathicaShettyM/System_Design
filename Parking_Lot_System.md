# **Low-Level Design of Parking Lot System** 
A parking lot management system is designed to handle the operations of parking vehicles, collecting payments, and managing available space efficiently. The system should be able to accommodate different types of vehicles, provide payment options, and ensure a smooth user experience.

#### **Rules of the System** (Understanding the functionalities) : 
**1. Setup**:
- The parking lot has `multiple slots` available for parking.
- `Different types of vehicles` (bike, car, truck) can occupy different slot sizes.
- Each vehicle is issued a `parking ticket` upon entry.
- The system calculates the `parking fee` based on the duration of stay and vehicle type.

**2. Exit and Payment**:
- A vehicle needs to `make a payment before exiting`.
- `Multiple payment methods` (Cash, Card, UPI) should be supported.
- Once `payment is successful`, the `vehicle is allowed to exit`, and the `parking slot is freed`.

**3. Illegal Actions**:
- A vehicle `cannot park` in an `already occupied slot`.
- Vehicles `cannot vacate without completing the payment process`.

# **Interview Setting**
Steps for approaching the problem statement
1. [Introduction to the Problem Statement](#step-1-introduction-and-vague-problem-statement)
2. [Clarify Requirements](#step-2-clarifying-requirements)
3. [Identify key components and Identities](#step-3-identifying-key-components)
4. [Design Challenges](#step-4-design-challenges)
5. [Design Approach](#step-5-approach-the-design-challenges)

## **Step 1: Introduction and Vague Problem Statement** 
`Interviewer`: 
**Let's start with a basic problem statement. Design a Parking Lot system**.

`Candidate`: Certainly! Here’s my understanding of the Parking Lot system:
- The system will manage different types of vehicles.
- Vehicles will enter and exit after making a payment.
- A parking slot is assigned upon entry and freed upon exit.
- Payment must be completed before leaving.
- The system should handle different vehicle sizes and slot allocations efficiently.
Is this the expected flow?
‍

`Interviewer`: Yes, you are aligned with the flow. Please continue ahead.

`Candidate`: Great! Before diving into the design, I’d like to clarify a few requirements:
- Will we have multiple types of parking slots based on vehicle size?
- Are we supporting multiple payment methods?
- Should the system track the duration of each parked vehicle?
- Can there be multiple floors parking lots ?


## **Step 2: Clarifying Requirements**: 
`Interviewer`: We want a system that:
- Supports different vehicle types (Bike, Car, Truck).
- Has different slot sizes based on vehicle type.
- Allows multiple payment methods.
- Ensures smooth entry and exit with parking fee calculation.

`Candidate`: To summarize, the key requirements are:
- A parking lot with multiple slot types.
- Support for bikes, cars, and trucks.
- Dynamic slot allocation based on vehicle size.
- Payment processing with multiple methods.
- Entry ticket issuance and exit validation.

`‍Interviewer`: Perfect, let’s proceed.

## **Step 3: Identifying Key Components**: 
`Candidate`: Now that we have the requirements, let’s identify the key components of our Parking Lot system:

1. `Vehicle`: Represents different types of vehicles.
- Class: Vehicle
- Description: This class represents vehicles entering the parking lot.
‍
```java
public abstract class Vehicle {
    protected String licensePlate; 
    protected VehicleType type; 
}
```

**✅ Reason for using an Abstract Class:**
- A Vehicle is a `common base class` for different types of vehicles like Car, Bike, Truck.
- It shares `common properties` like `licensePlate and type` that every vehicle will have.
- `We don’t want to create instances of a generic Vehicle itself` — only specific vehicle types.

Using an `abstract class` allows:
- `Code reuse for shared attributes and behavior`.
- Enforcing a `common structure` while `still allowing different types to implement their own logic` (if needed).
- Ability to define both `implemented methods` and `abstract methods` (if needed later).

**❌ Why not an interface?**
- `Interfaces can’t hold state` (prior to Java 8/9 enhancements), `but Vehicle has fields (licensePlate, type)`.
- **Vehicles** `share behavior and data, not just method signatures`.
- **Interfaces** are better when you `just want to define a contract, not shared logic or data`.


2. `Parking Lot`: Manages parking slots and vehicle allocations.
- Class: ParkingLot
- Description: This class manages the allocation and release of parking slots.
```java
public class ParkingLot {
    private List<ParkingSlot> slots; 
}
```

3. `Parking Slot`: Represents an individual parking space.
- Class: ParkingSlot
- Description: A slot has a type (Bike, Car, Truck) and an availability status.
```java
public class ParkingSlot {
    private VehicleType slotType;
    private boolean isOccupied; 
}
```

4. `Payment System`: Handles different payment methods like Credit Card, Cash, UPI etc
- Class: Payment
- Description: This class processes payments before exit.

```java
public interface PaymentStrategy { 
    boolean processPayment(double amount);
}
```
**✅ Reason for using an Interface:**
- PaymentStrategy represents a `family of algorithms` (e.g., CreditCardPayment, CashPayment, UPIPayment) that all `implement processPayment() differently`.
- This fits the `Strategy Design Pattern`, which favors interfaces to allow `runtime polymorphism`.
- We want flexibility to add new payment types without changing existing code — `open/closed principle`.

**❌ Why not an abstract class ?**
- `No shared fields` or `default implementations are needed`.
- Payment methods are `functionally different` — they don’t share state or logic.
- Java supports `multiple interfaces`, but `only single inheritance with abstract classes`.


## **Step 4: Design Challenges**: 
`Interviewer`: What design challenges do you anticipate?

`Candidate`: The key challenges for the Parking Lot system include:
1. `Efficient Slot Allocation`: Ensuring vehicles are assigned to the correct slot type.
2. `Tracking Vehicle Duration`: Keeping a record of entry times for payment calculations.
3. `Handling Payments`: Supporting multiple payment methods dynamically.
4. `Managing Concurrency`: Ensuring simultaneous vehicle entries and exits are handled properly.

## **Step 5: Approach the design challenges**:
`Interviewer`: How would you approach these challenges?

`Candidate`: I propose using design patterns effectively. Here are my strategies:

1. `Factory Pattern for Vehicle Creation`: 
- Allows easy extension for new vehicle types.
- Ensures consistent object creation.

2. `Strategy Pattern for Payments and Parking Fares`: 
- Enables flexible payment methods and Parking fares based on the vehicle type and duration for the parking.
- Easily extendable for future payment integrations and new fare strategy additions.

3. `Singleton Pattern for Parking Lot Management`: 
- Ensures only one instance of the parking lot exists.

4. `Observer Pattern for Exit Notifications`: 
- Notifies the system when a vehicle exits.
- Can be extended for alerts or logging.

`Interviewer`: That sounds like a solid approach. Let’s delve into the implementation details.

