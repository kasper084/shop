package shop.service;

import shop.entity.Order;

import java.util.List;

public interface OrderService {

    void addProductToOrder(String productId);

    void  getOrder(String orderId);

    List<Order> getAllOrdersForUser(String usersId);

    void checkout(String orderId);

    void confirmOrder(String orderId);

    void deleteOrder(String orderId);
}
