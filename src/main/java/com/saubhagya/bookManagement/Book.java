package com.saubhagya.bookManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private int bookId;
    private String title;
    private String author;
    private int pages;

    public Book(){

    }
    public Book(int bookId, String title, String author, int pages) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
}
