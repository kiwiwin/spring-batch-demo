package org.kiwi.springbatch;

import java.util.List;

public interface ProductDAO {
    List<Product> listProducts();

    void insertProduct(Product product);
}
