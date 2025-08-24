public class ExpressShipping implements IShipmentType {
    @Override
    public double calculateShippingCost(double weightKg) {
        return 80 + 8 * weightKg;
    }
}
