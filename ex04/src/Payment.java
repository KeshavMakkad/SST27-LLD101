public class Payment {
    PaymentProvider provider;
    double amount;

    Payment(PaymentProvider p, double a) {
        provider = p;
        amount = a;
    }
}