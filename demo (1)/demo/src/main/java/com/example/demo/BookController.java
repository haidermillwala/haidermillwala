package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @QueryMapping
    Iterable<Book> books() {

        return bookRepository.findAll();
    }

    @MutationMapping
    public Book addBook(@Argument BookInput book) {
        Author author = authorRepository.findById(book.authorId()).orElseThrow(() -> new IllegalArgumentException("Author not found"));
        Book b = new Book(book.title(), book.publisher(), author);
        return bookRepository.save(b);
    }

    record BookInput(String title, String publisher, Long authorId) {}
}
