package shop.service;

import shop.entity.Order;
import shop.entity.Product;

import java.util.List;

public interface OrderService {

    List<Product> addProductToOrder(String name);

    void  getOrder(String orderId);

    List<Order> getAllOrdersForUser(String usersId);

    void confirmOrder(String orderId);

    void checkoutOrder(String userId);

    void declineOrder(Order order);
}
