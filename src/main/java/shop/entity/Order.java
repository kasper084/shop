package shop.entity;

import com.sun.tools.javac.util.List;

public class Order {
    private String id;
    private String userid;
    private String status;
    private List productList;

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


    public String getStatus() {
        return status;
    }

    public void setStatus(String a) {
        status = a;
    }

    public List getList() {
        return productList;
    }

    public void setList(List a) {
        productList = a;
    }
}
