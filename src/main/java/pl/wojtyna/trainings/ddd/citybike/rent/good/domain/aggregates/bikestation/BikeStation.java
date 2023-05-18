package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

import lombok.EqualsAndHashCode;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Entity;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

import java.util.HashSet;
import java.util.Set;

@AggregateRoot
public class BikeStation {

    private final BikeStationId id;
    private final Set<BikeInStation> bikes = new HashSet<>();

    public BikeStation(BikeStationId id) {
        this.id = id;
    }

    public void placeNew(Bike bike) {
        if (bikes.stream().map(BikeInStation::id).anyMatch(bikeId -> bikeId.equals(bike.id()))) {
            throw new BikeAlreadyInStation("Bike already in station");
        }
        bikes.add(new BikeInStation(bike.id(), true));
    }

    public FluentLanguage.ByFunction<Borrower, FluentLanguage.ForDurationFunction<RentalDuration, DomainEvents>> rent(
        Bike bike) {
        return borrower -> rentalDuration -> {
            if (rentalDuration.duration().toHours() > 11) {
                throw new MaximumRentalDurationExceededException("Bike rent too long");
            }
            return bikes.stream()
                        .filter(BikeInStation::isAvailable).findAny()
                        .map(bikeInStation -> {
                            bikeInStation.setAvailable(false);
                            return DomainEvents.of(new BikeRent(borrower, rentalDuration));
                        })
                        .orElseThrow(() -> new BikeNotAvailableException("Bike not available"));
        };
    }

    public DomainEvents returnBike(Bike bike) {
        throw new UnsupportedOperationException("Implement this method");
    }

    @EqualsAndHashCode(of = "id")
    @Entity
    private class BikeInStation {

        private final BikeId id;
        private boolean available;

        private BikeInStation(BikeId id, boolean available) {
            this.id = id;
            this.available = available;
        }

        boolean isAvailable() {
            return available;
        }

        private void setAvailable(boolean available) {
            this.available = available;
        }

        BikeId id() {
            return id;
        }
    }
}
