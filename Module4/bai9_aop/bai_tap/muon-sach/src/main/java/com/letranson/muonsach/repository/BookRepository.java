package com.letranson.muonsach.repository;

import com.letranson.muonsach.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
