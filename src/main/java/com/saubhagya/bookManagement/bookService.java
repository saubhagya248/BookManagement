package com.saubhagya.bookManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Objects;
import java.util.Optional;

@Service
public class bookService {

    @Autowired
    bookRepository repo;

    public Boolean addBook(Book book) throws BookAlreadyExistsException{
        Optional<Book> opt = repo.getByID(book.getBookId());
        if(opt.isPresent()){
            throw new BookAlreadyExistsException(book.getBookId());
        }
        return repo.addBook(book);
    }

    public Book getBookById(int id) throws BookDoesNotExistException {
        Optional<Book> opt = repo.getByID(id);
        if(opt.isEmpty()){
            throw new BookDoesNotExistException(id);
        }
        return opt.get();
    }

    public String updateBook(int id, String title, String author, Integer pages) {
        try{
            Book book = getBookById(id);
            if(Objects.nonNull(title)){
                book.setTitle(title);
            }
            if(Objects.nonNull(author)){
                book.setAuthor(author);
            }
            if(Objects.nonNull(pages)){
                book.setPages(pages);
            }
            repo.addBook(book);
            return "Book updated";

        } catch (BookDoesNotExistException ex) {
            return "Book does not exist";
        }

    }


    public String deleteBook(Integer id) throws BookDoesNotExistException{
        Optional<Book> opt = repo.getByID(id);
        if(opt.isEmpty()){
            throw new BookDoesNotExistException(id);
        }
        repo.removeById(id);
        return "Book deleted successfully";
    }
}
