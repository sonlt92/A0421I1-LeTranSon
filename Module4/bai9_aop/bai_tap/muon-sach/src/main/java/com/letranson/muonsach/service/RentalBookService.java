package com.letranson.muonsach.service;

import com.letranson.muonsach.bean.RentalBook;

public interface RentalBookService {
    RentalBook findById(Integer id);

    void save(RentalBook rentalBook);

    void delete(RentalBook rentalBook);
}
