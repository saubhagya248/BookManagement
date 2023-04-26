package com.saubhagya.bookManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class bookController {

    @Autowired
    bookService service;
    @PostMapping("/book")
    public ResponseEntity addBook(@RequestBody Book book){
        try{
            Boolean added = service.addBook(book);
            return new ResponseEntity("added successfully", HttpStatus.CREATED);

        } catch (BookAlreadyExistsException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/book")
    public ResponseEntity findBook(@RequestParam int id){
        try{
            Book book = service.getBookById(id);
            return new ResponseEntity(book, HttpStatus.OK);
        } catch (BookDoesNotExistException e) {
            return new ResponseEntity(e.getMessage(), HttpStatusCode.valueOf(500));
        }
    }
    @PutMapping("/update-book")
    public ResponseEntity updateBook(@RequestParam(required = false) int id, @RequestParam(required = false) String title, @RequestParam(required = false) String author, @RequestParam(required = false) Integer pages){
        try{
            String response = service.updateBook(id,title,author,pages);
            return new ResponseEntity(response,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Something went wrong",HttpStatusCode.valueOf(500));
        }
    }


    @DeleteMapping("/delete-book/")
    public ResponseEntity deleteBook(@RequestParam Integer id){
        try{
            return new ResponseEntity(service.deleteBook(id),HttpStatus.OK);

        } catch (BookDoesNotExistException e) {
            return new ResponseEntity(e.getMessage(),HttpStatusCode.valueOf(500));
        }
    }
}
