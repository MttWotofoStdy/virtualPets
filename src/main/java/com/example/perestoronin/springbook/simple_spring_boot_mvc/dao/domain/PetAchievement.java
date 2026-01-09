package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import java.util.Objects;

import jakarta.persistence.*;

/**
 * Запись о достижении питомца.
 */
@Entity
@Table(name="pet_achievement")
public class PetAchievement {

    /**
     * Первичный ключ записи. Генерируемый.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "achievement_id") // ← ключ для Map
    private AchievementId achievementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /**
     * Отображалось ли игроку сообщение о получении достижения.
     */
    private Boolean wasShown = false;

    /**
     * Для оптимистичной блокировки.
     */
    @Version
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AchievementId getAchievement() {
        return achievementId;
    }

    public void setAchievement(AchievementId achievement) {
        this.achievementId = achievement;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Boolean getWasShown() {
        return wasShown;
    }

    public void setWasShown(Boolean wasShown) {
        this.wasShown = wasShown;
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
        PetAchievement other = (PetAchievement) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "PetAchievement [id=" + id + ", achievement=" + achievementId
                + ", pet=" + pet + ", wasShown=" + wasShown + ", version="
                + version + "]";
    }


}
