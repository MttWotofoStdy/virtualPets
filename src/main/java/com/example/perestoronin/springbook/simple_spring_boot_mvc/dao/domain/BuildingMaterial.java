package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "building_material")
public class BuildingMaterial implements Serializable {
    @Id
    @Enumerated(EnumType.STRING)
    private BuildingMaterialid id;
    private int rucksackOrder;
    private int newbieBoxDropmin;
    private int newbieBoxDropmax;
    private float newbiewBoxDropRate;
    private float hiddenObjectsGameDropRate;
public BuildingMaterial () {
    super();
}
public BuildingMaterial(BuildingMaterialid id) {
    super();
    this.id = id;
}

    public BuildingMaterialid getId() {
        return id;
    }

    public int getRucksackOrder() {
        return rucksackOrder;
    }

    public int getNewbieBoxDropmin() {
        return newbieBoxDropmin;
    }

    public int getNewbieBoxDropmax() {
        return newbieBoxDropmax;
    }

    public float getNewbiewBoxDropRate() {
        return newbiewBoxDropRate;
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
    if(this == obj)
        return true;
    if(obj == null)
        return false;
    if(getClass() != obj.getClass())
        return false;
    BuildingMaterial other = (BuildingMaterial) obj;
    return id == other.id;

    }
    @Override
    public String toString() {
    return "BuildingMaterial [id= " + id + ", rucksackOrder= " + rucksackOrder +
            ", newbieBoxDropMin= " + newbieBoxDropmin + ", newbieBoxDropMax= " + newbieBoxDropmax +
            ", newbieBoxDropRate= " + newbiewBoxDropRate + ", hiddenObjectsGameDropRate= " + hiddenObjectsGameDropRate + "]";
     }


}
