package de.aittr.g_31_2_rest.domain;

import java.util.Objects;

public class Dog {
    private int id;
    private String color;
    private double weight;


    public Dog() {
    }

    public Dog(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog dog)) return false;
        return getId() == dog.getId() && Double.compare(dog.getWeight(), getWeight()) == 0 && Objects.equals(getColor(), dog.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getColor(), getWeight());
    }

    @Override
    public String toString() {
        return String.format("Собака: ИД - %d, цвет - %s, вес - %.3f", id, color, weight);
    }

}
