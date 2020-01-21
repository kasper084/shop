package shop.service.impl;

import shop.dao.OrderDAO;
import shop.dao.impl.OrderDAOImpl;

import shop.entity.Order;
import shop.service.OrderService;

import java.util.List;

import java.util.stream.Collectors;

import static shop.enums.OrderStatus.PENDING;

public class OrderServiceImpl implements OrderService {
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

        List orders = orderDaoImpl.getOrdersByUserId();
                return orders.stream()
                        .filter(order -> order.getUserId().equals(orderDAO))
                        .collect(Collectors.toList());
            }

        @Override
        public void confirmOrder (String orderId){

        }

        @Override
        public void checkoutOrder (Order order){
            orderDAOImpl.setStatus(PENDING);
            orderDAOImpl.save(order);
        }

        public void deleteOrder (String orderId){
        }
    }
