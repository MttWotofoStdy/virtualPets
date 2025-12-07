package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;


import io.micrometer.observation.annotation.ObservationKeyValue;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "food")
public class Food implements Serializable {
    private static final long serialVersionUID = 8791181701061581183L;

    @Id
    @Enumerated(EnumType.STRING)
    private FoodId id;
    @Column(name = "refregriratorId")
    private int refregiratorLevel;

    private int refregiratorOrder;

    private float hiddernObjectGameDropRate;

    public Food() {
        super();
    }

    public Food(FoodId id, int refregiratorLevel, int refregiratorOrder, float hiddernObjectGameDropRate) {
        super();
        this.id = id;
        this.refregiratorLevel = refregiratorLevel;
        this.refregiratorOrder = refregiratorOrder;
        this.hiddernObjectGameDropRate = hiddernObjectGameDropRate;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public FoodId getId() {
        return id;
    }

    public int getRefregiratorLevel() {
        return refregiratorLevel;
    }

    public int getRefregiratorOrder() {
        return refregiratorOrder;
    }

    public float getHiddernObjectGameDropRate() {
        return hiddernObjectGameDropRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
     if(this == obj)
         return true;
     if(obj == null)
         return false;
     if(getClass() != obj.getClass())
         return false;
     Food other = (Food) obj;
     return id == other.id;
    }






}
