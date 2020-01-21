package shop.dao.impl;

import shop.dao.OrderDAO;
import shop.entity.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderDAOImpl implements OrderDAO {
    private Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void save(Order order) {
        orderMap.put(order.getUserId(), order);
    }

    @Override
    public void update(String orderId) {

    }

    @Override
    public Optional<Order> findOrder(String userId) {
        return orderMap.values().stream()
                .filter(order -> order.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<Order> getAllByUserId(String userId) {
        return orderMap.values().stream()
                .filter(order -> order.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getAll() {

        return null;
    }

}
