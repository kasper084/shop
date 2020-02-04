package shop.dao;

import shop.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    void save(Order order);

    Optional<Order> getOrderById(String orderId);

    void update(Order order);

    Optional<Order> findOrderByUserId(String userId);

    List<Order> getAllByUserId(String userId);

    List<Order> getAll();
}
