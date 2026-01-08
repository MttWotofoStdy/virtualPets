package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Room;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface RoomDao  extends ListCrudRepository<Room, Integer> {
Optional<Room> findByPetId(Integer petId);
}
