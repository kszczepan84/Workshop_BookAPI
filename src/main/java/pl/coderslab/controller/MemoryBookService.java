package pl.coderslab.controller;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService {

    private List<Book> books;
    private static Long nextId = 4L;


    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> getBook(Long id) {
        return books.stream().filter(el -> el.getId().equals(id)).findFirst();
    }

//    public void update(Book book) {
////        int indexOf = books.indexOf(books.get(book.getId().intValue()));
//        int indexOf = (book.getId().intValue())-1;
//        books.set(indexOf, book);
//    }

    public void update(Book book) {
        if (this.getBook(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.getBook(book.getId()).get());
            books.set(indexOf, book);
        }
    }



    public void delete(Long id) {
        if (getBook(id).isPresent()) {
            books.remove(this.getBook(id).get());
        }
    }


}
