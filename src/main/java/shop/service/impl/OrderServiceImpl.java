package shop.service.impl;

import shop.dao.OrderDAO;
import shop.dao.impl.OrderDAOImpl;

import shop.entity.Order;
import shop.service.OrderService;
import shop.service.ProductService;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import static shop.enums.OrderStatus.CONFIRMED;
import static shop.enums.OrderStatus.PENDING;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl() {
        @Override
        public Optional<Order> getOrderById(String orderId) {
            return Optional.empty();
        }
    };
    private ProductService productService = new ProductServiceImpl();

    @Override
    public void addProductToOrder(String productId) {
         productService.getProduct(productId);
    }

           @Override
            public void getOrder(String orderId) {

            }

            @Override
            public List<Order> getAllOrdersForUser(String usersId) {

        return orderDAO.getAllByUserId(usersId);
            }

        @Override
        public void confirmOrder (String orderId){
            Order existingOrder = orderDAO.getOrderById(orderId).orElseThrow(() -> new IllegalArgumentException("Order not found"));

            existingOrder.setStatus(CONFIRMED);

            // should be object order. not orderId (in method update)
            orderDAO.update(existingOrder);
        }

        @Override
        public void checkoutOrder (Order order){
         order.setStatus(PENDING);
         orderDAO.save(order);
        }

        public void deleteOrder (String orderId){
        }
    }
