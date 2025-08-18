package com.example.The.Book.Sphere.Controller;

import com.example.The.Book.Sphere.Entity.Book;
import com.example.The.Book.Sphere.Service.BookServiceInterface;
import com.example.The.Book.Sphere.Service.Implementation.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImp bookServiceImp;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        return BookServiceImp.addBook(book);
    }
}
