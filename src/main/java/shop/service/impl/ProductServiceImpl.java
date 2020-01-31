package shop.service.impl;

import shop.dao.ProductDAO;
import shop.dao.impl.ProductDAOImpl;
import shop.entity.Product;
import shop.service.ProductService;

import java.util.*;

import static shop.ExceptionMessages.NO_PRODUCT_FOUND;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void getProduct(String productId) {
    }

    @Override
    public Product getProductByName(String name) {
        return productDAO.findProductByName(name)
                .orElseThrow(() -> new IllegalArgumentException(NO_PRODUCT_FOUND));
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    @Override
    public void addProduct(String name, Double price, String description) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        productDAO.addProduct(product);
    }

    @Override
    public void editProduct(Product product, String name, Double price, String description) {
        if (!name.isEmpty()) product.setName(name);
        if (price != 0.0) product.setPrice(price);
        if (!description.isEmpty()) product.setDescription(description);

        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(String productName) {
        Product product = getProductByName(productName);
        productDAO.deleteProduct(product);
    }
}