package pl.wojtyna.trainings.ddd.citybike.rent.bad.domain.aggregates.bikestation;

import org.jmolecules.ddd.annotation.AggregateRoot;
import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

import java.util.HashSet;
import java.util.Set;

@AggregateRoot
public class BikeStation {

    private final Set<Borrower> allBorrowers = new HashSet<>();
    private final BikeStationId id;
    private Set<Bike> bikes;

    public BikeStation(BikeStationId id) {
        this.id = id;
    }

    public void addBorrower(BorrowerLoader repo, BorrowerId id) {
        repo.borrowerOfId(id).ifPresent(allBorrowers::add);
    }

    public DomainEvents rent(BorrowerId borrowerId, RentalDuration duration) {
        var borrower = allBorrowers.stream().filter(currentBorrower -> currentBorrower.id().equals(borrowerId))
                                   .findAny().orElseThrow();
        if (borrower.hasEnoughFunds(duration)) {
            borrower.updateBalance(duration);
            bikes.stream().filter(Bike::isAvailable).findAny().ifPresent(bike -> bike.setAvailable(false));
            return DomainEvents.of(new BikeRent(borrower.id(), duration));
        }
        else {
            return DomainEvents.of(new NotEnoughFunds(borrower.id(), duration));
        }
    }

    public DomainEvents returnBike() {
        throw new UnsupportedOperationException("Implement this method");
    }
}
