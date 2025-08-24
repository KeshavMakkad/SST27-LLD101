public class Payment {
    IPaymentProvider provider;
    double amount;

    Payment(IPaymentProvider p, double a) {
        provider = p;
        amount = a;
    }
}