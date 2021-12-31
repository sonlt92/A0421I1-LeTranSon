package com.codegym.gio_hang.repository;

import com.codegym.gio_hang.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
