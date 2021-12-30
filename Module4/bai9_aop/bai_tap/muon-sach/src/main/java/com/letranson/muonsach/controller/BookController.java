package com.letranson.muonsach.controller;

import com.letranson.muonsach.Exception.BookRemainingZeroException;
import com.letranson.muonsach.Exception.NotFoundIdRentalBookException;
import com.letranson.muonsach.bean.Book;
import com.letranson.muonsach.bean.RentalBook;
import com.letranson.muonsach.service.BookService;
import com.letranson.muonsach.service.RentalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private RentalBookService rentalBookService;

    @GetMapping(value = "/show")
    public ModelAndView showAllBook(@PageableDefault(value = 10)Pageable pageable){
        return new ModelAndView("show","books",bookService.findAll(pageable));
    }

    @GetMapping(value = "/create")
    public ModelAndView showPageCreateBooks(){
        return new ModelAndView("create","book",new Book());
    }

    @PostMapping(value = "/create")
    public String saveBook(@ModelAttribute Book book) throws Exception{
        if (book.getBooksRemaining() == 0){
            throw new BookRemainingZeroException();
        }
        bookService.save(book);
        return "redirect:/show";
    }

    @GetMapping(value = "/rentalBook/{id}")
    public String rentalBook(@PathVariable Integer id) throws Exception{
        Book book = bookService.findById(id);
        if (book.getBooksRemaining() == 0){
            throw new BookRemainingZeroException();
        }
        RentalBook rentalBook = new RentalBook();
        int idRentalBook = (int) (Math.random() * 100000);
        rentalBook.setId(idRentalBook);
        rentalBook.setBook(book);
        rentalBookService.save(rentalBook);
        book.setBooksRemaining(book.getBooksRemaining()-1);
        bookService.save(book);
        return "redirect:/show";
    }

    @GetMapping(value = "/giveBack")
    public String giveBack(@RequestParam("idRentalBook") Integer idRentalBook) throws Exception{
        RentalBook rentalBook = rentalBookService.findById(idRentalBook);
        if (rentalBook == null){
            throw new NotFoundIdRentalBookException();
        }
        Book book = rentalBook.getBook();
        rentalBookService.delete(rentalBook);
        book.setBooksRemaining(book.getBooksRemaining()+1);
        bookService.save(book);
        return "redirect:/show";
    }

    @ExceptionHandler(BookRemainingZeroException.class)
    public String showErrorPage(){
        return "error";
    }

    @ExceptionHandler(NotFoundIdRentalBookException.class)
    public String showErrorNotFoundPage(){
        return "error";
    }
}
