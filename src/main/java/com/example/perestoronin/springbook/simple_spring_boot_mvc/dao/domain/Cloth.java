package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="cloth")
public class Cloth {


    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private ClothType clothType;

    private int wardrobeOrder;

    private float hiddenObjectsGameDropRate;

    /**
     * Конструктор по умолчанию требуется JPA для создания объекта.
     */
    public Cloth() {
        super();
    }

    public Cloth(String id, ClothType clothType, int wardrobeOrder,
                 float hiddenObjectsGameDropRate) {
        super();
        this.id = id;
        this.clothType = clothType;
        this.wardrobeOrder = wardrobeOrder;
        this.hiddenObjectsGameDropRate = hiddenObjectsGameDropRate;
    }

    public String getId() {
        return id;
    }

    public ClothType getClothType() {
        return clothType;
    }

    public int getWardrobeOrder() {
        return wardrobeOrder;
    }

    public float getHiddenObjectsGameDropRate() {
        return hiddenObjectsGameDropRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cloth other = (Cloth) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Cloth [id=" + id + ", clothType=" + clothType
                + ", wardrobeOrder=" + wardrobeOrder
                + ", hiddenObjectsGameDropRate=" + hiddenObjectsGameDropRate
                + "]";
    }


}