package com.codegym.gio_hang.service;

import com.codegym.gio_hang.bean.ProductBuy;
import com.codegym.gio_hang.repository.ProductBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBuyServiceImpl implements ProductBuyService{
    @Autowired
    private ProductBuyRepository productBuyRepository;

    @Override
    public void save(ProductBuy productBuy) {
        productBuyRepository.save(productBuy);
    }
}
