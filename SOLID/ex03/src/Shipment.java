public class Shipment {
    IShipmentType type;
    double weightKg;

    Shipment(IShipmentType type, double w) {
        this.type = type;
        this.weightKg = w;
    }
}