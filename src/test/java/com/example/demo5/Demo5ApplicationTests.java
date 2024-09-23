package com.example.demo5;

import com.example.demo5.dao.BookRepository;
import com.example.demo5.entity.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;
@SpringBootTest
class Chapter05ApplicationTests {
    @Autowired
    private BookRepository bookRepository;
    private  void booksInfo(){
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @Test
    void saveBook() {
        Book book=new Book(null,"离骚","屈原","清华大学出版社","1");
        //新增图书
        bookRepository.save(book);
        booksInfo();
    }
    @Test
    void editBook() {
        Optional<Book> op = bookRepository.findById(1);
        Book book = op.get();
        book.setName("天问");
        //修改图书
        bookRepository.save(book);
        booksInfo();
    }
    @Test
    void findBook() {
        //根据图书作者和图书状态查找对应的图书
        Book b = bookRepository.findByAuthorAndStatus("屈原", "1");
        System.out.println(b);
    }
    @Test
    void delBook() {
        bookRepository.deleteBookById(2);
        booksInfo();
    }



}
