class Aviary {
    public void release(IFlyable b) {
        b.fly();
        System.out.println("Released");
    }
}