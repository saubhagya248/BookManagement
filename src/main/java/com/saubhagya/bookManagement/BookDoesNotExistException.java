package com.saubhagya.bookManagement;

public class BookDoesNotExistException extends RuntimeException{
    public BookDoesNotExistException(int id){
        super("book not found id: "+id);
    }
}
