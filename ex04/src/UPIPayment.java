public class UPIPayment implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via UPI of amount : " + amount + "done ");
    }
}
