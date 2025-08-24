public class StandardShipping implements IShipmentType {
    @Override
    public double calculateShippingCost(double weightKg) {
        return 50 + 5 * weightKg;
    }
}
