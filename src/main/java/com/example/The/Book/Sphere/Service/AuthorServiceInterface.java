package com.example.The.Book.Sphere.Service;

import com.example.The.Book.Sphere.Entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorServiceInterface {
    public String addAuthor(Author author);
    public String deleteAuthorById(Integer id);
    public String updateAuthorInfoById(Author author, Integer id);
    public Author getAuthorById(Integer id);
    public List<Author> getAllTheAuthor();

}
