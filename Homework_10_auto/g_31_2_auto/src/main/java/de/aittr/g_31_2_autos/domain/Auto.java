package de.aittr.g_31_2_autos.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  int id;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private  int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auto auto)) return false;
        return getId() == auto.getId() && getYear() == auto.getYear() && Objects.equals(getModel(), auto.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getYear());
    }


    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
