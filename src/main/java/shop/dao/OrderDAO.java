package shop.dao;

import shop.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {
    
    void save(Order order);

    void update(String orderId);

    Optional<Order> findOrder(String userId);

    List<Order> getAllByUserId(String userId);

    List<Order> getAll();
}
