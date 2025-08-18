package com.example.The.Book.Sphere.Repository;

import com.example.The.Book.Sphere.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
