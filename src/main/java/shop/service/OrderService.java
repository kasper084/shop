package shop.service;

public interface OrderService {

    void addProductToOrder(String productId);

    void showOrder(String orderId);

    List<Order> showAllOrdersByUser(String usersId);

    void checkout(String orderId);

    void confirmOrder(String orderId);

    void deleteOrder(String orderId);
}
