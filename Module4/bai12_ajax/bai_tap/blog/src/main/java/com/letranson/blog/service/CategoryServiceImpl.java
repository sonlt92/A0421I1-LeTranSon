package com.letranson.blog.service;

import com.letranson.blog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Locale.Category> findAllPage(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Iterable<Locale.Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Locale.Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Locale.Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
