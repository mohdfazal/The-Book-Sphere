package com.example.The.Book.Sphere.Controller;

import com.example.The.Book.Sphere.Entity.Author;
import com.example.The.Book.Sphere.Service.Implementation.AuthorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorServiceImp authorServiceImp;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        return authorServiceImp.addAuthor(author);
    }

    @DeleteMapping("/delete")
    public String deleteAuthorById(@RequestParam Integer id){
        return authorServiceImp.deleteAuthorById(id);
    }

    @PutMapping("/update")
    public String updateAuthorInfoById(@RequestBody Author updatedAuthor, @RequestParam Integer id){
        return authorServiceImp.updateAuthorInfoById(updatedAuthor, id);
    }

    @GetMapping("/get")
    public Author getAuthorById(@RequestParam Integer id){
        return authorServiceImp.getAuthorById(id);
    }

    @GetMapping("getAll")
    public List<Author> getAllTheAuthor(){
        return authorServiceImp.getAllTheAuthor();
    }

}
