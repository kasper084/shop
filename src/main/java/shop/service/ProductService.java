package shop.service;

public interface ProductService {

    void getProduct(String productId);

    List<Product> getAllProducts();

    void addProduct(String productId);

    void editProduct(String productId);
}
