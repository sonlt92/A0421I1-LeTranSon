package com.letranson.muonsach.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;

    private String nameBook;
    private Integer booksRemaining;

    @OneToMany(mappedBy = "book")
    private Set<RentalBook> rentalBookSet;

    public Book() {
    }

    public Book(Integer idBook, String nameBook, Integer booksRemaining, Set<RentalBook> rentalBookSet) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.booksRemaining = booksRemaining;
        this.rentalBookSet = rentalBookSet;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public Integer getBooksRemaining() {
        return booksRemaining;
    }

    public void setBooksRemaining(Integer booksRemaining) {
        this.booksRemaining = booksRemaining;
    }

    public Set<RentalBook> getRentalBookSet() {
        return rentalBookSet;
    }

    public void setRentalBookSet(Set<RentalBook> rentalBookSet) {
        this.rentalBookSet = rentalBookSet;
    }
}
