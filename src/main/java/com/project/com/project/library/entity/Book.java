package com.project.com.project.library.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private  Boolean borrowed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }
}
