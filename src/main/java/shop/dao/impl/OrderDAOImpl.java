package shop.dao.impl;

import shop.dao.OrderDAO;
import shop.entity.Order;

import java.util.*;
import java.util.stream.Collectors;

public abstract class OrderDAOImpl implements OrderDAO {
    private Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void save(Order order) {
        orderMap.put(order.getId(), order);
    }

    @Override
    public void update(Order order) {
        // може бути ось так. Бо тобі автоматично мапа перепише по кюючу існуючий обєкт
        save(order);
    }

    @Override
    public Optional<Order> findOrderByUserId(String userId) {
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
