package shop.service.impl;

import shop.dao.ProductDAO;
import shop.dao.impl.ProductDAOImpl;
import shop.entity.Product;
import shop.service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Product getProduct(String productId) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return productDAO.findProductByName(name)
                .orElseThrow(() -> new NoSuchElementException("No product found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }


    public void addProduct(String name, Double price, String description) {
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        productDAO.addProduct(product);

    }

    public void editProduct() {

    }

    @Override
    public void editProduct(String name) {
       Product product = getProductByName(name);
       product.setName(name);
       System.out.println("Enter name");
       product.setName(scanner.nextLine());
       System.out.println("Enter price");
       product.setPrice(scanner.nextDouble());
       System.out.println("Enter description");
       product.setDescription(scanner.nextLine());
       productDAO.updateProduct(product);
    }
}
