package com.shivam_acciojob.first_spring;

public class BookIdInvalidException extends RuntimeException{
    public BookIdInvalidException(Integer id){
        super("Book is not present with id "+id);
    }
}
