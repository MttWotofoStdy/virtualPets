package com.example.perestoronin.springbook.simple_spring_boot_mvc.dao.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "drink")
@SqlResultSetMapping(
        name = "Drink.defaultMapping",
        entities = {
                @EntityResult(entityClass = Drink.class, fields = {
                        @FieldResult(
                                name = "id",
                                column = "id"),
                        @FieldResult(
                                name = "machineWithDrinksLevel",
                                column = "machine_with_drinks_id"),
                        @FieldResult(
                                name = "machineWithDrinksOrder",
                                column = "machine_with_drinks_order"),
                        @FieldResult(
                                name = "hiddenObjectsGameDropRate",
                                column = "hidden_objects_game_drop_rate")
                })
        }
)
@NamedNativeQuery(
        name = "Drink.findAllOrderByMachineWithDrinksLevelAndMachineWithDrinksOrder",
        query = """
                        SELECT
                            d.id,
                            d.machine_with_drinks_id,
                            d.machine_with_drinks_order,
                            d.hidden_objects_game_drop_rate
                        FROM drink d
                        ORDER BY d.machine_with_drinks_id,
                            d.machine_with_drinks_order
                """,
        resultSetMapping = "Drink.defaultMapping"

)
public class Drink {


    @Id
    @Enumerated(EnumType.STRING)
    private DrinkId id;

    @Column(name = "machine_with_drinks_id")
    private int machineWithDrinksLevel;

    private int machineWithDrinksOrder;

    private float hiddenObjectsGameDropRate;

    public Drink() {
        super();
    }


    public Drink(DrinkId id, int machineWithDrinksLevel,
                 int machineWithDrinksOrder,
                 float hiddenObjectsGameDropRate) {
        super();
        this.id = id;
        this.machineWithDrinksLevel = machineWithDrinksLevel;
        this.machineWithDrinksOrder = machineWithDrinksOrder;
        this.hiddenObjectsGameDropRate = hiddenObjectsGameDropRate;
    }


    public DrinkId getId() {
        return id;
    }

    public int getMachineWithDrinksLevel() {
        return machineWithDrinksLevel;
    }

    public int getMachineWithDrinksOrder() {
        return machineWithDrinksOrder;
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
        Drink other = (Drink) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Drink [id=" + id + ", machineWithDrinksLevel="
                + machineWithDrinksLevel + ", machineWithDrinksOrder="
                + machineWithDrinksOrder + ", hiddenObjectsGameDropRate="
                + hiddenObjectsGameDropRate + "]";
    }
}