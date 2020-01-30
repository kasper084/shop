package shop.service;

import shop.entity.Order;
import shop.entity.Product;

import java.util.List;

public interface OrderService {

    List<Product> addProductToOrder(String name);

    Order getOrder(String orderId);

    List<Order> getAllOrdersForUser();

    void confirmOrder(String orderId);

    void checkoutOrder(String userId);

    void declineOrder(String orderId);

    List<Order> getAll();
}
