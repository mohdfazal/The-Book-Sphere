package com.example.The.Book.Sphere.Service.Implementation;

import com.example.The.Book.Sphere.Entity.Author;
import com.example.The.Book.Sphere.Entity.Book;
import com.example.The.Book.Sphere.Repository.AuthorRepository;
import com.example.The.Book.Sphere.Repository.BookRepository;
import com.example.The.Book.Sphere.Service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookServiceInterface {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;
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

    @Override
    public List<Book> getAllTheBooks() {
       List<Author> authors = authorRepository.findAll();
       List<Book> allBooks = new ArrayList<>();

        for (Author author: authors) {
            if(author.getBooks() != null){
                allBooks.addAll(author.getBooks());
            }
        }
        return allBooks;
    }

    @Override
    public List<Book> getBookListOfAnAuthorById(Integer id) {
        Author particularAuthorById = authorRepository.findById(id).get();
        List<Book> bookListOfAnAuthor = new ArrayList<>();

        if(particularAuthorById.getBooks() != null){
            bookListOfAnAuthor.addAll(particularAuthorById.getBooks());
        }

        return bookListOfAnAuthor;
    }

    // In your Service Implementation
    @Override
    public Integer getNumberOfBookByAnAuthorId(Integer id) {
        Author particularAuthorById = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        if (particularAuthorById.getBooks() == null) {
            return 0; // No books written
        }

        return particularAuthorById.getBooks().size();
    }

}
