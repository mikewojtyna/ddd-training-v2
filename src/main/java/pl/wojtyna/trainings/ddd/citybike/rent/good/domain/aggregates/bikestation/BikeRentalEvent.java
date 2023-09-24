package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

import pl.wojtyna.trainings.ddd.crowdsorcery.common.domain.DomainEvent;

public sealed interface BikeRentalEvent extends DomainEvent {

    record BikeRented(Borrower by, RentalDuration forDuration) implements BikeRentalEvent {
    }

    record BikeReturned() implements BikeRentalEvent {
    }
}
