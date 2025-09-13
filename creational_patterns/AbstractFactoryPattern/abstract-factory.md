The Abstract Factory Pattern

Studied this pattern today, sharing my takeaways:

What it is:
A creational design pattern that provides an interface for creating related or dependent objects without specifying their concrete classes. Think of it as a “factory of factories.” The core idea is to create related objects without hardcoding their types.
Abstract Factory → Families of related objects, created together.

The problem it solves:
It gives a structured way to create a whole set of related objects that are meant to work together. This guarantees consistency — all created objects belong to the same family and remain compatible.

Benefits:
- Adheres to SRP & OCP (SOLID): One place to manage object creation (SRP). Add new products to the family without touching existing code (OCP).
- Promotes loose coupling: Clients don’t need to know the exact classes being instantiated.
- Uses composition: Delegates object creation to specialised factories.
- Scalable: Adding a new family of objects becomes straightforward.

Drawbacks:
- More complex than the basic Factory pattern.
- Introduces a lot of interfaces and classes, which can feel heavy for small use cases.

Quick Example:
Instead of creating music files directly, we delegate the job to specific factories (creational_patterns.MP3FileFactory, creational_patterns.WAVFileFactory, creational_patterns.FLACFileFactory).
The client (BuilderPattern.AbstractFactoryPattern.creational_patterns.main) just uses creational_patterns.MusicFileFactory to get the right object — no need to know concrete classes.
Adding a new format? Just plug in a new factory; the existing code stays untouched.