public class OvernightShipping implements IShipmentType {
    @Override
    public double calculateShippingCost(double weightKg) {
        return 120 + 10 * weightKg;
    }
}
