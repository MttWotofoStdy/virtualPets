package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Pet;

import java.util.Optional;

public interface PetDao {
    public Optional<Pet> findByIdWithFullFoods(Integer id);

    public Optional<Pet> findByIdWithJournalEntriesAndAchievements(
            Integer id);
    public void delete(Pet fullPet);
    public Optional<Pet> findByIdWithFullCloths(Integer id);
    public Optional<Pet> findFullById(Integer id);
    public void save(Pet pet);


}
