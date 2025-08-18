package com.example.The.Book.Sphere.Controller;

import com.example.The.Book.Sphere.Entity.Author;
import com.example.The.Book.Sphere.Service.Implementation.AuthorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorServiceImp authorServiceImp;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        return authorServiceImp.addAuthor(author);
    }
}
