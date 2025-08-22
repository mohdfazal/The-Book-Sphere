package com.example.The.Book.Sphere.Service.Implementation;

import com.example.The.Book.Sphere.Entity.Author;
import com.example.The.Book.Sphere.Repository.AuthorRepository;
import com.example.The.Book.Sphere.Service.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorServiceInterface {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author){

        authorRepository.save(author);
        return "Author added successfully ";
    }
    @Override
    public String deleteAuthorById(Integer id){
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
            return "Author with ID: " + id + " deleted successfully";
        }
        else {
            return "Author with ID : " + id +" not found";
        }
    }


    @Override
    public String updateAuthorInfoById(Author updatedAuthor, Integer id) {
        if (authorRepository.existsById(id)) {
            Author existedAuthor = authorRepository.findById(id).get();
            existedAuthor.setAge(updatedAuthor.getAge());
            existedAuthor.setName(updatedAuthor.getName());
            existedAuthor.setEmail(updatedAuthor.getEmail());

            authorRepository.save(existedAuthor);
            return "Author updated successfully";
        } else {
            return "Author Not found with ID: " + id;
        }
    }

    @Override
    public Author getAuthorById(Integer id) {
        if(authorRepository.existsById(id)){
            return authorRepository.findById(id).get();
        }
       throw new RuntimeException("Author Not Found");
    }

    @Override
    public List<Author> getAllTheAuthor() {
        return authorRepository.findAll();
    }

}
