package com.example.demo5.dao;

import com.example.demo5.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByAuthorAndStatus(String author,String status);
    @Modifying
    @Transactional
    @Query("delete from Book b where b.id = :id")
    Integer deleteBookById(@Param("id")Integer id);
}
