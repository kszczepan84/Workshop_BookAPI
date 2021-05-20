package pl.coderslab.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService memoryBookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("")
    public List<Book> showBooks() {
        return memoryBookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return memoryBookService.getBook(id).orElseThrow(null);
    }


    @PostMapping("")
    public void addNewBook( @RequestBody Book book) {
        memoryBookService.addBook(book);
    }

    @PutMapping("")
    public void updateBook( @RequestBody Book book) {
        memoryBookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        memoryBookService.delete(id);
    }
}
