package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Level;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository("levelDao")
public class LevelDaoImpl implements LevelDao{

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public Optional<Level> findById(Integer id) {
        Level level = em.find(Level.class, id);
        return Optional.ofNullable(level);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Level> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Level> criteriaQuery = criteriaBuilder.createQuery(Level.class);
        criteriaQuery.from(Level.class);
        TypedQuery<Level> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

}
