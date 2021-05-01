package com.iamslash.excore.book;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class BookService {

  BookRepository bookRepository;

  public BookService(BookRepository bookRepository){
    this.bookRepository = bookRepository;
  }

  public Book save(Book book){
    book.setCreated(new Date());
    book.setBookStatus(BookStatus.DRAFT);
    return bookRepository.save(book);
  }

  @PostConstruct
  public void postConstruct(){
    System.out.println("BookService::postConstruct");
  }
}
