package com.saubhagya.bookManagement;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(int id){
        super("Book already exists with id: "+id);
    }
}
