package shop.entity;

import java.util.List;

public class Order {
    private String id;
    private String userid;
    private String status;
    private List<Product> productList;

    public String getUserId() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String a) {
        status = a;
    }

    public List<Product> getList() {
        return productList;
    }

    public void addList(Product product){
        productList.add(product);
    }

    public void setList(List<Product> a) {
        productList = a;
    }
}
