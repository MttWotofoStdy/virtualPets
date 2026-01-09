package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.JournalEntryId;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Pet;
import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.PetJournalEntry;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.MapJoin;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PetDao {
    public Optional<Pet> findByIdWithFullFoods(Integer id);

    public Optional<Pet> findByIdWithJournalEntriesAndAchievements(
            Integer id);

    public void delete(Pet fullPet);

    public Optional<Pet> findByIdWithFullCloths(Integer id);

    public Optional<Pet> findFullById(Integer id);

    public void save(Pet pet);

    @Query("from Pet p left outer join p.buildingMaterials bm where p.id = ?1")
    Optional<Pet> findByIdWithFullBuildingMaterials(Integer id);

    private static Specification<Pet> getPetNewJournalEntriesSpecification(Integer petId) {
        return (rootPet, criteriaQuery, criteriaBuilder) -> {
            MapJoin<Pet, JournalEntryId, PetJournalEntry> joinPetJournalEntries =
                    rootPet.joinMap("journalEntries", JoinType.LEFT);
            return criteriaBuilder.and(
                    criteriaBuilder.equal(joinPetJournalEntries.get("readed"), false),
                    criteriaBuilder.equal(rootPet.get("id"), petId)
            );
        };
    }
}
