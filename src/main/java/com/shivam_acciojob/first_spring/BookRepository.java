package com.shivam_acciojob.first_spring;

import com.sun.source.tree.ReturnTree;

import java.util.*;

public class BookRepository {

    private Map<Integer,Book > bookData = new HashMap<>();
    public void add(Book book){

        bookData.put(book.getId(),book);
    }

    public Optional<Book> getById(Integer id) {
        if(bookData.containsKey(id)){
            Book bookToReturn= bookData.get(id);
            return Optional.of(bookToReturn);
        }
        return Optional.empty();
    }

    public List<Book> getAll() {
        List<Book> allBook= new ArrayList<>(bookData.values());
        return allBook;
    }

    public void deleteById(Integer id) {
        bookData.remove(id);
    }
}
