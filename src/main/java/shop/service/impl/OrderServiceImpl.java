package shop.service.impl;

import shop.dao.OrderDAO;
import shop.dao.impl.OrderDAOImpl;

import shop.entity.Order;
import shop.entity.Product;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static shop.enums.OrderStatus.*;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();
    private ProductService productService = new ProductServiceImpl();
    private List<Product> productCart = new ArrayList<>();

    @Override
    public void getOrder(String orderId) {

    }

    @Override
    public List<Order> getAllOrdersForUser(String usersId) {

        return orderDAO.getAllByUserId(usersId);
    }

    @Override
    public void confirmOrder(String orderId) {
        Order existingOrder = orderDAO.getOrderById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found"));

        existingOrder.setStatus(CONFIRMED);

        orderDAO.update(existingOrder);
    }

    @Override
    public List<Product> addProductToOrder(String name) {
        productCart.add(productService.getProductByName(name));
        return productCart;
    };

    @Override
    public void checkoutOrder() {
        Order order = new Order();
        order.setProductList(productCart);
        order.setId(UUID.randomUUID().toString());
        order.setStatus(PENDING);
        System.out.println(order);
        orderDAO.save(order);
    }

    @Override
    public void declineOrder(Order order) {
        order.setStatus(CANCELED);
    }

}
