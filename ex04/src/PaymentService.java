
public class PaymentService {
    String pay(Payment p) {
        p.provider.processPayment(p.amount);
        return "Success";
    }
}