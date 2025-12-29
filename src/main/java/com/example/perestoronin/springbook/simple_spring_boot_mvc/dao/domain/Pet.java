package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@NamedEntityGraph(name = "pet.cloths",
        attributeNodes = @NamedAttributeNode("cloths")
)
@NamedEntityGraph(name = "pet.journalEntriesAndAchievements",
        attributeNodes = {
                @NamedAttributeNode("journalEntries"),
                @NamedAttributeNode("achievements")
        }
)
@NamedEntityGraph(name = "pet.foods",
        attributeNodes = @NamedAttributeNode(
                value = "foods", subgraph = "pet.foods.food"),
        subgraphs = @NamedSubgraph(
                name = "pet.foods.food",
                attributeNodes = @NamedAttributeNode("food")))

@Entity
@Table(name = "pet")
@NamedQuery(name = "Pet.findByUserId",
        query = "from Pet p where p.user.id = :userId")
@NamedQuery(name = "Pet.findFullById", query = """
        from Pet p
        left outer join fetch p.level l
        left outer join fetch p.hat h1
        left outer join fetch p.cloth c1
        left outer join fetch p.bow b1
        left outer join fetch p.user u
        left outer join fetch p.cloths c
        left outer join fetch p.books b
        left outer join fetch p.foods f
        left outer join fetch p.buildingMaterials bm 
        left outer join fetch bm.buildingMaterial 
        left outer join fetch p.journalEntries je
        left outer join fetch p.achievements ach
        where p.id = :id
        """)

public class Pet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_id_seq", allocationSize = 1)
    private Integer id;

    @Version
    private int version;

    @Size(max = 50)
    private String name;

    private String sessionKey;
    private OffsetDateTime createDate;
    private OffsetDateTime loginDate;
    private int satiety;
    private int mood;
    private int education;
    private int drink;

    @Size(max = 50)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated
    private PetType petType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cloth cloth;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cloth hat;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cloth bow;

    private int experience = 0;
    private int teachCount = 0;
    private int eatCount = 0;
    private int drinkCount = 0;
    private int buildCount = 0;
    private int hiddenObjectsGameCount;
    private OffsetDateTime everyDayLoginLast;
    private int everyDayLoginCount;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "food_id")
    private Map<FoodId, PetFood> foods;

    @ManyToMany
    @JoinTable(name = "pet_cloth",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "cloth_id"))
    private Set<Cloth> cloths;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "building_material_id")
    private Map<BuildingMaterialId, PetBuildingMaterial> buildingMaterials;

    @ManyToMany
    @JoinTable(
            name = "pet_book",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "achievement_id")
    private Map<AchievementId, PetAchievement> achievements;

    // --- ВСЕ МЕТОДЫ ДОЛЖНЫ БЫТЬ ВНУТРИ КЛАССА ---

    @Override
    public int hashCode() {
        return Objects.hash(createDate, name, petType, user.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass())
            return false;
        Pet other = (Pet) obj;
        return Objects.equals(createDate, other.createDate)
                && Objects.equals(name, other.name) && petType == other.petType && Objects.equals(user.getId(), other.user.getId());
    }

    @Override
    public String toString() {
        return "Pet [id = " + id + ", name = " + name + ", createDate = " + createDate + ", comment = " + comment + ", user.id = "
                + user.getId() + ", petType = " + petType + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}