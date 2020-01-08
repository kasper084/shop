package shop.entity;

public class Product {
    private String id;
    private String name;
    private Double price;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String a) {
        name = a;
    }

    public String getId() {
        return id;
    }

    public void setId(String a) {
        id = a;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double a) {
        price = a;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String a) {
        description = a;
    }
}
