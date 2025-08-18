package com.example.The.Book.Sphere.Service.Implementation;

import com.example.The.Book.Sphere.Entity.Author;
import com.example.The.Book.Sphere.Entity.Book;
import com.example.The.Book.Sphere.Repository.AuthorRepository;
import com.example.The.Book.Sphere.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookServiceInterface {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public  String addBook(Book book) throws Exception {
        Author author;
        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
        return "Book Added Successfully ";

    }
}
