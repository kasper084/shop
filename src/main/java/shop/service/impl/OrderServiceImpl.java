package shop.service.impl;

import shop.dao.OrderDAO;
import shop.dao.impl.OrderDAOImpl;
import shop.entity.Order;
import shop.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    private Map<String, Order> orderMap = new HashMap<>();
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void addProductToOrder(String productId) {

        orderMap.put(productId, (Order) orderDAO);
    }

    @Override
    public void getOrder(String orderId) {

    }

    @Override
    public List<Order> getAllOrdersForUser(String usersId) {
        List<Order> allOrders = new ArrayList<>();
        if (usersId.equals(orderDAO)) {
            allOrders = orderMap.values().stream()
                    .filter(order -> order.getUserId().equals(orderDAO))
                    .collect(Collectors.toList());
        }
        return allOrders;
    }
    // and this one also for u

    @Override
    public void confirmOrder(String orderId) {
        // not your task )
    }

    @Override
    public void checkoutOrder(Order order) {
        Map<String, Order> chekingOrder = new HashMap<>();
        chekingOrder.put(order.getUserId(),order);
        
    }
}
