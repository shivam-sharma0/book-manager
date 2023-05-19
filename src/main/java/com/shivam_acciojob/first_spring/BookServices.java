package com.shivam_acciojob.first_spring;

import java.util.List;
import java.util.Optional;

public class BookServices {

   private BookRepository bookRepository =new BookRepository();
    public String addBook(Book book){
        bookRepository.add(book);
        return "Book added with id: "+book.getId();
    }


    public Book getBook(Integer id) throws BookIdInvalidException {
        Optional<Book> bookOptional=bookRepository.getById(id);
        if (bookOptional.isEmpty()){
            throw new BookIdInvalidException(id); // Make our custom Exception those exted the runtime exceptioon
        }
        return bookOptional.get();
    }

    public List<Book> getAllBook() {
        return bookRepository.getAll();
    }

    public Book getBookByName(String name) throws BookNotFoundException {
        List<Book> all=getAllBook();
        for(Book book:all){
            if(book.getTitle().equals(name)){
                return book;
            }
        }
        throw new BookNotFoundException(name);
    }

    public Book updateBookPages(Integer id, Integer pages) throws BookIdInvalidException {
        Book book=getBook(id);
        book.setPages(pages);
        bookRepository.add(book);
        return book;
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }
}
