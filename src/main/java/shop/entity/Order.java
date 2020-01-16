package shop.entity;

import shop.enums.OrderStatus;

import java.util.List;

public class Order {
    private String id;
    private String userid;
    private OrderStatus status;
    private List<Product> productList;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String a) {
        userid = a;
    }

    public String getId() {
        return id;
    }

    public void setId(String a) {
        id = a;
    }


    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus a) {
        status = a;
    }

    public List<Product> getList() {
        return productList;
    }

    public void setList(List<Product> a) {
        productList = a;
    }
}
