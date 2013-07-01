package org.kiwi.springbatch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProductWriter implements ItemWriter<Product> {
    private ProductManager productManager;

    public ProductWriter(ProductManager productManager) {
        this.productManager = productManager;
    }

    @Override
    public void write(List<? extends Product> products) throws Exception {
        for (Product product : products) {
            productManager.insertProduct(product);
        }
    }
}