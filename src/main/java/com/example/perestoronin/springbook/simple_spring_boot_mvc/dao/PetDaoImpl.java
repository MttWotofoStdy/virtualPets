package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Pet;
import jakarta.persistence.*;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PetDaoImpl implements PetDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void delete(Pet fullPet) {
        em.remove(fullPet);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findByIdWithFullFoods(Integer id) {
        Pet pet = em.find(Pet.class, id,
                Map.of(
                        "jakarta.persistence.fetchgraph",
                        em.getEntityGraph("pet.foods")
                )
                );
        return Optional.ofNullable(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findByIdWithJournalEntriesAndAchiements(
            Integer id) {
        Pet pet = em.find(Pet.class, id,
                Map.of("jakarta.persistence.fetchgraph", em.EntityGraph(
                        "pet.journalEntriesAndAchievements")));
        return Optional.ofNullable(pet);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findByIdWithFullCloths(Integer id) {
        Pet pet = em.find(Pet.class, id,
                Map.of(
                        "jakarta.persistance.fetchgraph",
                        em.getEntityGraph("pet.cloths")
                )
        );
        return Optional.ofNullable(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pet> findFullById(Integer id) {
        TypedQuery<Pet> query = em.createQuery(
                "Pet.findFullById", Pet.class);
        query.setParameter("id", id);
        List<Pet> pets = query.getResultList();
        return DataAccessUtils.optionalResult(pets);
    }

    @Override
    @Transactional
    public void save(Pet pet) {
        if (pet.getId() == null) {
            em.persist(pet);
        } else {
            em.merge;
        }
    }
}
