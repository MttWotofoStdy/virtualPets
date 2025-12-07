package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Level;

import java.util.List;
import java.util.Optional;

public interface LevelDao {

    Optional<Level> findById(Integer id);

    List<Level> findAll();
}
