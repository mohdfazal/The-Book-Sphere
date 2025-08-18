package com.example.The.Book.Sphere.Entity;

import com.example.The.Book.Sphere.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int noOfPages;
    private int price;
    @ManyToOne
    @JoinColumn
    private Author author;

    public Book(String title, Genre genre, int noOfPages, int price, Author author) {
        this.title = title;
        this.genre = genre;
        this.noOfPages = noOfPages;
        this.price = price;
        this.author = author;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
