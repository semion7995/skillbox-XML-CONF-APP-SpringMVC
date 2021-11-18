package org.example.web.app.repo.impl;

import org.apache.log4j.Logger;
import org.example.web.app.repo.abstr.ProjectRepository;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository<T> implements ProjectRepository<Book> {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();
    private boolean flag = false;


    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

//    @Override
//    public boolean removeItemById(Integer bookIdToRemove) {
//
//        for (Book book : retreiveAll()) {
//            if (book.getId().equals(bookIdToRemove)){
//                logger.info("remove book completed: " + book);
//                return repo.remove(book);
//            }
//        }
//        return false;
//    }

    @Override
    public boolean removeBookByRegex(String queryRegex) {

        try {
            int number = Integer.parseInt(queryRegex);
            for (Book book : retreiveAll()) {
                if (book.getSize().equals(number)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
                if (book.getId().equals(number)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
            }
            return flag;
        } catch (NumberFormatException num){
            for (Book book : retreiveAll()) {
                if (book.getTitle().equals(queryRegex)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
                if (book.getAuthor().equals(queryRegex)){
                    logger.info("remove a book: " + book);
                    flag = repo.remove(book);
                }
            }
        }
        return flag;
    }
}
