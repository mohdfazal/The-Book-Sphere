package com.example.The.Book.Sphere.Service;

import com.example.The.Book.Sphere.Entity.Book;

import java.util.List;

public interface BookServiceInterface {
    public String addBook(Book book) throws Exception;
    public List<Book> getAllTheBooks();
}
