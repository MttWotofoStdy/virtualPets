package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao;

import com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain.Cloth;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ClothDaoImpl implements  ClothDao{
    @PersistenceContext
    private EntityManager em;
    @Override
    public Cloth getReference(String id)
    {
        return em.getReference(Cloth.class, id);
    }
}
