package com.letranson.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Locale;

public interface CategoryService {
    Page<Locale.Category> findAllPage(Pageable pageable);

    Iterable<Locale.Category> findAll();

    Locale.Category findById(Long id);

    void save(Locale.Category category);

    void remove(Long id);
}