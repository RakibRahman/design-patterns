# The Builder Pattern

## What it is
A creational design pattern that lets us create complex objects step by step.  
Other creational patterns, such as the **Factory Pattern**, support object creation in a single step.  
The Builder Pattern provides a systematic way to create objects with various properties.  
It simplifies the creation of complex objects with a clean approach and flexibility.

## The problem it solves
The Builder Pattern shines when an object requires—or can be created with—numerous properties or parameters.  
It is particularly useful when the construction process involves multiple steps.  
The core benefit is that it supports creating different types and representations of an object using the same construction code.

## Benefits
- **Reduced Complexity:** Keeps the constructor clean by reducing the number of parameters.  
  Objects can be constructed with required and optional properties through clear instructions.
- **Flexibility:** Easily add, update, or change object configurations without modifying the core object class.
- **Immutability:** Objects created with this pattern can be immutable, providing a stable state once created.
- **SOLID Compliance:** Adheres to the Single Responsibility Principle.

## Drawbacks
- This pattern often requires creating multiple new classes, which increases overall code complexity.

## When to Use
- The object has many optional parameters.
- Object creation requires a multi-step process.
- When multiple representations of the same object is required.

## Quick Example
Imagine we want to create a `BuilderPattern.House` object.  
A house always needs some **required properties** like the number of rooms, but it may also have **optional properties** such as a garden, garage, or swimming pool.

Without the Builder Pattern, we might end up with a **large constructor** that takes every possible parameter:
val house = BuilderPattern.House(rooms = 4, hasGarden = true, hasGarage = false, color = "Blue", floors = 2) // // Creating a house becomes confusing

With the Builder Pattern:
val house = BuilderPattern.House.Builder(rooms = 4)   // required
.setGarden(true)                   // optional
.setGarage(true)                   // optional
.setColor("Blue")                  // optional
.setFloors(2)                      // optional
.build()
This makes house creation  much cleaner and readable.