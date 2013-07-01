package org.kiwi.springbatch;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductManager {
    private ProductDAO productDAO;

    public ProductManager() {
    }

    public ProductManager(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Transactional
    public List<Product> listProducts() {
        return productDAO.listProducts();
    }

    @Transactional
    public void insertProduct(Product product) {
        productDAO.insertProduct(product);
    }
}
