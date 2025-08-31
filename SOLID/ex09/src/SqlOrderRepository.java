public class SqlOrderRepository implements IOrderRepository {
    @Override
    public void save(String id) {
        System.out.println("Saved order " + id + " to SQL");
    }
}
