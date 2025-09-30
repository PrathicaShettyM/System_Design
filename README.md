# **System Design**
- System design is the `process of defining the architecture`, `components`, `modules`, `interfaces`, and `data` for a system to satisfy specified requirements. 
- It involves creating a` blueprint` for how a software system will be built, focusing on `scalability`, `performance`, `reliability`, and `maintainability`. 
- System design can be broadly categorized into:
    - High-Level Design (HLD) and
    - Low-Level Design (LLD).

### Table of Contents
| sl. no | Topics |
|--------|--------|
| 1.     | [Introduction](#system-design)|
| 2.     | [High Level Design (HLD)](#high-level-design-hld)|
| 3.     | [Low Level Design (LLD)](#low-level-design)|



## **High Level Design HLD**
- HLD provides a broad overview of the `system architecture`. It focuses on the system's major components, their interactions, and how they align with business requirements. 

### Key Aspects of HLD:
- System architecture (e.g., microservices, monolithic, serverless).
- Major components (e.g., databases, servers, APIs, load balancers).
- Data flow and communication protocols between components.
- Scalability, fault tolerance, and deployment strategies.
- Technology stack selection (e.g., programming languages, frameworks).

- Example: For a ride-sharing app, HLD would outline the user app, driver app, backend services, database, and load balancer, along with how they interact (e.g., API calls, message queues).


## **Low Level Design**
LLD focuses on the `detailed design of individual components` identified in the HLD. It provides a granular view, specifying how each module or component will be implemented, including `algorithms`, `data structures`, and `code-level details`.

### Key Aspects of LLD:
- Detailed class diagrams, including methods, attributes, and relationships.
- Algorithms and data structures for specific functionalities.
- Database schema design (e.g., tables, relationships, indexes).
- API endpoints with input/output specifications.
- Error handling and logging mechanisms.

- Example: For the ride-sharing app, LLD would define the database schema for user data, the algorithm for matching drivers to riders, and the implementation details of a specific API endpoint.

### Sub topics
| sl. no. | Topics |
|---------|--------|
|  1.  | SOLID Principles|
|  2.  | DRY Principles  |
|  3.  | KISS Principles |
|  4.  | Design Patterns |

## Design Questions
### Easy Medium Problems (Pure Design Patterns)
1. Tic-Tac-Toe Game
2. Chess Game
3. Snake and Food Game
4. Parking Lot System
5. Elevator System
6. Inventory Management System
7. Car Rental System
8. Vending Machine
9. File System
10. Logging System
11. Splitwise
12. ATM Machine

### Hard problems (Concurrency Problem)
1. Movie Ticket Booking System
2. Cache
3. Kafka (Pub-Sub model)
4. Rate Limitter
