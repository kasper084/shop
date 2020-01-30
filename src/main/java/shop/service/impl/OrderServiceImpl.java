package shop.service.impl;

import shop.dao.OrderDAO;
import shop.dao.impl.OrderDAOImpl;

import shop.entity.Order;
import shop.entity.Product;
import shop.entity.User;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.service.session.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static shop.ExceptionMessages.ORDER_NOT_FOUND;
import static shop.enums.OrderStatus.*;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private ProductService productService = new ProductServiceImpl();
    private List<Product> productCart = new ArrayList<>();

    @Override
    public Order getOrder(String orderId) {
        return orderDAO.getOrderById(orderId).orElseThrow(() -> new IllegalArgumentException("No such order"));
    }

    @Override
    public List<Order> getAllOrdersForCurrentUser(String userId) {
        return orderDAO.getAllByUserId(userId);
    }
  
    @Override
    public void confirmOrder(String orderId) {
        Order existingOrder = getOrder(orderId);
        existingOrder.setStatus(CONFIRMED);
        orderDAO.update(existingOrder);
    }

    @Override
    public List<Product> addProductToOrder(String name) {
        productCart.add(productService.getProductByName(name));
        return productCart;
    }

    @Override
    public void checkoutOrder(String userId) {
        Order order = new Order();
        order.setProductList(new ArrayList<>(productCart));
        productCart.clear();
        order.setId(UUID.randomUUID().toString());
        order.setStatus(PENDING);
        order.setUserId(userId);
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
