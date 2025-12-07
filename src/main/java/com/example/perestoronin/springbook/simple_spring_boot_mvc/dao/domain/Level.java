package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "level")
public class Level implements Serializable {

    @Id
    private int id;

    private int experience;

    public Level() {
    }

    public Level(int id, int experience) {
        this.id = id;
        this.experience = experience;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public int getExperience() {
        return experience;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj ) {
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Level other = (Level) obj;
        return Objects.equals(id, other.id);
    }
    @Override
    public String toString(){
return "[Level [id = " + id + ", experience = " +experience + "]";
    }
}
