package shop.service;

import shop.entity.Product;

import java.util.List;

public interface ProductService {

    void getProduct(String productId);

    void getProductByName (String productName);

    void getAllProducts();

    void addNewProduct(String productId, String name, Double price);

    void editProduct(String productId);
}
