package com.letranson.furama.repository;

import com.letranson.furama.bean.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TypeOfCustomerRepository extends PagingAndSortingRepository<CustomerType,Integer> {
}
