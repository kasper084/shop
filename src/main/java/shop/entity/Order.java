package shop.entity;

import shop.enums.OrderStatus;
import java.util.Scanner;

import java.util.List;

public class Order {
    private String id;
    private String userId;
    private OrderStatus status;
    private List<Product> productList;
    private Scanner scanner = new Scanner(System.in);

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getOrderId(){ System.out.println("Enter ID"); return scanner.nextLine();}


    @Override
    public String toString() {
        return "orderId='" + id + '\'' +
                ", userId='" + userId + '\''+
                ", order status" + status;
    }
}