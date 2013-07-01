package org.kiwi.springbatch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private SessionFactory sessionFactory;

    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> listProducts() {
        return getCurrentSession().createCriteria(Product.class).list();
    }

    @Override
    public void insertProduct(Product product) {
        getCurrentSession().save(product);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
