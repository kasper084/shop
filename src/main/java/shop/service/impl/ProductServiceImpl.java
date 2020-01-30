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
                .orElseThrow(() -> new NoSuchElementException(NO_PRODUCT_FOUND));
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
    public void editProduct(String name, Double price, String description) {
        Product product = getProductByName(name);

        product.setName(name);
        if (name.isEmpty()) product.setName(product.getName());

        product.setPrice(price);
        if (price == 0) product.setPrice(product.getPrice());

        product.setDescription(description);
        if (description.isEmpty()) product.setDescription(product.getDescription());

        productDAO.updateProduct(product);
    }
}