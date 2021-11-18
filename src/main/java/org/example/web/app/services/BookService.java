package org.example.web.app.services;

import org.example.web.app.repo.impl.BookRepository;
import org.example.web.app.repo.abstr.ProjectRepository;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(BookRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }


    public List<Book> getAllBooks(){
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }


    public boolean removeBookByRegex(String queryRegex) {
        return bookRepo.removeBookByRegex(queryRegex);
    }

}
