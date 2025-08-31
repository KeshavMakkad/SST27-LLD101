package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private String id;
    private final String customerEmail;
    private final List<OrderLine> lines; // Can also do unmodifiablelist but did not do it........
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    public Order(Builder orderBuilder) {
        this.id = orderBuilder.id;
        this.customerEmail = orderBuilder.customerEmail;
        this.lines = orderBuilder.lines;
        this.discountPercent = orderBuilder.discountPercent;
        this.expedited = orderBuilder.expedited;
        this.notes = orderBuilder.notes;
    }

    public static final class Builder {
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder(String id, String customerEmail, Integer discountPercent) {
            this.id = id;
            this.customerEmail = customerEmail;
            this.discountPercent = discountPercent;
        }

        public Builder addLine(OrderLine line) {
            lines.add(new OrderLine(line));
            return this;
        }

        public Builder setLines(List<OrderLine> lines) {
            this.lines.clear();
            if (lines != null) {
                for (OrderLine line : lines) {
                    this.lines.add(new OrderLine(line));
                }
            }
            return this;
        }

        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        public Builder setDiscountPercent(Integer discountPercent) {
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Invalid discount percent");
            }
            this.discountPercent = discountPercent;
            return this;
        }

        public Order build() {
            if (this.id == null || this.customerEmail == null)
                throw new IllegalArgumentException("Missing required fields");
            if (this.customerEmail == null || !PricingRules.isValidEmail(this.customerEmail))
                throw new IllegalArgumentException("Invalid email");
            if (this.lines.size() == 0)
                throw new IllegalArgumentException("Order must have at least one line");

            return new Order(this);
        }
    }

    // public void addLine(OrderLine line) { lines.add(line); }
    // public void setDiscountPercent(Integer discountPercent) {
    // this.discountPercent = discountPercent; }
    // public void setExpedited(boolean expedited) { this.expedited = expedited; }
    // public void setNotes(String notes) { this.notes = notes; }

    public String getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderLine> getLines() {
        List<OrderLine> deepcopy = new ArrayList<>();
        for (OrderLine line : lines) {
            deepcopy.add(new OrderLine(line));
        }
        return deepcopy;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public boolean isExpedited() {
        return expedited;
    }

    public String getNotes() {
        return notes;
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines)
            sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null)
            return base;
        return base - (base * discountPercent / 100);
    }
}
