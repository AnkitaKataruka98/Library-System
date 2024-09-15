package com.project.com.project.library.Service;

import com.project.com.project.library.Repository.BookRepository;
import com.project.com.project.library.Repository.UserRepository;
import com.project.com.project.library.entity.Book;
import com.project.com.project.library.entity.User;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public Book save(Book book){
        return bookRepository.save(book);
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }


    public Book borrowBook(Long bookId, Long userId){
        Book book= findById(bookId);
        User user= userRepository.findById(userId).orElse(null);
        if(book!=null && !book.getBorrowed() &&  user!=null){
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        return null;

    }
    public Book returnBook(Long bookId){
        Book book=findById(bookId);
        if(book!=null && book.getBorrowed()){
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        return null;

    }
}
