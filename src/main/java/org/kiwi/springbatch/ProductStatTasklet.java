package org.kiwi.springbatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductStatTasklet implements Tasklet {
    private ProductManager productManager;

    public ProductStatTasklet(ProductManager productManager) {
        this.productManager = productManager;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<Product> products = productManager.listProducts();
        Product expensiveProduct = Collections.max(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice().subtract(o2.getPrice()).intValue();
            }
        });
        System.out.println(expensiveProduct.getName());
        return RepeatStatus.FINISHED;
    }
}
