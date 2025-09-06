# The Prototype Pattern

## What it is

A design pattern that lets you create new objects by copying existing ones. The pattern declares a common interface for all objects that support copying.
**Prototype = one template, many copies.**

## The problem it solves

Instead of writing long `if-else` or `switch` statements to create objects of different types, you can keep a prototype and call `clone()` to get a new instance.
It also avoids the overhead of complex initialization for each new object.

## Benefits

* No need to manually initialize each field; simply clone the existing object.
* Ensures consistency across similar objects.
* Improves efficiency by eliminating repeated initialization for new objects.

## Drawbacks

* Cloning large objects can be costly in memory.
* Circular references (objects pointing to each other) can cause issues if not handled properly.

## When to use

* When you want to reduce the number of subclasses that differ only in initial configuration.
* When your code shouldn’t rely on the specific classes of the objects you need to copy.

## Quick Example

Sometimes we create multiple subclasses just to give objects different initial states: `DesktopWithGPU`, `DesktopWithPSU`, `DesktopWithRGB`—all basically the same `Desktop` class with different parameters.
Instead of making many subclasses, define one base class (`Desktop`), prepare a few **prototype objects** (pre-configured desktops), and clone them when needed.
