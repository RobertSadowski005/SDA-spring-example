package eu.smallAllegro.springmvcfirst.services;

import eu.smallAllegro.springmvcfirst.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);

    List<Product> listAllProductsWithDescription(String description);
}
