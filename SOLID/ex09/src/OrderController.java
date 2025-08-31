public class OrderController {

    IOrderRepository orderRepository;

    public OrderController(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    void create(String id) {
        orderRepository.save(id);
        System.out.println("Created order: " + id);
    }
}