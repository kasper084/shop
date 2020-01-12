package shop.service.impl;

import shop.dao.ProductDAO;
import shop.dao.impl.ProductDAOImpl;
import shop.entity.Product;
import shop.service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public Product getProductByName(String name) {
        return productDAO.findProductByName(name)
                .orElseThrow(() -> new NoSuchElementException("No product found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAll();
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
