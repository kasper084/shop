package shop.dao;

import shop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    List<Product> findAll();

   Product findProductByName(String name);

}
