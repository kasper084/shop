package shop.service.impl;

import shop.entity.User;
import shop.enums.UserStatus;
import shop.service.AdminService;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService {
    private static final String ADMIN_EMAIL = "admin@adm.in";
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
        return userService.getInactiveUsers();
    }

    @Override
    public List<String> getInactiveUsers() {
        return userService.getInactiveUsers();
    }

    @Override
    public List<String> getAllUsers() {
        return userService.getAll().stream()
                .map(User::getEmail).collect(Collectors.toList());
    }

    private void changeUserStatus(String userEmail, UserStatus status) {
        User user = getUser(userEmail);
        user.setStatus(status);
        userService.updateUser(user);
    }

    private User getUser(String userEmail) {
        return userService.findUser(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("User with such email not found"));
    }

    public void confirmOrder(String orderId) {
        orderService.confirmOrder(orderId);
    }

    public void deleteOrder(String orderId) {
        orderService.deleteOrder(orderId);
    }

    public void addProduct(String productName, Double price, String description) {
        productService.addProduct(productName, price, description);
    }

    public void editProduct(String productId, Double price, String description) {
        productService.editProduct(productId, price, description);
    }
}