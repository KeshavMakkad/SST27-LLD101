public class CardPayment implements IPaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via Card of amount : " + amount + "done ");
    }
}
