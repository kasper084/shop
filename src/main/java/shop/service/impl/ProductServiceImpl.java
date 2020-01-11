package shop.service.impl;

import shop.dao.ProductDAO;
import shop.dao.impl.ProductDAOImpl;
import shop.entity.Product;
import shop.service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public void getProductByName(String name) {
        Optional<Product> product = productDAO.findProductByName(name);
        if (product.isPresent()) System.out.println(product);
        else System.out.println("No products found");
    }

    @Override
    public void getAllProducts() {
        List<Product> products = productDAO.findAll();
        System.out.println(products);
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
