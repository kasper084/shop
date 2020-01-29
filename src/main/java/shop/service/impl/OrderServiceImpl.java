package shop.service.impl;

import shop.dao.OrderDAO;
import shop.dao.impl.OrderDAOImpl;

import shop.entity.Order;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.List;
import java.util.Optional;

import static shop.enums.OrderStatus.*;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private ProductService productService = new ProductServiceImpl();

    @Override
    public void addProductToOrder(String productId) {
        productService.getProduct(productId);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderDAO.getOrderById(orderId).orElseThrow(() -> new IllegalArgumentException("No such order"));
    }

    @Override
    public List<Order> getAllOrdersForUser(String usersId) {
        return orderDAO.getAllByUserId(usersId);
    }

    @Override
    public void confirmOrder(String orderId) {
        Order existingOrder = getOrder(orderId);
        existingOrder.setStatus(CONFIRMED);
        orderDAO.update(existingOrder);
    }

    @Override
    public void checkoutOrder(Order order) {
        order.setStatus(PENDING);
        orderDAO.save(order);
    }

    @Override
    public void declineOrder(String orderId) {
        Order order = getOrder(orderId);
        order.setStatus(CANCELED);
        orderDAO.update(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }

}
