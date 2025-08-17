# design-patterns

# Singleton Pattern
The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance.
Ensure that only one instance of the class exists by using the `object` declaration in kotlin.
The Singleton pattern is crucial because it helps you manage shared resources more efficiently. For example, think of scenarios like logging, configuration settings, or database connections — these are areas where you typically need only one instance.


# Factory Pattern
The Factory Method pattern is a creational design pattern that provides an interface for creating objects in a superclass, but it allows subclasses to alter the type of objects that will be created. Instead of calling a constructor directly to create an object, the client calls a factory method defined by an abstract class or interface, which delegates the process to derived classes. This approach promotes loose coupling and adheres to the Open/Closed Principle, allowing a system to be extended without modifying existing code.
