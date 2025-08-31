public class OrderService {
    private final IMessageSender messageSender;
    private final TaxCalculator taxCalculator;

    public OrderService(IMessageSender messageSender, TaxCalculator taxCalculator) {
        this.messageSender = messageSender;
        this.taxCalculator = taxCalculator;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = taxCalculator.totalWithTax(subtotal);
        messageSender.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}