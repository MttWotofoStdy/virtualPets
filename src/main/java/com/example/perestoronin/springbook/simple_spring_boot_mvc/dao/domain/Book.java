package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;




@Entity
@Table(name = "book")
public class    Book {
    public static final String FIRST_BOOK_ID = "DESTINY";

    @Id
    private String id;

    @Column(name = "bookcase_id")
    private int bookcaseLevel;

    private int bookcaseOrder;

    private float hiddenObjectsGameDropRate;

    public Book() {
        super();
    }

    public Book(String id, int bookcaseLevel, int bookcaseOrder,
                float hiddenObjectsGameDropRate) {
        super();
        this.id = id;
        this.bookcaseLevel = bookcaseLevel;
        this.bookcaseOrder = bookcaseOrder;
        this.hiddenObjectsGameDropRate = hiddenObjectsGameDropRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(id, other.id);
    }

}
