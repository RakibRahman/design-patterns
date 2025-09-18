# The Decorator Pattern

## What it is:
The Decorator Pattern is a structural design pattern that allows you to dynamically add new behavior or responsibilities to an object without modifying its existing structure or class.

## The Problem it solves:
This pattern is useful when we need to add responsibilities to objects without subclassing.

## Benefits:
- Composition over inheritance: avoids creating redundant subclasses to extend or change a class's behavior.
- Flexibility: responsibilities can be added or removed dynamically.
- Adheres to SRP (each decorator focuses on one concern) and OCP (classes are open for extension via decorators but closed for modification, no need to change the original class).

## Drawbacks:
- Extra layers of wrapping can make debugging harder.
- Applying decorators in different sequences may change results.
- Too many small classes/decorators can clutter design.

## Diagram:
      ┌────────────┐
      │   Text     │  <─── Interface (format)
      └─────┬──────┘
            │
┌──────────┴───────────┐
│                      │
│                      │
▼                      ▼
SimpleText        TextDecorator (abstract)
(format → text)   (wraps another Text)
│
┌───────────┴───────────┐
▼                       ▼
BoldText                ItalicText
(adds <b>..</b>)        (adds <i>..</i>)
