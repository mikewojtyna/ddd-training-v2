package pl.wojtyna.trainings.ddd.citybike.rent.good.domain.aggregates.bikestation;

public record BikeRent(Borrower by, RentalDuration forDuration) implements BikeRentalEvent {
}
