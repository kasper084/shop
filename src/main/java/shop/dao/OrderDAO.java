package shop.dao;

import shop.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    // for user
    void save(Order order);

    // for admin
    void update(String orderId);

    // for user
    Optional<Order> findOrder(String userId);

    // for user
    List<Order> getAllByUser(String userId);

    // for admin
    List<Order> getAll();
}
