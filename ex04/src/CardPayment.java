public class CardPayment implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via Card of amount : " + amount + "done ");
    }
}
