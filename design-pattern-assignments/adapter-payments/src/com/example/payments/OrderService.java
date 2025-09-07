package com.example.payments;

import java.util.Map;
import java.util.Objects;

public class OrderService {
    public String charge(PaymentGateway provider, String customerId, int amountCents) {
        Objects.requireNonNull(provider, "provider");
        return provider.charge(customerId, amountCents);
    }
}
