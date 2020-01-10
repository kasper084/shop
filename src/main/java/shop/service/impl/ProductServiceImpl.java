package shop.service.impl;

import shop.entity.Product;
import shop.service.ProductService;

import java.util.*;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private Map<String, Product> productMap = new HashMap<>();

    public Product getProductByName(String name) {
      return productMap.entrySet()
              .stream()
              .filter(map -> map.getKey().equalsIgnoreCase(name))
              .findFirst().orElseThrow(() -> new NoSuchElementException("No product found")).getValue();
    }

    @Override
    public List<Product> getAllProducts() {
        return productMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void addNewProduct(String productId, String name, Double price) {

    }

    @Override
    public void getProduct(String productId) {

    }

    @Override
    public void editProduct(String productId) {

    }
}
