# Oracle Technical Home Assignment
This is Oracle technical home assignment.

## Design Pattern Choices:

### Builder Pattern
**Usage**: The Builder Pattern is used in the `BuildData` class to handle the creation of complex objects with multiple parameters. It ensures the immutability of the `BuildData` objects and provides a clear, fluent API for constructing instances. This adheres to the Single Responsibility Principle as it separates the construction of `BuildData` objects from their representation.

### Factory Pattern
**Usage**: The Factory Pattern is used in the `BuildDataParser` class to encapsulate the creation logic of `BuildData` objects. This separation of concerns makes the code more maintainable and testable, adhering to the Open/Closed Principle by allowing new types of data parsing without modifying existing code.

### Strategy Pattern
**Usage**: The Strategy Pattern is used in the `BuildDataReport` class, which contains multiple methods for generating different types of reports. Each method represents a different strategy for processing data, allowing for flexible and interchangeable data processing strategies. This adheres to the Open/Closed Principle by allowing new report strategies to be added without modifying existing ones.

## SOLID Principles Followance

### Single Responsibility Principle
Each class has a single responsibility. `BuildData` represents the data model, `BuildDataParser` handles parsing, and `BuildDataReport` handles reporting.

### Open/Closed Principle
Classes are open for extension but closed for modification. New report types can be added without modifying existing code.

### Liskov Substitution Principle
Not directly applicable here, but the design allows for subclasses if needed.

### Interface Segregation Principle
Not directly applicable here, but could be implemented with more complex interfaces.

### Dependency Inversion Principle
High-level modules (`BuildDataApp`) do not depend on low-level modules; they depend on abstractions (`BuildDataReport` and `BuildDataParser`).

## Testing
The application uses JUnit for unit testing to ensure the correctness of the implementation. Each method in the `BuildDataReport` class is tested with various inputs to validate the expected outcomes.

## Usage
To run the application, execute the `BuildDataApp` class, which parses the input data, generates reports, and prints them to the console.
