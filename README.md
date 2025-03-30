# SOLID Principles Refactoring Challenge

## Problem Description
The given code violates multiple SOLID principles in Object-Oriented Programming (OOP). The goal is to refactor the code to adhere to these principles while maintaining functionality.

### Existing Code
The provided code defines an `Order` interface with multiple responsibilities and an `OrderAction` class that implements it. The main issues include:
- **Single Responsibility Principle (SRP) Violation:** The `Order` interface has methods for order processing, invoice generation, and email notifications, which should be separate concerns.
- **Interface Segregation Principle (ISP) Violation:** The interface forces classes to implement methods they may not need.
- **Open/Closed Principle (OCP) Violation:** The `OrderAction` class is not easily extendable for new behaviors without modifying existing code.

### Given Code
```java
public interface Order {
  void calculateTotal(double price, int quantity);
  void placeOrder(String customerName, String address);
  void generateInvoice(String fileName);
  void sendEmailNotification(String email);
}

public class OrderAction implements Order {
  @Override
  public void calculateTotal(double price, int quantity) {
    double total = price * quantity;
    System.out.println("Order total: $" + total);
  }

  @Override
  public void placeOrder(String customerName, String address) {
    // Simulate placing order in a system
    System.out.println("Order placed for " + customerName + " at " + address);
  }

  @Override
  public void generateInvoice(String fileName) {
    // Simulate generating invoice file
    System.out.println("Invoice generated: " + fileName);
  }

  @Override
  public void sendEmailNotification(String email) {
    // Simulate sending email notification
    System.out.println("Email notification sent to: " + email);
  }
}

public class OrderTest {
  public static void main(String[] args) {
    Order order = new OrderAction();
    order.calculateTotal(10.0, 2);
    order.placeOrder("John Doe", "123 Main St");

    // These methods might not be needed for all orders
    order.generateInvoice("order_123.pdf");
    order.sendEmailNotification("johndoe@example.com");
  }
}
```

## Task
Refactor the code to adhere to SOLID principles. Key improvements include:
- Separating concerns for better maintainability.
- Implementing interface segregation to avoid forcing classes to implement unrelated methods.
- Allowing extensibility without modifying existing code.

## Expected Refactored Structure
A possible refactored structure could involve:
- Separate interfaces for order processing, invoicing, and notifications.
- Dedicated classes implementing these interfaces.
- Dependency injection to improve flexibility.
