package com.example.The.Book.Sphere.Service.Implementation;

import com.example.The.Book.Sphere.Entity.Author;
import com.example.The.Book.Sphere.Repository.AuthorRepository;
import com.example.The.Book.Sphere.Service.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImp implements AuthorServiceInterface {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author){

        authorRepository.save(author);
        return "Author added successfully ";
    }
}
