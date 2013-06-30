package org.kiwi.springbatch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProductWriter implements ItemWriter<Product> {
    private static final String INSERT_PRODUCT = "insert into PRODUCT " +
            "(product_id, name, price) values (?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    public ProductWriter(DataSource source) {
        this.jdbcTemplate = new JdbcTemplate(source);
    }

    @Override
    public void write(List<? extends Product> products) throws Exception {
        for (Product product : products) {
            jdbcTemplate.update(INSERT_PRODUCT,
                    product.getId(), product.getName(), product.getPrice());
        }
    }
}