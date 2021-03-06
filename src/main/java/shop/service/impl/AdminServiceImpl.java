package shop.service.impl;

import shop.entity.Order;
import shop.entity.User;
import shop.enums.OrderStatus;
import shop.enums.UserStatus;
import shop.service.AdminService;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static shop.ExceptionMessages.USER_NOT_FOUND;

public class AdminServiceImpl implements AdminService {
    private static final String ADMIN_EMAIL = "admin@mail.com";
    private static final String ADMIN_PASSWORD = "admin";

    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    public boolean login(String email, String password) {
        return email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD);
    }

    @Override
    public void blockUser(String userEmail) {
        changeUserStatus(userEmail, UserStatus.BLOCKED);
    }

    @Override
    public void unblockUser(String userEmail) {
        changeUserStatus(userEmail, UserStatus.ACTIVE);
    }

    @Override
    public void deleteUser(String userEmail) {
        User user = getUser(userEmail);
        userService.deleteUser(user);
    }

    @Override
    public List<String> getActiveUsers() {
        return getAllUsers().stream()
                .filter(user -> user.getStatus().equals(UserStatus.ACTIVE))
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getInactiveUsers() {
        return getAllUsers().stream()
                .filter(user -> user.getStatus().equals(UserStatus.BLOCKED))
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllEmails() {
        return getAllUsers().stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userService.getAll());
    }

    @Override
    public List<Order> getAllPendingOrders() {
        return orderService.getAll().stream()
                .filter(order -> order.getStatus().equals(OrderStatus.PENDING))
                .collect(Collectors.toList());
    }

    private void changeUserStatus(String userEmail, UserStatus status) {
        User user = getUser(userEmail);
        user.setStatus(status);
        userService.updateUser(user);
    }

    private User getUser(String userEmail) {
        return userService.findUser(userEmail)
                .orElseThrow(() -> new IllegalArgumentException(USER_NOT_FOUND));
    }

    public void confirmOrder(String orderId) {
        orderService.confirmOrder(orderId);
    }

    public void declineOrder(String orderId) {
        orderService.declineOrder(orderId);
    }
}