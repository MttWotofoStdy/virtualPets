package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import java.util.List;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface BookDao extends JpaRepository<Book, String> {
    List<Book> findByOrderByBookcaseLevelAscBookcaseOrderAsc();
}
