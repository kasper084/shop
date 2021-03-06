package shop.service;

import shop.entity.Order;
import shop.entity.User;

import java.util.List;

public interface AdminService {

    boolean login(String email, String password);

    void blockUser(String userId);

    void unblockUser(String userId);

    void deleteUser(String userEmail);

    List<String> getActiveUsers();

    List<String> getInactiveUsers();

    List<String> getAllEmails();

    List<User> getAllUsers();

    List<Order> getAllPendingOrders();

    void confirmOrder(String orderId);

    void declineOrder(String orderId);
}