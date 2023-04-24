package com.saubhagya.bookManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class bookRepository {
    HashMap<Integer,Book> data = new HashMap<>();

    public Boolean addBook(Book book){
        System.out.println(book.getBookId());
        data.put(book.getBookId(),book);
        return true;
    }

    public Optional<Book> getByID(int id) {
        if(data.containsKey(id)){
            return Optional.of(data.get(id));
        }
        return Optional.empty();
    }

    public void removeById(Integer id) {
        data.remove(id);
    }
}
