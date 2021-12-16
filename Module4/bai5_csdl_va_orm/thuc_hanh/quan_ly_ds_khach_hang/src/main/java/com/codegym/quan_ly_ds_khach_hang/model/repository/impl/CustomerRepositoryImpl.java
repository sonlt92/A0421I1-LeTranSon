package com.codegym.quan_ly_ds_khach_hang.model.repository.impl;


import com.codegym.quan_ly_ds_khach_hang.model.bean.Customer;
import com.codegym.quan_ly_ds_khach_hang.model.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT s FROM Customer as s", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer finById(int id) {
        return entityManager.find(Customer.class,id);
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void edit(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = finById(id);
        entityManager.remove(customer);
    }

    @Override
    public List<Customer> search(String searchValue) {
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer as c where c.name like :searchValue", Customer.class);
        query.setParameter("searchValue","%"+searchValue+"%");
        return query.getResultList();
    }
}
