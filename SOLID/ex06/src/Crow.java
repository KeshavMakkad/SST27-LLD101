public class Crow implements Bird, IFlyable {
    @Override
    public void fly() {
        System.out.println("Crow is flying");
    }

    @Override
    public void flapWings() {
        System.out.println("Crow is flapping its wings");
    }
}
