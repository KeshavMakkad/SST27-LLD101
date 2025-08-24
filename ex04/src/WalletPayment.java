public class WalletPayment implements PaymentProvider {
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment Via Wallet of amount : " + amount + "done ");
    }
}
