package pl.wojtyna.trainings.ddd.bikerental;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvents;

public record BikeSystem() {

    public DomainEvents rentBikeBy(Borrower borrower, SomeDomainRule rule) {
        if (thereAreNoAvailableBikes()) {
            // don't call rule/strategy here
        }
        if (borrower.balance().isZero()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        return DomainEvents.of(new BikeIsRent());
    }

    public void addAvailable(Bike bike) {
    }

    public static BikeSystem having(Bike bike) {

        return null;
    }

    private boolean thereAreNoAvailableBikes() {
        return false;
    }
}
