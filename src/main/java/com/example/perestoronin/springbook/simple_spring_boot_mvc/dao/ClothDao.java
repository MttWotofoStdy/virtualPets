package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Cloth;

public interface ClothDao {
    Cloth getReference(String id);
}
