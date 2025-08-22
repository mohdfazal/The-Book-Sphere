package com.example.The.Book.Sphere.Repository;

import com.example.The.Book.Sphere.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
