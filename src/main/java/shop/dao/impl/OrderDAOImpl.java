package shop.dao.impl;

import shop.dao.OrderDAO;
import shop.entity.Order;
import shop.entity.Product;
import shop.entity.User;
import shop.enums.OrderStatus;

import java.util.*;
import java.util.stream.Collectors;

public class OrderDAOImpl implements OrderDAO {
    private static Map<String, Order> orderMap = dataBuilder();

    private static Map<String, Order> dataBuilder() {
        Map<String, Order> orderMap = new HashMap<>();
        Product apple = setProduct("7", "apple", 0.52, "red apple");
        Product banana = setProduct("8", "banana", 0.73, "yellow banana");
        Product coconut = setProduct("9", "coconut", 1.75, "small coconut");
        Order order1 = setOrder("11", "3", apple);
        Order order2 = setOrder("12", "4", banana);
        Order order3 = setOrder("13", "5", coconut);
        orderMap.put(order1.getId(), order1);
        orderMap.put(order2.getId(), order2);
        orderMap.put(order3.getId(), order3);
        return orderMap;
    }

    private static Order setOrder(String id, String userId, Product product) {
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setProductList(new ArrayList<>());
        order.getProductList().add(product);
        order.setStatus(OrderStatus.PENDING);
        return order;
    }

    private static Product setProduct(String id, String name, Double price, String description) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return product;
    }

    @Override
    public void save(Order order) {
        orderMap.put(order.getId(), order);
    }

    @Override
    public Optional<Order> getOrderById(String orderId) {
        return orderMap.values().stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst();
    }

    @Override
    public void update(Order order) {
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
        return new ArrayList<>(orderMap.values());
    }
}