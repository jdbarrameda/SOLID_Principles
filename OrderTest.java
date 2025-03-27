public class OrderTest {
    public static void main(String[] args) {
        // Create instances of the interfaces
        Order order = new OrderAction();
        InvoiceGenerator invoiceGenerator = new InvoiceGeneratorImpl();
        EmailNotificationSender emailNotificationSender = new EmailNotificationSenderImpl();

        // Perform the actions on the order
        order.calculateTotal(10.0, 2);
        order.placeOrder("John Doe", "123 Main St");

        // Generate invoice and send notification
        invoiceGenerator.generateInvoice("order_123.pdf");
        emailNotificationSender.sendEmailNotification("johndoe@example.com");
    }
}