package shop.dao.impl;

import shop.dao.ProductDAO;
import shop.entity.Product;

import java.util.*;

public class ProductDAOImpl implements ProductDAO {

    private static Map<String, Product> productMap = dataBuilder();

    private static Map<String, Product> dataBuilder() {
        Map<String, Product> productMap = new HashMap<>();
        Product apple = setProduct("11", "apple", 0.52, "red apple");
        Product banana = setProduct("12", "banana", 0.73, "yellow banana");
        Product coconut = setProduct("13", "coconut", 1.75, "small coconut");
        productMap.put(apple.getId(), apple);
        productMap.put(banana.getId(), banana);
        productMap.put(coconut.getId(), coconut);
        return productMap;
    }

    private static Product setProduct(String id, String name, Double price, String description) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        return product;
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productMap.values()
                .stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    public void addProduct(Product product) {
        productMap.put(product.getName(), product);
    }

    public void updateProduct(Product product) {
        productMap.replace(product.getName(), product);
    }
}
