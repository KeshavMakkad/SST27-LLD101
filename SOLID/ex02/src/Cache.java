public class Cache implements IStore {
    @Override
    public void save(Frame frame) {
        System.out.println("Cached last frame");
    }
}
