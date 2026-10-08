# Vehicle Workshop Management System

## Project Structure & Architecture
This Java application is built using Object-Oriented Programming (OOP) principles to manage a vehicle repair workshop. The architecture focuses on clean separation of concerns, where data management is decoupled from the user interface.

### Central OOP Concepts Applied:
*   **Inheritance**: The abstract class `Vehicle` acts as the superclass, enforcing shared attributes and behaviors across specialized subclasses (`Car`, `Truck`, and `Motorcycle`).
*   **Polymorphism**:
    *   *Subtype Polymorphism*: Utilized in `WorkshopManager` where an `ArrayList<Vehicle>` holds different types of vehicle objects uniformly.
    *   *Polymorphic Method Invocations*: The `calculateRepairCost(int hours)` method is dynamically bound at runtime depending on the specific object instance within the collection loop.
*   **Encapsulation**: All state variables (fields) within the classes are marked `private` to restrict unauthorized direct access. Safe access and modification are exposed via public `getters` and `setters`, alongside constructor-level argument validation.
*   **Abstraction & Interfaces**: The `Serviceable` interface defines a contract for diagnostic behaviors. This decouples the core domain models from specific functional requirements, ensuring only eligible classes (`Car` and `Truck`) implement the contract.
*   **Method Overriding**: Subclasses implement `@Override` on the abstract `calculateRepairCost` method to provide specialized, domain-specific logic for cost calculations.