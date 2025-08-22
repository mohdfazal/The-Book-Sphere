package com.example.The.Book.Sphere.Controller;

import com.example.The.Book.Sphere.Entity.Book;
import com.example.The.Book.Sphere.Service.Implementation.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImp bookServiceImp;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookServiceImp.addBook(book);
    }
    @GetMapping("/getAll")
    public List<Book> getAllTheBooks(){
        return bookServiceImp.getAllTheBooks();
    }
}
