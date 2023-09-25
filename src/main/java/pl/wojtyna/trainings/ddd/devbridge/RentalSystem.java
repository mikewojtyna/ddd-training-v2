package pl.wojtyna.trainings.ddd.devbridge;

import org.joda.money.Money;

import java.time.LocalDateTime;

public class RentalSystem {

    private int numbeOfBikes;

    public RentalSystem(int numbeOfBikes) {

        this.numbeOfBikes = numbeOfBikes;
    }

    public DomainEvents rentAnyBikeBy(User user, RentalAllowancePolicy rentalAllowancePolicy) {
        Money balance = user.balance();
        if (bikeIsAvailable()) {
            if (rentalAllowancePolicy.isAllowedToRentABike(user)) {
                numbeOfBikes--;
                return DomainEvents.of(new BikeRented());
            }
        }
        return DomainEvents.of(new BikeRentalRejected());
    }

    private boolean bikeIsAvailable() {
        return numbeOfBikes > 0;
    }

    public DomainEvents returnBike(Bike rentedBike, LocalDateTime now) {

        return null;
    }
}
