package shop.service.impl;

import shop.dao.AdminDAO;
import shop.dao.impl.AdminDAOImpl;
import shop.entity.Admin;
import shop.entity.User;
import shop.enums.UserStatus;
import shop.service.AdminService;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.service.UserService;
import shop.utils.PasswordEncoder;

import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private UserService userService = new UserServiceImpl();
    private AdminDAO adminDAO = new AdminDAOImpl();

    @Override
    public boolean login(String email, String password) {
        Optional<Admin> optUser = adminDAO.findAdmin(email);
        return optUser.map(admin -> admin.getPassword()
                .equals(PasswordEncoder.decode(password)))
                .orElse(false);
    }

    @Override
    public boolean isExist(String email) {
        return adminDAO.isExist(email);
    }

    @Override
    public Optional<Admin> findAdmin(String email) {
        return adminDAO.findAdmin(email);
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

    public void addNewProduct(String productId, String productName, Double price) {
        productService.addNewProduct(productId, productName, price);
    }

    public void editProduct(String productId) {
        productService.editProduct(productId);
    }
}