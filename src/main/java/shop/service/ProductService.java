package shop.service;

public interface ProductService {

    void getProduct(String productId);

    List<Product> getAllProducts();

    void addNewProduct(String productId, String name, Double price);

    void editProduct(String productId);
}
