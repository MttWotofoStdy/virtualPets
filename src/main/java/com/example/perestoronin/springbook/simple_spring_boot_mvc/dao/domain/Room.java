package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


        @ManyToOne
        private Pet pet; // ← должно быть поле pet, а не petId

}
