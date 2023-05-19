package com.shivam_acciojob.first_spring;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String name) {
        super("Book is not found with name "+name);
    }
}
