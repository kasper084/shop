package shop.dao.impl;

import shop.dao.OrderDAO;
import shop.dao.UserDAO;
import shop.entity.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderDAOImpl implements OrderDAO {

    // this is your main place where all orders will be saved
    private Map<String, Order> orderMap = new HashMap<>();
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void save(Order order) {
        orderMap.put(order.getUserId(), order);
        // need to implement
    }

    @Override
    public void update(String orderId) {

    }

    @Override
    public Optional<Order> findOrder(String userId) {
        // need to implement
        return orderMap.values().stream()
                .filter(order -> order.getUserId().equals(userId))
                .findAny();
    }

    @Override
    public List<Order> getAllByUser(String userId) {
        List<Order> orders = new ArrayList<>();
        if (userDAO.isExist(userId)) {
             orders = orderMap.values().stream()
                    .filter(order -> order.getUserId().equals(userId))
                    .collect(Collectors.toList());
        }
      return orders;
    }

    @Override
    public List<Order> getAll() {

        return null;
    }

}
