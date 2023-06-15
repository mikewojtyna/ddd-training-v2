package pl.wojtyna.trainings.recipes.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SomeSimpleForm {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    public SomeSimpleForm() {
    }

    public SomeSimpleForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public SomeSimpleForm(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SomeSimpleForm that = (SomeSimpleForm) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
