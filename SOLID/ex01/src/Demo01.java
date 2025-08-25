
public class Demo01 {
    public static void main(String[] args) {
        IMessageSender messageSender = new EmailClient();
        TaxCalculator taxCalculator = new TaxCalculator(0.18);
        new OrderService(messageSender, taxCalculator).checkout("a@shop.com", 100.0);
    }
}
