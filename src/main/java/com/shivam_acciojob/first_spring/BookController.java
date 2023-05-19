package com.shivam_acciojob.first_spring;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class BookController {

      private BookServices bookServices=new BookServices();
     @PostMapping("/add-new-book")
     public ResponseEntity<String> addBook(@RequestBody Book book){
//        bookData.put(book.getId(),book);
        String str= bookServices.addBook(book);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
     }

     @GetMapping("/get-book")
     public  ResponseEntity<?> getBook(@RequestParam Integer id){
        try{
            Book book= bookServices.getBook(id);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        catch (BookIdInvalidException ex){
            return new ResponseEntity<>("Book is Not Found with id",HttpStatus.NOT_FOUND);
        }
     }
//
     @GetMapping("/get-all-book")
    public ResponseEntity<List<Book>> getAllBooks(){
         return new ResponseEntity<>(bookServices.getAllBook(),HttpStatus.ACCEPTED);
     }

     @GetMapping("/get-book-by-name/{name}") // get-book-by-name/name
    public ResponseEntity<?> getBookByName(@PathVariable  String name){
         try{
             Book book=bookServices.getBookByName(name);
             return new ResponseEntity<>(book, HttpStatus.OK);
         }catch (BookNotFoundException ex){
             return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
         }
     }
//
     @PutMapping("/update-book-page")
    public ResponseEntity<?> updateBookPages(@RequestParam Integer id, @RequestParam Integer pages){
        try{
            Book book =bookServices.updateBookPages(id,pages);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }catch (BookIdInvalidException ex){
            return new ResponseEntity<>("Book is not found with id: "+id,HttpStatus.NOT_FOUND);
        }

     }
//
     @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Integer id){
       bookServices.deleteById(id);
         return "Book Deleted With id: "+id;
     }

}
