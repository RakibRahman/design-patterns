# The Adapter Pattern

## What it is
The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together.

## The problem it solves
It enables collaboration between two different interfaces that otherwise cannot interact seamlessly.

## Benefits
- Improves compatibility by allowing incompatible interfaces to interact.
- Makes it possible to introduce new interfaces without modifying existing code.
- Promotes reusability of existing functionality even when interfaces don’t match.

## Drawbacks
- Adds an extra layer of abstraction, which may increase complexity.
- Could introduce slight performance overhead in some cases.

## When to use
- When objects with incompatible interfaces need to collaborate.
- When you want to reuse an existing class but its interface doesn’t meet current requirements.
- When following SOLID principles:
    - **SRP (Single Responsibility Principle):** separates business logic from adaptation logic.
    - **OCP (Open/Closed Principle):** allows introducing new types or features without modifying existing code.  
