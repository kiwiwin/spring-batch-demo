package org.kiwi.springbatch;

import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class ProductDiscount implements ItemProcessor<Product, Product>{
    @Override
    public Product process(Product product) throws Exception {
        Product result = new Product();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setPrice(product.getPrice().multiply(new BigDecimal(2)));
        return result;
    }
}
