package shop.service;

import shop.entity.Order;

import java.util.List;

public interface OrderService {

    void addProductToOrder(String productId);

    void  getOrder(String orderId);

    // for user
    List<Order> getAllOrdersForUser(String usersId);

    // for admin
    void confirmOrder(String orderId);

    // for user
    void checkoutOrder(Order order);
}
