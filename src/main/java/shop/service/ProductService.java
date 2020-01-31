package shop.service;

import shop.entity.Product;

import java.util.List;

public interface ProductService {

    void getProduct(String productId);

    Product getProductByName (String productName);

    List<Product> getAllProducts();

    void addProduct(String name, Double price, String description);

    void editProduct(Product product, String name, Double price, String description);

    void deleteProduct(String productName);
}
