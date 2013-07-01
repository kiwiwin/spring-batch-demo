package org.kiwi.springbatch;

import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class ProductDiscount implements ItemProcessor<Product, Product>{
    @Override
    public Product process(Product product) throws Exception {
        Product result = new Product();
        result.setProductId(product.getProductId());
        result.setName(product.getName());
        result.setPrice(product.getPrice().divide(new BigDecimal(2)));
        return result;
    }
}
