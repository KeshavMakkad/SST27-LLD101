public class Bicycle implements IPedalVehicle {
    @Override
    public void pedal(int effort) {
        System.out.println("Pedal effort " + effort);
    }
}