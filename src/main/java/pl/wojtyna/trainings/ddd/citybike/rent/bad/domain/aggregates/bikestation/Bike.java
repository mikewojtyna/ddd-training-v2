package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

import lombok.EqualsAndHashCode;
import org.jmolecules.ddd.annotation.Entity;

@Entity
@EqualsAndHashCode(of = "id")
public class Bike {

    private final BikeId id;
    private boolean available;

    public Bike(BikeId id) {
        this.id = id;
    }

    boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
