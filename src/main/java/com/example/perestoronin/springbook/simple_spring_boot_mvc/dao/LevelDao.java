package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LevelDao extends JpaRepository<Level, Integer> {

    Optional<Level> findById(Integer id);

    List<Level> findAll();
}
