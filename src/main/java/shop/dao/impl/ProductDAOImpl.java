package shop.dao.impl;

import shop.dao.ProductDAO;
import shop.entity.Product;

import java.util.*;

public class ProductDAOImpl implements ProductDAO {

    private Map<String, Product> productMap = new HashMap<>();

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
}
